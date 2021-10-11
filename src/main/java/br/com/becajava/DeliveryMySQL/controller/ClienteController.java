package br.com.becajava.DeliveryMySQL.controller;

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
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @PostMapping
    public ResponseEntity<Clientes> create(@Valid @RequestBody Clientes clientes) {
        Clientes savedClientes = clienteRepository.save(clientes);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedClientes.getId()).toUri();

        return ResponseEntity.created(location).body(savedClientes);
    }
    /*
     REST body a ser enviado no POST:
    {
        "nome": "Priscilla Boechat",
            "cpf": "123456789",
            "email": "fboechat@gmail.com",
            "telefone": "2121212121",
            "enderecos": [
        {
            "logradouro": "Rua do XIXI",
                "bairro": "Jardim cagado 3",
                "cep": "28910430",
                "estado": "RJ",
                "cidade": "cabo frio"
        }
    ]
    }
    */
    @PutMapping("/{id}")
    public ResponseEntity<Clientes> update(@PathVariable Integer id, @Valid @RequestBody Clientes clientes) {
        Optional<Clientes> optionalLibrary = clienteRepository.findById(id);
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        clientes.setId(optionalLibrary.get().getId());
        clienteRepository.save(clientes);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Clientes> delete(@PathVariable Integer id) {
        Optional<Clientes> optionalLibrary = clienteRepository.findById(id);
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        clienteRepository.delete(optionalLibrary.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> getById(@PathVariable Integer id) {
        Optional<Clientes> optionalLibrary = clienteRepository.findById(id);
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalLibrary.get());
    }

    @GetMapping
    public ResponseEntity<Page<Clientes>> getAll(Pageable pageable) {
        return ResponseEntity.ok(clienteRepository.findAll(pageable));
    }
}
