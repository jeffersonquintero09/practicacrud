package com.pragma.practicacrud.service;

import com.pragma.practicacrud.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface ClientService {

    public Iterable<Client> findAll();
    public Page<Client> findAll(Pageable pageable);
    public Optional<Client> findById(Long id);
    public Client save(Client client);
    public void deleteById(Long id);

}
