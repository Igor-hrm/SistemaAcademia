/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.academia.backend;

/**
 *
 * @author igor
 */
public class AcademiaBackend {

    public static void main(String[] args) {
        // teste cliente
        com.mycompany.academia.backend.pessoas.Cliente c =
        new com.mycompany.academia.backend.pessoas.Cliente(
            1, "Maria", "Rua A, 10", "38999990000", "maria@email.com", "123.456.789-09");
        System.out.println(c);
        System.out.println(c.getCpfPseudo());
        
        //teste Cilaborador
        
        var colab = new com.mycompany.academia.backend.pessoas.Colaborador(
            1, "Igor", "38999990000", "igor@email.com", "111.222.333-44",
                "igor", "senha123", 3000, java.time.LocalDate.now());
            System.out.println(colab);
            System.out.println(colab.autenticar("igor", "senha123")); // true
            System.out.println(colab.autenticar("igor", "errada"));   // false
            System.out.println(colab.isAdmin());                      // false
        }
}
