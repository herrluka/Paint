package painting;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Circle extends Shape {
	private Point center;
	private int radius;
	private Color bojaUnut;
	private Color bojaIvice;

	
	
	public Circle() {

	}

	public Circle(Point center, int radius) throws Exception {
		setCenter(center);
		setRadius(radius);
	}

	public Circle(Point center, int radius, boolean selected) throws Exception {
		this(center, radius);
		setSelected(selected);
	}

	@Override
	public void draw(Graphics g) {
		
		if(bojaUnut!=null)
		{
			g.setColor(bojaUnut);
			g.fillOval(this.getCenter().getX() - this.radius, getCenter().getY() - getRadius(), this.getRadius()*2, this.getRadius()*2);
		}
		if(bojaIvice!=null)
		g.setColor(bojaIvice);
		else
			g.setColor(Color.BLACK);
		g.drawOval(this.getCenter().getX() - this.radius, getCenter().getY() - getRadius(), this.getRadius()*2, this.getRadius()*2);
		g.setColor(Color.BLACK);
		
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() + getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() + getRadius() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - getRadius() - 3, 6, 6);
			g.setColor(Color.BLACK);
		}
	}
		
	public boolean contains(Point p) {
		return center.distance(p.getX(), p.getY()) <= radius;
	}

	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) throws Exception{
		if(radius>=0)
			this.radius = radius;
		else
			throw new Exception();
	}
	
	public Color getBojaUnut() {
		return bojaUnut;
	}

	public void setBojaUnut(Color bojaUnut) {
		this.bojaUnut = bojaUnut;
	}

	public Color getBojaIvice() {
		return bojaIvice;
	}

	public void setBojaIvice(Color bojaIvice) {
		this.bojaIvice = bojaIvice;
	}
	
	public String toString() {
		return "Center=" + center + ", radius=" + radius; 
	}
}
