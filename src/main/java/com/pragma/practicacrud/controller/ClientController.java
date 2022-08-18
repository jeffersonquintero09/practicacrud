package com.pragma.practicacrud.controller;

import com.pragma.practicacrud.entity.Client;
import com.pragma.practicacrud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Crear un nuevo cliente (CREATE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Client client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
    }

    // Leer un cliente (READ)
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<Client> oClient = clientService.findById(id);
        if (oClient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oClient);
    }

    // Actualizar un cliente (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Client clientDetails, @PathVariable Long id) {
        Optional<Client> oClient = clientService.findById(id);
        if (oClient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        oClient.get().setName(clientDetails.getName());
        oClient.get().setSurname(clientDetails.getSurname());
        oClient.get().setTypeId(clientDetails.getTypeId());
        oClient.get().setIdNumber(clientDetails.getIdNumber());
        oClient.get().setAge(clientDetails.getAge());
        oClient.get().setCity(clientDetails.getCity());

        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(oClient.get()));
    }

    // Borrar un usuario (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if(clientService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clientService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
