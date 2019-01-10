package Stek;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class Iscrtavanje extends JFrame {

	private JPanel contentPane;
	JToggleButton tglbtnTacka;
	JToggleButton tglbtnLinija;
	JToggleButton tglbtnPravougaonik;
	JToggleButton tglbtnKrug;
	JToggleButton tglbtnKrugSaRupom;
	JToggleButton tglbtnSelektuj;
	JToggleButton tglbtnModifikuj;
	JToggleButton tglbtnObrisi;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iscrtavanje frame = new Iscrtavanje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean getTglbtnTacka() {
		return tglbtnTacka.isSelected();
	}

	public boolean getTglbtnLinija() {
		return tglbtnLinija.isSelected();
	}

	public boolean getTglbtnPravougaonik() {
		return tglbtnPravougaonik.isSelected();
	}

	public boolean getTglbtnKrug() {
		return tglbtnKrug.isSelected();
	}

	public boolean getTglbtnKrugSaRupom() {
		return tglbtnKrugSaRupom.isSelected();
	}

	public boolean getTglbtnSelektuj() {
		return tglbtnSelektuj.isSelected();
	}

	public boolean getTglbtnModifikuj() {
		return tglbtnModifikuj.isSelected();
	}

	public boolean getTglbtnObrisi() {
		return tglbtnObrisi.isSelected();
	}

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Iscrtavanje() {
		PnlDrawing panel= new PnlDrawing(this); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ButtonGroup grupa=new ButtonGroup();
		
		JToolBar toolBar = new JToolBar();
		
		tglbtnTacka = new JToggleButton("Ta\u010Dka");
		tglbtnTacka.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnTacka);
		
		grupa.add(tglbtnTacka);
	    tglbtnLinija = new JToggleButton("Linija");
		tglbtnLinija.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnLinija);
		grupa.add(tglbtnLinija);
		
		tglbtnPravougaonik = new JToggleButton("Pravougaonik");
		tglbtnPravougaonik.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnPravougaonik);
		grupa.add(tglbtnPravougaonik);
		
		tglbtnKrug = new JToggleButton("Krug");
		tglbtnKrug.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnKrug);
		grupa.add(tglbtnKrug);
		
		tglbtnKrugSaRupom = new JToggleButton("Krug sa rupom");
		tglbtnKrugSaRupom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		grupa.add(tglbtnKrugSaRupom);
		toolBar.add(tglbtnKrugSaRupom);
		
		tglbtnSelektuj = new JToggleButton("Selektuj");
		grupa.add(tglbtnSelektuj);
		tglbtnSelektuj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnSelektuj);
		
		tglbtnModifikuj = new JToggleButton("Modifikuj");
		tglbtnModifikuj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(panel.getTestOblik()!=null)
				{
					Shape pomOblik=panel.getTestOblik();
					ArrayList<Shape> lista=panel.getOblik();
					int index=lista.indexOf(pomOblik);
				if(panel.getTestOblik() instanceof Point)
				{
					modTacka mt=new modTacka();
					mt.setTbX(Integer.toString(((Point) pomOblik).getX()));
					mt.setTxtY(Integer.toString(((Point) pomOblik).getY()));
					mt.setVisible(true);
					((Point) pomOblik).setX(Integer.parseInt(mt.getTbX()));
					((Point) pomOblik).setY(Integer.parseInt(mt.getTxtY()));
					if(mt.isOk())
					{
					lista.set(index, pomOblik);
					panel.setOblik(lista);
					pomOblik.setSelected(true);
					panel.setTestOblik(pomOblik);
					panel.repaint();
					}
				}
				else if(panel.getTestOblik() instanceof Line)
				{
					modLinija ml=new modLinija();
					ml.setTxtPocKoordX(Integer.toString(((Line) pomOblik).getStartPoint().getX()));
					ml.setTxtPocKoordY(Integer.toString(((Line) pomOblik).getStartPoint().getY()));
					ml.setTxtKrKoordX(Integer.toString(((Line) pomOblik).getEndPoint().getX()));
					ml.setTxtKrKoordY(Integer.toString(((Line) pomOblik).getEndPoint().getY()));
					ml.setVisible(true);
					((Line)pomOblik).setStartPoint(new Point((Integer.parseInt(ml.getTxtPocKoordX())),(Integer.parseInt(ml.getTxtPocKoordY()))));
					((Line)pomOblik).setEndPoint(new Point((Integer.parseInt(ml.getTxtKrKoordX())),(Integer.parseInt(ml.getTxtKrKoordY()))));
					if(ml.isOk())
					{
						lista.set(index,pomOblik);
						panel.setOblik(lista);
						pomOblik.setSelected(true);
						panel.setTestOblik(pomOblik);
						panel.repaint();
					}
				}
				else if(panel.getTestOblik() instanceof Rectangle)
				{
					dijalogPravougaonik dp=new dijalogPravougaonik();
					dp.setTxtXKoordinata(Integer.toString(((Rectangle)pomOblik).getUpperLeftPoint().getX()));
					dp.setTxtYKoordinata(Integer.toString(((Rectangle)pomOblik).getUpperLeftPoint().getY()));
					dp.setTxtSirina(Integer.toString(((Rectangle)pomOblik).getWidth()));
					dp.setTxtVisina(Integer.toString(((Rectangle)pomOblik).getHeight()));
					dp.setVisible(true);
					((Rectangle)pomOblik).setUpperLeftPoint(new Point(Integer.parseInt(dp.getTxtXKoordinata().getText()),Integer.parseInt(dp.getTxtYKoordinata().getText())));
					try
					{
					((Rectangle)pomOblik).setWidth(Integer.parseInt(dp.getTxtSirina().getText()));
					((Rectangle)pomOblik).setHeight(Integer.parseInt(dp.getTxtVisina().getText()));
					if(dp.isOk())
					{
						lista.set(index,pomOblik);
						panel.setOblik(lista);
						pomOblik.setSelected(true);
						panel.setTestOblik(pomOblik);
						panel.repaint();
					}
					}
					catch(Exception e)
					{
						
					}
					
				}
				else if(panel.getTestOblik() instanceof Donut)
				{
					dijalogKrofna dk=new dijalogKrofna();
					dk.setTxtKoordX(Integer.toString(((Donut)pomOblik).getCenter().getX()));
					dk.setTxtKoordY(Integer.toString(((Donut)pomOblik).getCenter().getY()));
					dk.setTxtUnut(Integer.toString(((Donut)pomOblik).getInnerRadius()));
					dk.setTxtSpolj(Integer.toString(((Donut)pomOblik).getRadius()));
					dk.setVisible(true);
					((Donut)pomOblik).setCenter(new Point(Integer.parseInt(dk.getTxtKoordX()),Integer.parseInt(dk.getTxtKoordY())));
					try {
					((Donut)pomOblik).setInnerRadius(Integer.parseInt(dk.getTxtUnut()));
					((Donut)pomOblik).setRadius(Integer.parseInt(dk.getTxtSpolj()));
					if(dk.isOk())
					{
						lista.set(index,pomOblik);
						panel.setOblik(lista);
						pomOblik.setSelected(true);
						panel.setTestOblik(pomOblik);
						panel.repaint();
					}
					}
					catch(Exception e)
					{
						
					}
					
				}else if(panel.getTestOblik() instanceof Circle)
				{
					dijalogKrug dk=new dijalogKrug();
					dk.setTxtKoordXEdt(true);
					dk.setTxtKoordYEdt(true);
					dk.setTxtKoordX(Integer.toString(((Circle)pomOblik).getCenter().getX()));
					dk.setTxtKoordY(Integer.toString(((Circle)pomOblik).getCenter().getY()));
					dk.setPoluprecnik(Integer.toString(((Circle)pomOblik).getRadius()));
					dk.setVisible(true);
					((Circle)pomOblik).setCenter(new Point(Integer.parseInt(dk.getTxtKoordX()),Integer.parseInt(dk.getTxtKoordY())));
					try {
					((Circle)pomOblik).setRadius(Integer.parseInt(dk.getTextPoluprecnik()));
					if(dk.isOk())
					{
						pomOblik.setSelected(false);
						
						lista.set(index,pomOblik);
						panel.setOblik(lista);
						pomOblik.setSelected(true);
						panel.setTestOblik(pomOblik);
						panel.repaint();
						
					}
					}
					catch(Exception e)
					{
						
					}
				}
				
				
				
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Nijedan oblik nije selektovan.", "Greska!", JOptionPane.WARNING_MESSAGE);
				}
			}
			});
		grupa.add(tglbtnModifikuj);
		tglbtnModifikuj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnModifikuj);
		tglbtnObrisi = new JToggleButton("Obri\u0161i");
		tglbtnObrisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(panel.getTestOblik()!=null)
				{
					Shape pomOblik=panel.getTestOblik();
					ArrayList<Shape> lista=panel.getOblik();
					int index=lista.indexOf(pomOblik);
					if(JOptionPane.showConfirmDialog(new JFrame(), "Da li ste sigurni da želite da obrišete selektovani oblik?","Potvrda",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					{
						lista.remove(index);
						panel.setOblik(lista);
					}
					panel.setTestOblik(null); //jer se zadrzava u modifikaciji
					panel.repaint();
					
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Nijedan oblik nije selektovan.", "Greska!", JOptionPane.WARNING_MESSAGE);
				}
	
			}
		});
		grupa.add(tglbtnObrisi);
		tglbtnObrisi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnObrisi);
		
		
		panel.setSize(new Dimension(20, 40));
		panel.setPreferredSize(new Dimension(200, 400));
		contentPane.add(panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(129, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
	}
	
}
