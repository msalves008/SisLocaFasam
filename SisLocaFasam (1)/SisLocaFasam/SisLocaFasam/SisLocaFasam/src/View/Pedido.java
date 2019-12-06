package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Pedido extends JFrame {

	private JPanel contentPane;

	public Pedido() {
		setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pedido.class.getResource("/Img/MENU/03 - PEDIDO.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo( null ); /* esta linha centraliza a janela*/
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 878, 625);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPedido_1 = new JLabel("PEDIDO");
		lblPedido_1.setFont(new Font("Consolas", Font.BOLD, 39));
		lblPedido_1.setBounds(363, 5, 147, 47);
		panel.add(lblPedido_1);
		
		JButton button = new JButton("MENU");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Consolas", Font.BOLD, 17));
		button.setBounds(716, 23, 124, 32);
		panel.add(button);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon(Pedido.class.getResource("/Img/BG PRINCIPAL.png")));
		lblBG.setBounds(0, 0, 874, 624);
		panel.add(lblBG);
	}

}
