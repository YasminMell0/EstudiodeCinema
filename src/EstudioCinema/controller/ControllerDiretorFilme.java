package EstudioCinema.controller;

import EstudioCinema.model.bean.Diretor;
import EstudioCinema.model.bean.DiretorFilme;
import EstudioCinema.model.bean.Filme;
import EstudioCinema.model.dao.DaoDiretorFilme;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerDiretorFilme {

    DaoDiretorFilme daoDirFil;
    ControllerDiretor contD;
    ControllerFilme contF;
    
    public DiretorFilme inserir(DiretorFilme dfEnt) throws SQLException, ClassNotFoundException {
       daoDirFil = new DaoDiretorFilme();
       return daoDirFil.inserir(dfEnt);
    }

    public DiretorFilme alterar(DiretorFilme dfEnt) throws SQLException, ClassNotFoundException {
       daoDirFil = new DaoDiretorFilme();
       return daoDirFil.alterar(dfEnt);
    }

    public DiretorFilme buscar(DiretorFilme dfEnt) throws SQLException, ClassNotFoundException {
        daoDirFil = new DaoDiretorFilme();
        DiretorFilme df = daoDirFil.buscar(dfEnt);
        Diretor d = new Diretor(df.getIdD());
        Filme f = new Filme(df.getIdF());
        contD = new ControllerDiretor();
        contF = new ControllerFilme();
        df.setD(contD.buscar(d));
        df.setF(contF.buscar(f));
        return df;
    }

    public DiretorFilme excluir(DiretorFilme dfEnt) throws SQLException, ClassNotFoundException {
       daoDirFil = new DaoDiretorFilme();
       return daoDirFil.excluir(dfEnt);
    }

    public List<DiretorFilme> listar(DiretorFilme dfEnt) throws SQLException, ClassNotFoundException {
       daoDirFil = new DaoDiretorFilme();
        List<DiretorFilme> listadf = daoDirFil.listar(dfEnt);
        List<DiretorFilme> listadfAux = new ArrayList<>();

        for (DiretorFilme dfSaida : listadf) {
            listadfAux.add(buscar(dfSaida));
        }


        return listadfAux;
    }
    
}
