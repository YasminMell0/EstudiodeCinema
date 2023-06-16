package EstudioCinema.controller;

import EstudioCinema.model.bean.Filme;
import EstudioCinema.model.dao.DaoFilme;
import java.sql.SQLException;
import java.util.List;

public class ControllerFilme {
    
    DaoFilme daoFil;

    public Filme inserir(Filme filEnt) throws SQLException, ClassNotFoundException {
        daoFil = new DaoFilme();
        return daoFil.inserir(filEnt);
    }

    public Filme alterar(Filme filEnt) throws SQLException, ClassNotFoundException {
        daoFil = new DaoFilme();
        return daoFil.alterar(filEnt);
    }

    public Filme buscar(Filme filEnt) throws SQLException, ClassNotFoundException {
        daoFil = new DaoFilme();
        return daoFil.buscar(filEnt);
    }

    public Filme excluir(Filme filEnt) throws SQLException, ClassNotFoundException {
        daoFil = new DaoFilme();
        return daoFil.excluir(filEnt);
    }

    public List<Filme> listar(Filme filEnt) throws SQLException, ClassNotFoundException {
        daoFil = new DaoFilme();
        List<Filme> listaFil = daoFil.listar(filEnt);
        return listaFil;
    }
    
}
