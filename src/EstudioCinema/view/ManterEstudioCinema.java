package EstudioCinema.view;

import EstudioCinema.controller.ControllerEstudioCinema;
import EstudioCinema.model.bean.EstudioCinema;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterEstudioCinema {
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
        int idD = Integer.parseInt(JOptionPane.showInputDialog("ID Diretor"));
        int idR = Integer.parseInt(JOptionPane.showInputDialog("ID Roteirista"));
        String nome = JOptionPane.showInputDialog("Nome");
        String dataCriacao = JOptionPane.showInputDialog("Data de Criação");
        EstudioCinema estEnt = new EstudioCinema(idF,idD,idR,nome,dataCriacao);
        ControllerEstudioCinema contEst = new ControllerEstudioCinema();
        EstudioCinema estSaida = contEst.inserir(estEnt);
        JOptionPane.showMessageDialog(null,estSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idF = Integer.parseInt(JOptionPane.showInputDialog("ID Filme"));
        int idD = Integer.parseInt(JOptionPane.showInputDialog("ID Diretor"));
        int idR = Integer.parseInt(JOptionPane.showInputDialog("ID Roteirista"));
        String nome = JOptionPane.showInputDialog("Nome");
        String dataCriacao = JOptionPane.showInputDialog("Data de Criação");
        EstudioCinema estEnt = new EstudioCinema(id,idF,idD,idR,nome,dataCriacao);
        ControllerEstudioCinema contEst = new ControllerEstudioCinema();
        EstudioCinema estSaida = contEst.alterar(estEnt);
        JOptionPane.showMessageDialog(null,estSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        EstudioCinema estEnt = new EstudioCinema(id);
        ControllerEstudioCinema contEst = new ControllerEstudioCinema();
        EstudioCinema estSaida = contEst.buscar(estEnt);
        JOptionPane.showMessageDialog(null,estSaida.toString());
        JOptionPane.showMessageDialog(null,estSaida.getF().toString());
        JOptionPane.showMessageDialog(null,estSaida.getD().toString());
        JOptionPane.showMessageDialog(null,estSaida.getR().toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        EstudioCinema estEnt = new EstudioCinema(id);
        ControllerEstudioCinema contEst = new ControllerEstudioCinema();
        EstudioCinema estSaida = contEst.excluir(estEnt);
        JOptionPane.showMessageDialog(null,estSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        EstudioCinema estEnt = new EstudioCinema(nome);
        ControllerEstudioCinema estUsu = new ControllerEstudioCinema();
        List<EstudioCinema> listaest = estUsu.listar(estEnt);
        for (EstudioCinema estSaida : listaest) {
            JOptionPane.showMessageDialog(null,estSaida.toString());
            JOptionPane.showMessageDialog(null,estSaida.getF().toString());
            JOptionPane.showMessageDialog(null,estSaida.getD().toString());
            JOptionPane.showMessageDialog(null,estSaida.getR().toString());
        }
    }

}
