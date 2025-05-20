package com.mycompany.consultasmedicas.dao;

import com.mycompany.consultasmedicas.modelo.Consulta;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ConsultaDAO {

    private Connection conexao;

    public ConsultaDAO() {
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }

    public void inserir(Consulta consulta) {
        String sql = "INSERT INTO Consulta (data, hora, observacao, fk_Paciente_id, fk_Medico_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(consulta.getData()));
            stmt.setTime(2, Time.valueOf(consulta.getHora()));
            stmt.setString(3, consulta.getObservacao());
            stmt.setInt(4, consulta.getIdPaciente());
            stmt.setInt(5, consulta.getIdMedico());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir consulta", e);
        }
    }

    public void atualizar(Consulta consulta) {
        String sql = "UPDATE Consulta SET data=?, hora=?, observacao=?, fk_Paciente_id=?, fk_Medico_id=? WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(consulta.getData()));
            stmt.setTime(2, Time.valueOf(consulta.getHora()));
            stmt.setString(3, consulta.getObservacao());
            stmt.setInt(4, consulta.getIdPaciente());
            stmt.setInt(5, consulta.getIdMedico());
            stmt.setInt(6, consulta.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar consulta", e);
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM Consulta WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover consulta", e);
        }
    }

    public ArrayList<Consulta> listar() {
        ArrayList<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM Consulta";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Consulta consulta = new Consulta(
                        rs.getInt("id"),
                        rs.getDate("data").toLocalDate(),
                        rs.getTime("hora").toLocalTime(),
                        rs.getString("observacao"),
                        rs.getInt("fk_Paciente_id"),
                        rs.getInt("fk_Medico_id")
                );
                lista.add(consulta);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar consultas", e);
        }

        return lista;
    }
}

/*package com.mycompany.consultasmedicas.dao;

import com.mycompany.consultasmedicas.ConexaoMySQL;
import com.mycompany.consultasmedicas.modelo.Consulta;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ConsultaDAO {

    public void inserir(Consulta consulta) {
        String sql = "INSERT INTO Consulta (id_paciente, id_medico, data, hora, observacao) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, consulta.getIdPaciente());
            stmt.setInt(2, consulta.getIdMedico());
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
                        rs.getInt("id_paciente"),
                        rs.getInt("id_medico"),
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
        String sql = "UPDATE Consulta SET id_paciente = ?, id_medico = ?, data = ?, hora = ?, observacao = ? WHERE id = ?";
        
        try (Connection conn = ConexaoMySQL.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, consulta.getIdPaciente());
            stmt.setInt(2, consulta.getIdMedico());
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
                Consulta consulta = new Consulta(
                        rs.getInt("id"),
                        rs.getInt("id_paciente"),
                        rs.getInt("id_medico"),
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
                Consulta consulta = new Consulta(
                        rs.getInt("id"),
                        rs.getInt("id_paciente"),
                        rs.getInt("id_medico"),
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
}*/
