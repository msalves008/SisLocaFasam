package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DAO.VeiculoDAO;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Scrollbar;
import javax.swing.ListSelectionModel;

public class Veiculo extends JFrame {

	private JPanel contentPane;
	private JLabel lblBg;
	private JLabel lblVeculo;
	private JTextField txtModelo;
	private JTextField txtAno;
	private JTextField txtCor;
	private JTextField txtPlaca;
	private JTextField txtCombustivel;
	private JTextField txtPotencia;
	private JTextField txtDisponibilidade;
	private JTable tblVeiculos;
	private JTextField txtMarca;
	private JTextField txtId;
	
	public void readJTable()
	{
	    DefaultTableModel modelo = (DefaultTableModel) tblVeiculos.getModel();
	    modelo.setNumRows(0);
	    VeiculoDAO veiculoDAO = new VeiculoDAO();
	  
	    List<Model.Veiculo> veiculos = veiculoDAO.read();
	    for(Model.Veiculo v : veiculos){
	        
	       modelo.addRow(new Object[]{
	           v.getId(),
	           v.getMarca(),
	           v.getModelo(),
	           v.getCor(),
	           v.getAno(),
	           v.getPotencia(),
	           v.getPlaca(),
	           v.getCombustivel(),
	           v.getSituacao()           
	        
	       });

	    }
	    
	}
	
	public void limparCampos() {
		
		txtMarca.setText("");
		txtModelo.setText("");
		txtCor.setText("");
		txtAno.setText("");
		txtPotencia.setText("");
		txtCombustivel.setText("");
		txtPlaca.setText("");
		txtDisponibilidade.setText("");
	}
	
