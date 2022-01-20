import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addWarehouse extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			addWarehouse dialog = new addWarehouse();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public addWarehouse() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel productNameLabel = new JLabel("Nazwa");
			productNameLabel.setBounds(6, 24, 112, 28);
			contentPanel.add(productNameLabel);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(130, 24, 299, 28);
			contentPanel.add(textField);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(130, 64, 299, 28);
			contentPanel.add(textField_1);
		}
		{
			JLabel productNameLabel = new JLabel("Adres");
			productNameLabel.setBounds(6, 64, 112, 28);
			contentPanel.add(productNameLabel);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(130, 104, 299, 28);
			contentPanel.add(textField_2);
		}
		{
			JLabel productNameLabel = new JLabel("Kod pocztowy");
			productNameLabel.setBounds(6, 104, 112, 28);
			contentPanel.add(productNameLabel);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(130, 147, 299, 28);
			contentPanel.add(textField_3);
		}
		{
			JLabel productNameLabel = new JLabel("Miasto");
			productNameLabel.setBounds(6, 147, 112, 28);
			contentPanel.add(productNameLabel);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(130, 187, 299, 28);
			contentPanel.add(textField_4);
		}
		{
			JLabel productNameLabel = new JLabel("Kraj");
			productNameLabel.setBounds(6, 187, 112, 28);
			contentPanel.add(productNameLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("Dodaj");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
                        Database.addWarehouseWithLocation(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText());
                        dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Anuluj");
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
