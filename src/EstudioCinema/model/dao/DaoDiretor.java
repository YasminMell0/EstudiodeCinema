package EstudioCinema.model.dao;

import EstudioCinema.model.bean.Diretor;
import EstudioCinema.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoDiretor {

    private final Connection c;

    public DaoDiretor() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public Diretor inserir(Diretor dirEnt) throws SQLException {
        String sql = "insert into diretores" + " (idF, nome, formacao, qtdFilmes)" + " values (?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1,dirEnt.getIdF());
        stmt.setString(2,dirEnt.getNome());
        stmt.setString(3,dirEnt.getFormacao());
        stmt.setString(4,dirEnt.getQtdFilmes());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            dirEnt.setId(id);
        }
        stmt.close();
        return dirEnt;
    }

    public Diretor alterar(Diretor dirEnt) throws SQLException {
        String sql = "UPDATE diretores SET idF = ?, nome = ?, formacao = ?, qtdFilmes = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,dirEnt.getIdF());
        stmt.setString(2,dirEnt.getNome());
        stmt.setString(3,dirEnt.getFormacao());
        stmt.setString(4,dirEnt.getQtdFilmes());
        stmt.setInt(5,dirEnt.getId());

        stmt.execute();
        stmt.close();
        return dirEnt;
    }

    public Diretor buscar(Diretor dirEnt) throws SQLException {
        String sql = "select * from diretores WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1,dirEnt.getId());
            ResultSet rs = stmt.executeQuery();
            Diretor dirSaida = null;
            while (rs.next()) {      
                dirSaida = new Diretor(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            }
            stmt.close();
        return dirSaida;
    }

    public Diretor excluir(Diretor dirEnt) throws SQLException {
        String sql = "delete from diretores WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,dirEnt.getId());
        stmt.execute();
        stmt.close();
        c.close();
        return dirEnt;
    }

    public List<Diretor> listar(Diretor dirEnt) throws SQLException {
        List<Diretor> dire = new ArrayList<>();
        
        String sql = "select * from diretores where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1,"%" + dirEnt.getNome()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Diretor dir = new Diretor(
                rs.getInt(1),
                rs.getInt(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5));
            dire.add(dir);
        }
        
        rs.close();
        stmt.close();
        return dire;
    }
    
}
