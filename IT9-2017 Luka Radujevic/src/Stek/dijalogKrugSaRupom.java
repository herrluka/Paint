package Stek;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dijalogKrugSaRupom extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUnut;
	private JTextField textSpolj;
	private boolean ok;
	
	public String getTextUnut() {
		return textUnut.getText();
	}

	public String getTextSpolj() {
		return textSpolj.getText();
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dijalogKrugSaRupom dialog = new dijalogKrugSaRupom();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dijalogKrugSaRupom() {
		setBounds(100, 100, 610, 329);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblUnesitePoluprenikUnutranjeg = new JLabel("Unesite polupre\u010Dnik unutra\u0161njeg i spoljnog kruga");
		lblUnesitePoluprenikUnutranjeg.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblPoluprenikUnutranjegKruga = new JLabel("Polupre\u010Dnik unutra\u0161njeg kruga");
		lblPoluprenikUnutranjegKruga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblPoluprenikSpoljnogKruga = new JLabel("Polupre\u010Dnik spoljnog kruga");
		lblPoluprenikSpoljnogKruga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textUnut = new JTextField();
		textUnut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textUnut.setColumns(10);
		textSpolj = new JTextField();
		textSpolj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textSpolj.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblUnesitePoluprenikUnutranjeg))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblPoluprenikSpoljnogKruga, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPoluprenikUnutranjegKruga, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(52)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textSpolj, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(textUnut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(262, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(25)
					.addComponent(lblUnesitePoluprenikUnutranjeg)
					.addGap(52)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPoluprenikUnutranjegKruga)
						.addComponent(textUnut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPoluprenikSpoljnogKruga)
						.addComponent(textSpolj, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(220, Short.MAX_VALUE))
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
