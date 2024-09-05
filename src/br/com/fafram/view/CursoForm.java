package br.com.fafram.view;

import br.com.fafram.dao.CursoDAOImpl;
import br.com.fafram.model.Curso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CursoForm {
    private JPanel panel;
    private JTextField textFieldId;
    private JTextField textFieldNome;
    private JTextField textFieldCarga;
    private JButton cadastrarButton;
    private JButton atualizarButton;
    private JButton apagarButton;
    private JTable tableCursos;

    public CursoForm() {
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });
    }

    public void cadastrar() {
        String nome = textFieldNome.getText();
        String carga = textFieldCarga.getText();

        if (validaEntrada(nome, carga)) {
            Curso curso = new Curso();
            curso.setNome(nome);
            curso.setCargaHoraria(Integer.valueOf(carga));

            CursoDAOImpl cursoDAO = new CursoDAOImpl();
            cursoDAO.cadastrar(curso);
        }
    }

    public boolean validaEntrada(String nome, String carga) {

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome não pode ser vazio!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        int cargaHoraria;
        try {
            cargaHoraria = Integer.parseInt(carga);
            if (cargaHoraria <= 0) {
                throw new NumberFormatException("A carga horária deve ser um número inteiro e positivo.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de curso");
        frame.setContentPane(new CursoForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
