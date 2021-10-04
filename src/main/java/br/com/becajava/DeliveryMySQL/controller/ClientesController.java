package br.com.becajava.DeliveryMySQL.controller;

import br.com.becajava.DeliveryMySQL.entities.clientes;
import br.com.becajava.DeliveryMySQL.repositories.ClientesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // representa uma classe com endpoints (URIs que serão expostas pela API)
// e a classe indica que o valor retornado pelos métodos
// devem ser vinculados ao corpo da resposta (response body).
@RequestMapping({"/clientes"}) // indica que a URL da API desse controller começa com /contatos,
// isso significa que pode-se acessar usando a URL http://localhost:8080/clientes (acesso local).

public class ClientesController {

    private ClientesRepository repositorio; // chama o DAO

    ClientesController(ClientesRepository contatoRepository) {
        this.repositorio = contatoRepository;
    }
    // métodos do CRUD aqui
    //
    // Um ponto importante é a anotação que foi utilizada em cada método que foi desenvolvido:
    //
    //    Listar todos os contatos - @GetMapping(“/contacts")
    //    Obter um contato específico pelo ID - @GetMapping(“/co>@GetMapping(“/contacts/{id}”)
    //    Remover um contato pelo ID - @GetMapping(“>@DeleteMapping(“/contacts/{id}”)
    //    Criar um novo contato - @GetMapping(“/contact>@PostMapping(“/contacts)
    //    Atualizar detalhes de um contato - @GetMapping(“>@PutMapping(“/contacts/{id}”)
    //
    //Apesar da URL ser a mesma (/contacts), o que garante os métodos HTTP diferentes são cada uma das anotações usadas em cada método.
    //
    // lista todos os contatos
    //
    // TESTE
    //

    //
    // END TESTE
    //
    @GetMapping
    public List<clientes> findAll(){
        return repositorio.findAll();
    }
    // lista por id
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){

        return repositorio.findById(id)
                //A lógica para obter um contato específico é utilizar o método findById da interface JpaRepository
                // (que irá fazer um select * from contacts where id = ?). Caso o registro seja encontrado, é retornado
                // o status HTTP 200 (ResponseEntity.ok()) e no corpo da resposta é enviado o registro.
                // Caso o registro não seja encontrado é retornado o status HTTP 404 - Não Encontrado
                // (ResponseEntity.notFound()).
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    // cria um usuario
    // deve-se selecionar no Postman body, raw e json
    //  e colar o request:
    // {
    //   "nome": "Priscilla Boechat",
    //   "email": "saboechat@gmail.com",
    //   "telefone": "(22) 111-1111"
    //}
    @PostMapping
    public clientes create(@RequestBody clientes contato){
        return repositorio.save(contato);
    }

    // atualizando contato
    @PutMapping(value="/{id}")

    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody clientes contato) {
        return repositorio.findById(id)
                .map(record -> {
                    record.setNome(contato.getNome());
                    record.setEmail(contato.getEmail());
                    record.setTelefone(contato.getTelefone());
                    clientes updated = repositorio.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());


    }

    // detelando um contato
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return repositorio.findById(id)
                .map(record -> {
                    repositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}