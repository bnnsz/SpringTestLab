/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.services;

import com.demo.enities.MockService;
import static com.demo.enities.MockService.totalTime;
import com.demo.enities.PersonEntity;
import com.demo.repository.PersonRepository;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import static java.util.stream.Collectors.toList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author obinna.asuzu
 */
@Service
public class PersonService {

    @Autowired
    MockService service;

    @Autowired
    PersonRepository repository;

    @Transactional
    @Scheduled(fixedDelay = 300000000, initialDelay = 10)
    public void execute() {
        System.out.println("execution started");
        repository.streamAll()
                .forEach(person -> {
                    person.setEnabled(true);
                    //repository.save(person);
                    service.fetchPhone(person);
                });

        System.out.println("Total: " + totalTime);
    }

}
