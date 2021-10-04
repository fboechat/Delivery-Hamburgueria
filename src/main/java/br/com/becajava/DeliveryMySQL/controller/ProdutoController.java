package br.com.becajava.DeliveryMySQL.controller;

import br.com.becajava.DeliveryMySQL.repositories.EnderecosRepository;
import org.springframework.web.bind.annotation.*;

@RestController // representa uma classe com endpoints (URIs que serão expostas pela API)
// e a classe indica que o valor retornado pelos métodos
// devem ser vinculados ao corpo da resposta (response body).
@RequestMapping({"/produtos"}) // indica que a URL da API desse controller começa com /contatos,
// isso significa que pode-se acessar usando a URL http://localhost:8080/contatos (acesso local).
public class ProdutoController {

    private EnderecosRepository produtoRepositorio; // chama o DAO

    ProdutoController(EnderecosRepository ProductRepositorio) {

        this.produtoRepositorio = ProductRepositorio;
    }
    // métodos do CRUD aqui

    // lista todos os produtos
    //
    /*
    @GetMapping
    public String listContact(Model model) {

        model.addAttribute("produtos", produtoRepositorio.findAll());
       return "listaclientes";
            // return produtoRepositorio.findAll();
        }

    // lista por id
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long idpedidos){

        return produtoRepositorio.findById(idpedidos)
                //A lógica para obter um contato específico é utilizar o método findById da interface JpaRepository
                // (que irá fazer um select * from contacts where id = ?). Caso o registro seja encontrado, é retornado
                // o status HTTP 200 (ResponseEntity.ok()) e no corpo da resposta é enviado o registro.
                // Caso o registro não seja encontrado é retornado o status HTTP 404 - Não Encontrado
                // (ResponseEntity.notFound()).
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


//        model.addAttribute("contacts", contactList);
//        return "contact";
*/

}