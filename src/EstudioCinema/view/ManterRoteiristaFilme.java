/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstudioCinema.view;

import EstudioCinema.controller.ControllerRoteiristaFilme;
import EstudioCinema.model.bean.RoteiristaFilme;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterRoteiristaFilme {
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
        int idR = Integer.parseInt(JOptionPane.showInputDialog("IDR"));
        int idF = Integer.parseInt(JOptionPane.showInputDialog("IDF"));
        String tituloRoteiro = JOptionPane.showInputDialog("tituloRoteiro");
        RoteiristaFilme rfEnt = new RoteiristaFilme(idR,idF, tituloRoteiro);
        ControllerRoteiristaFilme contRf = new ControllerRoteiristaFilme();
        RoteiristaFilme rfSaida = contRf.inserir(rfEnt);
        JOptionPane.showMessageDialog(null,rfSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idR = Integer.parseInt(JOptionPane.showInputDialog("IDR"));
        int idF = Integer.parseInt(JOptionPane.showInputDialog("IDF"));
        String tituloRoteiro = JOptionPane.showInputDialog("tituloRoteiro");
        RoteiristaFilme rfEnt = new RoteiristaFilme(id,idR,idF,tituloRoteiro);
        ControllerRoteiristaFilme contRf = new ControllerRoteiristaFilme();
        RoteiristaFilme rfSaida = contRf.alterar(rfEnt);
        JOptionPane.showMessageDialog(null,rfSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        String tituloRoteiro = JOptionPane.showInputDialog("tituloRoteiro");
        RoteiristaFilme rfEnt = new RoteiristaFilme(tituloRoteiro);
        ControllerRoteiristaFilme contRf = new ControllerRoteiristaFilme();
        RoteiristaFilme rfSaida = contRf.buscar(rfEnt);
        JOptionPane.showMessageDialog(null,rfSaida.toString());
        JOptionPane.showMessageDialog(null,rfSaida.getR().toString());
        JOptionPane.showMessageDialog(null,rfSaida.getF().toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        String tituloRoteiro = JOptionPane.showInputDialog("tituloRoteiro");
        RoteiristaFilme rfEnt = new RoteiristaFilme(tituloRoteiro);
        ControllerRoteiristaFilme contRf = new ControllerRoteiristaFilme();
        RoteiristaFilme rfSaida = contRf.excluir(rfEnt);
        JOptionPane.showMessageDialog(null,rfSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String tituloRoteiro = JOptionPane.showInputDialog("tituloRoteiro");
        RoteiristaFilme rfEnt = new RoteiristaFilme(tituloRoteiro);
        ControllerRoteiristaFilme rfUsu = new ControllerRoteiristaFilme();
        List<RoteiristaFilme> listarf = rfUsu.listar(rfEnt);
        for (RoteiristaFilme rfSaida : listarf) {
            JOptionPane.showMessageDialog(null,rfSaida.toString());
            JOptionPane.showMessageDialog(null,rfSaida.getR().toString());
            JOptionPane.showMessageDialog(null,rfSaida.getF().toString());
        }
    }
}