	public Veiculo() 
	{
		setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Veiculo.class.getResource("/Img/MENU/01 - VEICULO.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo( null ); /* esta linha centraliza a janela*/
		
		VeiculoDAO vec = new VeiculoDAO();
		vec.read();
	
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 875, 624);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.setFont(new Font("Consolas", Font.BOLD, 17));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				dispose();
			}
		});
		btnMenu.setBounds(634, 51, 124, 32);
		panel.add(btnMenu);
		
		lblVeculo = new JLabel("VE\u00CDCULO");
		lblVeculo.setFont(new Font("Consolas", Font.BOLD, 39));
		lblVeculo.setBounds(361, 5, 155, 78);
		panel.add(lblVeculo);
		
		JLabel lblMarca = new JLabel("MODELO:");
		lblMarca.setFont(new Font("Consolas", Font.BOLD, 12));
		lblMarca.setBounds(199, 120, 72, 14);
		panel.add(lblMarca);
		
		JLabel lblFotoCarro = new JLabel("");
		lblFotoCarro.setIcon(new ImageIcon(Veiculo.class.getResource("/Img/carro.png")));
		lblFotoCarro.setBackground(Color.LIGHT_GRAY);
		lblFotoCarro.setBounds(561, 113, 242, 176);
		panel.add(lblFotoCarro);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(196, 134, 177, 32);
		panel.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblAno = new JLabel("ANO:");
		lblAno.setFont(new Font("Consolas", Font.BOLD, 12));
		lblAno.setBounds(387, 119, 33, 14);
		panel.add(lblAno);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		txtAno.setBounds(383, 134, 132, 32);
		panel.add(txtAno);
		
		JLabel lblCor = new JLabel("COR:");
		lblCor.setFont(new Font("Consolas", Font.BOLD, 12));
		lblCor.setBounds(54, 177, 33, 14);
		panel.add(lblCor);
		
		txtCor = new JTextField();
		txtCor.setColumns(10);
		txtCor.setBounds(54, 193, 132, 32);
		panel.add(txtCor);
		
		JButton btnNovo = new JButton("LIMPAR CAMPOS");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnNovo.setBounds(54, 546, 132, 23);
		panel.add(btnNovo);
		
		
		JButton btnSalvar = new JButton("SALVAR");
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			
			{
				VeiculoDAO veiculoDAO = new VeiculoDAO();
				if( txtMarca.getText().equals("") && txtModelo.getText().equals("") &&  txtCor.getText().equals("") && txtAno.getText().equals("") && 
						txtPotencia.getText().equals("") && txtCombustivel.getText().equals("") && 
						txtPlaca.getText().equals("") && txtDisponibilidade.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
					
				}else
				{
					veiculoDAO.cadastrarVeiculo(txtModelo.getText(), txtAno.getText(), txtCor.getText(), 
							txtPlaca.getText(), txtCombustivel.getText(), txtPotencia.getText(), txtDisponibilidade.getText(), txtMarca.getText());
					readJTable();
					limparCampos();
					
				}
			}
		});
		
		
		btnSalvar.setBounds(213, 546, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ATUALIZAR DADOS
		int	idConvertido = Integer.parseInt(txtId.getText());	
				VeiculoDAO veiculoDAO = new VeiculoDAO();
				if( txtMarca.getText().equals("") && txtModelo.getText().equals("") &&  txtCor.getText().equals("") && txtAno.getText().equals("") && 
						txtPotencia.getText().equals("") && txtCombustivel.getText().equals("") && 
						txtPlaca.getText().equals("") && txtDisponibilidade.getText().equals("")){
					JOptionPane.showMessageDialog(null, "ERRO!!  SELECIONE PREENCHA TODOS OS CAMPOS PARA ATUALIZAR.");
					
				}else
				{
					//veiculoDAO.editarVeiculo(txtId.getText(), marca, modelo, ano, cor, placa, combustivel, potencia, disponibilidade);
					veiculoDAO.editarVeiculo(
							idConvertido,
							txtMarca.getText(),
							txtModelo.getText(), 
							txtAno.getText(), 
							txtCor.getText(), 
							txtPlaca.getText(),
							txtCombustivel.getText(),
							txtPotencia.getText(),
							txtDisponibilidade.getText());
				
					readJTable();
					limparCampos();
				}
				
			}
		});
		btnAtualizar.setBounds(334, 546, 100, 23);
		panel.add(btnAtualizar);
		
		// apagando veiculo
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VeiculoDAO veiculoDAO = new VeiculoDAO();
				
				if( txtMarca.getText().equals("") && txtModelo.getText().equals("") &&  txtCor.getText().equals("") && txtAno.getText().equals("") && 
						txtPotencia.getText().equals("") && txtCombustivel.getText().equals("") && 
						txtPlaca.getText().equals("") && txtDisponibilidade.getText().equals("")){
					JOptionPane.showMessageDialog(null, "ERRO!!,  SELECIONE O CAMPO QUE DESEJA EXCLUIR.");
					
				}else
				{
					veiculoDAO.apagarVeiculo(txtId.getText(),txtModelo.getText(), txtAno.getText(), txtCor.getText(), 
							txtPlaca.getText(), txtCombustivel.getText(), txtPotencia.getText(), txtDisponibilidade.getText());
					readJTable();
					limparCampos();
					
				}
			}
		});
		btnExcluir.setBounds(477, 546, 89, 23);
		panel.add(btnExcluir);
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(199, 193, 132, 32);
		panel.add(txtPlaca);
		
		JLabel lblPlaca = new JLabel("PLACA:");
		lblPlaca.setFont(new Font("Consolas", Font.BOLD, 12));
		lblPlaca.setBounds(199, 177, 56, 14);
		panel.add(lblPlaca);
		
		txtCombustivel = new JTextField();
		txtCombustivel.setColumns(10);
		txtCombustivel.setBounds(350, 193, 165, 32);
		panel.add(txtCombustivel);
		
		JLabel lblCombustivl = new JLabel("COMBUST\u00CDVEL:");
		lblCombustivl.setFont(new Font("Consolas", Font.BOLD, 12));
		lblCombustivl.setBounds(350, 177, 84, 14);
		panel.add(lblCombustivl);
		
		txtPotencia = new JTextField();
		txtPotencia.setColumns(10);
		txtPotencia.setBounds(54, 252, 132, 32);
		panel.add(txtPotencia);
		
		JLabel lblPotncia = new JLabel("POT\u00CANCIA");
		lblPotncia.setFont(new Font("Consolas", Font.BOLD, 12));
		lblPotncia.setBounds(54, 236, 56, 14);
		panel.add(lblPotncia);
		
		txtDisponibilidade = new JTextField();
		txtDisponibilidade.setColumns(10);
		txtDisponibilidade.setBounds(199, 252, 316, 32);
		panel.add(txtDisponibilidade);
		
		JLabel lblDisponibilidade = new JLabel("DISPONIBILIDADE:");
		lblDisponibilidade.setFont(new Font("Consolas", Font.BOLD, 12));
		lblDisponibilidade.setBounds(199, 236, 127, 14);
		panel.add(lblDisponibilidade);
		
		JLabel lblMarca_1 = new JLabel("MARCA:");
		lblMarca_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblMarca_1.setBounds(54, 119, 72, 14);
		panel.add(lblMarca_1);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(54, 134, 132, 32);
		panel.add(txtMarca);
		
		tblVeiculos = new JTable();
		tblVeiculos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tblVeiculos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tblVeiculos.getSelectedRow() != -1) {
					txtId.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 0).toString());
					txtMarca.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 1).toString());
					txtModelo.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 2).toString());
					txtAno.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 4).toString());
					txtCor.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 3).toString());
					txtPlaca.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 6).toString());
					txtCombustivel.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 7).toString());
					txtPotencia.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 5).toString());
					txtDisponibilidade.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 8).toString());
				
					}
			}
		});
		tblVeiculos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (tblVeiculos.getSelectedRow() != -1) {
				txtId.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 0).toString());
				txtMarca.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 1).toString());
				txtModelo.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 2).toString());
				txtAno.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 4).toString());
				txtCor.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 3).toString());
				txtPlaca.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 6).toString());
				txtCombustivel.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 7).toString());
				txtPotencia.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 5).toString());
				txtDisponibilidade.setText(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 8).toString());
			
				}
			}
		});
		
		tblVeiculos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "MARCA", "MODELO", "COR", "ANO", "POT\u00CANCIA", "PLACA", "COMBUST\u00CDVEL", "SITUA\u00C7\u00C3O"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Object.class, Object.class, Integer.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblVeiculos.getColumnModel().getColumn(0).setResizable(false);
		tblVeiculos.getColumnModel().getColumn(0).setPreferredWidth(35);
		tblVeiculos.getColumnModel().getColumn(4).setPreferredWidth(65);
		tblVeiculos.getColumnModel().getColumn(7).setPreferredWidth(80);
		tblVeiculos.setBounds(29, 315, 815, 198);
		panel.add(tblVeiculos);
		//JScrollPane scrollPane = new JScrollPane(tblVeiculos);

		
		lblBg = new JLabel("");
		lblBg.setBounds(0, 0, 874, 624);
		panel.add(lblBg);
		lblBg.setIcon(new ImageIcon(Veiculo.class.getResource("/Img/BG PRINCIPAL.png")));
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setBounds(10, 11, 17, 20);
		panel.add(txtId);
		txtId.setColumns(10);
	}
}