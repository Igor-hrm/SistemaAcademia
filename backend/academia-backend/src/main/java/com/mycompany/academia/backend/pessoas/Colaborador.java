/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.academia.backend.pessoas;

/**
 *
 * @author iogor
 */

import java.time.LocalDate;

public class Colaborador extends Pessoa {

    private String login;
    private String senha;
    private double salario;
    private final LocalDate dataAdmissao;
    private boolean ativo;

    public Colaborador(int id, String nome, String telefone, String email, String cpf,
                       String login, String senha, double salario, LocalDate dataAdmissao) {
        super(id, nome, telefone, email, cpf);
        setLogin(login);
        this.senha = senha;
        setSalario(salario);
        this.dataAdmissao = dataAdmissao;
        this.ativo = true;
    }

    // Retorna true se o login e a senha batem e o usuário está ativo
    public boolean autenticar(String login, String senha) {
        return ativo && this.login.equals(login) && this.senha.equals(senha);
    }

    public boolean isAdmin() {
        return false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null || login.isBlank()) {
            throw new IllegalArgumentException("Login é obrigatório");
        }
        this.login = login;
    }

    //  A senha só é acessível por subclasses (protected) nunca é exibida no toString
    protected String getSenha() {
        return senha;
    }

    protected void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("Salário não pode ser negativo");
        }
        this.salario = salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Colaborador{id=" + getId() + ", nome=" + getNome() + ", login=" + login
                + ", salario=" + salario + ", admissao=" + dataAdmissao
                + ", ativo=" + ativo + "}";
    }
}