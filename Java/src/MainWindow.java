import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MainWindow {

	private JFrame frame;
	private JTable table;
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
		panel_1.setBounds(306, 6, 765, 574);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		table = new JTable(new DefaultTableModel(new Object[]{"Name", "Description", "Warehouse"},3));
		panel_1.add(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(6, 6, 288, 574);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 10));
		panel_2.setOpaque(true);
		
		JButton btnNewButton_1 = new JButton("Produkty");
		btnNewButton_1.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton_1.setBackground(new Color(205, 133, 63));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				Vector<Vector<String>> data = Database.getProducts();
				System.out.println(data);
				for(int i=0; i<data.size();++i){
									System.out.println("Loop");
					model.addRow(new String[]{data.get(i).get(0).toString(), data.get(i).get(1).toString(), data.get(i).get(2).toString()});
					System.out.println(data.get(i).get(0).toString()+ data.get(i).get(1).toString()+ data.get(i).get(2).toString());

				}

				model.fireTableDataChanged();
				System.out.println("After Set model" +  table.getRowCount());
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Pracownicy");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setBackground(new Color(205, 133, 63));
		btnNewButton_2.setOpaque(true);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Zamówienia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton.setBackground(new Color(205, 133, 63));
		btnNewButton.setOpaque(true);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Klienci");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBackground(new Color(205, 133, 63));
		btnNewButton_3.setOpaque(true);
		panel_2.add(btnNewButton_3);
	}
}
