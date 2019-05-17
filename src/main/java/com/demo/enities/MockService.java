/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.enities;

import com.demo.repository.PersonRepository;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author obinna.asuzu
 */
@Service
public class MockService {

    public static long totalTime = 0;
    @Autowired
    PersonRepository repository;

    @Async
    public void fetchPhone(PersonEntity person) {
        
        long i;
        Random r = new Random();
        try {
            i = r.nextInt((2000 - 0) + 1) + 0;
            Thread.sleep(i);
            totalTime = totalTime + i;

        } catch (InterruptedException ex) {
            Logger.getLogger(MockService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Fetching phone for id:" + person);
        String phone = "080" + (r.nextInt((90000000 - 30000000) + 1) + 30000000);
        person.setPhone(phone);
        person.setEnabled(false);
        repository.save(person);
        System.out.println("Total: " + totalTime);
    }
}
