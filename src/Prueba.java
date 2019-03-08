import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

class GeneraradorAleatorio {
	
	final static int TOTALDATOS=100;
	String[] datosAleatorios=new String[TOTALDATOS];
	protected int contSi=0, contNo=0;
	
	public String[] generar(){		
		for(int i=0;i<datosAleatorios.length;i++){
			if(Math.random()>0.5){
				datosAleatorios[i]="Si";
				contSi++;
			}
			else{
				datosAleatorios[i]="No";
				contNo++;
			}
		}
		return datosAleatorios;
	}
}

class HiloSepararDatos implements Runnable {
	
	GeneraradorAleatorio generador=new GeneraradorAleatorio();
	
	final String[] datosAleatorios=generador.generar();
	final int totalSi=generador.contSi;
	final int totalNo=generador.contNo;
	
	
	@Override
	public void run() {
		VentanaPrincipal.txtAAreaSi.setText("");
		VentanaPrincipal.txtAAreaNo.setText("");
		int contSi=0, contNo=0;
		
		for(int i=0; i<datosAleatorios.length; i++) {
			if(datosAleatorios[i].equals("Si")) {
				if(contSi<totalSi-1)
					VentanaPrincipal.txtAAreaSi.append((contSi+1)+".-	"+datosAleatorios[i]+"\n");
				else
					VentanaPrincipal.txtAAreaSi.append((contSi+1)+".-	"+datosAleatorios[i]);
				contSi++;
			}
			else if(datosAleatorios[i].equals("No")) {
				if(contNo<totalNo-1)
					VentanaPrincipal.txtAAreaNo.append((contNo+1)+".-	"+datosAleatorios[i]+"\n");
				else
					VentanaPrincipal.txtAAreaNo.append((contNo+1)+".-	"+datosAleatorios[i]);
				contNo++;
			}
		}
	}
}




class VentanaPrincipal extends JFrame implements ActionListener{
	
	static JTextArea txtAAreaSi, txtAAreaNo;
	JButton btnAnalizar, btnLimpiar;
	static JProgressBar barraProgresoSi, barraProgresoNo;
	
	public VentanaPrincipal() {
		
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
		
		
		JLabel lblCantidadSi = new JLabel("Cantidad Si:");
			lblCantidadSi.setFont(new Font("Times New Roman", 0, 26));
			lblCantidadSi.setBounds(20, 430, 200, 30);
		add(lblCantidadSi);
		
		barraProgresoSi = new JProgressBar(0, GeneraradorAleatorio.TOTALDATOS);
			barraProgresoSi.setBounds(180, 430, 450, 30);
			barraProgresoSi.setStringPainted(true);
		add(barraProgresoSi);
		
		JLabel no = new JLabel("Cantidad No:");
			no.setFont(new Font("Times New Roman", 0, 26));
			no.setBounds(20, 470, 200, 30);
		add(no);
		
		barraProgresoNo = new JProgressBar(0, GeneraradorAleatorio.TOTALDATOS);
			barraProgresoNo.setBounds(180, 470, 450, 30);
			barraProgresoNo.setStringPainted(true);
		add(barraProgresoNo);
		
		
		
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
	
	
	
	public void limpiar(){
		txtAAreaSi.setText("");
		txtAAreaNo.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAnalizar){
			Thread hiloSeparar = new Thread(new HiloSepararDatos());
			hiloSeparar.start();
			
		}
		if(e.getSource()==btnLimpiar){
			limpiar();
		}
	}
}

class Hilo1 implements Runnable {
	@Override
	public void run() {
		//if(datos[i].eq)
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