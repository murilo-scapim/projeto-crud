package br.com.fafram.dao;

import br.com.fafram.db.DBConnection;
import br.com.fafram.interfaces.CursoDAO;
import br.com.fafram.model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public Curso buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void atualizar(Curso curso) {

    }

    @Override
    public void deletar(Curso curso) {

    }
}
