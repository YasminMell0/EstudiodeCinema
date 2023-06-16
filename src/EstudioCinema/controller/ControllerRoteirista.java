package EstudioCinema.controller;

import EstudioCinema.model.bean.Filme;
import EstudioCinema.model.bean.Roteirista;
import EstudioCinema.model.dao.DaoRoteirista;
import java.sql.SQLException;
import java.util.List;

public class ControllerRoteirista {

    DaoRoteirista daoRot;
    ControllerFilme contF;
    
    public List<Roteirista> listar(Roteirista rotEnt) throws SQLException, ClassNotFoundException {
        daoRot = new DaoRoteirista();
        List<Roteirista> listarot = daoRot.listar(rotEnt);
        for (Roteirista rotSaida : listarot) {
            Filme f = new Filme(rotSaida.getIdF());
            contF = new ControllerFilme();
            rotSaida.setF(contF.buscar(f));
        }
        return listarot;
    }

    public Roteirista inserir(Roteirista rotEnt) throws SQLException, ClassNotFoundException {
        daoRot = new DaoRoteirista();
        return daoRot.inserir(rotEnt);
    }

    public Roteirista alterar(Roteirista rotEnt) throws SQLException, ClassNotFoundException {
        daoRot = new DaoRoteirista();
        return daoRot.alterar(rotEnt);
    }

    public Roteirista buscar(Roteirista rotEnt) throws SQLException, ClassNotFoundException {
        daoRot = new DaoRoteirista();
        Roteirista rot = daoRot.buscar(rotEnt);
        Filme f = new Filme(rot.getIdF());
        contF = new ControllerFilme();
        rot.setF(contF.buscar(f));
        return rot;
    }

    public Roteirista excluir(Roteirista rotEnt) throws ClassNotFoundException, SQLException {
        daoRot = new DaoRoteirista();
        return daoRot.excluir(rotEnt);
    }
    
}
