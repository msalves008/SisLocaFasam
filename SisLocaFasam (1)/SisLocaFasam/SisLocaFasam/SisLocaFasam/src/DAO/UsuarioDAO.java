package DAO;


	import Connection.ConnectionFactory;
	import Model.Usuario;
import Model.Veiculo;

import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	import javax.swing.JOptionPane;

	public class UsuarioDAO {
	     
	    public boolean checkLogin(String nomeUsuario, String senha) {

	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        boolean check = false;

	        try {

	            stmt = con.prepareStatement("SELECT * FROM usuario WHERE nomeUsuario = ? and senha = ?");
	            stmt.setString(1, nomeUsuario);
	            stmt.setString(2, senha);

	            rs = stmt.executeQuery();

	            if (rs.next()) {

	                
	                check = true;
	            }	            
	            
	        } catch (Exception ex) {
	            System.out.println(ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt, rs);
	        }

	        return check;

	    }
	    public void create(Usuario u){
	        
	         Connection con = ConnectionFactory.getConnection();
	        
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement("INSERT INTO usuario (nomeUsuario,senha)VALUES(?,?)");
	            //stmt.setInt(1,a.getMatricula());
	            
	            stmt.setString (1, u.getLogin());
	            stmt.setString(2, u.getSenha());

	            stmt.executeUpdate();
	              

	            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	        } catch (Exception ex) {
	            System.out.println(ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt);
	        }
	    }
	    
	    
	    public List<Usuario> read() {

	        Connection con = ConnectionFactory.getConnection();
	        
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        List<Usuario> usuarios = new ArrayList<>();

	        try 
	        {
	            stmt = con.prepareStatement("SELECT * FROM usuarios");
	            rs = stmt.executeQuery();

	            while (rs.next()) 
	            {
	               Usuario usuario = new Usuario();
	               
	               usuario.setNome(rs.getString("nome"));
	               usuario.setCpf(rs.getString("cpf"));
	               usuario.setEndereco(rs.getString("endereco"));
	               usuario.setLogin(rs.getString("login"));
	               usuario.setSenha(rs.getString("senha"));
	              
	               usuarios.add(usuario); /*Adicionado os veiculos que estão cadastrados no banco de dados  na tabela*/
	            
	            }

	        } catch (Exception ex) {
	            System.out.println(ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt, rs);
	        }

	        return usuarios;
	    }
		
		public void cadastrarUsuario(String nome, String cpf,String endereco,String login,String senha)
		{
			Connection con = ConnectionFactory.getConnection();
	        
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        List<Usuario> usuario = new ArrayList<>();

	        try 
	        {
	            stmt = con.prepareStatement("INSERT INTO usuario (nome, cpf, endereco, login, senha) "
	            		+ "VALUES ('"+nome+"','"+cpf+"','"+endereco+"','"+login+"','"+senha+"');");
	         
	            stmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

	        } catch (Exception ex) {
	            System.out.println(ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt, rs);
	        }
	        	
		}
		
		public void editarUsuario(String id, String nome, String cpf,String endereco,String login,String senha)
		{
			Connection con = ConnectionFactory.getConnection();
	        
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        List<Usuario> usuario = new ArrayList<>();

	        try 
	        {
	            stmt = con.prepareStatement("UPDATE usuarios SET nome = '"+nome+"', cpf = '"+cpf+"', endereco = '"+endereco+"', login = '"+login+"', senha = '"+senha+"';");
	            stmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

	        } catch (Exception ex) {
	          System.out.println(ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt, rs);
	        }
	        	
		}
		
		public void apagarVeiculo(String id, String modelo, String ano,String  cor,String  placa,String  combustivel,String  potencia,String  disponibilidade)
		{
			Connection con = ConnectionFactory.getConnection();
	        
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        List<Veiculo> veiculos = new ArrayList<>();

	        try 
	        {
	            stmt = con.prepareStatement("DELETE FROM veiculos WHERE id = "+id+";");
	            stmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Veiculo foi apagado com sucesso!");

	        } catch (Exception ex) {
	           	System.out.println(ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt, rs);
	        }
	        	
		}
}
