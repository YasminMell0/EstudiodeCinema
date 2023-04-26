package EstudioCinema.model.dao;

import EstudioCinema.model.bean.Roteirista;
import EstudioCinema.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoRoteirista {

    private final Connection c;

    public DaoRoteirista() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public List<Roteirista> listar(Roteirista rotEnt) throws SQLException {
        List<Roteirista> rote = new ArrayList<>();
        
        String sql = "select * from roteiristas where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1,"%" + rotEnt.getNome()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Roteirista rot = new Roteirista(
                rs.getInt(1),
                rs.getInt(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5));
            rote.add(rot);
        }
        
        rs.close();
        stmt.close();
        return rote;
    }

    public Roteirista inserir(Roteirista rotEnt) throws SQLException {
        String sql = "insert into roteiristas" + " (idF, nome, formacao, qtdFilmes)" + " values (?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1,rotEnt.getIdF());
        stmt.setString(2,rotEnt.getNome());
        stmt.setString(3,rotEnt.getFormacao());
        stmt.setString(4,rotEnt.getQtdFilmes());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            rotEnt.setId(id);
        }
        stmt.close();
        return rotEnt;
    }

    public Roteirista alterar(Roteirista rotEnt) throws SQLException {
        String sql = "UPDATE roteiristas SET idF = ?, nome = ?, formacao = ?, qtdFilmes = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,rotEnt.getIdF());
        stmt.setString(2,rotEnt.getNome());
        stmt.setString(3,rotEnt.getFormacao());
        stmt.setString(4,rotEnt.getQtdFilmes());
        stmt.setInt(5,rotEnt.getId());

        stmt.execute();
        stmt.close();
        return rotEnt;
    }

    public Roteirista buscar(Roteirista rotEnt) throws SQLException {
        String sql = "select * from roteiristas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1,rotEnt.getId());
            ResultSet rs = stmt.executeQuery();
            Roteirista rotSaida = null;
            while (rs.next()) {      
                rotSaida = new Roteirista(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            }
            stmt.close();
        return rotSaida;
    }

    public Roteirista excluir(Roteirista rotEnt) throws SQLException { 
        String sql = "delete from roteiristas WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,rotEnt.getId());
        stmt.execute();
        stmt.close();
        c.close();
        return rotEnt;
    }
    
}
