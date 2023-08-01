package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

/** The driver. */
//Módulo de conexão
	private String driver = "com.mysql.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?userTimeZone=true&serverTimezone=UTC";
	
	/** The usuario. */
	private String usuario = "root";
	
	/** The senha. */
	@SuppressWarnings("unused")
	private String senha = "88180562";
	
	/** The pst. */
	private PreparedStatement pst;
	
	/** The rs. */
	private ResultSet rs;

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, senha);
			return con;
		} catch (Exception e) {
			System.out.println("foi n" + e);
			return null;
		}

	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(Contato_Model contato) {
		String sql = "insert into contatos (nome, fone, email) values (?, ?, ?)";
		try {
			Connection con = conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("inserirContato  " + e);
		}
	}

	/**
	 * Select all.
	 *
	 * @return the array list
	 */
	public ArrayList<Contato_Model> selectAll() {
		ArrayList<Contato_Model> contatos = new ArrayList<>();
		String sql = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				contatos.add(new Contato_Model(id, nome, fone, email));
				
			}
			con.close();

		} catch (Exception e) {
			System.out.println("selectAll  " + e);
			return null;
		}
		return contatos;
	}

	/**
	 * Select id.
	 *
	 * @param id the id
	 * @return the contato model
	 */
	@SuppressWarnings("finally")
	public Contato_Model selectId(String id) {
		String sql= "select * from contatos where id=?";
		Contato_Model contato = null;
		try {
			
			Connection con = conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				 contato = new Contato_Model (rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4));
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(" selectId  "+e);
		}
		finally {
			return contato;
		}
		
	}

	/**
	 * Update.
	 *
	 * @param contato the contato
	 */
	public void update(Contato_Model contato) {
		String sql="update contatos set nome=?, fone=?, email=? where id=?";
		try {
			Connection con = conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, contato.getNome());
			pst.setString(2,contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} 
		
		catch (Exception e) {
			System.out.println("update "+e);
		}
		
	}
	
	/**
	 * Delete.
	 *
	 * @param contato the contato
	 */
	public void delete(Contato_Model contato) {
		String sql = "delete from contatos where id=?";
		try {
			Connection con = conectar();
			pst = con.prepareStatement(sql);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		}
		
		
		catch (Exception e) {
			System.out.println("delete  "+e);
		}
	}

}
