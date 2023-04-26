package EstudioCinema.view;

import EstudioCinema.controller.ControllerDiretorFilme;
import EstudioCinema.model.bean.DiretorFilme;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterDiretorFilme {
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
        int idD = Integer.parseInt(JOptionPane.showInputDialog("IDD"));
        int idF = Integer.parseInt(JOptionPane.showInputDialog("IDF"));
        String cinematografia = JOptionPane.showInputDialog("Cinematografia");
        DiretorFilme dfEnt = new DiretorFilme(idD,idF, cinematografia);
        ControllerDiretorFilme contDf = new ControllerDiretorFilme();
        DiretorFilme dfSaida = contDf.inserir(dfEnt);
        JOptionPane.showMessageDialog(null,dfSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idD = Integer.parseInt(JOptionPane.showInputDialog("IDD"));
        int idF = Integer.parseInt(JOptionPane.showInputDialog("IDF"));
        String cinematografia = JOptionPane.showInputDialog("Cinematografia");
        DiretorFilme dfEnt = new DiretorFilme(id,idD,idF,cinematografia);
        ControllerDiretorFilme contDf = new ControllerDiretorFilme();
        DiretorFilme dfSaida = contDf.alterar(dfEnt);
        JOptionPane.showMessageDialog(null,dfSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        String cinematografia = JOptionPane.showInputDialog("Cinematografia");
        DiretorFilme dfEnt = new DiretorFilme(cinematografia);
        ControllerDiretorFilme contDf = new ControllerDiretorFilme();
        DiretorFilme dfSaida = contDf.buscar(dfEnt);
        JOptionPane.showMessageDialog(null,dfSaida.toString());
        JOptionPane.showMessageDialog(null,dfSaida.getD().toString());
        JOptionPane.showMessageDialog(null,dfSaida.getF().toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        String cinematografia = JOptionPane.showInputDialog("Cinematografia");
        DiretorFilme dfEnt = new DiretorFilme(cinematografia);
        ControllerDiretorFilme contDf = new ControllerDiretorFilme();
        DiretorFilme dfSaida = contDf.excluir(dfEnt);
        JOptionPane.showMessageDialog(null,dfSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String cinematografia = JOptionPane.showInputDialog("Cinematografia");
        DiretorFilme dfEnt = new DiretorFilme(cinematografia);
        ControllerDiretorFilme dfUsu = new ControllerDiretorFilme();
        List<DiretorFilme> listadf = dfUsu.listar(dfEnt);
        for (DiretorFilme dfSaida : listadf) {
            JOptionPane.showMessageDialog(null,dfSaida.toString());
            JOptionPane.showMessageDialog(null,dfSaida.getD().toString());
            JOptionPane.showMessageDialog(null,dfSaida.getF().toString());
        }
    }
}
