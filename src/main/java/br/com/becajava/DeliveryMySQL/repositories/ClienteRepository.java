package br.com.becajava.DeliveryMySQL.repositories;

import br.com.becajava.DeliveryMySQL.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Clientes, Integer>{
}

