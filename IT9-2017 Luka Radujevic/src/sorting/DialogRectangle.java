package sorting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.css.Rect;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXKoordinata;
	private JTextField txtYKoordinata;
	private JTextField txtVisina;
	private JTextField txtSirina;
	private boolean ok;
	private JLabel lblXKoordinata;
	private JLabel lblYKoordinata;
	private JLabel lblVisina;
	private JLabel lblSirina;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblOpciono;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogRectangle dialog = new DialogRectangle();
			dialog.setTitle("Pravougaonik");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the dialog.
	 */
	public DialogRectangle() {
		setTitle("Rectangle");
		setBounds(100, 100, 680, 508);
		getContentPane().setLayout(new BorderLayout());
		this.setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblXKoordinata = new JLabel("X koordinata");
			lblXKoordinata.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblXKoordinata.setHorizontalTextPosition(SwingConstants.LEFT);
			lblXKoordinata.setHorizontalAlignment(SwingConstants.LEFT);
		}
		{
			txtXKoordinata = new JTextField();
			txtXKoordinata.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtXKoordinata.setColumns(10);
		}
		
		txtXKoordinata.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
					if (c=='-') {
						e.consume();
						getToolkit().beep();
					}
			}
		});
		
		{
			lblYKoordinata = new JLabel("Y koordinata");
			lblYKoordinata.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		{
			txtYKoordinata = new JTextField();
			txtYKoordinata.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtYKoordinata.setColumns(10);
		}
		
		txtYKoordinata.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
					if (c=='-') {
						e.consume();
						getToolkit().beep();
					}
			}
		});
		{
			lblVisina = new JLabel("Visina");
			lblVisina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		{
			txtVisina = new JTextField();
			txtVisina.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtVisina.setColumns(10);
		}
		{
			lblSirina = new JLabel("Sirina");
			lblSirina.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
		}
		{
			txtSirina = new JTextField();
			txtSirina.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtSirina.setText("");
			txtSirina.setColumns(10);
		}
		
		lblOpciono = new JLabel("");
		lblOpciono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblXKoordinata)
								.addComponent(lblYKoordinata)
								.addComponent(lblVisina)
								.addComponent(lblSirina, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
							.addGap(37)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtSirina)
								.addComponent(txtYKoordinata, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
								.addComponent(txtXKoordinata, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
								.addComponent(txtVisina, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblOpciono)
							.addContainerGap(738, Short.MAX_VALUE))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOpciono)
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXKoordinata)
						.addComponent(txtXKoordinata, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtYKoordinata, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYKoordinata))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtVisina, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVisina))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSirina, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSirina, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(125, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try
						{
							Rectangle pravougaonik=new Rectangle();
							pravougaonik.setUpperLeftPoint(new Point(Integer.parseInt((getTxtXKoordinata())),Integer.parseInt(getTxtYKoordinata())));
							pravougaonik.setWidth(Integer.parseInt(getTxtSirina()));
							pravougaonik.setHeight(Integer.parseInt(getTxtVisina()));
							int i=Integer.parseInt(getTxtXKoordinata());
							int j=Integer.parseInt(getTxtYKoordinata());
						ok=true;
						dispose();
						}
						catch(NumberFormatException e) {
							JOptionPane.showMessageDialog(new JFrame(),"Neispravan unos. Proverite da li su sva polja popunjena brojnim vrednostima.", "Greška!", JOptionPane.ERROR_MESSAGE);
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(new JFrame(),"Visina i sirina moraju da budu pozitivne.", "Greška!", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ok=false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(476)
						.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
						.addGap(122))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap())
			);
			buttonPane.setLayout(gl_buttonPane);
			
			
		}
	}
	
	public void setTxtXKoordinataEnabled(boolean b)
	{
		this.txtXKoordinata.setEnabled(b);
	}
	
	public void setTxtYKoordinataEnabled(boolean b)
	{
		this.txtYKoordinata.setEnabled(b);
	}
	
	public void setTxtVisinaEnabled(boolean b)
	{
		this.txtVisina.setEnabled(b);
	}
	
	public void setTxtSirinaEnabled(boolean b)
	{
		this.txtSirina.setEnabled(b);
	}
	public void setLblOpcionoTxt(String text) {
		lblOpciono.setText(text);
	}
	
	public String getTxtXKoordinata() {
		return txtXKoordinata.getText();
	}


	public void setTxtXKoordinata(String s) {
		this.txtXKoordinata.setText(s);
	}


	public boolean isOk() {
		return ok;
	}


	public void setOk(boolean ok) {
		this.ok = ok;
	}


	public String getTxtYKoordinata() {
		return txtYKoordinata.getText();
	}


	public void setTxtYKoordinata(String s) {
		this.txtYKoordinata.setText(s);;
	}


	public String getTxtVisina() {
		return txtVisina.getText();
	}


	public void setTxtVisina(String broj) {
		this.txtVisina.setText(broj);
	}


	public String getTxtSirina() {
		return txtSirina.getText();
	}


	public void setTxtSirina(String broj) {
		this.txtSirina.setText(broj);;
	}


}
