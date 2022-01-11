import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;
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
	private static JTextField productDescriptionTextField;
	private static JTextField productPriceTextField;
	private static JTextField productCostTextField;
	public static JComboBox<String> productCategoryComboBox;
	public static JComboBox<String> productWarehouseComboBox;
	public static JComboBox<String> employeeJobTitleComboBox;
	public static JComboBox<String> employeeWarehouseComboBox;
	public static JTabbedPane tabbedPane;
	private JTextField productQuantityTextField;
	private JTextField employeeFirstNameTextField;
	private JTextField employeeLastNameTextField;
	private JTextField employeeEmailTextField;
	private JTextField employeePhoneTextField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField clientEmailTextField;
	private JTextField clientPhoneTextField;
	private JTextField clientLastNameTextField;
	private JTextField clientFirstNameTextField;
	private JTextField clientAddressTextField;

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

		// Filling comboBoxWarehousesItems with categories
		Vector<String> comboBoxWarehousesItems = Database.getWarehouses();
		Vector<String> comboBoxEmployeeWarehousesItems = Database.getWarehouses();

		// Filling comboBoxCategoriesItems with categories
		Vector<String> comboBoxCategoriesItems = Database.getCategories();

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
		productNameLabel.setBounds(49, 19, 112, 28);
		productPanel.add(productNameLabel);

		productNameTextField = new JTextField();
		productNameLabel.setLabelFor(productNameTextField);
		productNameTextField.setBounds(173, 19, 299, 28);
		productPanel.add(productNameTextField);
		productNameTextField.setColumns(10);

		JLabel productDescriptionLabel = new JLabel("Opis");
		productDescriptionLabel.setBounds(49, 66, 112, 28);
		productPanel.add(productDescriptionLabel);

		productDescriptionTextField = new JTextField();
		productDescriptionLabel.setLabelFor(productDescriptionTextField);
		productDescriptionTextField.setColumns(10);
		productDescriptionTextField.setBounds(173, 66, 299, 28);
		productPanel.add(productDescriptionTextField);

		productWarehouseComboBox = new JComboBox<String>();
		productWarehouseComboBox.setModel(new DefaultComboBoxModel<String>(comboBoxWarehousesItems));

		productWarehouseComboBox.setBounds(173, 113, 299, 27);
		productPanel.add(productWarehouseComboBox);

		JLabel productWarehouseLabel = new JLabel("Magazyn");
		productWarehouseLabel.setLabelFor(productWarehouseComboBox);
		productWarehouseLabel.setBounds(49, 113, 114, 28);
		productPanel.add(productWarehouseLabel);

		JLabel productPriceLabel = new JLabel("Cena");
		productPriceLabel.setBounds(49, 207, 112, 28);
		productPanel.add(productPriceLabel);

		JLabel productCostLabel = new JLabel("Koszt");
		productCostLabel.setBounds(49, 254, 112, 28);
		productPanel.add(productCostLabel);

		productPriceTextField = new JTextField();
		productPriceLabel.setLabelFor(productPriceTextField);
		productPriceTextField.setColumns(10);
		productPriceTextField.setBounds(173, 205, 299, 28);
		productPanel.add(productPriceTextField);

		productCostTextField = new JTextField();
		productCostLabel.setLabelFor(productCostTextField);
		productCostTextField.setColumns(10);
		productCostTextField.setBounds(173, 252, 299, 28);
		productPanel.add(productCostTextField);

		JLabel productCategoryLabel = new JLabel("Kategoria");
		productCategoryLabel.setBounds(49, 160, 112, 28);
		productPanel.add(productCategoryLabel);

		productCategoryComboBox = new JComboBox<String>();
		productCategoryLabel.setLabelFor(productCategoryComboBox);
		productCategoryComboBox.setModel(new DefaultComboBoxModel<String>(comboBoxCategoriesItems));

		productCategoryComboBox.setBounds(173, 159, 299, 27);
		productPanel.add(productCategoryComboBox);

		productQuantityTextField = new JTextField();
		productQuantityTextField.setColumns(10);
		productQuantityTextField.setBounds(173, 299, 299, 28);
		productPanel.add(productQuantityTextField);

		JLabel productQuantityLabel = new JLabel("Ilość");
		productQuantityLabel.setLabelFor(productQuantityTextField);
		productQuantityLabel.setBounds(49, 301, 112, 28);
		productPanel.add(productQuantityLabel);

		Component verticalGlue = Box.createVerticalGlue();
		verticalGlue.setBounds(0, 0, 83, 24);
		productPanel.add(verticalGlue);

		JPanel employeePanel = new JPanel();
		tabbedPane.addTab("Pracownik", null, employeePanel, null);
		employeePanel.setLayout(null);

		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalGlue_1.setBounds(0, 0, 83, 24);
		employeePanel.add(verticalGlue_1);

		JLabel employeeFirstNameLabel = new JLabel("Imię");
		employeeFirstNameLabel.setLabelFor(employeeFirstNameLabel);
		employeeFirstNameLabel.setBounds(49, 26, 112, 28);
		employeePanel.add(employeeFirstNameLabel);

		employeeFirstNameTextField = new JTextField();
		employeeFirstNameTextField.setColumns(10);
		employeeFirstNameTextField.setBounds(173, 26, 299, 28);
		employeePanel.add(employeeFirstNameTextField);

		JLabel employeeLastNameLabel = new JLabel("Nazwisko");
		employeeLastNameLabel.setBounds(49, 80, 112, 28);
		employeePanel.add(employeeLastNameLabel);

		employeeLastNameTextField = new JTextField();
		employeeLastNameLabel.setLabelFor(employeeLastNameTextField);
		employeeLastNameTextField.setColumns(10);
		employeeLastNameTextField.setBounds(173, 80, 299, 28);
		employeePanel.add(employeeLastNameTextField);

		JLabel employeePhoneLabel = new JLabel("Telefon");
		employeePhoneLabel.setBounds(49, 134, 114, 28);
		employeePanel.add(employeePhoneLabel);

		JLabel employeeJobTitleLable = new JLabel("Stanowisko");
		employeeJobTitleLable.setBounds(49, 242, 112, 28);
		employeePanel.add(employeeJobTitleLable);

		employeeJobTitleComboBox = new JComboBox<String>();
		employeeJobTitleComboBox.setModel(
				new DefaultComboBoxModel<String>(
						new String[] { "Magazynier", "Księgowy", "Osoba sprzątająca", "Kierowca" }));
		employeeJobTitleLable.setLabelFor(employeeJobTitleComboBox);
		employeeJobTitleComboBox.setBounds(173, 242, 299, 27);
		employeePanel.add(employeeJobTitleComboBox);

		employeeEmailTextField = new JTextField();
		employeeEmailTextField.setColumns(10);
		employeeEmailTextField.setBounds(173, 188, 299, 28);
		employeePanel.add(employeeEmailTextField);

		JLabel employeeEmailLabel = new JLabel("Email");
		employeeEmailLabel.setBounds(49, 188, 112, 28);
		employeePanel.add(employeeEmailLabel);
		employeeEmailLabel.setLabelFor(employeeEmailTextField);

		employeePhoneTextField = new JTextField();
		employeePhoneLabel.setLabelFor(employeePhoneTextField);
		employeePhoneTextField.setColumns(10);
		employeePhoneTextField.setBounds(173, 134, 299, 28);
		employeePanel.add(employeePhoneTextField);
		
		employeeWarehouseComboBox = new JComboBox<String>(comboBoxEmployeeWarehousesItems);
		employeeWarehouseComboBox.setBounds(173, 295, 299, 27);
		employeePanel.add(employeeWarehouseComboBox);
		
		JLabel employeeWarehouseTextField = new JLabel("Magazyn");
		employeeWarehouseTextField.setLabelFor(employeeWarehouseComboBox);
		employeeWarehouseTextField.setBounds(49, 296, 112, 28);
		employeePanel.add(employeeWarehouseTextField);

		JPanel ordersPanel = new JPanel();
		tabbedPane.addTab("Zamówienia", null, ordersPanel, null);
		ordersPanel.setLayout(null);

		Component verticalGlue_1_1 = Box.createVerticalGlue();
		verticalGlue_1_1.setBounds(0, 0, 83, 24);
		ordersPanel.add(verticalGlue_1_1);

		JLabel nameLabel_1 = new JLabel("Imię");
		nameLabel_1.setBounds(49, 35, 112, 28);
		ordersPanel.add(nameLabel_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(173, 35, 299, 28);
		ordersPanel.add(textField);

		JLabel lastNameLabel_1 = new JLabel("Nazwisko");
		lastNameLabel_1.setBounds(49, 98, 112, 28);
		ordersPanel.add(lastNameLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(173, 98, 299, 28);
		ordersPanel.add(textField_1);

		JLabel phoneLabel_1 = new JLabel("Telefon");
		phoneLabel_1.setBounds(49, 161, 114, 28);
		ordersPanel.add(phoneLabel_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(173, 161, 299, 28);
		ordersPanel.add(textField_2);

		JLabel emailLabel_1 = new JLabel("Email");
		emailLabel_1.setBounds(49, 224, 112, 28);
		ordersPanel.add(emailLabel_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(173, 224, 299, 28);
		ordersPanel.add(textField_3);

		JLabel jobTitleLable_1 = new JLabel("Stanowisko");
		jobTitleLable_1.setBounds(49, 287, 112, 28);
		ordersPanel.add(jobTitleLable_1);

		JComboBox<String> jobTitleComboBox_1 = new JComboBox<String>();
		jobTitleComboBox_1.setBounds(173, 287, 299, 27);
		ordersPanel.add(jobTitleComboBox_1);

		JPanel clientPanel = new JPanel();
		tabbedPane.addTab("Klient", null, clientPanel, null);
		clientPanel.setLayout(null);

		clientEmailTextField = new JTextField();
		clientEmailTextField.setColumns(10);
		clientEmailTextField.setBounds(173, 287, 299, 28);
		clientPanel.add(clientEmailTextField);

		JLabel clientEmailLabel = new JLabel("Email");
		clientEmailLabel.setLabelFor(clientEmailTextField);
		clientEmailLabel.setBounds(49, 287, 112, 28);
		clientPanel.add(clientEmailLabel);

		JLabel clienPhoneLabel = new JLabel("Telefon");
		clienPhoneLabel.setBounds(49, 161, 114, 28);
		clientPanel.add(clienPhoneLabel);

		clientPhoneTextField = new JTextField();
		clienPhoneLabel.setLabelFor(clientPhoneTextField);
		clientPhoneTextField.setColumns(10);
		clientPhoneTextField.setBounds(173, 161, 299, 28);
		clientPanel.add(clientPhoneTextField);

		clientLastNameTextField = new JTextField();
		clientLastNameTextField.setColumns(10);
		clientLastNameTextField.setBounds(173, 98, 299, 28);
		clientPanel.add(clientLastNameTextField);

		JLabel clientLastNameLabel = new JLabel("Nazwisko");
		clientLastNameLabel.setLabelFor(clientLastNameTextField);
		clientLastNameLabel.setBounds(49, 98, 112, 28);
		clientPanel.add(clientLastNameLabel);

		JLabel clientFirstNameLabel = new JLabel("Imię");
		clientFirstNameLabel.setBounds(49, 35, 112, 28);
		clientPanel.add(clientFirstNameLabel);

		clientFirstNameTextField = new JTextField();
		clientFirstNameLabel.setLabelFor(clientFirstNameTextField);
		clientFirstNameTextField.setColumns(10);
		clientFirstNameTextField.setBounds(173, 35, 299, 28);
		clientPanel.add(clientFirstNameTextField);

		Component verticalGlue_1_1_1 = Box.createVerticalGlue();
		verticalGlue_1_1_1.setBounds(0, 0, 83, 24);
		clientPanel.add(verticalGlue_1_1_1);

		JLabel clientAddressLabel = new JLabel("Adres");
		clientAddressLabel.setBounds(49, 224, 112, 28);
		clientPanel.add(clientAddressLabel);

		clientAddressTextField = new JTextField();
		clientAddressLabel.setLabelFor(clientAddressTextField);
		clientAddressTextField.setColumns(10);
		clientAddressTextField.setBounds(173, 224, 299, 28);
		clientPanel.add(clientAddressTextField);
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			cancelButton.setBounds(16, 409, 240, 38);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}

		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedTabIndex = tabbedPane.getSelectedIndex();
				System.out.println(selectedTabIndex);
				switch (selectedTabIndex) {
					case 0:
						Database.addProduct(productNameTextField.getText(), productDescriptionTextField.getText(),
								productWarehouseComboBox.getSelectedIndex(), productCategoryComboBox.getSelectedIndex(),
								Integer.parseInt(productPriceTextField.getText()),
								Integer.parseInt(productCostTextField.getText()),
								Integer.parseInt(productQuantityTextField.getText()));
						break;
					case 1:
						Database.addEmployee(employeeFirstNameTextField.getText(), employeeLastNameTextField.getText(),
						employeePhoneTextField.getText(),
						employeeEmailTextField.getText(),
						employeeJobTitleComboBox.getSelectedItem().toString(),
						employeeWarehouseComboBox.getSelectedIndex());
						break;
					case 2:
						// code block
						break;
					case 3:
						// code block
						break;
					default:
						System.out.println("Wrong logic!");
				}

			}
		});
		addButton.setActionCommand("Add");
		addButton.setBounds(302, 409, 240, 38);
		contentPanel.add(addButton);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
		}
	}
}
