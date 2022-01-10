import java.sql.*;
import java.util.*;


public class Database {
	private static Connection con;
	public static void main() {
		/*
		  System.out.println("Sprawdzenie czy sterownik jest zarejestrowany w menadzerze");
		  try {
		    Class.forName("org.postgresql.Driver");
		  } catch (ClassNotFoundException cnfe) {
		    System.out.println("Nie znaleziono sterownika!");
		    System.out.println("Wyduk sledzenia bledu i zakonczenie.");
		    cnfe.printStackTrace();
		    System.exit(1);
		  }
		  System.out.println("Zarejstrowano sterownik - OK, kolejny krok nawiazanie polaczenia z baza danych.");
		  */
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
		        
			
		    return true;			 }
		    
		  else
		    System.out.println("Brak polaczenia z baza, dalsza czesc aplikacji nie jest wykonywana."); 
			return false;}
	
		 public static boolean login(String user, String pass) {
			 
			 
			 try {
				PreparedStatement pst = con.prepareStatement("SELECT U.LOGIN, U.PASSWORD FROM Project.USERS U;", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = pst.executeQuery();
				while (rs.next())  {
		            String login    = rs.getString("login") ;
		            String password    = rs.getString("password") ;
		            if(user.equals(login) && pass.equals(password))
		            {
					    System.out.print("Zwrocone kolumny  ");
		            	System.out.println(login + "\t" + password); 
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

		public static void getProducts(){
			try {

				PreparedStatement pst = con.prepareStatement("SELECT * FROM PRODUCTS;", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = pst.executeQuery();
				MainWindow.tableModel.setRowCount(0);
				while (rs.next())  {

					String product_name = rs.getString("product_name");
					String description = rs.getString("description");
					String warehouse_name = rs.getString("warehouse_name");

					// add header of the table
					String header[] = new String[] { "NAZWA PRODUKTU", "OPIS", "MAGAZYN" };

					// add header to the table model     
					MainWindow.tableModel.setColumnIdentifiers(header);

					MainWindow.tableModel.addRow(new String[]{product_name, description, warehouse_name});
					MainWindow.tableModel.fireTableDataChanged();
					
		        }
				
					
				rs.close();
				pst.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	public static void getEmployees(){
		try {

				PreparedStatement pst = con.prepareStatement("SELECT * FROM EMPLOYEES;", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = pst.executeQuery();
				MainWindow.tableModel.setRowCount(0);
				while (rs.next())  {
					Vector<String> dataRow = new Vector<String>();
					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					String warehouse_name = rs.getString("warehouse_name");

					// add header of the table
					String header[] = new String[]{ "IMIĘ", "NAZWISKO", "MAGAZYN" };

					// add header to the table model     
					MainWindow.tableModel.setColumnIdentifiers(header);


					
					MainWindow.tableModel.addRow(new String[]{first_name, last_name, warehouse_name});
					MainWindow.tableModel.fireTableDataChanged();
					
		        }
				
					
				rs.close();
				pst.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



	public static void getClients(){
		try {
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM CLIENTS;", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			MainWindow.tableModel.setRowCount(0);
			while (rs.next())  {
				Vector<String> dataRow = new Vector<String>();
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String credit = rs.getString("credit");

				// add header of the table
				String header[] = new String[] { "IMIĘ", "NAZWISKO","TELEFON", "EMAIL", "ADRES", "KREDYT" };

				// add header to the table model     
				MainWindow.tableModel.setColumnIdentifiers(header);
				// add data to rows of the table
				dataRow.add(first_name);
				dataRow.add(last_name);
				dataRow.add(phone);
				dataRow.add(address);
				dataRow.add(email);
				dataRow.add(credit);
				
		
				data.add(dataRow);
				
				MainWindow.tableModel.addRow(new String[]{first_name, last_name, phone, address, email, credit});
				MainWindow.tableModel.fireTableDataChanged();
				
			}
			
				
			rs.close();
			pst.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getOrders(){
		try {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM Orders;", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pst.executeQuery();
			MainWindow.tableModel.setRowCount(0);
			while (rs.next())  {

				String first_name = rs.getString("number");
				String last_name = rs.getString("date");
				String phone = rs.getString("total_amount");
				String address = rs.getString("status");

				// add header of the table
				String header[] = new String[] { "NUMER ZAMÓWIENIA", "DATA WYSTAWIENIA", "KWOTA", "STATUS" };

				// add header to the table model     
				MainWindow.tableModel.setColumnIdentifiers(header);
				
				MainWindow.tableModel.addRow(new String[]{first_name, last_name, phone, address});
				MainWindow.tableModel.fireTableDataChanged();
				
			}
			
				
			rs.close();
			pst.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}