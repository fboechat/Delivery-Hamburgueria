package br.com.becajava.DeliveryMySQL.entities;

import br.com.becajava.DeliveryMySQL.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class buscaTodosClientes {


        @Autowired
        private EntityManager entityManager;
        @RequestMapping(value = "/buscaclientes", method = RequestMethod.GET)
        public List<clientes> getPlaces() {
            List<clientes> results = entityManager.createNativeQuery("select clientes.nome, clientes.telefone, clientes.email, enderecos.logradouro, enderecos.bairro, enderecos.cidade, enderecos.estado, enderecos.CEP from clientes inner join enderecos on clientes.idclientes=enderecos.clientes_idclientes;").getResultList();
            return results;
        }


    }


