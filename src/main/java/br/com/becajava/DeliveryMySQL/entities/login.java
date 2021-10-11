package br.com.becajava.DeliveryMySQL.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idlogin;
    private String senha;
    private String nivel;
    private int clientes_idclientes;
}
