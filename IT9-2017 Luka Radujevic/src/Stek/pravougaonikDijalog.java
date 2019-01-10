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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pravougaonikDijalog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textKoordX;
	private JTextField textKoordY;
	private JTextField textVisina;
	private JTextField textSirina;
	private boolean ok;
	

	public String getTextKoordX() {
		return textKoordX.getText();
	}

	public void setTextKoordX(String textKoordX) {
		this.textKoordX.setText(textKoordX);
	}

	public String getTextKoordY() {
		return textKoordY.getText();
	}

	public void setTextKoordY(String textKoordY) {
		this.textKoordY.setText(textKoordY);
	}

	public String getTextVisina() {
		return textVisina.getText();
	}

	public String getTextSirina() {
		return textSirina.getText();
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
			pravougaonikDijalog dialog = new pravougaonikDijalog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public pravougaonikDijalog() {
		setBounds(100, 100, 640, 408);
		getContentPane().setLayout(new BorderLayout());
		this.setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblKoordinataX = new JLabel("Koordinata X");
		lblKoordinataX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblKoordinataY = new JLabel("Koordinata Y");
		lblKoordinataY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblVisina = new JLabel("Visina");
		lblVisina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblSirina = new JLabel("\u0160irina");
		lblSirina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textKoordX = new JTextField();
		textKoordX.setEditable(false);
		textKoordX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textKoordX.setColumns(10);
		
		textKoordY = new JTextField();
		textKoordY.setEditable(false);
		textKoordY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textKoordY.setColumns(10);
		
		textVisina = new JTextField();
		textVisina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textVisina.setColumns(10);
		
		textSirina = new JTextField();
		textSirina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textSirina.setColumns(10);
		
		JLabel lblUnesiteirinuI = new JLabel("Unesite \u0161irinu i visinu pravougaonika");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUnesiteirinuI)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblKoordinataX)
								.addComponent(lblKoordinataY)
								.addComponent(lblVisina)
								.addComponent(lblSirina))
							.addGap(65)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textSirina, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(textVisina, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(textKoordY, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(textKoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUnesiteirinuI)
					.addGap(22)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblKoordinataX)
						.addComponent(textKoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblKoordinataY)
						.addComponent(textKoordY, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVisina)
						.addComponent(textVisina, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSirina)
						.addComponent(textSirina, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(94, Short.MAX_VALUE))
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
