import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class MainWindow {

	private JFrame frame;
	private JTable table;
	public static DefaultTableModel tableModel;
	public static String lastClickedButton = "Produkty";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1122, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(306, 6, 591, 574);
		panel_1.setLayout(new BorderLayout());
		panel.add(panel_1);

		// Initialize table
		tableModel = new DefaultTableModel();

		Database.getProducts();

		table = new JTable(tableModel);
		table.setFillsViewportHeight(true);
		JScrollPane tableContainer = new JScrollPane(table);
		tableContainer.setViewportView(table);

		panel_1.add(tableContainer, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(6, 6, 288, 574);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 20));
		panel_2.setOpaque(true);

		JButton btnNewButton_1 = new JButton("Produkty");
		btnNewButton_1.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton_1.setBackground(new Color(205, 133, 63));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastClickedButton = "Produkty";
				Database.getProducts();
			}
		});
		panel_2.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Pracownicy");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastClickedButton = "Pracownicy";
				Database.getEmployees();
			}
		});
		btnNewButton_2.setBackground(new Color(205, 133, 63));
		btnNewButton_2.setOpaque(true);
		panel_2.add(btnNewButton_2);

		JButton btnNewButton = new JButton("Zamówienia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastClickedButton = "Zamówienia";
				Database.getOrders();
			}
		});
		btnNewButton.setBackground(new Color(205, 133, 63));
		btnNewButton.setOpaque(true);
		panel_2.add(btnNewButton);

		JButton btnNewButton_3 = new JButton("Klienci");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastClickedButton = "Klienci";
				Database.getClients();
			}
		});
		
		JButton btnNewButton_3_1 = new JButton("Uzytkownicy");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastClickedButton = "Uzytkownicy";
				Database.getUsers();
			}
		});
		btnNewButton_3_1.setOpaque(true);
		btnNewButton_3_1.setBackground(new Color(205, 133, 63));
		panel_2.add(btnNewButton_3_1);
		btnNewButton_3.setBackground(new Color(205, 133, 63));
		btnNewButton_3.setOpaque(true);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_3_2 = new JButton("Magazyny");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastClickedButton = "Magazyny";
				Database.getWarehousesWithLocations();
			}
		});
		btnNewButton_3_2.setOpaque(true);
		btnNewButton_3_2.setBackground(new Color(205, 133, 63));
		panel_2.add(btnNewButton_3_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(909, 6, 164, 574);
		panel.add(panel_3);

		JButton addButton = new JButton("Dodaj");
		addButton.setBounds(6, 111, 152, 41);
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setEnabled(false);
				AddDialog.main(null);
				frame.setEnabled(true);
			}
		});
		panel_3.setLayout(null);
		panel_3.add(addButton);

		JButton deleteButton = new JButton("Usuń");
		deleteButton.setBounds(6, 191, 152, 41);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow() + 1;
				switch (lastClickedButton) {
					case "Produkty":
						String productName = (String) tableModel.getValueAt(row - 1, 1);
						String productDescirption = (String) tableModel.getValueAt(row - 1, 2);
						String productWarehouse = (String) tableModel.getValueAt(row - 1, 3);
						Database.deleteProduct(productName, productWarehouse, productDescirption);
						break;
					case "Pracownicy":
						Database.deleteEmployee(Integer.parseInt((String) tableModel.getValueAt(row - 1, 0)));
						break;
					case "Zamówienia":
						Database.deleteOrder(row);
						break;
					case "Klienci":
						Database.deleteClient(Integer.parseInt((String) tableModel.getValueAt(row - 1, 0)));
						break;
					default:
						System.out.println("Error checking last clicked button!");
				}
				tableModel.removeRow(row - 1); // dynamic delete of row
			}
		});
		panel_3.add(deleteButton);

		JButton editButton = new JButton("Raport");
		editButton.setBounds(6, 271, 152, 41);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (lastClickedButton) {
					case "Produkty":
						Database.generateRaport();
						break;
					case "Pracownicy":
						Database.generateRaport();
						break;
					case "Zamówienia":
						Database.generateRaport();
						break;
					case "Klienci":
						Database.generateRaport();
						break;
					case "Uzytkownicy":
						Database.generateRaport();
						break;
					case "Magazyny":
						Database.generateRaport();
						break;
					default:
						Database.generateRaport();
				}
			}
		});
		panel_3.add(editButton);
		
		JButton buttonDodajMagazyn = new JButton("Dodaj Magazyn");
		buttonDodajMagazyn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWarehouse.main(null);
			}
		});
		buttonDodajMagazyn.setBounds(6, 430, 152, 41);
		panel_3.add(buttonDodajMagazyn);
	}

}