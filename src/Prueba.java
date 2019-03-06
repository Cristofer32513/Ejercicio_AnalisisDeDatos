import javax.swing.*;
import java.awt.*;


class VentanaPrincipal extends JFrame {
	
	JTextArea txtAAreaSi, txtAAreaNo;
	JButton btnAnalizar;
	JProgressBar barraProgreso;
	
	public VentanaPrincipal() {
		getContentPane().setLayout(null);
		setTitle("Analisis de Datos");
		setSize(680, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		txtAAreaSi=new JTextArea();
			txtAAreaSi.setFont(new Font("Times New Roman", 5, 16));
			txtAAreaSi.setBackground(new Color(230, 230, 230));
			txtAAreaSi.setEditable(false);
			txtAAreaSi.setLineWrap(true);
			txtAAreaSi.setWrapStyleWord(true);
		JScrollPane scrollPane1 = new JScrollPane(txtAAreaSi);
			scrollPane1.setBounds(20, 20, 300, 400);
			scrollPane1.setBorder(BorderFactory.createTitledBorder(""));
		add(scrollPane1);
		
		txtAAreaNo=new JTextArea();
			txtAAreaNo.setFont(new Font("Times New Roman", 5, 16));
			txtAAreaNo.setBackground(new Color(230, 230, 230));
			txtAAreaNo.setEditable(false);
			txtAAreaNo.setLineWrap(true);
			txtAAreaNo.setWrapStyleWord(true);
		JScrollPane scrollPane2 = new JScrollPane(txtAAreaNo);
			scrollPane2.setBounds(350, 20, 300, 400);
			scrollPane2.setBorder(BorderFactory.createTitledBorder(""));
		add(scrollPane2);
		
		btnAnalizar=new JButton("Analizar");
			btnAnalizar.setBounds(260, 450, 150, 40);
			btnAnalizar.setFont(new Font("Time New Romans", 0, 20));
		add(btnAnalizar);
		
	}
}



public class Prueba {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaPrincipal();
			}
		});
	}
}