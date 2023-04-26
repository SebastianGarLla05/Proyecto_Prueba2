package Proyecto_Final;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;

public class MyWindow extends JFrame implements ActionListener , MouseListener , ChangeListener {
	
	JButton cargarButton;
	JButton guardarButton;
	JButton borrarButton;
	
	JButton colorButton1;
	JButton colorButton2;
	JButton colorButton3;
	JButton colorButton4;
	JButton colorButton5;
	JButton colorButton6;
	
	JPanel contentPane;
	
	Canvas canvas;
	
	JLabel lbl;
	
	JSlider RGB1;
	JSlider RGB2;
	JSlider RGB3;
	
	static Graphics g;	
	static BufferedImage img;
	
	int width, height, x, y;
	
	public MyWindow(int width, int height) {
	
		this.width = width;
		this.height = height;				
		
		components();		
		
		//img = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		
		//g = img.createGraphics();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // al cerrar la ventana se detiene el programa
		setSize(width,height);							// tamaño de la ventana
		setLocationRelativeTo(null);					// centra la ventana
		setLayout(null);								// elimina plantillas
		setResizable(false);							// no permite modificar el tamaño de la ventana
		setVisible(true);								// muestra la ventana	
	}
			
	private void components()
	{
		contentPane = new JPanel();
		cargarButton = new JButton("Cargar");
		guardarButton = new JButton("Guardar");
		borrarButton = new JButton("BORRAR");
		colorButton1 = new JButton();
		colorButton2 = new JButton();
		colorButton3 = new JButton();
		colorButton4 = new JButton();
		colorButton5 = new JButton();
		colorButton6 = new JButton();
		lbl 		= new JLabel("");
		canvas 		= new Canvas();
		RGB1		= new JSlider(0, 100);
		RGB2		= new JSlider(0, 100);
		RGB3		= new JSlider(0, 100);
				
		contentPane.setLayout(null);
		contentPane.setBackground(Color.gray);
		contentPane.setBounds(0,0,width,height);//*/
				
		lbl.setBounds(0,0, width,height);
		lbl.setForeground(Color.white);
		lbl.setFont(new Font("Serif", Font.PLAIN, 70));
		
		//COLORES RGB
		
		RGB1.setBounds(20, 600, 335, 35);
		RGB1.addChangeListener(this); //AGREGAR SLIDERS	
		RGB2.setBounds(20, 630, 335, 35);
		RGB2.addChangeListener(this); //AGREGAR SLIDERS	
		RGB3.setBounds(20, 660, 335, 35);
		RGB3.addChangeListener(this); //AGREGAR SLIDERS	
		
		//BOTONES EXTRA
		cargarButton.setBounds(50, 50, 150, 30);
		cargarButton.addActionListener(this);	//AGREGAR BOTON
		guardarButton.setBounds(225, 50, 150, 30);
		guardarButton.addActionListener(this);	//AGREGAR BOTON
		borrarButton.setBounds(50, 200, 150, 30);
		borrarButton.addActionListener(this);	//AGREGAR BOTON
		
		//COLORES PREDETERMINADOS
		colorButton1.setBounds(50, 260, 200, 30);
		colorButton1.addActionListener(this);	//AGREGAR BOTON
		colorButton2.setBounds(50, 290, 200, 30);
		colorButton2.addActionListener(this);	//AGREGAR BOTON
		colorButton3.setBounds(50, 320, 200, 30);
		colorButton3.addActionListener(this);	//AGREGAR BOTON
		colorButton4.setBounds(50, 350, 200, 30);
		colorButton4.addActionListener(this);	//AGREGAR BOTON
		colorButton5.setBounds(50, 380, 200, 30);
		colorButton5.addActionListener(this);	//AGREGAR BOTON
		colorButton6.setBounds(50, 410, 200, 30);
		colorButton6.addActionListener(this);	//AGREGAR BOTON

				
		canvas.setBounds((width/2 )- 250, (height/2) - 390,626,626);//---	
		canvas.addMouseListener(this);
		
		contentPane.add(RGB1);
		contentPane.add(RGB2);
		contentPane.add(RGB3);
		contentPane.add(canvas);
		contentPane.add(lbl);
		contentPane.add(cargarButton);
		contentPane.add(guardarButton);
		contentPane.add(borrarButton);
		contentPane.add(colorButton1);
		contentPane.add(colorButton2);
		contentPane.add(colorButton3);
		contentPane.add(colorButton4);
		contentPane.add(colorButton5);
		contentPane.add(colorButton6);
		
		add(contentPane);
	}
	
	public void actionPerformed(ActionEvent event) {			
			lbl.setText("HOLA TODOS !!!");	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		x = e.getX(); //get the x and y coordinates of
		y = e.getY();
		
		x /= 25;
		x *= 25;
		
		y /=25;
		y *=25;
		
		canvas.getGraphic().setColor(Color.blue);
		canvas.getGraphic().fillRect(x, y, 25, 25);
		/*
		canvas.getGraphic().setColor(Color.yellow);
		canvas.getGraphic().fillRect(x-10, y-10, 20, 20);
		canvas.getGraphic().setColor(Color.gray);
		canvas.getGraphic().drawRect(x-10, y-10, 20, 20);//*/
		//canvas.setImage(img);
		
		lbl.setText(x+" "+y);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {	}

	@Override
	public void stateChanged(ChangeEvent e) {
		lbl.setText("val : "+RGB1.getValue());
	}
	
	
}