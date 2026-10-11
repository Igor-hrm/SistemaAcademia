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

public class Cliente extends Pessoa {

    private String endereco;
    private final LocalDate dataCadastro;

    public Cliente(int id, String nome, String endereco, String telefone,
                   String email, String cpf) {
        super(id, nome, telefone, email, cpf);
        this.endereco = endereco;
        this.dataCadastro = LocalDate.now();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + getId() + ", nome=" + getNome() + ", endereco=" + endereco
                + ", telefone=" + getTelefone() + ", email=" + getEmail()
                + ", cadastro=" + dataCadastro + "}";
    }
}