package com.mycompany.consultasmedicas.controle;

import com.mycompany.consultasmedicas.dao.MedicoDAO;
import com.mycompany.consultasmedicas.modelo.Medico;
import java.util.ArrayList;

public class MedicoControle {

    private MedicoDAO dao = new MedicoDAO();

    public void cadastrar(String nome, String especialidade, String crm) {
        Medico medico = new Medico(0, nome, especialidade, crm);
        dao.inserir(medico);
    }

    public ArrayList<Medico> listar() {
        return dao.listar();
    }

    public void atualizar(int id, String nome, String especialidade, String crm) {
        Medico medico = new Medico(id, nome, especialidade, crm);
        dao.atualizar(medico);
    }

    public void remover(int id) {
        dao.remover(id);
    }

    public ArrayList<Medico> buscarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }
}
