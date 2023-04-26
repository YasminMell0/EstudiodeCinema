package EstudioCinema.view;

import EstudioCinema.controller.ControllerDiretor;
import EstudioCinema.model.bean.Diretor;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterDiretor {
        public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao invalida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
        int idF = Integer.parseInt(JOptionPane.showInputDialog("ID Filme"));
        String nome = JOptionPane.showInputDialog("Nome");
        String formacao = JOptionPane.showInputDialog("Formação");
        String qtdFilmes = JOptionPane.showInputDialog("Quantidade de Filmes");
        Diretor dirEnt = new Diretor(idF,nome,formacao,qtdFilmes);
        ControllerDiretor contDir = new ControllerDiretor();
        Diretor dirSaida = contDir.inserir(dirEnt);
        JOptionPane.showMessageDialog(null,dirSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idF = Integer.parseInt(JOptionPane.showInputDialog("ID Filme"));
        String nome = JOptionPane.showInputDialog("Nome");
        String formacao = JOptionPane.showInputDialog("Formação");
        String qtdFilmes = JOptionPane.showInputDialog("Quantidade de Filmes");
        Diretor dirEnt = new Diretor(id,idF,nome,formacao,qtdFilmes);
        ControllerDiretor contDir = new ControllerDiretor();
        Diretor dirSaida = contDir.alterar(dirEnt);
        JOptionPane.showMessageDialog(null,dirSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Diretor dirEnt = new Diretor(id);
        ControllerDiretor contDir = new ControllerDiretor();
        Diretor dirSaida = contDir.buscar(dirEnt);
        JOptionPane.showMessageDialog(null,dirSaida.toString());
        JOptionPane.showMessageDialog(null,dirSaida.getF().toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Diretor dirEnt = new Diretor(id);
        ControllerDiretor contDir = new ControllerDiretor();
        Diretor dirSaida = contDir.excluir(dirEnt);
        JOptionPane.showMessageDialog(null,dirSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        Diretor dirEnt = new Diretor(nome);
        ControllerDiretor dirUsu = new ControllerDiretor();
        List<Diretor> listadir = dirUsu.listar(dirEnt);
        for (Diretor dirSaida : listadir) {
            JOptionPane.showMessageDialog(null,dirSaida.toString());
            JOptionPane.showMessageDialog(null,dirSaida.getF().toString());
        }
    }

}
