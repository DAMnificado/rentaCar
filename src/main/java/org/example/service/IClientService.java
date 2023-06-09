package org.example.service;

import org.example.model.Client;

public interface IClientService extends ICrudService<Client>{

    Client findByDni(String dni);


}
