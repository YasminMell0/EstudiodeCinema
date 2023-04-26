package EstudioCinema.controller;

import EstudioCinema.model.bean.Diretor;
import EstudioCinema.model.bean.EstudioCinema;
import EstudioCinema.model.bean.Filme;
import EstudioCinema.model.bean.Roteirista;
import EstudioCinema.model.dao.DaoEstudioCinema;
import java.sql.SQLException;
import java.util.List;

public class ControllerEstudioCinema {
    
    DaoEstudioCinema daoEst;
    ControllerFilme contF;
    ControllerDiretor contD;
    ControllerRoteirista contR;

    public EstudioCinema inserir(EstudioCinema estEnt) throws SQLException, ClassNotFoundException {
        daoEst = new DaoEstudioCinema();
        return daoEst.inserir(estEnt);
    }

    public EstudioCinema alterar(EstudioCinema estEnt) throws SQLException, ClassNotFoundException {
        daoEst = new DaoEstudioCinema();
        return daoEst.alterar(estEnt);
    }

    public List<EstudioCinema> listar(EstudioCinema estEnt) throws SQLException, ClassNotFoundException {
        daoEst = new DaoEstudioCinema();
        List<EstudioCinema> listaest = daoEst.listar(estEnt);
        for (EstudioCinema estSaida : listaest) {
            Filme f = new Filme(estSaida.getIdF());
            contF = new ControllerFilme();
            estSaida.setF(contF.buscar(f));
            
            Diretor d = new Diretor(estSaida.getIdD());
            contD = new ControllerDiretor();
            estSaida.setD(contD.buscar(d));
            
            Roteirista r = new Roteirista(estSaida.getIdR());
            contR = new ControllerRoteirista();
            estSaida.setR(contR.buscar(r));
        }

        return listaest;
    }

    public EstudioCinema excluir(EstudioCinema estEnt) throws SQLException, ClassNotFoundException {
        daoEst = new DaoEstudioCinema();
        return daoEst.excluir(estEnt);
    }

    public EstudioCinema buscar(EstudioCinema estEnt) throws SQLException, ClassNotFoundException {
        daoEst = new DaoEstudioCinema();
        EstudioCinema ec = daoEst.buscar(estEnt);
        Filme f = new Filme(ec.getIdF());
        Diretor d = new Diretor(ec.getIdD());
        Roteirista r = new Roteirista(ec.getIdR());
        contF = new ControllerFilme();
        contD = new ControllerDiretor();
        contR = new ControllerRoteirista();
        ec.setF(contF.buscar(f));
        ec.setD(contD.buscar(d));
        ec.setR(contR.buscar(r));
        return ec;
    }
    
}
