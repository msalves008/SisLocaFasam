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

public class Pagamento extends JFrame {

	private JPanel contentPane;

	public Pagamento() {
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pagamento.class.getResource("/Img/MENU/04 - PAGAMENTO.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo( null ); /* esta linha centraliza a janela*/
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 878, 625);
		contentPane.add(panel);
		
		JLabel label = new JLabel("PAGAMENTO");
		label.setFont(new Font("Consolas", Font.BOLD, 39));
		label.setBounds(363, 5, 196, 47);
		panel.add(label);
		
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
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Pagamento.class.getResource("/Img/BG PRINCIPAL.png")));
		bg.setBounds(0, 0, 874, 624);
		panel.add(bg);
	}
}
