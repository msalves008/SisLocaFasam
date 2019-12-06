package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Model.Usuario;
import DAO.UsuarioDAO;;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	
	public static void main(String[] args) {
		new Login();
	}


	public Login() {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo( null ); 
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 464, 711);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIconUsuario = new JLabel("");
		lblIconUsuario.setBounds(104, 323, 33, 63);
		panel.add(lblIconUsuario);
		lblIconUsuario.setIcon(new ImageIcon(Login.class.getResource("/Img/icon usuario.png")));
		
		JLabel lblIconSenha = new JLabel("");
		lblIconSenha.setIcon(new ImageIcon(Login.class.getResource("/Img/icon senha.png")));
		lblIconSenha.setBounds(104, 436, 33, 63);
		panel.add(lblIconSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(94, 323, 270, 63);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(94, 436, 270, 63);
		panel.add(txtSenha);

		 String login;
	    UsuarioDAO dao = new UsuarioDAO();    
		
		JButton btnEntrar = new JButton("");
		btnEntrar.addActionListener(new ActionListener() {
			private String login;

			public void actionPerformed(ActionEvent arg0) {
				if(checkLogin(txtUsuario.getText(), new String(txtSenha.getPassword()))){
			         
			        MenuPrincipal tela = new  MenuPrincipal();			               
			        tela.setVisible(true);
			        dispose(); /*Esta linha fecha a janela de Login*/
			         
			     }  else{
			         JOptionPane.showMessageDialog(null, " Usuario ou senha incorreto, tente Novamente ");
			        
			     } 

			   
			}

			private boolean checkLogin(String login, String senha) {
				this.login = login;
		        return dao.checkLogin(login, senha);
			}
			
		});
		
		
		
		btnEntrar.setIcon(new ImageIcon(Login.class.getResource("/Img/btn.png")));
		btnEntrar.setBounds(113, 525, 232, 63);
		panel.add(btnEntrar);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setBounds(0, 0, 471, 708);
		panel.add(lblFundo);
		lblFundo.setIcon(new ImageIcon(Login.class.getResource("/Img/LOGIN - SISLOCACAR.png")));
	
	}
}
