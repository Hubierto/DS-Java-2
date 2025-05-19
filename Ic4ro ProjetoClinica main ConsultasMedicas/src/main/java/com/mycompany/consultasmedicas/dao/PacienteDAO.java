package com.mycompany.consultasmedicas.dao;

import com.mycompany.consultasmedicas.ConexaoMySQL;
import com.mycompany.consultasmedicas.modelo.Consulta;
import com.mycompany.consultasmedicas.modelo.Paciente;
import java.sql.*;
import java.util.ArrayList;

public class PacienteDAO {

    public void inserir(Paciente paciente) {
        String sql = "INSERT INTO Paciente (nome, cpf, telefone) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Paciente> listar() {
        ArrayList<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Paciente";
        try (Connection conn = ConexaoMySQL.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Paciente paciente = new Paciente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone")
                );
                lista.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Paciente> buscarPorNome(String nome) {
        ArrayList<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Paciente WHERE nome LIKE ?";
        
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone")
                );
                lista.add(paciente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizar(Paciente paciente) {
        String sql = "UPDATE Paciente SET nome = ?, cpf = ?, telefone = ? WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getTelefone());
            stmt.setInt(4, paciente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM Paciente WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Consulta> buscarPorNomeOuData(String nomePaciente, String dataConsulta) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT c.id, c.id_paciente, c.id_medico, c.data, c.hora, c.observacao " +
                     "FROM consultas c " +
                     "JOIN pacientes p ON p.id = c.id_paciente " +
                     "WHERE p.nome LIKE ? OR c.data = ?";

        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nomePaciente + "%");
            stmt.setString(2, dataConsulta);  // Data no formato 'YYYY-MM-DD'

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
