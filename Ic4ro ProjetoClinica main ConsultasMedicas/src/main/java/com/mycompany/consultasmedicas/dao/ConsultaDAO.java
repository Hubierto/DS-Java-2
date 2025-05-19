package com.mycompany.consultasmedicas.dao;

import com.mycompany.consultasmedicas.ConexaoMySQL;
import com.mycompany.consultasmedicas.modelo.Consulta;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ConsultaDAO {

    public void inserir(Consulta consulta) {
        String sql = "INSERT INTO Consulta (paciente, medico, data, hora, observacao) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, consulta.getPaciente());
            stmt.setString(2, consulta.getMedico());
            stmt.setDate(3, Date.valueOf(consulta.getData()));  // Convertendo LocalDate para SQL Date
            stmt.setTime(4, Time.valueOf(consulta.getHora()));  // Convertendo LocalTime para SQL Time
            stmt.setString(5, consulta.getObservacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Consulta> listar() {
        ArrayList<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM Consulta";
        
        try (Connection conn = ConexaoMySQL.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Consulta consulta = new Consulta(
                        rs.getInt("id"),
                        rs.getString("paciente"),
                        rs.getString("medico"),
                        rs.getDate("data").toLocalDate(),
                        rs.getTime("hora").toLocalTime(),
                        rs.getString("observacao")
                );
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public void atualizar(Consulta consulta) {
        String sql = "UPDATE Consulta SET paciente = ?, medico = ?, data = ?, hora = ?, observacao = ? WHERE id = ?";
        
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, consulta.getPaciente());
            stmt.setString(2, consulta.getMedico());
            stmt.setDate(3, Date.valueOf(consulta.getData()));  // Convertendo LocalDate para SQL Date
            stmt.setTime(4, Time.valueOf(consulta.getHora()));  // Convertendo LocalTime para SQL Time
            stmt.setString(5, consulta.getObservacao());
            stmt.setInt(6, consulta.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM Consulta WHERE id = ?";
        
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Consulta> buscarPorNome(String nome) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT c.* FROM Consulta c "
                + "JOIN pacientes p ON c.id_paciente = p.id "
                + "WHERE p.nome LIKE ?";
        
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Consulta consulta;
                consulta = new Consulta(
                        rs.getInt("id"),
                        rs.getString("paciente"),
                        rs.getString("medico"),
                        rs.getDate("data").toLocalDate(),
                        rs.getTime("hora").toLocalTime(),
                        rs.getString("observacao")
                );
                consultas.add(consulta);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public ArrayList<Consulta> buscarPorData(LocalDate data) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM Consulta WHERE data = ?";
        
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(data));
            ResultSet rs = stmt.executeQuery();
            
           while (rs.next()) {
                Consulta consulta;
                consulta = new Consulta(
                        rs.getInt("id"),
                        rs.getString("paciente"),
                        rs.getString("medico"),
                        rs.getDate("data").toLocalDate(),
                        rs.getTime("hora").toLocalTime(),
                        rs.getString("observacao")
                );
                consultas.add(consulta);
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }
}
