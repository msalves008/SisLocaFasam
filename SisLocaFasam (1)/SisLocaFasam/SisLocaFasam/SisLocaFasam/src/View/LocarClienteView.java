package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ClienteDAO;
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
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LocarClienteView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtCep;
	private JTextField txtEstado;
	private JTextField txtCidade;
	private JTable tblLocar;

	
	public void readJTable()
	{
	    DefaultTableModel modelo = (DefaultTableModel) tblLocar.getModel();
	    modelo.setNumRows(0);
	
	    ClienteDAO clienteDAO = new ClienteDAO();
	    List<Model.ClienteModel> cliente = clienteDAO.read();
	    
	
	    for(Model.ClienteModel c : cliente){
	        
	       modelo.addRow(new Object[]{
	           c.getId(),
	           c.getNome(),
	           c.getCpf(),
	           c.getRg(),
	           c.getTelefone(),
	           c.getEndereco(),
	           c.getCep(),
	           c.getEstado(),
	           c.getCidade()
	        
	       });

	    }
	    
	}
	
	
	public LocarClienteView() {
		setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LocarClienteView.class.getResource("/Img/MENU/05 - LOCAR - DEVOLVER.png")));
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
		tblLocar = new JTable();
		tblLocar.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tblLocar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (tblLocar.getSelectedRow() != -1) {
				
					txtNome.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 1).toString());
					txtCpf.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 2).toString());
					txtRg.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 3).toString());
					txtTelefone.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 4).toString());
					txtEndereco.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 5).toString());
					txtCep.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 6).toString());
					txtEstado.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 7).toString());
					txtCidade.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 8).toString());
				//id, nome, cfp, rg, telefone, endereco, cep, estado, cidade, 
					}
			}
		});
		tblLocar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (tblLocar.getSelectedRow() != -1) {
				
				txtNome.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 1).toString());
				txtCpf.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 2).toString());
				txtRg.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 3).toString());
				txtTelefone.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 4).toString());
				txtEndereco.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 5).toString());
				txtCep.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 6).toString());
				txtEstado.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 7).toString());
				txtCidade.setText(tblLocar.getValueAt(tblLocar.getSelectedRow(), 8).toString());
			
				}
			}
		});
		
		tblLocar.setBounds(38, 89, 799, 283);
		tblLocar.setLocation(28, 89);
		tblLocar.setVisible(true);
		
		
		tblLocar.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "NOME", "CPF", "RG", "TELEFONE", "ENDERECO", "CEP", "ESTADO", "CIDADE"
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
	
			panel.add(tblLocar);
			
			
			JButton btnCadastrarCliente = new JButton("CADASTRAR CLIENTE");
			btnCadastrarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ClienteView viewCliente = new ClienteView();
					viewCliente.setVisible(true);
					viewCliente.readJTable();
					dispose();
				}
			});
			btnCadastrarCliente.setForeground(new Color(0, 0, 0));
			btnCadastrarCliente.setFont(new Font("Consolas", Font.BOLD, 17));
			btnCadastrarCliente.setBackground(new Color(0, 204, 51));
			btnCadastrarCliente.setBounds(27, 393, 199, 32);
			panel.add(btnCadastrarCliente);

			panel.add(tblLocar);
			//JScrollPane scrollPane = new JScrollPane(tblVeiculos);

			
		JLabel lblLocarDevollver = new JLabel("CLIENTES");
		lblLocarDevollver.setFont(new Font("Consolas", Font.BOLD, 39));
		lblLocarDevollver.setBounds(355, 15, 173, 47);
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
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Consolas", Font.BOLD, 12));
		lblNome.setBounds(254, 435, 72, 14);
		panel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Consolas", Font.BOLD, 12));
		lblCpf.setBounds(399, 435, 72, 14);
		panel.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Consolas", Font.BOLD, 12));
		lblRg.setBounds(542, 435, 33, 14);
		panel.add(lblRg);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(254, 449, 132, 32);
		panel.add(txtNome);
		
		txtCpf = new JTextField();
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);
		txtCpf.setBounds(396, 449, 132, 32);
		panel.add(txtCpf);
		
		txtRg = new JTextField();
		txtRg.setEditable(false);
		txtRg.setColumns(10);
		txtRg.setBounds(538, 450, 96, 32);
		panel.add(txtRg);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Consolas", Font.BOLD, 12));
		lblCep.setBounds(516, 492, 84, 14);
		panel.add(lblCep);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O:");
		lblEndereo.setFont(new Font("Consolas", Font.BOLD, 12));
		lblEndereo.setBounds(399, 492, 86, 14);
		panel.add(lblEndereo);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setFont(new Font("Consolas", Font.BOLD, 12));
		lblTelefone.setBounds(254, 492, 107, 14);
		panel.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setEditable(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(254, 508, 132, 32);
		panel.add(txtTelefone);
		
		txtEndereco = new JTextField();
		txtEndereco.setEditable(false);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(399, 508, 107, 32);
		panel.add(txtEndereco);
		
		txtCep = new JTextField();
		txtCep.setEditable(false);
		txtCep.setColumns(10);
		txtCep.setBounds(516, 508, 118, 32);
		panel.add(txtCep);
		
		JLabel lblCidade = new JLabel("CIDADE:");
		lblCidade.setFont(new Font("Consolas", Font.BOLD, 12));
		lblCidade.setBounds(399, 551, 127, 14);
		panel.add(lblCidade);
		
		JLabel lblEstado = new JLabel("ESTADO:");
		lblEstado.setFont(new Font("Consolas", Font.BOLD, 12));
		lblEstado.setBounds(254, 551, 56, 14);
		panel.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(254, 567, 132, 32);
		panel.add(txtEstado);
		
		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(399, 567, 235, 32);
		panel.add(txtCidade);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LocarClienteView.class.getResource("/Img/MENU/02 - CLIENTE.png")));
		lblNewLabel.setBounds(57, 435, 164, 164);
		panel.add(lblNewLabel);
		
		JButton btnCancelar = new JButton("CANCELAR ");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Deseja cancelar?");
			}
		});
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setFont(new Font("Consolas", Font.BOLD, 17));
		btnCancelar.setBounds(628, 393, 199, 32);
		panel.add(btnCancelar);
		
		JButton btnContinuar = new JButton("CONFIRMAR");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Locação efetuada com sucesso!");
				 MenuPrincipal tela = new  MenuPrincipal();			               
			        tela.setVisible(true);
			        dispose();
			}
		});
		btnContinuar.setForeground(new Color(0, 0, 0));
		btnContinuar.setBackground(new Color(0, 204, 51));
		btnContinuar.setFont(new Font("Consolas", Font.BOLD, 17));
		btnContinuar.setBounds(318, 393, 199, 32);
		panel.add(btnContinuar);
		
		JLabel lblVeculos = new JLabel("CLIENTES DISPONIVEIS:");
		lblVeculos.setFont(new Font("Consolas", Font.BOLD, 15));
		lblVeculos.setBounds(28, 58, 190, 32);
		panel.add(lblVeculos);
		
		JLabel lblBg = new JLabel("");
		lblBg.setBounds(0, 0, 871, 624);
		panel.add(lblBg);
		lblBg.setIcon(new ImageIcon(LocarClienteView.class.getResource("/Img/BG PRINCIPAL.png")));
		setLocationRelativeTo( null );
			//JScrollPane scrollPane = new JScrollPane(tblVeiculos);

	}
}
