package EstudioCinema.model.dao;

import EstudioCinema.model.bean.RoteiristaFilme;
import EstudioCinema.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoRoteiristaFilme {

    private final Connection c;
    
    public DaoRoteiristaFilme() throws SQLException, ClassNotFoundException {
            this.c = ConexaoDb.getConexaoMySQL();
        }

    public RoteiristaFilme alterar(RoteiristaFilme rfEnt) throws SQLException {
        String sql = "UPDATE roteiristaFilme SET idR = ?, idF = ?, tituloRoteiro = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,rfEnt.getIdR());
        stmt.setInt(2,rfEnt.getIdF());
        stmt.setString(3,rfEnt.getTituloRoteiro());
        stmt.setInt(4,rfEnt.getId());

        stmt.execute();
        stmt.close();
        return rfEnt;
    }

    public RoteiristaFilme inserir(RoteiristaFilme rfEnt) throws SQLException {
        String sql = "insert into roteiristaFilme" + " (idR, idF, tituloRoteiro)" + " values (?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1,rfEnt.getIdR());
        stmt.setInt(2,rfEnt.getIdF());
        stmt.setString(3,rfEnt.getTituloRoteiro());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            rfEnt.setId(id);
        }
        stmt.close();
        return rfEnt;
    }

    public RoteiristaFilme excluir(RoteiristaFilme rfEnt) throws SQLException {
        String sql = "delete from roteiristaFilme WHERE tituloRoteiro = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1,rfEnt.getTituloRoteiro());
        stmt.execute();
        stmt.close();
        c.close();
        return rfEnt;
    }

    public RoteiristaFilme buscar(RoteiristaFilme rfEnt) throws SQLException {
        String sql = "select * from roteiristaFilme WHERE tituloRoteiro = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setString(1,rfEnt.getTituloRoteiro());
            ResultSet rs = stmt.executeQuery();
            RoteiristaFilme rfSaida = null;
            while (rs.next()) {      
                rfSaida = new RoteiristaFilme(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            }
            stmt.close();
        return rfSaida;
    }

    public List<RoteiristaFilme> listar(RoteiristaFilme rfEnt) throws SQLException {
        List<RoteiristaFilme> rofi = new ArrayList<>();
        
        String sql = "select * from roteiristaFilme where tituloRoteiro like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1,rfEnt.getTituloRoteiro());
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            RoteiristaFilme rf = new RoteiristaFilme(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4));
            rofi.add(rf);
        }
        
        rs.close();
        stmt.close();
        return rofi;
    }
    
   
}
