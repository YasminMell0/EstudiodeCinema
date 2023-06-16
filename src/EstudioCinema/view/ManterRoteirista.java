package EstudioCinema.view;

import EstudioCinema.controller.ControllerRoteirista;
import EstudioCinema.model.bean.Roteirista;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterRoteirista {
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
        Roteirista rotEnt = new Roteirista(idF,nome,formacao,qtdFilmes);
        ControllerRoteirista contRot = new ControllerRoteirista();
        Roteirista rotSaida = contRot.inserir(rotEnt);
        JOptionPane.showMessageDialog(null,rotSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idF = Integer.parseInt(JOptionPane.showInputDialog("ID Filme"));
        String nome = JOptionPane.showInputDialog("Nome");
        String formacao = JOptionPane.showInputDialog("Formação");
        String qtdFilmes = JOptionPane.showInputDialog("Quantidade de Filmes");
        Roteirista rotEnt = new Roteirista(id,idF,nome,formacao,qtdFilmes);
        ControllerRoteirista contRot = new ControllerRoteirista();
        Roteirista rotSaida = contRot.alterar(rotEnt);
        JOptionPane.showMessageDialog(null,rotSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Roteirista rotEnt = new Roteirista(id);
        ControllerRoteirista contRot = new ControllerRoteirista();
        Roteirista rotSaida = contRot.buscar(rotEnt);
        JOptionPane.showMessageDialog(null,rotSaida.toString());
        JOptionPane.showMessageDialog(null,rotSaida.getF().toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Roteirista rotEnt = new Roteirista(id);
        ControllerRoteirista contRot = new ControllerRoteirista();
        Roteirista rotSaida = contRot.excluir(rotEnt);
        JOptionPane.showMessageDialog(null,rotSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        Roteirista rotEnt = new Roteirista(nome);
        ControllerRoteirista rotUsu = new ControllerRoteirista();
        List<Roteirista> listarot = rotUsu.listar(rotEnt);
        for (Roteirista rotSaida : listarot) {
            JOptionPane.showMessageDialog(null,rotSaida.toString());
            JOptionPane.showMessageDialog(null,rotSaida.getF().toString());
        }
    }

}
