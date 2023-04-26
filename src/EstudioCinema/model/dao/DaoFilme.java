package EstudioCinema.model.dao;

import EstudioCinema.model.bean.Filme;
import EstudioCinema.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoFilme {
    
    private final Connection c;

    public DaoFilme() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public Filme inserir(Filme filEnt) throws SQLException {
        String sql = "insert into filmes" + " (nome, genero, tramaPrincipal, anoLanc, descri)" + " values (?,?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1,filEnt.getNome());
        stmt.setString(2,filEnt.getGenero());
        stmt.setString(3,filEnt.getTramaPrincipal());
        stmt.setString(4,filEnt.getAnoLanc());
        stmt.setString(5,filEnt.getDesc());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            filEnt.setId(id);
        }
        stmt.close();
        return filEnt;
    }

    public Filme alterar(Filme filEnt) throws SQLException {
        String sql = "UPDATE filmes SET nome = ?, genero = ?, tramaPrincipal = ?, anoLanc = ?, descri = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1,filEnt.getNome());
        stmt.setString(2,filEnt.getGenero());
        stmt.setString(3,filEnt.getTramaPrincipal());
        stmt.setString(4,filEnt.getAnoLanc());
        stmt.setString(5,filEnt.getDesc());
        stmt.setInt(6,filEnt.getId());

        stmt.execute();
        stmt.close();
        return filEnt;
    }

    public Filme buscar(Filme filEnt) throws SQLException {
        String sql = "select * from filmes WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1,filEnt.getId());
            ResultSet rs = stmt.executeQuery();
            Filme filSaida = null;
            while (rs.next()) {      
                filSaida = new Filme(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
            }
            stmt.close();
        return filSaida;
    }

    public Filme excluir(Filme filEnt) throws SQLException {
        String sql = "delete from filmes WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,filEnt.getId());
        stmt.execute();
        stmt.close();
        c.close();
        return filEnt;
    }

    public List<Filme> listar(Filme filEnt) throws SQLException {
       List<Filme> listafilme = new ArrayList<>();
        
        String sql = "select * from filmes where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1,"%" + filEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Filme fil = new Filme(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)
            );
            listafilme.add(fil);
        }
        
        rs.close();
        stmt.close();
        return listafilme;
    }
    
}
