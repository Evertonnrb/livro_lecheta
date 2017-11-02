package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.domain.Carro;
import br.com.util.BaseDao;

public class CarroDao extends BaseDao {

	//Busca por ID
	public Carro getCarroById(Long id) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			pst = con.prepareStatement("select*from carro where id = ?");
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Carro c = new Carro();
				rs.close();
				return c;
			}
		} finally {
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return null;
	}

	//Busca por %nome%
	public List<Carro> findByName(String nome) throws SQLException{
		List<Carro> carros = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			pst = con.prepareStatement("select*from carro where lower(nome) like ?");
			pst.setString(1, "%"+nome.toLowerCase()+"%");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Carro c = createCarro(rs);
				carros.add(c);
			}
			rs.close();
		} finally {
			if(pst!=null)
				pst.close();
			if(con!=null)
				con.close();
		}
		return carros;
	}

	//Busca por TIPO
	public List<Carro> findByTipo(String tipo)throws SQLException{
		List<Carro> carros = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			pst = con.prepareStatement("select*from carro where tipo = ?");
			pst.setString(1, tipo);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Carro c = createCarro(rs);
				carros.add(c);
			}
		} finally {
			if(pst!=null)
				pst.close();
			if(con!=null)
				con.close();
		}
		return carros;
	}
	
	//Lista carros
	public List<Carro> getCarros() throws SQLException{
		List<Carro> carros = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			pst = con.prepareStatement("select*from carro");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Carro c = createCarro(rs);
				carros.add(c);
			}
		} finally {
			if(pst!=null)
				pst.close();
			if(con!=null)
				pst.close();
		}
		return carros;
	}
	
	//instancia carro
	private Carro createCarro(ResultSet rs) throws SQLException {
		Carro c = new Carro();
		c.setId(rs.getLong("id"));
		c.setNome(rs.getString("nome"));
		c.setTipo(rs.getString("tipo"));
		c.setDesc(rs.getString("descricao"));
		c.setUrlFoto(rs.getString("url_foto"));
		c.setUrlVideo(rs.getString("url_video"));
		c.setLatitude(rs.getString("latitude"));
		c.setLongitude(rs.getString("longitude"));
		return c;
	}
	
	public void save(Carro c) throws SQLException{
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			if(c.getId() == null) {
			pst = con.prepareStatement("insert into carro (nome,descricao,url_foto,url_video,latitude,longitude,tipo) values (?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			}else {
				pst = con.prepareStatement("update carro set nome=?, descricao=?,url_foto=?,url_video=?,latitude=?,logitude=?,"
						+ "tipo=? where id=?");
			}
			pst.setString(1, c.getNome());
			pst.setString(2, c.getDesc());
			pst.setString(3, c.getUrlFoto());
			pst.setString(4, c.getUrlVideo());
			pst.setString(5, c.getLatitude());
			pst.setString(6, c.getLongitude());
			pst.setString(7, c.getTipo());
			if(c.getId() != null) {
				pst.setLong(8, c.getId());
			}
			int count = pst.executeUpdate();
			if(count == 0) {
				throw new SQLException("Erro ao inserir carro");
			}
			if(c.getId() == null) {
				Long id = getGeneratedId(pst);
				c.setId(id);
			}
		} finally {
			if(pst!=null)
				pst.close();
			if(con!=null)
				con.close();
		}
	}

	//Check ID
	private Long getGeneratedId(java.sql.Statement pst) throws SQLException{
		ResultSet rs = pst.getGeneratedKeys();
		if(rs.next()) {
			Long id = rs.getLong(1);
			return id;
		}
		return 0L;
	}
	
	public boolean deletar(Long id) throws SQLException{
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			pst = con.prepareStatement("delete from carro where id=?");
			pst.setLong(1, id);
			int count = pst.executeUpdate();
			boolean ok = count>0;
			return ok;
		} finally {
			if(pst!=null)
				pst.close();
			if(con!=null)
				con.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
