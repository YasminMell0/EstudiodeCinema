package EstudioCinema.controller;

import EstudioCinema.model.bean.Filme;
import EstudioCinema.model.bean.Roteirista;
import EstudioCinema.model.bean.RoteiristaFilme;
import EstudioCinema.model.dao.DaoRoteiristaFilme;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerRoteiristaFilme {

    DaoRoteiristaFilme daoRotFil;
    ControllerRoteirista contR;
    ControllerFilme contF;
    
    public RoteiristaFilme alterar(RoteiristaFilme rfEnt) throws SQLException, ClassNotFoundException{
        daoRotFil = new DaoRoteiristaFilme();
        return daoRotFil.alterar(rfEnt);
    }

    public RoteiristaFilme inserir(RoteiristaFilme rfEnt) throws SQLException, ClassNotFoundException{
        daoRotFil = new DaoRoteiristaFilme();
        return daoRotFil.inserir(rfEnt);
    }

    public RoteiristaFilme buscar(RoteiristaFilme rfEnt) throws SQLException, ClassNotFoundException{
        daoRotFil = new DaoRoteiristaFilme();
        RoteiristaFilme rf = daoRotFil.buscar(rfEnt);
        Roteirista r = new Roteirista(rf.getIdR());
        Filme f = new Filme(rf.getIdF());
        contR = new ControllerRoteirista();
        contF = new ControllerFilme();
        rf.setR(contR.buscar(r));
        rf.setF(contF.buscar(f));
        return rf;
    }

    public RoteiristaFilme excluir(RoteiristaFilme rfEnt) throws SQLException, ClassNotFoundException{
        daoRotFil = new DaoRoteiristaFilme();
        return daoRotFil.excluir(rfEnt);
    }

    public List<RoteiristaFilme> listar(RoteiristaFilme rfEnt) throws SQLException, ClassNotFoundException{
        daoRotFil = new DaoRoteiristaFilme();
        List<RoteiristaFilme> listarf = daoRotFil.listar(rfEnt);
        List<RoteiristaFilme> listarfAux = new ArrayList<>();
        
        for (RoteiristaFilme rfSaida : listarf) {
            listarfAux.add(buscar(rfSaida));
        }

        return listarfAux;
    }
    
}
