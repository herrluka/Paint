package Stek;


import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.lang.invoke.CallSite;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Stack extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm=new DefaultListModel<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
					frame.setTitle("IT9-2107 Luka Radujevic");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the frame.
	 */
	public Stack() {
		setForeground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
JScrollPane scrlPanePravougaonici = new JScrollPane();
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrlPanePravougaonici.setViewportView(list);
		list.setModel(dlm);
		scrlPanePravougaonici.setViewportView(list);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Rectangle pravougaonik=new Rectangle();
				dijalogPravougaonik dija= new dijalogPravougaonik();
				dija.setLblOpcionoTxt("Unesite obelezja pravougaonika?");
				dija.setVisible(true);
				if(dija.isOk())
				{
				try {
				pravougaonik.setUpperLeftPoint(new Point(Integer.parseInt((dija.getTxtXKoordinata().getText())),Integer.parseInt(dija.getTxtYKoordinata().getText())));
				pravougaonik.setWidth(Integer.parseInt(dija.getTxtSirina().getText()));
				pravougaonik.setHeight(Integer.parseInt(dija.getTxtVisina().getText()));
				dlm.add(0,pravougaonik);
				}
				catch(NullPointerException e) {
					JOptionPane.showMessageDialog(new JFrame(),"Proverite da li su sva polja popunjena.", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(new JFrame(),"Uneli ste pogresan tip podataka.", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e)
				{
					
				}
				}
				
				}
				
				
			
		});
		
		JButton btnIzuzmi = new JButton("Izuzmi");
		btnIzuzmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Rectangle pravougaonik=(Rectangle) list.getSelectedValue();
				dijalogPravougaonik dlg=new dijalogPravougaonik();
				dlg.setLblOpcionoTxt("Da li ste sigurni da zelite da obrisete pravougaonik sa ovim obelezjima?");
				dlg.setTxtXKoordinata(Integer.toString(pravougaonik.getUpperLeftPoint().getX()));
				dlg.setTxtYKoordinata(Integer.toString(pravougaonik.getUpperLeftPoint().getY()));
				dlg.setTxtVisina(Integer.toString(pravougaonik.getHeight()));
				dlg.setTxtSirina(Integer.toString(pravougaonik.getWidth()));
				dlg.setVisible(true);
				if(dlg.isOk())
				{
					dlm.removeElement(pravougaonik);
				}
				}
				catch(ClassCastException e)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Problem prilikom kastovanja.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				catch(NullPointerException e) {
					JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali nijednu vrednost u listi.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				//catch konvert gresku
			}
		});
		btnIzuzmi.setFont(new Font("Tahoma", Font.PLAIN, 17));
        	
		
		
		
		
		JLabel lblDodajteIliIzuzmite = new JLabel("Dodajte pravougaonik na stek ili ga izuzmite");
		lblDodajteIliIzuzmite.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(lblDodajteIliIzuzmite))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(scrlPanePravougaonici, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addComponent(btnDodaj, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(81)
					.addComponent(btnIzuzmi, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(lblDodajteIliIzuzmite, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(scrlPanePravougaonici, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(btnDodaj, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnIzuzmi, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
