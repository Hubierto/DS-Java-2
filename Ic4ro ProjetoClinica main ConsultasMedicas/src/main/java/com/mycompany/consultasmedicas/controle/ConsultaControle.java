package com.mycompany.consultasmedicas.controle;

import com.mycompany.consultasmedicas.dao.ConsultaDAO;
import com.mycompany.consultasmedicas.modelo.Consulta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ConsultaControle {

    private ConsultaDAO consultaDAO;

    public ConsultaControle() {
        this.consultaDAO = new ConsultaDAO();
    }

    public void agendarConsulta(int idPaciente, int idMedico, String data, String hora, String observacoes) {
        LocalDate dataFormatada = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalTime horaFormatada = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
        Consulta consulta = new Consulta(0, dataFormatada, horaFormatada, observacoes, idPaciente, idMedico);
        consultaDAO.inserir(consulta);
    }

    public void alterarConsulta(int idConsulta, int idPaciente, int idMedico, String data, String hora, String observacoes) {
        LocalDate dataFormatada = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalTime horaFormatada = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
        Consulta consulta = new Consulta(idConsulta, dataFormatada, horaFormatada, observacoes, idPaciente, idMedico);
        consultaDAO.atualizar(consulta);
    }

    public void removerConsulta(int idConsulta) {
        consultaDAO.remover(idConsulta);
    }

    public ArrayList<Consulta> listarConsultas() {
        return consultaDAO.listar();
    }
}



/*package com.mycompany.consultasmedicas.controle;

import com.mycompany.consultasmedicas.dao.ConsultaDAO;
import com.mycompany.consultasmedicas.modelo.Consulta;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ConsultaControle {

    private ConsultaDAO dao = new ConsultaDAO();

    public void cadastrar(int idPaciente, int idMedico, LocalDate data, LocalTime hora, String observacao) {
        Consulta consulta = new Consulta(0, idPaciente, idMedico, data, hora, observacao);
        dao.inserir(consulta);
    }

    public ArrayList<Consulta> listar() {
        return dao.listar();
    }

    public void atualizar(int id, int idPaciente, int idMedico, LocalDate data, LocalTime hora, String observacao) {
        Consulta consulta = new Consulta(id, idPaciente, idMedico, data, hora, observacao);
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

    public void agendarConsulta(int idPaciente, int idMedico, String data, String hora, String observacoes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void alterarConsulta(int idConsulta, int idPaciente, int idMedico, String data, String hora, String observacoes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void removerConsulta(int idConsulta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}*/
