package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.VeiculoDAO;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LocarView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodico;
	private JTextField txtModelo;
	private JTextField txtAno;
	private JTextField txtCor;
	private JTextField txtPlaca;
	private JTextField txtCombustivel;
	private JTextField txtPotencia;
	private JTextField txtDisponibilidade;
	private JTable tblLocar;

	
	public void readJTable()
	{
	    DefaultTableModel modelo = (DefaultTableModel) tblLocar.getModel();
	    modelo.setNumRows(0);
	    VeiculoDAO veiculoDAO = new VeiculoDAO();
	  
	    List<Model.Veiculo> veiculos = veiculoDAO.locar();
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
	
	private void validaCampo() {
		int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.OK_CANCEL_OPTION);
		if (op == JOptionPane.OK_OPTION)
		{
			  MenuPrincipal tela = new  MenuPrincipal();			               
		      tela.setVisible(true);
		      dispose(); 
		}

			
	
	}
	
	
	public LocarView() {
		setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LocarView.class.getResource("/Img/MENU/05 - LOCAR - DEVOLVER.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		VeiculoDAO vec = new VeiculoDAO();
		vec.read();
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 871, 623);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tblLocar = new JTable();
		tblLocar.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tblLocar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tblLocar.getSelectedRow() != -1) {
					txtModelo.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 2).toString());
					txtAno.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 4).toString());
					txtCor.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 3).toString());
					txtPlaca.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 6).toString());
					txtCombustivel.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 7).toString());
					txtPotencia.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 5).toString());
					txtDisponibilidade.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 8).toString());
				
					}
			}
		});
		tblLocar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (tblLocar.getSelectedRow() != -1) {
				txtModelo.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 2).toString());
				txtAno.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 4).toString());
				txtCor.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 3).toString());
				txtPlaca.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 6).toString());
				txtCombustivel.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 7).toString());
				txtPotencia.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 5).toString());
				txtDisponibilidade.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 8).toString());
			
				}
			}
		});
		
		
		tblLocar.setBounds(38, 83, 820, 291);
		tblLocar.setLocation(28, 83);
		tblLocar.setVisible(true);
		
		
		tblLocar.setModel(new DefaultTableModel(
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
		tblLocar.getColumnModel().getColumn(0).setResizable(false);
		tblLocar.getColumnModel().getColumn(0).setPreferredWidth(35);
		tblLocar.getColumnModel().getColumn(4).setPreferredWidth(65);
		tblLocar.getColumnModel().getColumn(7).setPreferredWidth(80);
			
			JButton btnCadastrarVeiculo = new JButton("CADASTRAR VEICULO");
			btnCadastrarVeiculo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Veiculo veiculo = new Veiculo(); 
					veiculo.readJTable();
					veiculo.setVisible(true);
					dispose();
				}
			});
			btnCadastrarVeiculo.setForeground(new Color(0, 0, 0));
			btnCadastrarVeiculo.setFont(new Font("Consolas", Font.BOLD, 17));
			btnCadastrarVeiculo.setBackground(new Color(0, 204, 51));
			btnCadastrarVeiculo.setBounds(28, 391, 204, 32);
			panel.add(btnCadastrarVeiculo);

			panel.add(tblLocar);
			

			
		JLabel lblLocarDevollver = new JLabel("LOCAR VEICULO");
		lblLocarDevollver.setFont(new Font("Consolas", Font.BOLD, 39));
		lblLocarDevollver.setBounds(278, 15, 281, 47);
		panel.add(lblLocarDevollver);
		
		JButton button = new JButton("MENU");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal viewMenu = new MenuPrincipal();
				viewMenu.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Consolas", Font.BOLD, 17));
		button.setBounds(724, 25, 124, 32);
		panel.add(button);
		
		JLabel label = new JLabel("C\u00D3DICO:");
		label.setFont(new Font("Consolas", Font.BOLD, 12));
		label.setBounds(254, 435, 72, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("MODELO:");
		label_1.setFont(new Font("Consolas", Font.BOLD, 12));
		label_1.setBounds(399, 435, 72, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("ANO:");
		label_2.setFont(new Font("Consolas", Font.BOLD, 12));
		label_2.setBounds(542, 435, 33, 14);
		panel.add(label_2);
		
		txtCodico = new JTextField();
		txtCodico.setEditable(false);
		txtCodico.setColumns(10);
		txtCodico.setBounds(254, 449, 132, 32);
		panel.add(txtCodico);
		
		txtModelo = new JTextField();
		txtModelo.setEditable(false);
		txtModelo.setColumns(10);
		txtModelo.setBounds(396, 449, 132, 32);
		panel.add(txtModelo);
		
		txtAno = new JTextField();
		txtAno.setEditable(false);
		txtAno.setColumns(10);
		txtAno.setBounds(538, 450, 96, 32);
		panel.add(txtAno);
		
		JLabel label_3 = new JLabel("COMBUST\u00CDVEL:");
		label_3.setFont(new Font("Consolas", Font.BOLD, 12));
		label_3.setBounds(516, 492, 84, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("PLACA:");
		label_4.setFont(new Font("Consolas", Font.BOLD, 12));
		label_4.setBounds(399, 492, 56, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("COR:");
		label_5.setFont(new Font("Consolas", Font.BOLD, 12));
		label_5.setBounds(254, 492, 33, 14);
		panel.add(label_5);
		
		txtCor = new JTextField();
		txtCor.setEditable(false);
		txtCor.setColumns(10);
		txtCor.setBounds(254, 508, 132, 32);
		panel.add(txtCor);
		
		txtPlaca = new JTextField();
		txtPlaca.setEditable(false);
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(399, 508, 107, 32);
		panel.add(txtPlaca);
		
		txtCombustivel = new JTextField();
		txtCombustivel.setEditable(false);
		txtCombustivel.setColumns(10);
		txtCombustivel.setBounds(516, 508, 118, 32);
		panel.add(txtCombustivel);
		
		JLabel label_6 = new JLabel("DISPONIBILIDADE:");
		label_6.setFont(new Font("Consolas", Font.BOLD, 12));
		label_6.setBounds(399, 551, 127, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("POT\u00CANCIA");
		label_7.setFont(new Font("Consolas", Font.BOLD, 12));
		label_7.setBounds(254, 551, 56, 14);
		panel.add(label_7);
		
		txtPotencia = new JTextField();
		txtPotencia.setEditable(false);
		txtPotencia.setColumns(10);
		txtPotencia.setBounds(254, 567, 132, 32);
		panel.add(txtPotencia);
		
		txtDisponibilidade = new JTextField();
		txtDisponibilidade.setEditable(false);
		txtDisponibilidade.setColumns(10);
		txtDisponibilidade.setBounds(399, 567, 235, 32);
		panel.add(txtDisponibilidade);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LocarView.class.getResource("/Img/car.png")));
		lblNewLabel.setBounds(28, 435, 202, 164);
		panel.add(lblNewLabel);
		
		JButton btnCancelar = new JButton("CANCELAR ");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  /*MenuPrincipal tela = new  MenuPrincipal();			               
			      tela.setVisible(true);
			      dispose(); */
				
				validaCampo();
			}
		});
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setFont(new Font("Consolas", Font.BOLD, 17));
		btnCancelar.setBounds(646, 391, 204, 32);
		panel.add(btnCancelar);
		
		JButton btnContinuar = new JButton("CONTINUAR ");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocarClienteView clienteLocar = new LocarClienteView();
				clienteLocar.setVisible(true);
				clienteLocar.readJTable();
				dispose();
			}
		});
		btnContinuar.setForeground(new Color(0, 0, 0));
		btnContinuar.setBackground(new Color(0, 204, 51));
		btnContinuar.setFont(new Font("Consolas", Font.BOLD, 17));
		btnContinuar.setBounds(341, 391, 204, 32);
		panel.add(btnContinuar);
		
		JLabel lblVeculos = new JLabel("VE\u00CDCULOS DISPON\u00CDVEIS: ");
		lblVeculos.setFont(new Font("Consolas", Font.BOLD, 15));
		lblVeculos.setBounds(28, 53, 190, 32);
		panel.add(lblVeculos);
		
		JLabel lblBg = new JLabel("");
		lblBg.setBounds(0, 0, 871, 624);
		panel.add(lblBg);
		lblBg.setIcon(new ImageIcon(LocarView.class.getResource("/Img/BG PRINCIPAL.png")));
		setLocationRelativeTo( null );
			//JScrollPane scrollPane = new JScrollPane(tblVeiculos);
	}
}
