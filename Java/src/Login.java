import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private static boolean userLoged = false;
	private static Login frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

	/**
	 * Create the frame.
	 */
	public Login() {

		setTitle("Warehouse Panel Logowania");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 178, 262);
		panel.setBackground(new Color(205, 133, 63));
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(68, 96, 50, 63);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("password.png"));

		JLabel label = new JLabel("");
		label.setBounds(225, 5, 0, 0);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(225, 5, 0, 0);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(183, 5, 261, 262);
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(19, 97, 59, 26);
		panel_1.add(lblNewLabel);

		usernameTextField = new JTextField();
		usernameTextField.setBounds(84, 97, 130, 26);
		panel_1.add(usernameTextField);
		usernameTextField.setColumns(10);

		JLabel lblPassword = new JLabel("Hasło");
		lblPassword.setBounds(19, 134, 59, 26);
		panel_1.add(lblPassword);

		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(84, 134, 130, 26);
		panel_1.add(passwordTextField);
		contentPane.setLayout(null);
		contentPane.add(panel);
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(panel_1);

		JButton signinButton = new JButton("Zaloguj");
		signinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = usernameTextField.getText();
				String pass = String.valueOf(passwordTextField.getPassword());

				Database.connectToDb();

				if (Database.login(user, pass)) {
					// JOptionPane.showMessageDialog(getContentPane(), "Pomyślnie zalogowano!");
					userLoged = true;
					frame.setVisible(false);
					MainWindow.main(null);
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "Błędne dane! Spróbuj jeszcze raz.");
				}
			}
		});
		signinButton.setBounds(19, 176, 195, 29);
		panel_1.add(signinButton);
	}

	public static boolean userLogedIn() {
		return userLoged;
	}
}
