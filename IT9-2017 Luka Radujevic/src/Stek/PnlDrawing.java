package Stek;

import java.awt.Graphics;
import java.awt.RadialGradientPaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.management.modelmbean.ModelMBeanInfoSupport;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PnlDrawing extends JPanel {

	private Iscrtavanje frejm;
	private ArrayList<Shape> oblik=new ArrayList<Shape>();
	private Shape sh;
	private Point startPoint;
	private Shape testOblik;
	
	public ArrayList<Shape> getOblik() {
		return oblik;
	}

	public void setOblik(ArrayList<Shape> oblik) {
		this.oblik = oblik;
	}

	public Shape getTestOblik() {
		return testOblik;
	}

	public void setTestOblik(Shape testOblik) {
		this.testOblik = testOblik;
	}



	/**
	 * Create the panel.
	 */
	public PnlDrawing(Iscrtavanje frame) {
		this.frejm=frame;
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			thisMouseClicked(e);
			}
		});
	}
	
	
	
	protected void thisMouseClicked(MouseEvent e) {
		if(frejm.getTglbtnSelektuj())
		{
			testOblik=null;
			Point p=new Point(e.getX(),e.getY());
			Iterator<Shape> it=oblik.iterator();
			while(it.hasNext())
			{
				Shape geo=it.next();
				geo.setSelected(false);
				if((geo.contains(p)) && geo.isSelected()==false)
				{
					testOblik=geo;
				}
				
			}
			
		}
		if(frejm.getTglbtnTacka()) {
			sh=new Point(e.getX(),e.getY());
			oblik.add(sh);
		}
		else if(frejm.getTglbtnLinija())
		{
			if(startPoint==null)
			startPoint=new Point(e.getX(),e.getY());
			else {
			sh=new Line(startPoint,new Point(e.getX(),e.getY()));
			oblik.add(sh);
			startPoint=null;
			}
		}
		else if(frejm.getTglbtnPravougaonik())
		{
			Point p=new Point(e.getX(),e.getY());
			pravougaonikDijalog dija=new pravougaonikDijalog();
			dija.setTextKoordX(Integer.toString(p.getX()));
			dija.setTextKoordY(Integer.toString(p.getY()));
			dija.setVisible(true);
			if(dija.isOk()) {
			try {
			int sirina=Integer.parseInt(dija.getTextSirina());
			int visina=Integer.parseInt(dija.getTextVisina());
			if(sirina>0 && visina>0) {
			Rectangle rct=new Rectangle(p,sirina,visina);
			oblik.add(rct);
			}
			else
				JOptionPane.showMessageDialog(new JFrame(), "Uneli ste neispravne podatke!", "Greška", JOptionPane.WARNING_MESSAGE);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Uneli ste neispravne podatke!", "Greška", JOptionPane.WARNING_MESSAGE);
			}
			}
		}
		else if(frejm.getTglbtnKrug())
		{
			Point centar=new Point(e.getX(),e.getY());
			dijalogKrug dija=new dijalogKrug();
			dija.setTxtKoordXEdt(false);
			dija.setTxtKoordYEdt(false);
			dija.setTxtKoordX(Integer.toString(centar.getX()));
			dija.setTxtKoordY(Integer.toString(centar.getY()));
			dija.setVisible(true);
			if(dija.isOk())
			{
				int radius=Integer.parseInt(dija.getTextPoluprecnik());
			    if(radius<0)
					JOptionPane.showMessageDialog(new JFrame(), "Uneli ste neispravne podatke!", "Greška", JOptionPane.WARNING_MESSAGE);
			else
			{
				Circle krug=new Circle(centar,radius);
				oblik.add(krug);
			}
			}
		}
		else if(frejm.getTglbtnKrugSaRupom())
		{
			Point centar=new Point(e.getX(),e.getY());
			dijalogKrugSaRupom dija=new dijalogKrugSaRupom();
			dija.setVisible(true);
			if(dija.isOk())
			{
				int innerRadius=Integer.parseInt(dija.getTextUnut());
				int outerRadius=Integer.parseInt(dija.getTextSpolj());
				if(innerRadius>0 && outerRadius>0)
				{
					Donut krofna=new Donut(centar,outerRadius,innerRadius);
					oblik.add(krofna);
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Uneli ste neispravne podatke!", "Greška", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		else if(testOblik!=null)
		{
			testOblik.setSelected(true);
		}
		else if(frejm.getTglbtnModifikuj())
		{
			if(testOblik instanceof Point)
			{
				System.out.println("Ulazi");
				int index=oblik.indexOf(testOblik);
				modTacka mt=new modTacka();
				mt.setTbX(Integer.toString(((Point) testOblik).getX()));
				mt.setTxtY(Integer.toString(((Point) testOblik).getY()));
				mt.setVisible(true);
				((Point) testOblik).setX(Integer.parseInt(mt.getTbX()));
				((Point) testOblik).setY(Integer.parseInt(mt.getTxtY()));
				if(mt.isOk())
				oblik.add(index, testOblik);
			}
		}
		if(oblik!=null) 
			repaint();
	}
	public void paint(Graphics g) {
		super.paint(g);
		Iterator it=oblik.iterator();
		while(it.hasNext())
			((Shape) it.next()).draw(g);
        }

}
