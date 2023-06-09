package org.example.repository;

import org.example.model.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTestHector {

ClientRepository repo;
Client c1;
Client c2;

ArrayList<Client> clients;
    @BeforeEach
    void setUp() {
        repo = ClientRepository.getClientRepository();
        c1 = new Client(15L,"54230111K","Hector","Kamas");
        c2 = new Client(10L,"85230111F","Fresas","Frostas");

    }

    @Test
    void getClientRepository() {
        Assertions.assertEquals(repo,ClientRepository.getClientRepository());
    }

    @Test
    void add() {
        repo.add(c1);
        Assertions.assertEquals(c1,repo.findById(1L));
    }

    @Test
    void findById() {
        repo.add(c2);
        Assertions.assertAll(
                ()-> assertEquals(c2,repo.findById(1l)),
                ()-> assertNotEquals(c2,repo.findById(2L)),
                ()->assertNull(repo.findById(3L))
        );
    }
    @Test
    void update() {
        repo.add(c1);
        Assertions.assertEquals(c1,repo.findById(1L));
        c1.setName("Pedro");
        repo.update(c1);
        Assertions.assertEquals("Pedro",c1.getName());
        Assertions.assertNotEquals("Hector",c1.getName());
    }

    @Test
    void findAll() {
    repo.add(c1);
    repo.add(c2);
        Assertions.assertEquals(2,repo.findAll().size());
        Assertions.assertEquals(c1,repo.findAll().get(0));
        Assertions.assertEquals(c2,repo.findAll().get(1));
    }

    @Test
    void deleteById() {
        repo.add(c1);
        Assertions.assertEquals(c1,repo.findById(1L));
        repo.deleteById(1L);
        Assertions.assertNull(repo.findById(1L));
    }

    @Test
    void nextIdAvailable() {
        repo.add(c1);
        repo.add(c2);
        Assertions.assertEquals(3,repo.nextIdAvailable());
        repo.deleteById(2L);
        Assertions.assertEquals(2,repo.nextIdAvailable());
        repo.deleteById(1L);
        Assertions.assertEquals(1,repo.nextIdAvailable());
    }

    @Test
    void findByDni() {
        repo.add(c1);
        Assertions.assertEquals("54230111K",repo.findByDni("54230111K").getDni());
        Assertions.assertNull(repo.findByDni("32F"));
    }

    @Test
    void cleanUp() {
        repo.add(c1);
        repo.add(c2);
        repo.cleanUp();
       Assertions.assertEquals(1L,repo.nextIdAvailable());
    }
}