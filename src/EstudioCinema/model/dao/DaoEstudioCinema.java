
package EstudioCinema.model.dao;

import EstudioCinema.model.bean.EstudioCinema;
import EstudioCinema.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoEstudioCinema {

    private final Connection c;
    
    public DaoEstudioCinema() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public EstudioCinema inserir(EstudioCinema estEnt) throws SQLException, ClassNotFoundException {
        String sql = "insert into estudioCinema" + " (idF, idD, idR, nome, dataCriacao)" + " values (?,?,?,?,?)";
    
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1,estEnt.getIdF());
        stmt.setInt(2,estEnt.getIdD());
        stmt.setInt(3,estEnt.getIdR());
        stmt.setString(4,estEnt.getNome());
        stmt.setString(5,estEnt.getDataCriacao());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            estEnt.setId(id);
        }
        stmt.close();
        return estEnt;
    }

    public EstudioCinema alterar(EstudioCinema estEnt) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE estudioCinema SET idF = ?, idD = ?, idR = ?, nome = ?, dataCriacao = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,estEnt.getIdF());
        stmt.setInt(2,estEnt.getIdD());
        stmt.setInt(3,estEnt.getIdR());
        stmt.setString(4,estEnt.getNome());
        stmt.setString(5,estEnt.getDataCriacao());
        stmt.setInt(6,estEnt.getId());

        stmt.execute();
        stmt.close();
        return estEnt;
    }

    public EstudioCinema excluir(EstudioCinema estEnt) throws SQLException {
        String sql = "delete from estudioCinema WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,estEnt.getId());
        stmt.execute();
        stmt.close();
        c.close();
        return estEnt;
    }

    public EstudioCinema buscar(EstudioCinema estEnt) throws SQLException, ClassNotFoundException {
        String sql = "select * from estudioCinema WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1,estEnt.getId());
            ResultSet rs = stmt.executeQuery();
            EstudioCinema estSaida = null;
            while (rs.next()) {      
                estSaida = new EstudioCinema(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6));
            }
            stmt.close();
        return estSaida;
    }

    public List<EstudioCinema> listar(EstudioCinema estEnt) throws SQLException, ClassNotFoundException {
        List<EstudioCinema> est = new ArrayList<>();
        
        String sql = "select * from estudioCinema where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1,"%" + estEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            EstudioCinema estu = new EstudioCinema(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getString(5),
                rs.getString(6));
            
            est.add(estu);
        }
        
        rs.close();
        stmt.close();
        return est;
    }
    
}
