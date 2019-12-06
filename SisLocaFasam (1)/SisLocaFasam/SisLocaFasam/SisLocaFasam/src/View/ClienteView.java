package View;

import java.awt.BorderLayout;
import DAO.ClienteDAO;
import DAO.VeiculoDAO;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ClienteView extends JFrame {
	private JPanel contentPane;
	private JLabel lblCliente;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtCep;
	private JTextField txtEstado;
	private JTextField txtCidade;
	private JTable tblDesistoCara;
	private JTextField txtNome;
	private JTextField txtId;
	
	public void readJTable()
	{
	    DefaultTableModel modelo = (DefaultTableModel) tblDesistoCara.getModel();
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
	
	public void limparCampos() {
		
		txtNome.setText("");
		txtCpf.setText("");
		txtTelefone.setText("");
		txtRg.setText("");
		txtEstado.setText("");
		txtCep.setText("");
		txtEndereco.setText("");
		txtCidade.setText("");
	}
	
	public ClienteView() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClienteView.class.getResource("/Img/MENU/02 - CLIENTE.png")));
		setTitle("Cliente");
		setVisible(true);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo( null ); /* esta linha centraliza a janela*/
		
		tblDesistoCara = new JTable();
		ClienteDAO cli = new ClienteDAO();
		cli.read();
		readJTable();
	
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 870, 610);
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
		
		lblCliente = new JLabel("CLIENTE");
		lblCliente.setFont(new Font("Consolas", Font.BOLD, 39));
		lblCliente.setBounds(361, 5, 155, 78);
		panel.add(lblCliente);
		
		JLabel lblMarca = new JLabel("CPF:");
		lblMarca.setFont(new Font("Consolas", Font.BOLD, 12));
		lblMarca.setBounds(199, 120, 72, 14);
		panel.add(lblMarca);
		//
		txtCpf = new JTextField();
		txtCpf.setBounds(196, 134, 177, 32);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblAno = new JLabel("RG:");
		lblAno.setFont(new Font("Consolas", Font.BOLD, 12));
		lblAno.setBounds(387, 119, 33, 14);
		panel.add(lblAno);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(383, 134, 132, 32);
		panel.add(txtRg);
		
		JLabel lblCor = new JLabel("TELEFONE:");
		lblCor.setFont(new Font("Consolas", Font.BOLD, 12));
		lblCor.setBounds(54, 177, 89, 14);
		panel.add(lblCor);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(54, 193, 132, 32);
		panel.add(txtTelefone);
		
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
				ClienteDAO clienteDAO = new ClienteDAO();
				if( txtNome.getText().equals("") && txtCpf.getText().equals("") &&  txtTelefone.getText().equals("") && txtRg.getText().equals("") && 
						txtEstado.getText().equals("") && txtCep.getText().equals("") && 
						txtEndereco.getText().equals("") && txtCidade.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
					
				}else
				{
					clienteDAO.cadastrarCliente(txtNome.getText(),txtCpf.getText(), txtRg.getText(), txtTelefone.getText(), txtEndereco.getText(), txtCep.getText(), txtEstado.getText(), txtCidade.getText());
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
		ClienteDAO clienteDAO = new ClienteDAO();
				if( txtNome.getText().equals("") && txtCpf.getText().equals("") &&  txtTelefone.getText().equals("") && txtRg.getText().equals("") && 
						txtEstado.getText().equals("") && txtCep.getText().equals("") && 
						txtEndereco.getText().equals("") && txtCidade.getText().equals("")){
					JOptionPane.showMessageDialog(null, "ERRO!!  SELECIONE PREENCHA TODOS OS CAMPOS PARA ATUALIZAR.");
					
				}else
				{
					clienteDAO.editarCliente(idConvertido, txtNome.getText(), txtCpf.getText(), txtRg.getText(), txtTelefone.getText(), txtEndereco.getText(), txtCep.getText(), txtEstado.getText(), txtCidade.getText());
					
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
				ClienteDAO clienteDAO = new ClienteDAO();
				int	idConvertido = Integer.parseInt(txtId.getText());
				if( txtNome.getText().equals("") && txtCpf.getText().equals("") &&  txtTelefone.getText().equals("") && txtRg.getText().equals("") && 
						txtEstado.getText().equals("") && txtCep.getText().equals("") && 
						txtEndereco.getText().equals("") && txtCidade.getText().equals("")){
					JOptionPane.showMessageDialog(null, "ERRO!!,  SELECIONE O CAMPO QUE DESEJA EXCLUIR.");
					
				}else
				{
					clienteDAO.apagarCliente(idConvertido, txtNome.getText(), txtCpf.getText(), txtRg.getText(), txtTelefone.getText(), txtEndereco.getText(), txtCep.getText(), txtEstado.getText(), txtCidade.getText());
					readJTable();
					limparCampos();
					
				}
			}
		});
		btnExcluir.setBounds(477, 546, 89, 23);
		panel.add(btnExcluir);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(199, 193, 132, 32);
		panel.add(txtEndereco);
		
		JLabel lblPlaca = new JLabel("ENDERE\u00C7O:");
		lblPlaca.setFont(new Font("Consolas", Font.BOLD, 12));
		lblPlaca.setBounds(199, 177, 89, 14);
		panel.add(lblPlaca);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(350, 193, 165, 32);
		panel.add(txtCep);
		
		JLabel lblCombustivl = new JLabel("CEP:");
		lblCombustivl.setFont(new Font("Consolas", Font.BOLD, 12));
		lblCombustivl.setBounds(350, 177, 84, 14);
		panel.add(lblCombustivl);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(54, 252, 132, 32);
		panel.add(txtEstado);
		
		JLabel lblPotncia = new JLabel("ESTADO:");
		lblPotncia.setFont(new Font("Consolas", Font.BOLD, 12));
		lblPotncia.setBounds(54, 236, 56, 14);
		panel.add(lblPotncia);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(199, 252, 316, 32);
		panel.add(txtCidade);
		
		JLabel lblDisponibilidade = new JLabel("CIDADE:");
		lblDisponibilidade.setFont(new Font("Consolas", Font.BOLD, 12));
		lblDisponibilidade.setBounds(199, 236, 127, 14);
		panel.add(lblDisponibilidade);
		
		JLabel lblMarca_1 = new JLabel("NOME:");
		lblMarca_1.setFont(new Font("Consolas", Font.BOLD, 12));
		lblMarca_1.setBounds(54, 119, 72, 14);
		panel.add(lblMarca_1);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(54, 134, 132, 32);
		panel.add(txtNome);
		
		
		tblDesistoCara.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tblDesistoCara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tblDesistoCara.getSelectedRow() != -1) {
					txtId.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 0).toString());
					txtNome.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 1).toString());
					txtCpf.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 2).toString());
					txtRg.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 3).toString());
					txtTelefone.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 4).toString());
					txtEndereco.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 5).toString());
					txtCep.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 6).toString());
					txtEstado.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 7).toString());
					txtCidade.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 8).toString());
				//id, nome, cfp, rg, telefone, endereco, cep, estado, cidade, 
					}
			}
		});
		tblDesistoCara.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (tblDesistoCara.getSelectedRow() != -1) {
				txtId.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 0).toString());
				txtNome.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 1).toString());
				txtCpf.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 2).toString());
				txtRg.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 3).toString());
				txtTelefone.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 4).toString());
				txtEndereco.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 5).toString());
				txtCep.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 6).toString());
				txtEstado.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 7).toString());
				txtCidade.setText(tblDesistoCara.getValueAt(tblDesistoCara.getSelectedRow(), 8).toString());
			
				}
			}
		});
		
		tblDesistoCara.setModel(new DefaultTableModel(
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
		tblDesistoCara.getColumnModel().getColumn(0).setResizable(false);
		tblDesistoCara.getColumnModel().getColumn(0).setPreferredWidth(35);
		tblDesistoCara.getColumnModel().getColumn(4).setPreferredWidth(65);
		tblDesistoCara.getColumnModel().getColumn(7).setPreferredWidth(80);
		tblDesistoCara.setBounds(29, 315, 799, 198);
		panel.add(tblDesistoCara);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(ClienteView.class.getResource("/Img/BG PRINCIPAL.png")));
		lblBg.setBounds(0, 0, 865, 624);
		panel.add(lblBg);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setEnabled(false);
		txtId.setBounds(10, 11, 17, 20);
		panel.add(txtId);
		txtId.setColumns(10);
	}
}