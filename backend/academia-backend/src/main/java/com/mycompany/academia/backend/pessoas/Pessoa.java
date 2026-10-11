/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.academia.backend.pessoas;

/**
 *
 * @author iogor
 */

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Pessoa {

    private final int id;
    private String nome;
    private String telefone;
    private String email;
    private final String cpfPseudo;

    public Pessoa(int id, String nome, String telefone, String email, String cpf) {
        this.id = id;
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
        this.cpfPseudo = pseudoanonimizarCpf(cpf);
    }

    // Gera um "apelido" fixo do CPF , para não guardar o CPF real
    public static String pseudoanonimizarCpf(String cpf) {
        try {
            String apenasDigitos = cpf.replaceAll("\\D", "");
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(apenasDigitos.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 indisponível", e);
        }
    }

    public int getId() {
        return id;
    }

    public String getCpfPseudo() {
        return cpfPseudo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone é obrigatório");
        }
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{id=" + id + ", nome=" + nome + ", telefone=" + telefone
                + ", email=" + email + "}";
    }
}