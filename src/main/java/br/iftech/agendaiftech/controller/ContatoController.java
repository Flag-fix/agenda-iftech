package br.iftech.agendaiftech.controller;


import br.iftech.agendaiftech.dto.ContatoDTO;
import br.iftech.agendaiftech.entity.Contato;
import br.iftech.agendaiftech.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
//@AllArgsConstructor
@RequestMapping("/v1/contatos")
@Tag(name = "Marca", description = "Operação relacionada a criação de Marca")
public class ContatoController {

    final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @Operation(description = "Salva Marca no banco de dados")
    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid ContatoDTO contatoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.salvar(contatoDTO));
    }

    @GetMapping
    public ResponseEntity<Page<Contato>> buscarTodos(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.buscarTodos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable(value = "id") Long id) throws NotFoundException {
        Optional<Contato> contatoOptional = contatoService.buscarPorId(id);

        if (contatoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contatoOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable(value = "id") Long id) throws NotFoundException {
        Optional<Contato> contatoOptional = contatoService.buscarPorId(id);

        if (contatoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");
        }
        contatoService.deletar(contatoOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Contato deletado");
    }
}
