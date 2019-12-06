package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Color;

public class NovoUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;

	public NovoUsuario() {
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NovoUsuario.class.getResource("/Img/MENU/06 - NOVO USUARIO.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 879, 629);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("MENU");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			MenuPrincipal viewMenu = new MenuPrincipal();
			viewMenu.setVisible(true);
			dispose();
			}
			
		});
		button.setFont(new Font("Consolas", Font.BOLD, 17));
		button.setBounds(701, 28, 124, 32);
		panel.add(button);
		
		JLabel lblNovoUsuario = new JLabel("NOVO USU\u00C1RIO ");
		lblNovoUsuario.setFont(new Font("Consolas", Font.BOLD, 39));
		lblNovoUsuario.setBounds(277, 16, 273, 47);
		panel.add(lblNovoUsuario);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNome.setBounds(44, 96, 46, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(44, 118, 266, 32);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("DATA DE NASCIMENTO:");
		lblDataDeNascimento.setFont(new Font("Consolas", Font.BOLD, 14));
		lblDataDeNascimento.setBounds(44, 173, 173, 14);
		panel.add(lblDataDeNascimento);
		
		JFormattedTextField txtDataDeNascimento = new JFormattedTextField();
		txtDataDeNascimento.setBounds(44, 198, 266, 32);
		panel.add(txtDataDeNascimento);
		
		JLabel lblFuno = new JLabel("FUN\u00C7\u00C3O:");
		lblFuno.setFont(new Font("Consolas", Font.BOLD, 14));
		lblFuno.setBounds(44, 252, 173, 14);
		panel.add(lblFuno);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(44, 277, 266, 32);
		panel.add(formattedTextField);
		
		JLabel lblMatrcula = new JLabel("MATR\u00CDCULA:");
		lblMatrcula.setFont(new Font("Consolas", Font.BOLD, 14));
		lblMatrcula.setBounds(44, 332, 173, 14);
		panel.add(lblMatrcula);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(44, 357, 266, 32);
		panel.add(formattedTextField_1);
		
		JButton btnNovo = new JButton("NOVO");
		btnNovo.setFont(new Font("Consolas", Font.BOLD, 15));
		btnNovo.setBounds(325, 351, 124, 38);
		panel.add(btnNovo);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setFont(new Font("Consolas", Font.BOLD, 15));
		btnSalvar.setBounds(459, 351, 124, 38);
		panel.add(btnSalvar);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setFont(new Font("Consolas", Font.BOLD, 15));
		btnAtualizar.setBounds(593, 351, 124, 38);
		panel.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setFont(new Font("Consolas", Font.BOLD, 15));
		btnExcluir.setBounds(732, 351, 124, 38);
		panel.add(btnExcluir);
		
		JLabel lblNivlDeAcesso = new JLabel("NIV\u00C9L DE ACESSO");
		lblNivlDeAcesso.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNivlDeAcesso.setBounds(407, 135, 151, 47);
		panel.add(lblNivlDeAcesso);
		
		JCheckBox CheckBoxAdministrador = new JCheckBox("ADMINISTRADOR");
		CheckBoxAdministrador.setFont(new Font("Consolas", Font.BOLD, 14));
		CheckBoxAdministrador.setBounds(325, 181, 140, 23);
		panel.add(CheckBoxAdministrador);
		
		JCheckBox CheckBoxUsuario = new JCheckBox("USU\u00C1RIO");
		CheckBoxUsuario.setFont(new Font("Consolas", Font.BOLD, 14));
		CheckBoxUsuario.setBounds(518, 181, 90, 23);
		panel.add(CheckBoxUsuario);
		
		JLabel lblLigadoAEmpresa = new JLabel("LIGADO A EMPRESA:");
		lblLigadoAEmpresa.setFont(new Font("Consolas", Font.BOLD, 16));
		lblLigadoAEmpresa.setBounds(407, 236, 173, 47);
		panel.add(lblLigadoAEmpresa);
		
		JCheckBox chckbxEmpregado = new JCheckBox("EMPREGADO");
		chckbxEmpregado.setFont(new Font("Consolas", Font.BOLD, 14));
		chckbxEmpregado.setBounds(336, 282, 140, 23);
		panel.add(chckbxEmpregado);
		
		JCheckBox chckbxDesligado = new JCheckBox("DESLIGADO");
		chckbxDesligado.setFont(new Font("Consolas", Font.BOLD, 14));
		chckbxDesligado.setBounds(509, 282, 102, 23);
		panel.add(chckbxDesligado);
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setBackground(Color.DARK_GRAY);
		lblFoto.setIcon(new ImageIcon(NovoUsuario.class.getResource("/Img/iconFoto.png")));
		lblFoto.setBounds(642, 96, 214, 213);
		panel.add(lblFoto);
		
		JLabel BG = new JLabel("");
		BG.setIcon(new ImageIcon(NovoUsuario.class.getResource("/Img/BG PRINCIPAL.png")));
		BG.setBounds(0, 0, 874, 628);
		panel.add(BG);
	}
}
