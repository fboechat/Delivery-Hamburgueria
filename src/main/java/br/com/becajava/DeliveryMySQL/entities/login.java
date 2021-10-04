package br.com.becajava.DeliveryMySQL.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor // cria automaticamente um construtor com todas os atributos da classe como argumento.
@NoArgsConstructor // cria automaticamente um construtor vazio (sem argumentos).
@Data //cria automaticamente os métodos toString, equals, hashCode, getters e setters.
@Entity
public class login {
    @Id //chave primaria eh o campo logo abaixo (id)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //como sera o campo abaixo(id), sera auto-increment
    private Long idlogin;
    private String senha;
    private String nivel;
    private int clientes_idclientes;
}
