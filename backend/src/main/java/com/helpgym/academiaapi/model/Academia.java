package com.helpgym.academiaapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "academia")
public class Academia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres")
    private String nome;

    @Column(name = "sobre_nos", columnDefinition = "TEXT")
    private String sobreNos;

    @Column(name = "url_logo")
    private String urlLogo;

    private String endereco;
    
    private String telefone;
    
    private String email;
    
    @Column(name = "horario_funcionamento")
    private String horarioFuncionamento;

    // Construtores
    public Academia() {
    }

    public Academia(Long id, String nome, String sobreNos, String urlLogo, String endereco, String telefone, String email, String horarioFuncionamento) {
        this.id = id;
        this.nome = nome;
        this.sobreNos = sobreNos;
        this.urlLogo = urlLogo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.horarioFuncionamento = horarioFuncionamento;
    }

    // Getters e Setters
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

    public String getSobreNos() {
        return sobreNos;
    }

    public void setSobreNos(String sobreNos) {
        this.sobreNos = sobreNos;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }
}
