package br.com.fafram.interfaces;

import br.com.fafram.model.Curso;
import br.com.fafram.utils.CursoNaoEncontradoException;

import java.sql.SQLException;
import java.util.List;

public interface CursoDAO {

    public void cadastrar(Curso curso);
    public List<Curso> listar();
    public Curso buscarPorId(Integer id);
    public Curso buscarPorId2(Integer id) throws SQLException, CursoNaoEncontradoException;
    public void atualizar(Curso curso);
    public void deletar(Integer id);
}