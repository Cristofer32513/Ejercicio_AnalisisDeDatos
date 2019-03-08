import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;


class VentanaPrincipal extends JFrame implements ActionListener{
	
	JTextArea txtAAreaSi, txtAAreaNo;
	JButton btnAnalizar, btnLimpiar;
	JProgressBar barraProgreso;
	
	String[] datosAleatorios=new String[10000000]; 
	
	public VentanaPrincipal() {
		
		generarDatosAleatorios();
		
		getContentPane().setLayout(null);
		setTitle("Analisis de Datos");
		setSize(680, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		txtAAreaSi=new JTextArea();
			txtAAreaSi.setFont(new Font("Times New Roman", 0, 16));
			txtAAreaSi.setBackground(new Color(230, 230, 230));
			txtAAreaSi.setEditable(false);
			txtAAreaSi.setLineWrap(true);
			txtAAreaSi.setWrapStyleWord(true);
		JScrollPane scrollPane1 = new JScrollPane(txtAAreaSi);
			scrollPane1.setBounds(20, 20, 300, 400);
			scrollPane1.setBorder(BorderFactory.createTitledBorder("Resultados Si"));
		add(scrollPane1);
		
		
		txtAAreaNo=new JTextArea();
			txtAAreaNo.setFont(new Font("Times New Roman", 0, 16));
			txtAAreaNo.setBackground(new Color(230, 230, 230));
			txtAAreaNo.setEditable(false);
			txtAAreaNo.setLineWrap(true);
			txtAAreaNo.setWrapStyleWord(true);
		JScrollPane scrollPane2 = new JScrollPane(txtAAreaNo);
			scrollPane2.setBounds(350, 20, 300, 400);
			scrollPane2.setBorder(BorderFactory.createTitledBorder("Resultados No"));
		add(scrollPane2);
		
		
		btnAnalizar=new JButton("Analizar");
			btnAnalizar.setBounds(170, 520, 150, 40);
			btnAnalizar.setFont(new Font("Time New Romans", 0, 20));
			btnAnalizar.addActionListener(this);
		add(btnAnalizar);
		
		
		btnLimpiar=new JButton("Limpiar");
			btnLimpiar.setBounds(350, 520, 150, 40);
			btnLimpiar.setFont(new Font("Time New Romans", 0, 20));
			btnLimpiar.addActionListener(this);
		add(btnLimpiar);
	}
	
	public void generarDatosAleatorios(){
		for(int i=0;i<datosAleatorios.length;i++){
			if(Math.random()>0.5)
				datosAleatorios[i]="Si";
			else
				datosAleatorios[i]="No";
		}
	}
	
	public void limpiar(){
		txtAAreaSi.setText("");
		txtAAreaNo.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAnalizar){
			
		}
		if(e.getSource()==btnLimpiar){
			limpiar();
		}
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