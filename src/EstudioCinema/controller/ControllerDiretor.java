package EstudioCinema.controller;

import EstudioCinema.model.bean.Diretor;
import EstudioCinema.model.bean.Filme;
import EstudioCinema.model.dao.DaoDiretor;
import java.sql.SQLException;
import java.util.List;

public class ControllerDiretor {

    DaoDiretor daoDir;
    ControllerFilme contF;
    
    public Diretor inserir(Diretor dirEnt) throws SQLException, ClassNotFoundException {
        daoDir = new DaoDiretor();
        return daoDir.inserir(dirEnt);
    }

    public Diretor alterar(Diretor dirEnt) throws SQLException, ClassNotFoundException {
        daoDir = new DaoDiretor();
        return daoDir.alterar(dirEnt);
    }

    public Diretor buscar(Diretor dirEnt) throws SQLException, ClassNotFoundException {
        daoDir = new DaoDiretor();
        Diretor dir = daoDir.buscar(dirEnt);
        Filme f = new Filme(dir.getIdF());
        contF = new ControllerFilme();
        dir.setF(contF.buscar(f));
        return dir;
    }

    public Diretor excluir(Diretor dirEnt) throws SQLException, ClassNotFoundException {
        daoDir = new DaoDiretor();
        return daoDir.excluir(dirEnt);
    }

    public List<Diretor> listar(Diretor dirEnt) throws SQLException, ClassNotFoundException {
        daoDir = new DaoDiretor();
        List<Diretor> listadir = daoDir.listar(dirEnt);
        for (Diretor dirSaida : listadir) {
            Filme f = new Filme(dirSaida.getIdF());
            contF = new ControllerFilme();
            dirSaida.setF(contF.buscar(f));
        }
        return listadir;
    }
    
}
