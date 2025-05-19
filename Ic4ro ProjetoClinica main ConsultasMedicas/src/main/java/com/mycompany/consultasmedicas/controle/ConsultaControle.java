package com.mycompany.consultasmedicas.controle;

import com.mycompany.consultasmedicas.dao.ConsultaDAO;
import com.mycompany.consultasmedicas.modelo.Consulta;
import com.mycompany.consultasmedicas.modelo.Medico;
import com.mycompany.consultasmedicas.modelo.Paciente;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ConsultaControle {

    private ConsultaDAO dao = new ConsultaDAO();

    public void cadastrar(String Paciente, String Medico, LocalDate data, LocalTime hora, String observacao) {
        Consulta consulta = new Consulta(0, Paciente, Medico, data, hora, observacao);
        dao.inserir(consulta);
    }

    public ArrayList<Consulta> listar() {
        return dao.listar();
    }

    public void atualizar(int id, String Paciente, String Medico, LocalDate data, LocalTime hora, String observacao) {
        Consulta consulta = new Consulta(id, Paciente, Medico, data, hora, observacao);
        dao.atualizar(consulta);
    }

    public void remover(int id) {
        dao.remover(id);
    }

    public ArrayList<Consulta> buscarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }

    public ArrayList<Consulta> buscarPorData(LocalDate data) {
        return dao.buscarPorData(data);
    }
}
