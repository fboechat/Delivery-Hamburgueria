package br.com.becajava.DeliveryMySQL.controller;

import br.com.becajava.DeliveryMySQL.entities.Enderecos;
import br.com.becajava.DeliveryMySQL.entities.Clientes;
import br.com.becajava.DeliveryMySQL.repositories.EnderecoRepository;
import br.com.becajava.DeliveryMySQL.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    private final EnderecoRepository enderecoRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public EnderecoController(EnderecoRepository enderecoRepository, ClienteRepository clienteRepository) {
        this.enderecoRepository = enderecoRepository;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ResponseEntity<Enderecos> create(@RequestBody @Valid Enderecos enderecos) {
        Optional<Clientes> optionalLibrary = clienteRepository.findById(enderecos.getClientes().getId());
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        enderecos.setClientes(optionalLibrary.get());

        Enderecos savedEnderecos = enderecoRepository.save(enderecos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEnderecos.getId()).toUri();

        return ResponseEntity.created(location).body(savedEnderecos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enderecos> update(@RequestBody @Valid Enderecos enderecos, @PathVariable Integer id) {
        Optional<Clientes> optionalLibrary = clienteRepository.findById(enderecos.getClientes().getId());
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Enderecos> optionalBook = enderecoRepository.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        enderecos.setClientes(optionalLibrary.get());
        enderecos.setId(optionalBook.get().getId());
        enderecoRepository.save(enderecos);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Enderecos> delete(@PathVariable Integer id) {
        Optional<Enderecos> optionalBook = enderecoRepository.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        enderecoRepository.delete(optionalBook.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Enderecos>> getAll(Pageable pageable) {
        return ResponseEntity.ok(enderecoRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enderecos> getById(@PathVariable Integer id) {
        Optional<Enderecos> optionalBook = enderecoRepository.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalBook.get());
    }
}
