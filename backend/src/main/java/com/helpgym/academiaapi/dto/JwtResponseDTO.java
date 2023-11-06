package com.helpgym.academiaapi.dto;

public class JwtResponseDTO {
    private String token;
    private Long id;
    private String nome;
    private String email;
    private String mensagem;

    // Construtor padrão
    public JwtResponseDTO() {
    }

    // Construtor com todos os campos
    public JwtResponseDTO(String token, Long id, String nome, String email, String mensagem) {
        this.token = token;
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.mensagem = mensagem;
    }

    // Getters e Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
