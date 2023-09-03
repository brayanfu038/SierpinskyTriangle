package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SierpinskyTriangle extends JFrame{
	
	private final int WIDTH = 1000;
	private final int HEIGHT = 1000;
	private int numberIteration;
	
	public SierpinskyTriangle(int numberIteration) {
		// TODO Auto-generated constructor stub
		this.numberIteration = numberIteration;
		this.setSize(WIDTH, HEIGHT);
		setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		int[] xPoints = {20,this.getWidth()/2,this.getWidth()-20};
		int[] yPoints = {this.getHeight()-100,30,this.getHeight()-100};
		g.setColor(Color.BLACK);
		g.fillPolygon(xPoints, yPoints,3);
		this.drawTriangle(xPoints[0],xPoints[1] ,xPoints[2],yPoints[0],yPoints[1],yPoints[2], g,numberIteration);		
	}
	
	public void drawTriangle(int x1,int x2, int x3,int y1,int y2, int y3,Graphics g ,int n) {
		if(n==0) {
			
		}else {	
		int aux_X1 = (x1+x2)/2;int aux_X2 = (x1+x3)/2;int aux_X3 =(x2+x3)/2;
		int aux_Y1 =(y1+y2)/2;int aux_Y2 =(y1+y3)/2; int aux_Y3=(y2+y3)/2; 
		
		int[] xPoints={aux_X1,aux_X2,aux_X3};
		int[] yPoints={aux_Y1,aux_Y2,aux_Y3};
		
		g.setColor(Color.WHITE);
		g.fillPolygon(xPoints,yPoints,3);
		
		// Triangulo Inferior Izquierdo
		this.drawTriangle(x1, aux_X1,aux_X2,y1,aux_Y1,y1, g, n-1);
		
		//Triangulo Inferior Derecho
		this.drawTriangle(aux_X2, aux_X3,x3,y1,aux_Y3,y1, g, n-1);
		
		//Triangulo Superior
		this.drawTriangle(aux_X1, aux_X2,aux_X3,aux_Y1,y2,aux_Y3,g, n-1);
			
		}
		
	}
	public static int readInt(String message) {
		return Integer.parseInt(JOptionPane.showInputDialog(message));
	}
	
	public static void main(String[] args) {
		SierpinskyTriangle triangle = new SierpinskyTriangle(SierpinskyTriangle.readInt("Ingrese El Numero De Iteraciones"));
	}
}
