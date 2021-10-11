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
public class produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idprodutos;

    private int quantidadeDeProdutos;
    private int pedidos_idpedidos;
    private int estoque_idestoque;
    private int pedidos_clientes_idclientes;
}
