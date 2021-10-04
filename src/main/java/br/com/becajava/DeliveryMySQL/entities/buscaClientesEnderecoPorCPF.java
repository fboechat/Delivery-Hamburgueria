package br.com.becajava.DeliveryMySQL.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class buscaClientesEnderecoPorCPF {


        @Autowired
        private EntityManager entityManager;
        @RequestMapping(value = "/buscaclientes/{cpf}", method = RequestMethod.GET)
        public List<clientes> getCustByCPF(@PathVariable String cpf) {
            List<clientes> results = entityManager.createNativeQuery("select clientes.nome, clientes.telefone, clientes.email, enderecos.logradouro, enderecos.bairro, enderecos.cidade, enderecos.estado, enderecos.CEP from clientes inner join enderecos on clientes.idclientes=enderecos.clientes_idclientes and clientes.CPF = '" + cpf + "';").getResultList();
            return results;
        }

/*
            public List<clientes> getPlaces () {
                List<clientes> results = entityManager.createNativeQuery("select clientes.nome, clientes.telefone, clientes.email, enderecos.logradouro, enderecos.bairro, enderecos.cidade, enderecos.estado, enderecos.CEP from clientes inner join enderecos on clientes.idclientes=enderecos.clientes_idclientes and clientes.CPF = '" + getCustByCPF(cpf) + ";").getResultList();
                return results;
            }
            */

        }





