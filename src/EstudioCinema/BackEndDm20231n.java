package EstudioCinema;

import EstudioCinema.view.ManterEstudioCinema;
import EstudioCinema.view.ManterDiretor;
import EstudioCinema.view.ManterRoteirista;
import EstudioCinema.view.ManterUsuario;
import EstudioCinema.view.ManterFilme;
import EstudioCinema.view.ManterDiretorFilme;
import EstudioCinema.view.ManterRoteiristaFilme;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BackEndDm20231n {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Usuario \n 2 - Estudio de Cinema \n 3 - Diretor \n 4 - Roteirista \n 5 - Filme \n 6 - Diretor do Filme \n 7 - Roteirista do Filme \n";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
            case 1:
                ManterUsuario.menu();
                break;
            case 2:
                ManterEstudioCinema.menu();
                break;
            case 3:
                ManterDiretor.menu();
                break;
            case 4:
                ManterRoteirista.menu();
                break;
            case 5:
                ManterFilme.menu();
                break;
                
            case 6:
                ManterDiretorFilme.menu();
                break;
            
            case 7:
                ManterRoteiristaFilme.menu();
                break;

            default:
                System.out.println("Opção inválido");
        }
    }
    
}
