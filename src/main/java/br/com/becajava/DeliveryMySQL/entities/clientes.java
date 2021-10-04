package br.com.becajava.DeliveryMySQL.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor // cria automaticamente um construtor com todas os atributos da classe como argumento.
    @NoArgsConstructor // cria automaticamente um construtor vazio (sem argumentos).
    @Data //cria automaticamente os métodos toString, equals, hashCode, getters e setters.
    @Entity //classe será automaticamente mapeada à tabela com o mesmo nome (classe Contact e tabela Contact).

    public class clientes {
        @Id //chave primaria eh o campo logo abaixo (id)
        @GeneratedValue(strategy = GenerationType.IDENTITY) //como sera o campo abaixo(id), sera auto-increment
        @Column(name="idclientes")

        private Long id;

        //campos abaixo serao os mesmos no MySQL
        private String nome;
        private String telefone;
        private String email;

    }

