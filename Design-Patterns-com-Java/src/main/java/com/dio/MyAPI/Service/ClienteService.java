package com.dio.MyAPI.Service;

import com.dio.MyAPI.Model.Cliente;
import com.dio.MyAPI.Model.Endereco;
import com.dio.MyAPI.Repository.ClienteRepository;
import com.dio.MyAPI.Repository.EnderecoRepository;
import com.dio.MyAPI.TO.ClienteTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    public ResponseEntity<List<Cliente>> getAll() {
        return new ResponseEntity<>(clienteRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Cliente> findById(UUID id) {
       Optional<Cliente> clienteById = clienteRepository.findById(id);

       if (clienteById.isEmpty()){
           return new ResponseEntity(HttpStatus.NOT_FOUND);
       }

       Cliente cliente = new Cliente();

       cliente.setId(clienteById.get().getId());
       cliente.setNome(clienteById.get().getNome());
       cliente.setEndereco(clienteById.get().getEndereco());
       clienteRepository.save(cliente);

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    public ResponseEntity<Cliente> createCliente(ClienteTO clienteTO) {
        String cep = clienteTO.getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        Cliente cliente = new Cliente();

        cliente.setNome(clienteTO.getNome());
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    public ResponseEntity<Cliente> updateCliente(UUID id, ClienteTO clienteTO) {
        Optional<Cliente> clienteById = clienteRepository.findById(id);

        if (clienteById.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        String cep = clienteTO.getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        Cliente cliente = new Cliente();

        cliente.setId(clienteById.get().getId());
        cliente.setNome(clienteTO.getNome());
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    public ResponseEntity deleteCliente(UUID id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
