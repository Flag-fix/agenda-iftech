package br.iftech.agendaiftech.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;

//@Data
public class ContatoDTO {

    @Schema(
            example = "1",
            description = "Identificação de um Contato"
    )
    @JsonProperty("id")
    private Long id;

    @Schema(
            example = "Fulano de Tal",
            description = "Nome de um Contato",
            required = true
    )
    @JsonProperty("nome")
    @NotEmpty(message = "Nome não pode ser nulo ou vazio")
    private String nome;

    @Schema(
            example = "44 99135-5425",
            description = "Número de um contato",
            required = true
    )
    @JsonProperty("telefone")
    @NotEmpty(message = "Número não pode ser nulo ou vazio")
    private String telefone;

    @Schema(
            example = "a@a.com.br",
            description = "E-mail de um Contato",
            required = true
    )
    @JsonProperty("email")
    @NotEmpty(message = "E-mail não pode ser nulo ou vazio")
    private String email;

    @Schema(
            example = "sitedafoto.com.br/imagem.jpg",
            description = "Identificação da URL de um Contato"
    )
    @JsonProperty("urlFoto")
    private String urlFoto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}