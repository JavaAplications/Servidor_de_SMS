package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Threads.*
;public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField esit_Puerto;
	JButton btnStart;
public Servidor s;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		esit_Puerto = new JTextField();
		esit_Puerto.setHorizontalAlignment(SwingConstants.CENTER);
		esit_Puerto.setText("9003");
		esit_Puerto.setBounds(10, 11, 86, 20);
		panel.add(esit_Puerto);
		esit_Puerto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 394, 150);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 if(btnStart.getText().toString().equals("Start")){
				iniciarServidor();
				 btnStart.setText("Stop");}
			 else{ detenerServidor();
				 btnStart.setText("Start");}
			
			}

			private void detenerServidor() {
				s.StopServer();
				
			}

			private void iniciarServidor() {
				s=new Servidor(9003);
				s.start();
				
			}
		});
		btnStart.setBounds(175, 32, 89, 23);
		panel.add(btnStart);
	}
	
	
	
	
	
}
