package org.example.repository;

import org.example.model.Client;

public interface IClientRepository extends ICrudRepository<Client> {
    Client findByDni(String dni);
}
