package sorting;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Sort extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm=new DefaultListModel<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sort frame = new Sort();
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
	public Sort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("IT9-2017 Luka Radujevic");
		setBounds(100, 100, 686, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Rectangle pravougaonik=new Rectangle();
				DialogRectangle dija= new DialogRectangle();
				dija.setLblOpcionoTxt("Unesite obelezja pravougaonika?");
				dija.setVisible(true);
				if(dija.isOk())
				{
				try {
				pravougaonik.setUpperLeftPoint(new Point(Integer.parseInt((dija.getTxtXKoordinata())),Integer.parseInt(dija.getTxtYKoordinata())));
				pravougaonik.setWidth(Integer.parseInt(dija.getTxtSirina()));
				pravougaonik.setHeight(Integer.parseInt(dija.getTxtVisina()));
				dlm.addElement(pravougaonik);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(new JFrame(),"Neispravan unos. Proverite da li su sva polja popunjena brojnim vrednostima.", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(new JFrame(),"Visina i sirina moraju da budu pozitivne.", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
				}
			}
		});
		
		JButton btnSortiraj = new JButton("Sortiraj");
		btnSortiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Rectangle> pomList=new ArrayList<Rectangle>();
				for(int i=0;i<dlm.size();i++)
				{
					pomList.add(i,dlm.getElementAt(i));
				}
				for(int i=1;i<=pomList.size()-1;i++) {
					for(int j=0;j<pomList.size()-1;j++) {
						if(pomList.get(j).area()>pomList.get(j+1).area()) {
							Rectangle pom=pomList.get(j);
							pomList.set(j, pomList.get(j+1));
							pomList.set(j+1, pom);
						}
					}
				}
				dlm.removeAllElements();
				for(Rectangle i:pomList) {
					dlm.addElement(i);
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
					.addGap(79)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSortiraj, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDodaj, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(106)
							.addComponent(btnDodaj, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(btnSortiraj, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		
		JList list = new JList();
		list.setModel(dlm);
		scrollPane.setViewportView(list);
		contentPane.setLayout(gl_contentPane);
	}
}
