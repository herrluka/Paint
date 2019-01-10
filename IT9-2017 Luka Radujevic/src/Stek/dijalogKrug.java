package Stek;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class dijalogKrug extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPoluprecnik;
	private boolean ok;
	private JTextField txtKoordY;
	private JTextField txtKoordX;

	public String getTxtKoordY() {
		return txtKoordY.getText();
	}

	public void setTxtKoordY(String txtKoordY) {
		this.txtKoordY.setText(txtKoordY);
	}

	public String getTxtKoordX() {
		return txtKoordX.getText();
	}

	public void setTxtKoordX(String txtKoordX) {
		this.txtKoordX.setText(txtKoordX);
	}
	
	public void setTxtKoordXEdt(boolean b)
	{
		this.txtKoordX.setEditable(b);
	}
	
	public void setTxtKoordYEdt(boolean b)
	{
		this.txtKoordY.setEditable(b);
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getTextPoluprecnik() {
		return txtPoluprecnik.getText();
	}

	public void setPoluprecnik(String textField) {
		this.txtPoluprecnik.setText(textField);
		}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dijalogKrug dialog = new dijalogKrug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dijalogKrug() {
		setTitle("Circle");
		setBounds(100, 100, 568, 391);
		getContentPane().setLayout(new BorderLayout());
		this.setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblPoluprenik = new JLabel("Polupre\u010Dnik");
		lblPoluprenik.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPoluprecnik = new JTextField();
		txtPoluprecnik.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPoluprecnik.setColumns(10);
		
		JLabel lblKoordinataX = new JLabel("Koordinata X");
		lblKoordinataX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCentar = new JLabel("Centar");
		lblCentar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblKoordinataY = new JLabel("Koordinata Y");
		lblKoordinataY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtKoordY = new JTextField();
		txtKoordY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKoordY.setColumns(10);
		
		txtKoordX = new JTextField();
		txtKoordX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKoordX.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCentar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblKoordinataX)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtKoordX, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblKoordinataY, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPoluprenik))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPoluprecnik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtKoordY, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(239, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblCentar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblKoordinataX, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtKoordX, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinataY, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtKoordY, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPoluprenik)
						.addComponent(txtPoluprecnik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(159, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setOk(true);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
