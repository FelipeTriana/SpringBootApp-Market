package com.platzi.market.domain.repository;

import com.platzi.market.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> getAll();
    Optional<Client> getClient(String id);
    Client save(Client client);
    void delete(String id);
}
