package EstudioCinema.model.dao;

import EstudioCinema.model.bean.DiretorFilme;
import EstudioCinema.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoDiretorFilme {

    private final Connection c;

    public DaoDiretorFilme() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    public DiretorFilme inserir(DiretorFilme dfEnt) throws SQLException {
        String sql = "insert into diretorFilme " + " (idD, idF, cinematografia)" + " values (?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1,dfEnt.getIdD());
        stmt.setInt(2,dfEnt.getIdF());
        stmt.setString(3,dfEnt.getCinematografia());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            dfEnt.setId(id);
        }
        stmt.close();
        return dfEnt;
    }

    public DiretorFilme excluir(DiretorFilme dfEnt) throws SQLException {
        String sql = "delete from diretorFilme  WHERE cinematografia = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1,dfEnt.getCinematografia());
        stmt.execute();
        stmt.close();
        c.close();
        return dfEnt;
    }

    public DiretorFilme alterar(DiretorFilme dfEnt) throws SQLException {
        String sql = "UPDATE diretorFilme  SET idD = ?, idF = ?, cinematografia = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,dfEnt.getIdD());
        stmt.setInt(2,dfEnt.getIdF());
        stmt.setString(3, dfEnt.getCinematografia());
        stmt.setInt(4,dfEnt.getId());

        stmt.execute();
        stmt.close();
        return dfEnt;
    }

    public DiretorFilme buscar(DiretorFilme dfEnt) throws SQLException {
        String sql = "select * from diretorFilme  WHERE cinematografia = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setString(1,dfEnt.getCinematografia());
            ResultSet rs = stmt.executeQuery();
            DiretorFilme dfSaida = null;
            while (rs.next()) {      
                dfSaida = new DiretorFilme(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            }
            stmt.close();
        return dfSaida;
    }

    public List<DiretorFilme> listar(DiretorFilme dfEnt) throws SQLException {
        List<DiretorFilme> difi = new ArrayList<>();
        
        String sql = "select * from diretorFilme  where cinematografia like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1, dfEnt.getCinematografia());
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            DiretorFilme df = new DiretorFilme(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4));
            difi.add(df);
        }
        
        rs.close();
        stmt.close();
        return difi;
    }
    
}
