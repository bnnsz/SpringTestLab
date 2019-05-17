/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.repository;

import com.demo.enities.PersonEntity;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author obinna.asuzu
 */
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    
    @Query("SELECT a FROM PersonEntity AS a")
    public Stream<PersonEntity> streamAll();
}
