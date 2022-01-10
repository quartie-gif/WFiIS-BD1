import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.util.Vector;

@SuppressWarnings("serial")
public class AddDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField productNameTextField;
	private static JTextField descriptionTextField;
	private static JTextField priceTextField;
	private static JTextField costTextField;
	public static JComboBox<String>categoryComboBox;
	public static JComboBox<String>warehouseComboBox;
	public static  JTabbedPane tabbedPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddDialog dialog = new AddDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddDialog() {
		setBounds(100, 100, 559, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(6, 6, 547, 397);
		contentPanel.add(tabbedPane);
		
		JPanel productPanel = new JPanel();
		productPanel.setLocation(15, 33);
		tabbedPane.addTab("Produkt", null, productPanel, null);
		productPanel.setLayout(null);
		
		JLabel productNameLabel = new JLabel("Nazwa");
		productNameLabel.setBounds(49, 18, 112, 28);
		productPanel.add(productNameLabel);
		
		productNameTextField = new JTextField();
		productNameTextField.setBounds(173, 18, 299, 28);
		productPanel.add(productNameTextField);
		productNameTextField.setColumns(10);
		
		JLabel descriptionLabel = new JLabel("Opis");
		descriptionLabel.setBounds(49, 74, 112, 28);
		productPanel.add(descriptionLabel);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setColumns(10);
		descriptionTextField.setBounds(173, 74, 299, 28);
		productPanel.add(descriptionTextField);
		
		warehouseComboBox = new JComboBox<String>();
		//Filling comboBoxWarehousesItems with categories
		Vector<String> comboBoxWarehousesItems = Database.getWarehouses();
		warehouseComboBox.setModel(new DefaultComboBoxModel<String>(comboBoxWarehousesItems));

		warehouseComboBox.setBounds(173, 130, 299, 27);
		productPanel.add(warehouseComboBox);
		
		JLabel warehouseLabel = new JLabel("Magazyn");
		warehouseLabel.setBounds(49, 129, 114, 28);
		productPanel.add(warehouseLabel);
		
		JLabel priceLabel = new JLabel("Cena");
		priceLabel.setBounds(49, 242, 112, 28);
		productPanel.add(priceLabel);
		
		JLabel costLabel = new JLabel("Koszt");
		costLabel.setBounds(49, 298, 112, 28);
		productPanel.add(costLabel);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		priceTextField.setBounds(173, 242, 299, 28);
		productPanel.add(priceTextField);
		
		costTextField = new JTextField();
		costTextField.setColumns(10);
		costTextField.setBounds(173, 298, 299, 28);
		productPanel.add(costTextField);
		
		JLabel categoryLabel = new JLabel("Kategoria");
		categoryLabel.setBounds(49, 186, 112, 28);
		productPanel.add(categoryLabel);
		

		categoryComboBox = new JComboBox<String>();

		//Filling comboBoxCategoriesItems with categories
		Vector<String> comboBoxCategoriesItems = Database.getCategories();
		categoryComboBox.setModel(new DefaultComboBoxModel<String>(comboBoxCategoriesItems));

		categoryComboBox.setBounds(173, 187, 299, 27);
		productPanel.add(categoryComboBox);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Pracownik", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Zamówienia", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Klient", null, panel_3, null);
		panel_3.setLayout(null);
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			cancelButton.setBounds(16, 395, 240, 52);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedTabIndex = tabbedPane.getSelectedIndex();
				System.out.println(selectedTabIndex);
				switch(selectedTabIndex) {
				case 0:
				Database.addProduct(productNameTextField.getText(), descriptionTextField.getText(), (warehouseComboBox.getSelectedItem()).toString(), categoryComboBox.getSelectedIndex(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(costTextField.getText()));
					break;
				case 2:
					// code block
					break;
				case 3:
					// code block
					break;
				case 4:
					// code block
					break;	
				default:
					System.out.println("Wrong logic!");
				}



			}
		});
		addButton.setActionCommand("Add");
		addButton.setBounds(302, 395, 240, 52);
		contentPanel.add(addButton);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
		}
	}
}
