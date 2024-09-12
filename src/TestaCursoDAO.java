import br.com.fafram.dao.CursoDAOImpl;
import br.com.fafram.model.Curso;
import br.com.fafram.utils.CursoNaoEncontradoException;

import java.sql.SQLException;
import java.util.List;

public class TestaCursoDAO {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setNome("Sistemas de Informação");
        curso1.setCargaHoraria(3700);

        CursoDAOImpl cursoDAO = new CursoDAOImpl();
        cursoDAO.cadastrar(curso1);

        List<Curso> cursos = cursoDAO.listar();
        for (Curso curso : cursos) {
            System.out.println(curso.getId());
            System.out.println(curso.getNome());
            System.out.println(curso.getCargaHoraria());
            System.out.println("-------------");
        }

        Curso c = cursoDAO.buscarPorId(1);
        System.out.println("Nome: " + c.getNome());

        c.setNome("Sistemas atualizado");

         cursoDAO.atualizar(c);

         cursoDAO.deletar(1);

        try {
            cursoDAO.buscarPorId2(1);
        } catch (CursoNaoEncontradoException | SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}
