package Ventanas;

import sun.audio.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



import Threads.*
;

import javax.swing.JLabel;

import java.awt.Color;public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField edit_Puerto;
	JButton btnStart;
	static public JTextArea consolaArea;
public Servidor s;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		setTitle("Servidor SMS de solicitud de Accesos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 380, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		edit_Puerto = new JTextField();
		edit_Puerto.setHorizontalAlignment(SwingConstants.CENTER);
		edit_Puerto.setText("9003");
		edit_Puerto.setBounds(51, 11, 86, 20);
		panel.add(edit_Puerto);
		edit_Puerto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 354, 187);
		panel.add(scrollPane);
		
		consolaArea = new JTextArea();
		 DefaultCaret caret = (DefaultCaret)consolaArea.getCaret();
		 caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		consolaArea.setBackground(new Color(144, 238, 144));
		consolaArea.setEditable(false);
		scrollPane.setViewportView(consolaArea);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 if(btnStart.getText().toString().equals("Start")){
				iniciarServidor();
				 btnStart.setText("Stop");
				 edit_Puerto.setEnabled(false);
				
				
				 }
			 else{ detenerServidor();
				 btnStart.setText("Start");
				 edit_Puerto.setEnabled(true);}
			
			}

			private void detenerServidor() {
				s.StopServer();
				consolaArea.setText("");
				
			}

			private void iniciarServidor() {
				int puerto=Integer.parseInt(edit_Puerto.getText().toString());
				
				s=new Servidor(puerto,consolaArea);
				s.start();
				
			}
		});
		btnStart.setBounds(147, 11, 217, 20);
		panel.add(btnStart);
		
		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setBounds(10, 14, 46, 14);
		panel.add(lblPuerto);
	}
}
