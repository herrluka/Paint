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

public class dijalogKrofna extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtKoordX;
	private JTextField txtKoordY;
	private JTextField txtUnut;
	private JTextField txtSpolj;
	private boolean ok;
	

	public String getTxtUnut() {
		return txtUnut.getText();
	}

	public void setTxtUnut(String txtUnut) {
		this.txtUnut.setText(txtUnut);
	}

	public String getTxtSpolj() {
		return txtSpolj.getText();
	}

	public void setTxtSpolj(String txtSpolj) {
		this.txtSpolj.setText(txtSpolj);
	}

	public String getTxtKoordX() {
		return txtKoordX.getText();
	}

	public void setTxtKoordX(String txtKoordX) {
		this.txtKoordX.setText(txtKoordX);
	}

	public String getTxtKoordY() {
		return txtKoordY.getText();
	}

	public void setTxtKoordY(String txtKoordY) {
		this.txtKoordY.setText(txtKoordY);
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
			dijalogKrofna dialog = new dijalogKrofna();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dijalogKrofna() {
		setBounds(100, 100, 730, 492);
		setTitle("Donut");
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblCentar = new JLabel("Centar");
		lblCentar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JLabel lblKoordinataX = new JLabel("Koordinata X");
		lblKoordinataX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblKoordinataY = new JLabel("Koordinata Y");
		lblKoordinataY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKoordX = new JTextField();
		txtKoordX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKoordX.setColumns(10);
		txtKoordY = new JTextField();
		txtKoordY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKoordY.setColumns(10);
		JLabel lblRadius = new JLabel("Polupre\u010Dnici");
		lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JLabel lblUnutranji = new JLabel("Unutra\u0161nji");
		lblUnutranji.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblSpoljni = new JLabel("Spoljni");
		lblSpoljni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUnut = new JTextField();
		txtUnut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUnut.setColumns(10);
		txtSpolj = new JTextField();
		txtSpolj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSpolj.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCentar)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblRadius, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblKoordinataX, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblKoordinataY, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblSpoljni, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUnutranji, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
							.addGap(40)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtUnut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSpolj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtKoordY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtKoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(364, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(31)
					.addComponent(lblCentar)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinataX)
						.addComponent(txtKoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinataY)
						.addComponent(txtKoordY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnutranji, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUnut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSpoljni, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSpolj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(73, Short.MAX_VALUE))
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
