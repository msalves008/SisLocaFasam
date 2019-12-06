package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Connection.ConnectionFactory;
import Model.ClienteModel;
import Model.Veiculo;
import View.ClienteView;

public class ClienteDAO {

	
	public List<ClienteModel> read() {

        Connection con = ConnectionFactory.getConnection();
        //
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ClienteModel> clientes = new ArrayList<>();

        try 
        {
            stmt = con.prepareStatement("SELECT * FROM tbl_cliente");
            rs = stmt.executeQuery();

            while (rs.next()) 
            {
            	ClienteModel cliente = new ClienteModel();
               //ClienteDAO cliente = new ClienteDAO();
                    //id, nome, cfp, rg, telefone, endereco, cep, estado, cidade,           
               cliente.setId(rs.getInt("id"));
               cliente.setNome(rs.getString("nome"));
               cliente.setCpf(rs.getString("cpf"));
               cliente.setRg(rs.getString("rg"));
               cliente.setTelefone(rs.getString("telefone"));
               cliente.setEndereco(rs.getString("endereco"));
               cliente.setCep(rs.getString("cep"));
               cliente.setEstado(rs.getString("estado"));
               cliente.setCidade(rs.getString("cidade")); 
               
               clientes.add(cliente); 
            
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;
    }
	

	public void cadastrarCliente( String nome,String  cpf,String  rg,String  telefone,String  endereco,String  cep, String estado, String cidade)
	{
		Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ClienteModel> clientes = new ArrayList<>();

        try 
        {
            stmt = con.prepareStatement("INSERT INTO tbl_cliente ( nome, cpf, rg, telefone, endereco, cep, estado, cidade) "
            		+ "VALUES ('"+nome+"','"+cpf+"','"+rg+"','"+telefone+"','"+endereco+"','"+cep+"','"+estado+"','"+cidade+"');");
         
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        	
	}
	

	public void editarCliente(int id, String nome,String  cpf,String  rg,String  telefone,String  endereco,String  cep, String estado, String cidade)
	{
		Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

       
        try 
        {
        	ClienteModel cliente = new ClienteModel(id, nome, cpf, rg, telefone, endereco, cep, estado, cidade);
        	
        	//System.out.println(veiculo);
        	ClienteDAO clienteDAO = new ClienteDAO();
        	
        	stmt = con.prepareStatement("UPDATE tbl_cliente SET id = '"+cliente.getId()+"',"
        			+ " nome = '"+cliente.getNome()+"',"
        			+ " cpf= '"+cliente.getCpf()+"', "
        			+ "rg= '"+cliente.getRg()+"',"
        			+ " telefone= '"+cliente.getTelefone()+"',"
        			+ " endereco= '"+cliente.getEndereco()+"',"
        			+ " cep	= '"+cliente.getCep()+"', "
        			+ " estado	= '"+cliente.getEstado()+"', "
        			+ "cidade= '"+cliente.getCidade()+"' WHERE id = "+id+";");
//             
//        	
        	//System.out.println(stmt);
         stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        	
	}
	
	public void apagarCliente(int id, String nome,String  cpf,String  rg,String  telefone,String  endereco,String  cep, String estado, String cidade)
	{
		Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ClienteModel> clientes = new ArrayList<>();

        try 
        {
            stmt = con.prepareStatement("DELETE FROM tbl_cliente WHERE id = "+id+";");
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente foi apagado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        	
	}
	
	
	
	
	
	
}
