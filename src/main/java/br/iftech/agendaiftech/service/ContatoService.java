package br.iftech.agendaiftech.service;

import br.iftech.agendaiftech.dto.ContatoDTO;
import br.iftech.agendaiftech.entity.Contato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webjars.NotFoundException;

import java.util.Optional;

public interface ContatoService {

    Page<Contato> buscarTodos(Pageable pageable);

    Optional<Contato> buscarPorId(Long id) throws NotFoundException;

    Optional<Contato> salvar(ContatoDTO marca);

    void deletar(Contato marca);

}
