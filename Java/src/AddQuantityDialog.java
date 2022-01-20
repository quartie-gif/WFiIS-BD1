import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javafx.util.Pair;
import java.util.Vector;

@SuppressWarnings("serial")
public class AddQuantityDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField addQuantityTextField;
	private JLabel addQuantityLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddQuantityDialog dialog = new AddQuantityDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddQuantityDialog() {
		setBounds(100, 100, 281, 147);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			addQuantityLabel = new JLabel("Ilość");
			addQuantityLabel.setBounds(38, 37, 61, 16);
			contentPanel.add(addQuantityLabel);
		}
		{
			addQuantityTextField = new JTextField();
			addQuantityLabel.setLabelFor(addQuantityTextField);
			addQuantityTextField.setBounds(125, 32, 130, 26);
			contentPanel.add(addQuantityTextField);
			addQuantityTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Pair<String, Integer> productToAdd = new Pair<String, Integer>(
								AddDialog.orderItemList.getSelectedValue(),
								Integer.valueOf(addQuantityTextField.getText()));
						AddDialog.itemsToAddToOrder.add(productToAdd);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Anuluj");
				buttonPane.add(cancelButton);
			}
		}
	}

}
