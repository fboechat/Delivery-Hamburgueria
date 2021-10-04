package br.com.becajava.DeliveryMySQL.entities;

import br.com.becajava.DeliveryMySQL.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import br.com.becajava.DeliveryMySQL.repositories.ClientesRepository;

@RestController
@EntityScan({"br.com.becajava.DeliveryMySQL.entities.clientes"})

public class cadastraClientesPorCPF {
    private ClientesRepository repositorio; // chama o DAO

        @Autowired
        //private EntityManager entityManager;
        @PostMapping
        public clientes create(@RequestBody clientes contato){
            return repositorio.save(contato);
        }

/*
            public List<clientes> getPlaces () {
                List<clientes> results = entityManager.createNativeQuery("select clientes.nome, clientes.telefone, clientes.email, enderecos.logradouro, enderecos.bairro, enderecos.cidade, enderecos.estado, enderecos.CEP from clientes inner join enderecos on clientes.idclientes=enderecos.clientes_idclientes and clientes.CPF = '" + getCustByCPF(cpf) + ";").getResultList();
                return results;
            }
            */

        }





