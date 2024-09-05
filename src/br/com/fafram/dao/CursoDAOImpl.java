package br.com.fafram.dao;

import br.com.fafram.db.DBConnection;
import br.com.fafram.interfaces.CursoDAO;
import br.com.fafram.model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImpl implements CursoDAO {
    @Override
    public void cadastrar(Curso curso) {
        String sql = "INSERT INTO cursos (nome, carga_horaria) VALUES (?, ?)";
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, curso.getNome());
            ps.setInt(2, curso.getCargaHoraria());
            ps.executeUpdate();
            System.out.println("Curso cadastrado");
            conn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Curso> listar() {
        String sql = "SELECT * FROM cursos";
        List<Curso> cursos = new ArrayList<>();

        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setCargaHoraria(rs.getInt("carga_horaria"));
                cursos.add(curso);
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return cursos;
    }

    @Override
    public Curso buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void atualizar(Curso curso) {
        String sql = "UPDATE cursos SET nome=?, carga_horaria=? WHERE id=?";
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,curso.getNome());
            ps.setInt(2,curso.getCargaHoraria());
            ps.setInt(3,curso.getId());
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (SQLException e ) {
            System.out.println(e);
        }
    }

    @Override
    public void deletar(Integer id) {
        String sql = "DELETE FROM cursos WHERE id=?";
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
