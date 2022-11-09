package br.iftech.agendaiftech.service.impl;

import br.iftech.agendaiftech.dto.ContatoDTO;
import br.iftech.agendaiftech.entity.Contato;
import br.iftech.agendaiftech.repository.ContatoRepository;
import br.iftech.agendaiftech.service.ContatoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;
@Service
//@AllArgsConstructor
public class ContatoServiceImpl implements ContatoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContatoServiceImpl.class);

    final ContatoRepository contatoRepository;

    public ContatoServiceImpl(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Override
    public Page<Contato> buscarTodos(Pageable pageable) {
        LOGGER.info("Buscando todos contatos");
        return contatoRepository.findAll(pageable);
    }

    @Override
    public Optional<Contato> buscarPorId(Long id){
        try {
            LOGGER.info("Buscando Contato pelo ID: {}", id);
            return contatoRepository.findById(id);
        }catch (Exception e) {
            LOGGER.error(e.toString(), e);
            throw new DataIntegrityViolationException(e.toString());
        }
    }

    @Override
    public Optional<Contato> salvar(ContatoDTO contatoDTO) {
        try {
            var contato = new Contato();
            BeanUtils.copyProperties(contatoDTO, contato);
            return Optional.of(contatoRepository.save(contato));
        }catch (Exception e) {
            LOGGER.error(e.toString(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Contato contato) {
        try {
            contatoRepository.delete(contato);
        } catch (Exception e) {
            LOGGER.error(e.toString(), e);
            throw new DataIntegrityViolationException("Ocorreu um erro ao apagar Objeto!!! " + e);
        }
    }
}
