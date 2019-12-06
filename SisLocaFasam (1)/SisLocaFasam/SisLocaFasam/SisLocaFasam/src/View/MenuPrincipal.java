package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuPrincipal extends JFrame {

	public static void main(String[] args) {
		new MenuPrincipal();
	}
	
	private JPanel contentPane;
		public MenuPrincipal() {
		setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/Img/MENU/01 - VEICULO.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo( null ); /* esta linha centraliza a janela*/
		//dispose();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 880, 612);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton lblvEICULO = new JButton("");
		lblvEICULO.setForeground(Color.WHITE);
		lblvEICULO.setBackground(Color.WHITE);
		lblvEICULO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = new Veiculo(); //trocar pela tela do veiculo
				veiculo.readJTable();
				veiculo.setVisible(true);
				dispose();
			}
		});
		lblvEICULO.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Img/MENU/01 - VEICULO.png")));
		lblvEICULO.setBounds(135, 165, 164, 163);
		panel.add(lblvEICULO);
		
		JButton lblCliente = new JButton("");
		lblCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ClienteView viewCliente = new ClienteView();
				viewCliente.setVisible(true);
				viewCliente.readJTable();
				dispose();
			}
		});
		lblCliente.setBackground(Color.WHITE);
		lblCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Img/MENU/02 - CLIENTE.png")));
		lblCliente.setBounds(345, 164, 164, 164);
		panel.add(lblCliente);
		
		JButton lblPedido = new JButton("");
		lblPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pedido viewPedido= new Pedido();
				viewPedido.setVisible(true);
				dispose();
			}
		});
		lblPedido.setBackground(Color.WHITE);
		lblPedido.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Img/MENU/03 - PEDIDO.png")));
		lblPedido.setBounds(550, 164, 164, 164);
		panel.add(lblPedido);
		
		JButton lblPagamento = new JButton("");
		lblPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pagamento viewPagamento = new Pagamento();
				viewPagamento.setVisible(true);
				dispose();
			}
		});
		lblPagamento.setBackground(Color.WHITE);
		lblPagamento.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Img/MENU/04 - PAGAMENTO.png")));
		lblPagamento.setBounds(135, 373, 164, 164);
		panel.add(lblPagamento);
		
		JButton lblLocarDevolver = new JButton("");
		lblLocarDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LocarView locDev = new LocarView();
				locDev.setVisible(true);
				locDev.readJTable();
				dispose();
			}
		});
		lblLocarDevolver.setBackground(Color.WHITE);
		lblLocarDevolver.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Img/MENU/05 - LOCAR - DEVOLVER.png")));
		lblLocarDevolver.setBounds(345, 373, 164, 164);
		panel.add(lblLocarDevolver);
		
		JButton lblNovoUsuario = new JButton("");
		lblNovoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			NovoUsuario viewNovoUsuario = new NovoUsuario();
			viewNovoUsuario.setVisible(true);
			dispose();
			}
			
		});
		lblNovoUsuario.setBackground(Color.WHITE);
		lblNovoUsuario.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Img/MENU/06 - NOVO USUARIO.png")));
		lblNovoUsuario.setBounds(550, 373, 164, 164);
		panel.add(lblNovoUsuario);
		
		JLabel lblBg = new JLabel("");
		lblBg.setBounds(0, 0, 875, 624);
		lblBg.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Img/MENU/BG MENU.png")));
		panel.add(lblBg);
	}
}
