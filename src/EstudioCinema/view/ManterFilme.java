package EstudioCinema.view;

import EstudioCinema.controller.ControllerFilme;
import EstudioCinema.model.bean.Filme;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterFilme {
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
        String nome = JOptionPane.showInputDialog("Nome");
        String genero = JOptionPane.showInputDialog("Genero");
        String tramaPrincipal = JOptionPane.showInputDialog("Trama Principal");
        String anoLanc = JOptionPane.showInputDialog("Ano de Lançamento");
        String desc = JOptionPane.showInputDialog("Descrição");
        Filme filEnt = new Filme(nome,genero,tramaPrincipal,anoLanc,desc);
        ControllerFilme contFil = new ControllerFilme();
        Filme filSaida = contFil.inserir(filEnt);
        JOptionPane.showMessageDialog(null,filSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("Nome");
        String genero = JOptionPane.showInputDialog("Genero");
        String tramaPrincipal = JOptionPane.showInputDialog("Trama Principal");
        String anoLanc = JOptionPane.showInputDialog("Ano de Lançamento");
        String desc = JOptionPane.showInputDialog("Descrição");
        Filme filEnt = new Filme(id,nome,genero,tramaPrincipal,anoLanc,desc);
        ControllerFilme contFil = new ControllerFilme();
        Filme filSaida = contFil.alterar(filEnt);
        JOptionPane.showMessageDialog(null,filSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Filme filEnt = new Filme(id);
        ControllerFilme contFil = new ControllerFilme();
        Filme filSaida = contFil.buscar(filEnt);
        JOptionPane.showMessageDialog(null,filSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Filme filEnt = new Filme(id);
        ControllerFilme contFil = new ControllerFilme();
        Filme filSaida = contFil.excluir(filEnt);
        JOptionPane.showMessageDialog(null,filSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        Filme filEnt = new Filme(nome);
        ControllerFilme filUsu = new ControllerFilme();
        List<Filme> listafil = filUsu.listar(filEnt);
        for (Filme filSaida : listafil) {
            JOptionPane.showMessageDialog(null,filSaida.toString());
        }
    }
}
