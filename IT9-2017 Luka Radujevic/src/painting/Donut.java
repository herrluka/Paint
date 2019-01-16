package painting;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Donut extends Circle {
private int innerRadius;
private Color bojaManjeIvice;


	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) throws Exception {
		super(center, radius);
			setInnerRadius(innerRadius);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) throws Exception {
		this(center, radius, innerRadius);
		setSelected(selected);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		PnlDrawing pn=new PnlDrawing(new Drawing());
		g.setColor(pn.getBackground());
		g.fillOval(this.getCenter().getX() - this.innerRadius, this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.innerRadius*2);
		if(bojaManjeIvice!=null)
		{
			g.setColor(bojaManjeIvice);
		}
		else
			g.setColor(Color.BLACK);
		g.drawOval(this.getCenter().getX() - this.innerRadius, this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.innerRadius*2);
		g.setColor(Color.BLACK);
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() + getInnerRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - getInnerRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() + getInnerRadius() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - getInnerRadius() - 3, 6, 6);
			g.setColor(Color.BLACK);
		}
	}
	
	public boolean contains(Point p) {
		double dFromCenter = this.getCenter().distance(p.getX(), p.getY());
		return dFromCenter > innerRadius &&
				super.contains(p);
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) throws Exception {
		if(innerRadius>=0 && innerRadius<this.getRadius())
		{
		this.innerRadius = innerRadius;
		}
		else
			throw new Exception();
	}
	
	public Color getBojaManjeIvice() {
		return bojaManjeIvice;
	}

	public void setBojaManjeIvice(Color bojaManjeIvice) {
		this.bojaManjeIvice = bojaManjeIvice;
	}
	
	public String toString() {
		return super.toString() + ", inner radius=" + innerRadius ;
	}
}
