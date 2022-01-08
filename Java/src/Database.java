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

		public static Vector<Vector<String>> getProducts(){
			try {
				Vector<Vector<String>> data = new Vector<Vector<String>>();
				PreparedStatement pst = con.prepareStatement("SELECT P.PRODUCT_NAME, P.DESCRIPTION, W.WAREHOUSE_NAME FROM Project.PRODUCTS P LEFT JOIN Project.PRODUCTS_IN_WAREHOUSES PW ON P.PRODUCT_ID = PW.PRODUCT_ID LEFT JOIN Project.WAREHOUSES W ON W.WAREHOUSE_ID = PW.WAREHOUSE_ID ORDER BY WAREHOUSE_NAME;", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = pst.executeQuery();
				System.out.println("DUPA");
				while (rs.next())  {
						System.out.println("DUPA");
					Vector<String> dataRow = new Vector<String>();
					String product_name = rs.getString("product_name");
					String description = rs.getString("description");
					String warehouse_name = "";
		   			if(!product_name.equals(null) && !description.equals(null) && !warehouse_name.equals(null) ){
						dataRow.add(product_name);
						dataRow.add(description);
						dataRow.add(warehouse_name);
						System.out.println(dataRow.size());
						if(dataRow.size()==3){
							data.add(dataRow);
							System.out.println("Data added");
						}
						System.out.println(product_name + "\t" + description);
					   }
		            					

		        }
				
					
				rs.close();
				pst.close();
				return data;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

	}
