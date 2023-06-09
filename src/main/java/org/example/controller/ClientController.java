package org.example.controller;

import org.example.model.Client;
import org.example.service.ClientServiceImpl;
import org.example.service.IClientService;

import java.util.ArrayList;

public class ClientController {

    private IClientService service;
    public ClientController() {
        service = new ClientServiceImpl();
    }

    public void add(String dni, String name, String surname){
        Client client = new Client(dni, name, surname);
        service.add(client);

    }

    public void deleteById(Long id){
        service.deleteById(id);

    }

    public ArrayList findAll(){
        return service.findAll();
    }

    public Client findByDni(String dni){
        return service.findByDni(dni);
    }

    public void update(Long id, String dni, String name, String surname){
        Client client = new Client(id, dni, name, surname);
        service.update(client);
    }


}
