package br.com.becajava.DeliveryMySQL.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class buscaTodosPedidos {


        @Autowired
        private EntityManager entityManager;
        @RequestMapping(value = "/buscapedidos", method = RequestMethod.GET)
        public List<clientes> getPlaces() {
            List<clientes> results = entityManager.createNativeQuery("select estoque.item, estoque.preco, pedidos.forma_pagamento, pedidos.data, produtos.quantidadeDeProdutos, clientes.nome, pedidos.idpedidos from produtos inner join pedidos on produtos.pedidos_idpedidos=pedidos.idpedidos inner join estoque on produtos.estoque_idestoque = estoque.idestoque inner join clientes on produtos.pedidos_clientes_idclientes = clientes.idclientes and clientes.idclientes =\n" +
                    "'1';").getResultList();
            return results;
        }


    }


