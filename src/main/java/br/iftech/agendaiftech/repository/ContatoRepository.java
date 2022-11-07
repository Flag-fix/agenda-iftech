package br.iftech.agendaiftech.repository;

import br.iftech.agendaiftech.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "contatos", path = "contatos")
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
