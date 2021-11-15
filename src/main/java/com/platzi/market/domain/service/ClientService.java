package com.platzi.market.domain.service;

import com.platzi.market.domain.Client;
import com.platzi.market.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){return clientRepository.getAll();}

    public Optional<Client> getClient(String id){return clientRepository.getClient(id);}

    public Client save(Client client){return clientRepository.save(client);}

    public boolean delete(String id){
        return getClient(id).map(clt -> {
            clientRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
