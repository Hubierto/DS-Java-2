/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultasmedicas.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author aluno.den
 */
public class Consulta {
    private int id;
    private String Paciente;  
    private String Medico;    
    private LocalDate data;
    private LocalTime hora;
    private String observacao;

    public Consulta() {
    }

    public Consulta(int id, String Paciente, String Medico, LocalDate data, LocalTime hora, String observacao) {
        this.id = id;
        this.Paciente = Paciente;
        this.Medico = Medico;
        this.data = data;
        this.hora = hora;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaciente() {
        return Paciente;
    }

    public void setPaciente(String Paciente) {
        this.Paciente = Paciente;
    }

    public String getMedico() {
        return Medico;
    }

    public void setMedico(String Medico) {
        this.Medico = Medico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}

