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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javafx.util.Pair;

@SuppressWarnings("serial")
public class AddDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JList<String> orderItemList;
	private static JTextField productNameTextField;
	private static JTextField productDescriptionTextField;
	private static JTextField productPriceTextField;
	private static JTextField productCostTextField;
	private JTextField productQuantityTextField;
	private JTextField employeeFirstNameTextField;
	private JTextField employeeLastNameTextField;
	private JTextField employeeEmailTextField;
	private JTextField employeePhoneTextField;
	private JTextField clientEmailTextField;
	private JTextField clientPhoneTextField;
	private JTextField clientLastNameTextField;
	private JTextField clientFirstNameTextField;
	private JTextField clientAddressTextField;
	public static JComboBox<String> productCategoryComboBox;
	public static JComboBox<String> productWarehouseComboBox;
	public static JComboBox<String> employeeJobTitleComboBox;
	public static JComboBox<String> employeeWarehouseComboBox;
	public static JComboBox<String> orderStatusComboBox;
	public static JComboBox<String> orderClientComboBox;
	public static JTabbedPane tabbedPane;
	private JTextField orderSearchTextField;
	public static int quantity = 1;
	public static Vector<Pair<String, Integer>> itemsToAddToOrder = new Vector<Pair<String, Integer>>();	
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
		Vector<String> comboBoxClientItems = Database.getClientsFirstAndLastNames();
		

		setBounds(100, 100, 559, 481);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 559, 412);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(6, 6, 547, 411);
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

		JLabel orderStatusLabel = new JLabel("Status");
		orderStatusLabel.setBounds(49, 331, 112, 28);
		ordersPanel.add(orderStatusLabel);

		orderStatusComboBox = new JComboBox<String>();
		orderStatusComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Nowe", "W Realizacji", "Do Wysłania", "Do Odbioru", "Wysłane", "Odebrane", "Anulowane"}));
		orderStatusComboBox.setBounds(173, 331, 299, 27);
		ordersPanel.add(orderStatusComboBox);
		
		JPanel orderViewPanel = new JPanel();
		orderViewPanel.setBounds(49, 36, 423, 240);
		ordersPanel.add(orderViewPanel);
		orderViewPanel.setLayout(null);
		
		JScrollPane orderScrollPane = new JScrollPane();
		orderScrollPane.setBounds(6, 44, 317, 190);
		orderViewPanel.add(orderScrollPane);
		
		orderItemList = new JList<String>(Database.getProductsNames());
		orderScrollPane.setViewportView(orderItemList);
		
		JButton orderAddItemButton = new JButton("Add Item");
		orderAddItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddQuantityDialog.main(null);
				

			}
		});
		orderAddItemButton.setBounds(335, 103, 82, 29);
		orderViewPanel.add(orderAddItemButton);
		
		orderSearchTextField = new JTextField();
		orderSearchTextField.setBounds(108, 6, 215, 26);
		orderViewPanel.add(orderSearchTextField);
		orderSearchTextField.setColumns(10);
		
		JLabel orderSearchLabel = new JLabel("Wyszukaj");
		orderSearchLabel.setBounds(6, 6, 90, 26);
		orderViewPanel.add(orderSearchLabel);
		
		JLabel orderClientLabel = new JLabel("Klient");
		orderClientLabel.setBounds(49, 291, 112, 28);
		ordersPanel.add(orderClientLabel);
		
		orderClientComboBox = new JComboBox<String>(comboBoxClientItems);
		orderClientComboBox.setBounds(173, 291, 299, 27);
		ordersPanel.add(orderClientComboBox);

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
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 424, 559, 29);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			
					JButton addButton = new JButton("Add");
					buttonPane.add(addButton);
					addButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int selectedTabIndex = tabbedPane.getSelectedIndex();
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
									Database.addOrder(orderItemList.getSelectedValue() , quantity, orderClientComboBox.getSelectedItem().toString() , orderStatusComboBox.getSelectedItem().toString());
									for (Pair<String, Integer> item : itemsToAddToOrder){
										Database.addItemToOrder(item.getValue(), item.getKey());
										System.out.println("Dodano : " + item.getValue() + " " +  item.getKey());
									}
									
									itemsToAddToOrder.clear();
									break;
								case 3:
									Database.addClient(clientFirstNameTextField.getText(), clientLastNameTextField.getText(),
											clientPhoneTextField.getText(), clientAddressTextField.getText(),
											clientEmailTextField.getText());
									break;
								default:
									System.out.println("Error!");
							}
							dispose();
						}
					});
					addButton.setActionCommand("Add");
					{
						JButton cancelButton = new JButton("Cancel");
						buttonPane.add(cancelButton);
						cancelButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dispose();
							}
						});
						cancelButton.setActionCommand("Cancel");
					}
		}
	}
}
