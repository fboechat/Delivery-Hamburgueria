package br.com.becajava.DeliveryMySQL.repositories;

import br.com.becajava.DeliveryMySQL.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// interface usado para o DAO
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

        }