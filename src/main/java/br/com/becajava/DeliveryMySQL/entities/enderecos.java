package br.com.becajava.DeliveryMySQL.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor // cria automaticamente um construtor com todas os atributos da classe como argumento.
@NoArgsConstructor // cria automaticamente um construtor vazio (sem argumentos).
@Data //cria automaticamente os métodos toString, equals, hashCode, getters e setters.
@Entity //classe será automaticamente mapeada à tabela com o mesmo nome (classe Contact e tabela Contact).
public class enderecos {

    @Id //chave primaria eh o campo logo abaixo (id)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //como sera o campo abaixo(id), sera auto-increment
   // @Column(name="idenderecos")
    private Long idenderecos;

    private String lograduro;
    private String bairro;
    private String cidade;
    private String estado;
    private String CEP;
    private int clientes_idclientes;


    }