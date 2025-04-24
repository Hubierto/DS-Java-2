/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastro1.controle;

/**
 *
 * @author aluno.den
 */
public class PessoaControle {
    private PessoaDAO dao = new PessoaDAO();
    
    public void cadastrar(String nome, int idade) {
        Pessoa p = new Pessoa(nome, idade);
        dao.inserir(p);
    }
    
    public Arraylist<Pessoa> Listar() {
        return dao.listar();
    }
   
    public void atualizar(int id, String nome, int idade) {
        Pessoa p = new Pessoa(id,nome,idade);
    }
    
      public void remover(int id) {
        dao.remover(id);
    }
    public ArrayList<Pessoa> buscarPorNome (String nome){
        return dao.buscarPorNome(nome);
    }
}
