import br.com.fafram.dao.CursoDAOImpl;
import br.com.fafram.model.Curso;

public class TestaCursoDAO {
    public static void main(String[] args) {

        Curso curso = new Curso();
        curso.setNome("Sistemas de Informação");
        curso.setCargaHoraria(3700);

        CursoDAOImpl cursoDAO = new CursoDAOImpl();
        cursoDAO.cadastrar(curso);
    }
}
