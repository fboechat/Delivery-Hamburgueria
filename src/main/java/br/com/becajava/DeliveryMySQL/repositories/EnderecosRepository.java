package br.com.becajava.DeliveryMySQL.repositories;

import br.com.becajava.DeliveryMySQL.entities.enderecos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// interface usado para o DAO
public interface EnderecosRepository extends JpaRepository<enderecos, Long> {

        }