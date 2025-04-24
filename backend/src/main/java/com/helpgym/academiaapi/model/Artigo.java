package com.helpgym.academiaapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "artigos")
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    @Size(max = 255, message = "O título deve ter no máximo 255 caracteres")
    private String titulo;

    @NotBlank(message = "O conteúdo resumido é obrigatório")
    @Size(max = 500, message = "O conteúdo resumido deve ter no máximo 500 caracteres")
    @Column(name = "conteudo_resumido")
    private String conteudoResumido;

    @NotBlank(message = "O conteúdo completo é obrigatório")
    @Column(name = "conteudo_completo", columnDefinition = "TEXT")
    private String conteudoCompleto;

    @Column(name = "url_imagem")
    private String urlImagem;

    // Construtores
    public Artigo() {
    }

    public Artigo(Long id, String titulo, String conteudoResumido, String conteudoCompleto, String urlImagem) {
        this.id = id;
        this.titulo = titulo;
        this.conteudoResumido = conteudoResumido;
        this.conteudoCompleto = conteudoCompleto;
        this.urlImagem = urlImagem;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudoResumido() {
        return conteudoResumido;
    }

    public void setConteudoResumido(String conteudoResumido) {
        this.conteudoResumido = conteudoResumido;
    }

    public String getConteudoCompleto() {
        return conteudoCompleto;
    }

    public void setConteudoCompleto(String conteudoCompleto) {
        this.conteudoCompleto = conteudoCompleto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
