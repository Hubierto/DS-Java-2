package com.mycompany.consultasmedicas.dao;

import com.mycompany.consultasmedicas.ConexaoMySQL;
import com.mycompany.consultasmedicas.modelo.Medico;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicoDAO {

    private static final Logger LOGGER = Logger.getLogger(MedicoDAO.class.getName());

    // Método para inserir um médico
    public void inserir(Medico medico) {
        String sql = "INSERT INTO Medico (nome, especialidade, crm) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setString(3, medico.getCrm());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao inserir médico", e);
        }
    }

    // Método para listar todos os médicos
    public ArrayList<Medico> listar() {
        ArrayList<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM Medico";
        try (Connection conn = ConexaoMySQL.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Medico medico = new Medico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("especialidade"),
                        rs.getString("crm")
                );
                lista.add(medico);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao listar médicos", e);
        }
        return lista;
    }

    // Método para buscar médicos por nome
    public ArrayList<Medico> buscarPorNome(String nome) {
        ArrayList<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM Medico WHERE nome LIKE ?";
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Medico medico = new Medico(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("especialidade"),
                            rs.getString("crm")
                    );
                    lista.add(medico);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar médicos por nome", e);
        }
        return lista;
    }

    // Método para atualizar os dados de um médico
    public void atualizar(Medico medico) {
        String sql = "UPDATE Medico SET nome = ?, especialidade = ?, crm = ? WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setString(3, medico.getCrm());
            stmt.setInt(4, medico.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar médico", e);
        }
    }

    // Método para remover um médico
    public void remover(int id) {
        String sql = "DELETE FROM Medico WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao remover médico", e);
        }
    }
}
