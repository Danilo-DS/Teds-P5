package br.com.aulacarlos.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aulacarlos.application.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
