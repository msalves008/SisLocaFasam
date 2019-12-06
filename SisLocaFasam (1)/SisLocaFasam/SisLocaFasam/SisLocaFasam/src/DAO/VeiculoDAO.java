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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Connection.ConnectionFactory;
import Model.Veiculo;

public class VeiculoDAO {

	public List<Veiculo> read() {

        Connection con = ConnectionFactory.getConnection();
        //
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Veiculo> veiculos = new ArrayList<>();

        try 
        {
            stmt = con.prepareStatement("SELECT * FROM veiculos");
            rs = stmt.executeQuery();

            while (rs.next()) 
            {
               Veiculo veiculo = new Veiculo();
               
               veiculo.setId(rs.getInt("id"));
               veiculo.setMarca(rs.getString("marca"));
               veiculo.setModelo(rs.getString("modelo"));        
               
               veiculo.setCor(rs.getString("cor"));
               veiculo.setAno(rs.getString("ano"));
               veiculo.setPotencia(rs.getString("potencia"));
               veiculo.setPlaca(rs.getString("placa"));
               veiculo.setCombustivel(rs.getString("combustivel"));
               
               veiculo.setSituacao(rs.getString("disponibilidade"));
                
               veiculos.add(veiculo); /*Adicionado os veiculos que estão cadastrados no banco de dados  na tabela*/
            
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return veiculos;
    }
	
	public void cadastrarVeiculo(String modelo, String ano,String  cor,String  placa,String  combustivel,String  potencia,String  disponibilidade, String marca)
	{
		Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Veiculo> veiculos = new ArrayList<>();

        try 
        {
            stmt = con.prepareStatement("INSERT INTO veiculos (modelo, ano, cor, placa, combustivel, potencia, disponibilidade, marca) "
            		+ "VALUES ('"+modelo+"','"+ano+"','"+cor+"','"+placa+"','"+combustivel+"','"+potencia+"','"+disponibilidade+"','"+marca+"');");
         
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        	
	}
	
	public void editarVeiculo(int id, String marca, String modelo, String ano,String  cor,String  placa,String  combustivel,String  potencia,String  situacao)
	{
		Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

       
        try 
        {
        	Veiculo veiculo = new Veiculo(ano,marca,modelo,cor,potencia,placa,combustivel,situacao);
        	
        	//System.out.println(veiculo);
        	VeiculoDAO veiculoDAO = new VeiculoDAO();
        	
        	stmt = con.prepareStatement("UPDATE veiculos SET marca = '"+veiculo.getMarca()+"',"
        			+ " modelo = '"+veiculo.getModelo()+"',"
        			+ " ano= '"+veiculo.getAno()+"', "
        			+ "cor= '"+veiculo.getCor()+"',"
        			+ " placa= '"+veiculo.getPlaca()+"',"
        			+ " combustivel= '"+veiculo.getCombustivel()+"',"
        			+ " potencia= '"+veiculo.getPotencia()+"', "
        			+ "disponibilidade= '"+veiculo.getSituacao()+"' WHERE id = "+id+";");
//             
//        	
        	//System.out.println(stmt);
         stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
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

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        	
	}
	
	
	public List<Veiculo> locar() {

        Connection con = ConnectionFactory.getConnection();
        //
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Veiculo> veiculos = new ArrayList<>();
        String dispo = "DISPONIVEL";
        try 
        {
            stmt = con.prepareStatement("SELECT * FROM veiculos WHERE disponibilidade = \"DISPONIVEL\"");
            rs = stmt.executeQuery();
       
            while (rs.next()) 
            {
               Veiculo veiculo = new Veiculo();
               
               veiculo.setId(rs.getInt("id"));
               veiculo.setMarca(rs.getString("marca"));
               veiculo.setModelo(rs.getString("modelo"));        
               
               veiculo.setCor(rs.getString("cor"));
               veiculo.setAno(rs.getString("ano"));
               veiculo.setPotencia(rs.getString("potencia"));
               veiculo.setPlaca(rs.getString("placa"));
               veiculo.setCombustivel(rs.getString("combustivel"));
               
               veiculo.setSituacao(rs.getString("disponibilidade"));
                
               veiculos.add(veiculo); 
            
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return veiculos;
    }
	
}
