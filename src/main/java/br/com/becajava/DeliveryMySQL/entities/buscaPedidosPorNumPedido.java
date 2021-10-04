package br.com.becajava.DeliveryMySQL.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class buscaPedidosPorNumPedido {


        @Autowired
        private EntityManager entityManager;
        @RequestMapping(value = "/buscapedidos/{numpedido}", method = RequestMethod.GET)
        public List<clientes> getCustByCPF(@PathVariable String numpedido) {
            List<clientes> results = entityManager.createNativeQuery("select estoque.item, estoque.preco, pedidos.forma_pagamento, pedidos.data, produtos.quantidadeDeProdutos, clientes.nome, pedidos.idpedidos from produtos inner join pedidos on produtos.pedidos_idpedidos=pedidos.idpedidos inner join estoque on produtos.estoque_idestoque = estoque.idestoque inner join clientes on produtos.pedidos_clientes_idclientes = clientes.idclientes and" +
                    " pedidos.idpedidos ='"+numpedido+"';").getResultList();
            return results;
        }

/*
            public List<clientes> getPlaces () {
                List<clientes> results = entityManager.createNativeQuery("select clientes.nome, clientes.telefone, clientes.email, enderecos.logradouro, enderecos.bairro, enderecos.cidade, enderecos.estado, enderecos.CEP from clientes inner join enderecos on clientes.idclientes=enderecos.clientes_idclientes and clientes.CPF = '" + getCustByCPF(cpf) + ";").getResultList();
                return results;
            }
            */

        }





