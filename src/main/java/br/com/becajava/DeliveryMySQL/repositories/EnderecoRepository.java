package br.com.becajava.DeliveryMySQL.repositories;

import br.com.becajava.DeliveryMySQL.entities.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Enderecos, Integer>{
}
