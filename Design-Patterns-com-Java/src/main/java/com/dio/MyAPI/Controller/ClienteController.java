package com.dio.MyAPI.Controller;

import com.dio.MyAPI.Model.Cliente;
import com.dio.MyAPI.Service.ClienteService;
import com.dio.MyAPI.TO.ClienteTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") UUID id){
        return clienteService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteTO cliente){
        return clienteService.createCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") UUID id, @RequestBody ClienteTO cliente){
        return clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCliente(@PathVariable("id") UUID id){
        return clienteService.deleteCliente(id);
    }


}
