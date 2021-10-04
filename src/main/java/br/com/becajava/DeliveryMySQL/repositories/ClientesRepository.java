package br.com.becajava.DeliveryMySQL.repositories;

import br.com.becajava.DeliveryMySQL.entities.clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
// interface usado para o DAO
public interface ClientesRepository extends JpaRepository<clientes, Long> {
        @Query(value="select * from clientes u where c.nome like '%?1'", nativeQuery = true)
        Collection<clientes> findAllUsersByName();
        }