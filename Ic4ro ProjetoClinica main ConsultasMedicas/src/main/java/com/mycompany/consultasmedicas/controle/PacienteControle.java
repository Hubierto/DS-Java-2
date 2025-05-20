package com.mycompany.consultasmedicas.controle;

import com.mycompany.consultasmedicas.dao.PacienteDAO;
import com.mycompany.consultasmedicas.modelo.Paciente;
import com.mycompany.consultasmedicas.modelo.Consulta;
import java.util.ArrayList;

public class PacienteControle {

    private PacienteDAO dao = new PacienteDAO();

    public void cadastrar(String nome, String cpf, String telefone) {
        Paciente paciente = new Paciente(0, nome, cpf, telefone);
        dao.inserir(paciente);
    }

    public ArrayList<Paciente> listar() {
        return dao.listar();
    }

    public void atualizar(int id, String nome, String cpf, String telefone) {
        Paciente paciente = new Paciente(id, nome, cpf, telefone);
        dao.atualizar(paciente);
    }

    public void remover(int id) {
        dao.remover(id);
    }

    public ArrayList<Paciente> buscarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }
    

}
