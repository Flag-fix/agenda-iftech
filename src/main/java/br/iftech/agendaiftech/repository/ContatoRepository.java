package br.iftech.agendaiftech.repository;

import br.iftech.agendaiftech.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "contatos", path = "contatos")
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
