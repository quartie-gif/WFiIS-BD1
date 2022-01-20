import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringJoiner;
import java.util.Vector;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class Database {
	private static Connection con;
	public static int userId;
	public static void main() {

	}

	public static boolean connectToDb() {

		try {
			String dbUrl = "jdbc:postgresql://pascal.fis.agh.edu.pl:5432/u9piwek";
			String dbUser = "u9piwek";
			String dbPass = "9piwek";
			con = DriverManager.getConnection(dbUrl,
					dbUser, dbPass);
		} catch (SQLException se) {
			System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
			se.printStackTrace();
			System.exit(1);
		}
		if (con != null) {
			System.out.println("Polaczenie z baza danych OK ! ");

			return true;
		}

		else
			System.out.println("Brak polaczenia z baza, dalsza czesc aplikacji nie jest wykonywana.");
		return false;
	}

	public static boolean login(String user, String pass) {

		try {
			PreparedStatement pst = con.prepareStatement("SELECT U.USER_ID, U.LOGIN, U.PASSWORD FROM Project.USERS U;",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int newUserId= rs.getInt("user_id");
				String login = rs.getString("login");
				String password = rs.getString("password");
				if (user.equals(login) && pass.equals(password)) {
					Database.userId = newUserId;
					return true;
				}
			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static void getProducts() {
		try {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM PRODUCTS WHERE USER_ID = ?;", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
					pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			MainWindow.tableModel.setRowCount(0);
			while (rs.next()) {

				String product_id = rs.getString("product_id");
				String product_name = rs.getString("product_name");
				String description = rs.getString("description");
				String warehouse_name = rs.getString("warehouse_name");
				String quantity = rs.getString("quantity");

				// add header of the table
				String header[] = new String[] { "ID", "NAZWA PRODUKTU", "OPIS", "MAGAZYN", "ILOŚĆ" };

				// add header to the table model
				MainWindow.tableModel.setColumnIdentifiers(header);

				MainWindow.tableModel
						.addRow(new String[] { product_id, product_name, description, warehouse_name, quantity });
				MainWindow.tableModel.fireTableDataChanged();

			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Vector<String> getClientsFirstAndLastNames() {

		try {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM Clients;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			Vector<String> comboBoxItems = new Vector<String>();
			while (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				comboBoxItems.add(firstName + " " + lastName);
			}
			rs.close();
			pst.close();
			return comboBoxItems;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String[] getProductsNames() {
		try {
			Vector<String> products = new Vector<String>();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM PRODUCTS;", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				products.add(rs.getString("product_name"));
			}

			rs.close();
			pst.close();
			return products.toArray(new String[products.size()]);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void getEmployees() {
		try {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM EMPLOYEES WHERE USER_ID = ?;", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
					pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			MainWindow.tableModel.setRowCount(0);
			while (rs.next()) {
				String employee_id = rs.getString("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String warehouse_name = rs.getString("warehouse_name");

				// add header of the table
				String header[] = new String[] { "ID", "IMIĘ", "NAZWISKO", "MAGAZYN" };

				// add header to the table model
				MainWindow.tableModel.setColumnIdentifiers(header);

				MainWindow.tableModel.addRow(new String[] { employee_id, first_name, last_name, warehouse_name });
				MainWindow.tableModel.fireTableDataChanged();

			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getUsers() {
		try {

			PreparedStatement pst = con.prepareStatement("SELECT USER_ID, LOGIN FROM Project.USERS", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			MainWindow.tableModel.setRowCount(0);
			while (rs.next()) {
				String user_id = rs.getString("user_id");
				String login = rs.getString("login");

				// add header of the table
				String header[] = new String[] { "ID", "LOGIN" };

				// add header to the table model
				MainWindow.tableModel.setColumnIdentifiers(header);

				MainWindow.tableModel.addRow(new String[] {user_id, login});
				MainWindow.tableModel.fireTableDataChanged();

			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getClients() {
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM CLIENTS;", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			MainWindow.tableModel.setRowCount(0);
			while (rs.next()) {
				String client_id = rs.getString("customer_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String credit = rs.getString("credit");

				// add header of the table
				String header[] = new String[] { "ID", "IMIĘ", "NAZWISKO", "TELEFON", "EMAIL", "ADRES", "KREDYT" };

				// add header to the table model
				MainWindow.tableModel.setColumnIdentifiers(header);

				MainWindow.tableModel
						.addRow(new String[] { client_id, first_name, last_name, phone, address, email, credit });
				MainWindow.tableModel.fireTableDataChanged();

			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getWarehousesWithLocations() {
		try {
			PreparedStatement pst = con.prepareStatement("SELECT WAREHOUSE_NAME, CITY, COUNTRY, POSTAL_CODE FROM Project.WAREHOUSES W LEFT JOIN Project.LOCATIONS L ON L.LOCATION_ID = W.LOCATION_ID;", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			MainWindow.tableModel.setRowCount(0);
			while (rs.next()) {
				String warehouse_name = rs.getString("warehouse_name");
				String city = rs.getString("city");
				String country = rs.getString("country");
				String postal_code = rs.getString("postal_code");

				// add header of the table
				String header[] = new String[] { "NAZWA", "MIASTO", "PAŃSTWO", "KOD POCZTOWY"};

				// add header to the table model
				MainWindow.tableModel.setColumnIdentifiers(header);

				MainWindow.tableModel
						.addRow(new String[] { warehouse_name, city, country, postal_code });
				MainWindow.tableModel.fireTableDataChanged();

			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getOrders() {
		try {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM Orders;", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			MainWindow.tableModel.setRowCount(0);
			while (rs.next()) {

				String orderId = rs.getString("order_id");
				String number = rs.getString("number");
				String date = rs.getString("date");
				String totalAmount = rs.getString("total_amount");
				String status = rs.getString("status");

				// add header of the table
				String header[] = new String[] { "ID", "NUMER ZAMÓWIENIA", "DATA WYSTAWIENIA", "KWOTA", "STATUS" };

				// add header to the table model
				MainWindow.tableModel.setColumnIdentifiers(header);

				MainWindow.tableModel.addRow(new String[] { orderId, number, date, totalAmount, status });
				MainWindow.tableModel.fireTableDataChanged();

			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Vector<String> getCategories() {
		try {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM PRODUCT_CATEGORIES;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			Vector<String> comboBoxItems = new Vector<String>();
			while (rs.next()) {

				comboBoxItems.add(rs.getString("Category_name"));
			}

			rs.close();
			pst.close();
			return comboBoxItems;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static Vector<String> getWarehouses() {
		try {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM WAREHOUSES_WITH_LOCATIONS;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			Vector<String> comboBoxItems = new Vector<String>();
			while (rs.next()) {
				String warehouse_name = rs.getString("warehouse_name");
				comboBoxItems.add(warehouse_name);
			}

			rs.close();
			pst.close();
			return comboBoxItems;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void addEmployee(String firstName, String lastName, String phone, String email, String jobTitle,
			int warehouseId) {
		try {

			PreparedStatement pst = con.prepareStatement("SELECT MAX(employee_id) FROM Employees;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs;
			rs = pst.executeQuery();
			int employeeId = 1;
			while (rs.next()) {
				employeeId = rs.getInt("max") + 1;
			}
			rs.close();
			pst = con.prepareStatement(
					"INSERT INTO Project.EMPLOYEES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE, EMAIL, JOB_TITLE) VALUES(?, ?, ?, ?, ?, ?); ",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, employeeId);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setString(4, phone);
			pst.setString(5, email);
			pst.setString(6, jobTitle);
			pst.executeUpdate();

			pst = con.prepareStatement(
					"INSERT INTO Project.EMPLOYEES_IN_WAREHOUSES(EMPLOYEE_ID, WAREHOUSE_ID) VALUES(?, ?); ",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, employeeId);
			pst.setInt(2, warehouseId + 1);
			pst.executeUpdate();

			MainWindow.tableModel.fireTableDataChanged();

			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addItemToOrder(int quantity, String productName) {
		try {

			PreparedStatement pst = con.prepareStatement("SELECT MAX(ITEM_ID) FROM Project.ORDER_ITEM;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs;
			rs = pst.executeQuery();
			int orderItemId = 1;
			while (rs.next()) {
				orderItemId = rs.getInt("max") + 1;
			}

			pst = con.prepareStatement("SELECT MAX(ORDER_ID) FROM Orders;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = pst.executeQuery();
			int orderId = 1;
			while (rs.next()) {
				orderId = rs.getInt("max");
			}

			pst = con.prepareStatement("SELECT P.PRODUCT_ID FROM Project.PRODUCTS P WHERE P.PRODUCT_NAME = ?;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pst.setString(1, productName);
			rs = pst.executeQuery();
			int productId = 1;
			while (rs.next()) {
				productId = rs.getInt("product_id") + 1;
			}

			pst = con.prepareStatement(
					"INSERT INTO Project.ORDER_ITEM(ITEM_ID, ORDER_ID, PRODUCT_ID, QUANTITY) VALUES (?, ?, ?, ?); ",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, orderItemId);
			pst.setInt(2, orderId);
			pst.setInt(3, productId);
			pst.setInt(4, quantity);

			pst.executeUpdate();

			MainWindow.tableModel.fireTableDataChanged();

			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addOrder(String productName, int quantity, String client, String status) {
		try {
			PreparedStatement pst = con.prepareStatement("SELECT MAX(order_id) FROM Orders;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs;
			rs = pst.executeQuery();
			int orderId = 1;
			while (rs.next()) {
				orderId = rs.getInt("max") + 1;
			}

			String[] splitedClientName = client.split(" ");

			pst = con.prepareStatement("SELECT CUSTOMER_ID from clients WHERE FIRST_NAME = ? AND LAST_NAME = ?;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pst.setString(1, splitedClientName[0]);
			pst.setString(2, splitedClientName[1]);
			rs = pst.executeQuery();
			int clientId = 1;
			while (rs.next()) {
				clientId = rs.getInt("customer_id");
			}
			rs.close();
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
			LocalDateTime now = LocalDateTime.now();  
			pst = con.prepareStatement(
					"INSERT INTO Project.ORDERS(ORDER_ID, CUSTOMER_ID, NUMBER, DATE, TOTAL_AMOUNT, STATUS) VALUES (?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?); ",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, orderId);
			pst.setInt(2, clientId);
			pst.setString(3, "123/123");
			pst.setString(4, dtf.format(now));
			pst.setFloat(5, 0.0f);
			pst.setString(6, status);

			pst.executeUpdate();

			MainWindow.tableModel.fireTableDataChanged();

			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addProduct(String name, String description, int warehouseId, int categoryId, int price,
			int cost, int quantity) {
		try {

			PreparedStatement pst = con.prepareStatement("SELECT MAX(PRODUCT_ID) FROM Products;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs;
			rs = pst.executeQuery();
			int productId = 1;
			while (rs.next()) {
				productId = rs.getInt("max") + 1;
			}
			rs.close();

			pst = con.prepareStatement(
					"INSERT INTO Project.PRODUCTS(PRODUCT_ID, CATEGORY_ID, PRODUCT_NAME, DESCRIPTION, COST, PRICE) VALUES(?, ?, ?, ?, ?, ?); ",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pst.setInt(1, productId);
			pst.setInt(2, categoryId + 1);
			pst.setString(3, name);
			pst.setString(4, description);
			pst.setFloat(5, cost);
			pst.setFloat(6, price);
			pst.executeUpdate();

			pst = con.prepareStatement(
					"INSERT INTO Project.PRODUCTS_IN_WAREHOUSES(PRODUCT_ID, WAREHOUSE_ID, QUANTITY) VALUES(?, ?, ?); ",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, productId);
			pst.setInt(2, warehouseId + 1);
			pst.setInt(3, quantity);
			pst.executeUpdate();

			MainWindow.tableModel.fireTableDataChanged();

			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addClient(String firstName, String lastName, String phone, String address, String email) {
		try {

			PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM (SELECT * FROM Clients)as Clients;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs;
			rs = pst.executeQuery();
			int clientId = 1;

			while (rs.next()) {
				clientId = rs.getInt("count") + 1;
			}

			int contactId = clientId;

			rs.close();

			pst = con.prepareStatement(
					"INSERT INTO Project.CUSTOMERS(CUSTOMER_ID, CREDIT) VALUES (?, 0); ",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, clientId);
			pst.executeUpdate();

			pst = con.prepareStatement(
					"INSERT INTO Project.CONTACTS(CONTACT_ID, CUSTOMER_ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?); ",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, contactId);
			pst.setInt(2, clientId);
			pst.setString(3, firstName);
			pst.setString(4, lastName);
			pst.setString(5, phone);
			pst.setString(6, address);
			pst.setString(7, email);
			pst.executeUpdate();

			MainWindow.tableModel.fireTableDataChanged();

			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addWarehouseWithLocation(String name, String address, String postalCode, String city, String country) {
		try {

			PreparedStatement pst = con.prepareStatement("SELECT MAX(WAREHOUSE_ID) FROM Project.WAREHOUSES",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs;
			rs = pst.executeQuery();
			int warehouse_id = 1;

			while (rs.next()) {
				warehouse_id = rs.getInt("max") + 1;
			}
			rs.close();


			pst = con.prepareStatement(
				"INSERT INTO Project.LOCATIONS(LOCATION_ID, ADDRESS, POSTAL_CODE, CITY, COUNTRY) VALUES (?, ?, ?, ?, ?); ",
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, warehouse_id);
			pst.setString(2, address);
			pst.setString(3, postalCode);
			pst.setString(4, city);
			pst.setString(5, country);
			pst.executeUpdate();


			pst = con.prepareStatement(
					"INSERT INTO Project.WAREHOUSES(WAREHOUSE_ID, USER_ID, LOCATION_ID, WAREHOUSE_NAME) VALUES (?, ?, ?, ?); ",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, warehouse_id);
			pst.setInt(2, userId);
			pst.setInt(3, warehouse_id);
			pst.setString(4, name);
			pst.executeUpdate();


			MainWindow.tableModel.fireTableDataChanged();

			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addUser(String login, String password) {
		try {

			PreparedStatement pst = con.prepareStatement("SELECT MAX(USER_ID) FROM Project.USERS; ",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs;
			rs = pst.executeQuery();
			int userId = 1;

			while (rs.next()) {
				userId = rs.getInt("MAX") + 1;
			}

			rs.close();

			pst = con.prepareStatement(
					"INSERT INTO Project.USERS(USER_ID, LOGIN, PASSWORD) VALUES (?, ?, ?); ",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, userId);
			pst.setString(2, login);
			pst.setString(3, password);

			pst.executeUpdate();

			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void deleteClient(int clientId) {
		try {
			PreparedStatement pst = con.prepareStatement("DELETE FROM Project.CONTACTS WHERE CUSTOMER_ID = ?;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pst.setInt(1, clientId);
			pst.executeUpdate();

			Vector<Integer> ordersToDelete = new Vector<Integer>();
			pst = con.prepareStatement("SELECT ORDER_ID FROM ORDERS O WHERE O.CUSTOMER_ID = ?;  ",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pst.setInt(1, clientId);
			ResultSet rs;
			rs = pst.executeQuery();

			while (rs.next()) {
				ordersToDelete.add(rs.getInt("order_id"));
			}

			rs.close();
			for (Integer number : ordersToDelete) { 
				System.out.println(number);
			}
			while(!ordersToDelete.isEmpty()){
				System.out.println("Usunieto item");
				pst = con.prepareStatement("DELETE FROM Project.ORDER_ITEM WHERE ORDER_ID = ?;",
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
				pst.setInt(1, ordersToDelete.remove(ordersToDelete.size() - 1));
				pst.executeUpdate();
			}

			pst = con.prepareStatement("DELETE FROM Project.ORDERS WHERE CUSTOMER_ID = ?;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pst.setInt(1, clientId);
			pst.executeUpdate();

			pst = con.prepareStatement("DELETE FROM Project.CUSTOMERS WHERE CUSTOMER_ID = ?;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, clientId);
			pst.executeUpdate();
			MainWindow.tableModel.fireTableDataChanged();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteOrder(int orderId) {
		try {

			PreparedStatement pst = con.prepareStatement("DELETE FROM Project.ORDER_ITEM WHERE ORDER_ID = ?;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pst.setInt(1, orderId);
			pst.executeUpdate();

			pst = con.prepareStatement("DELETE FROM Project.ORDERS WHERE ORDER_ID = ?;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, orderId);
			pst.executeUpdate();
			MainWindow.tableModel.fireTableDataChanged();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteEmployee(int employeeId) {
		try {

			PreparedStatement pst = con.prepareStatement(
					"DELETE FROM Project.EMPLOYEES_IN_WAREHOUSES WHERE EMPLOYEE_ID = ?;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pst.setInt(1, employeeId);
			pst.executeUpdate();

			pst = con.prepareStatement("DELETE FROM Project.EMPLOYEES WHERE EMPLOYEE_ID = ?;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setInt(1, employeeId);
			pst.executeUpdate();
			MainWindow.tableModel.fireTableDataChanged();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteProduct(String productName, String warehouseName, String description) {
		try {
			// Get an index of product
			PreparedStatement pst = con.prepareStatement(
					"SELECT P.PRODUCT_ID, W.WAREHOUSE_ID FROM Project.PRODUCTS_IN_WAREHOUSES PW LEFT JOIN Project.WAREHOUSES W ON W.WAREHOUSE_ID = PW.WAREHOUSE_ID LEFT JOIN Project.PRODUCTS P ON P.PRODUCT_ID = PW.PRODUCT_ID WHERE W.WAREHOUSE_NAME = ? and P.PRODUCT_NAME = ? and P.DESCRIPTION = ?;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			pst.setString(1, warehouseName);
			pst.setString(2, productName);
			pst.setString(3, description);
			ResultSet rs = pst.executeQuery();
			int productId = 0;
			int warehouseId = 0;
			while (rs.next()) {
				productId = rs.getInt("product_id");
				warehouseId = rs.getInt("warehouse_id");
			}

			pst = con.prepareStatement(
					"DELETE FROM Project.PRODUCTS_IN_WAREHOUSES WHERE PRODUCT_ID = ? AND WAREHOUSE_ID = ?;",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pst.setInt(1, productId);
			pst.setInt(2, warehouseId);
			pst.executeUpdate();
			
			MainWindow.tableModel.fireTableDataChanged();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void generateRaport() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("./raports/Raport.txt")));

			StringJoiner joiner = new StringJoiner("");
			for (int column = 0; column < MainWindow.tableModel.getColumnCount(); column++) {
				joiner.add(String.format("%-25s",MainWindow.tableModel.getColumnName(column)));
			}
			bw.write(joiner.toString());
			bw.newLine();
			bw.newLine();
			for (int row = 0; row < MainWindow.tableModel.getRowCount(); row++) {
				joiner = new StringJoiner("");
				for (int column = 0; column < MainWindow.tableModel.getColumnCount(); column++) {
					Object tableItem = MainWindow.tableModel.getValueAt(row, column);
					String value = tableItem == null ? "null" : tableItem.toString();
					joiner.add(String.format("%-25s",value));
				}
				bw.write(Database.centerString(25, joiner.toString()));
				bw.newLine();
			}
			bw.close();
			BufferedWriter bw2 = new BufferedWriter(new FileWriter(new File("./raports/PasswordsAndLogins.txt")));

			//From views raports
			PreparedStatement pst = con.prepareStatement("SELECT LOGIN, PASSWORD FROM Project.USERS",
			ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			joiner = new StringJoiner("");
			joiner.add(String.format("%-25s","LOGIN"));
			joiner.add(String.format("%-25s","PASSWORD"));
			bw2.write(Database.centerString(25, joiner.toString()));
			bw2.newLine();
			bw2.newLine();
			while (rs.next()) {
				joiner = new StringJoiner("");
				joiner.add(String.format("%-25s",rs.getString("login")));
				joiner.add(String.format("%-25s",rs.getString("password")));
				bw2.write(Database.centerString(25, joiner.toString()));
				bw2.newLine();
			}
			bw2.close();

			BufferedWriter bw3 = new BufferedWriter(new FileWriter(new File("./raports/OrdersAndTotalSum.txt")));

			//From views raports
			pst = con.prepareStatement("SELECT * FROM orders_with_amount",
			ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_UPDATABLE);
			rs = pst.executeQuery();
			joiner = new StringJoiner("");
			joiner.add(String.format("%-25s","NUMER ZAMOWIENIA"));
			joiner.add(String.format("%-25s","CALKOWITA WARTOSC"));
			bw3.write(Database.centerString(25, joiner.toString()));
			bw3.newLine();
			bw3.newLine();
			while (rs.next()) {
				joiner = new StringJoiner("");
				joiner.add(String.format("%-25s",rs.getString("numer_zamowienia")));
				joiner.add(String.format("%-25s",rs.getString("calkowita_wartosc")));
				bw3.write(Database.centerString(25, joiner.toString()));
				bw3.newLine();
			}
			bw3.close();


			BufferedWriter bw4 = new BufferedWriter(new FileWriter(new File("./raports/Categories.txt")));

			//From views raports
			pst = con.prepareStatement("SELECT * FROM Project.product_categories",
			ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_UPDATABLE);
			rs = pst.executeQuery();
			joiner = new StringJoiner("");
			joiner.add(String.format("%-25s","Kategorie"));
			bw4.write(Database.centerString(25, joiner.toString()));
			bw4.newLine();
			bw4.newLine();
			while (rs.next()) {
				joiner = new StringJoiner("");
				joiner.add(String.format("%-25s",rs.getString("category_name")));
				bw4.write(Database.centerString(25, joiner.toString()));
				bw4.newLine();
			}
			bw4.close();

			pst.close();
			rs.close();

		} catch (IOException exp) {
			exp.printStackTrace();
		} catch (SQLException exp) {
			exp.printStackTrace();
		}
	}
	public static String centerString (int width, String s) {
		return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}

}