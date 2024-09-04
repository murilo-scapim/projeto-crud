package br.com.fafram.interfaces;

import br.com.fafram.model.Curso;

import java.util.List;

public interface CursoDAO {

    public void cadastrar(Curso curso);
    public List<Curso> listar();
    public Curso buscarPorId(Integer id);
    public void atualizar(Curso curso);
    public void deletar(Integer id);
}
