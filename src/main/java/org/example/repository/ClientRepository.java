package org.example.repository;

import org.example.model.Client;

import java.util.ArrayList;

public class ClientRepository implements IClientRepository {

    private ArrayList<Client> clients;
    private static ClientRepository clientRepository;


    private ClientRepository() {
        clients = new ArrayList<>();
    }

    public static ClientRepository getClientRepository() {
        if(clientRepository == null){
            clientRepository = new ClientRepository();
        }
        return clientRepository;
    }

    /**
     * Metodo que añade un cliente a nuestra base de datos y le otorga la siguiente ID disponible
     * @param client tipo cliente
     */
    public void add(Client client){
        client.setId(nextIdAvailable());
        clients.add(client);
    }

    /**
     * Metodo que devuelve el cliente asociado al id proporcionado
     * @param id tipo Long
     * @return devuelve el cliente asociado al id o devuelve null si no coincide el id con ningun cliente
     */
    public Client findById(Long id) {
        for (Client client : clients) {
            if(client.getId() == id){
                return client;
            }
        }
        return null;
    }


    /**
     * Actualiza la información de un cliente dentro de nuestra array Clients
     * @param client tipo cliente
     */
    public void update(Client client) {
        clients.set(clients.indexOf(findById(client.getId())), client);
    }

    /**
     * Método que nos da la lista de todos los clientes
     * @return devuelve tods los clientes asociados a la lista
     */
    public ArrayList findAll(){
        return clients;
    }

    /**
     * Método que elimina el cliente que tiene asociado el id que le pasas
     * @param id tipo Long
     */
    public void deleteById(Long id){
        for (Client client : clients) {
            if (client.getId() == id) {
                clients.remove(client);
                break;
            }
        }
    }


    /**
     * Método que nos dice el siguiente id disponible
     * coge el id del último y le suma 1
     * @return SI el ARRAY ESTÁ VACIO: devuelve 1, SI EL ARRAY NO ESTÁ VACIO: coge el id del último cliente en el array y le suma 1
     */
    public Long nextIdAvailable(){
        if(!clients.isEmpty()){
            return clients.get(clients.size()-1).getId() + 1;
        }
        else{
            return (long)1;
        }
    }


    /***
     * Método que busca un cliente por su dni
     * @param dni tipo String
     * @return Nos devuelve el cliente asociado al dni que le pasamos o null si no está en la lista
     */
    public Client findByDni(String dni){
        for (Client client : clients) {
            if(client.getDni().equals(dni)){
                return client;
            }
        }
        return null;
    }


    public void cleanUp(){
        clients = new ArrayList<>();
    }

}
