
import java.sql.*;

public class SqlCon {
	/*
	public static void main(String[] args) {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/leavitt_3100","root","DataFor2.0");
			con.close();  
		}
		catch(Exception e){ System.out.println(e);}  
	} 
	*/
	 
	//Update password
	public static void updatePassword(String email, String password) {
		String query = "UPDATE Employee SET Pwd = '" + password + "' WHERE (Email = '" + email + "' AND EmployeeID <> 0)";	//EmployeeID <> 0 to circumvent safe update mode. 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Verify user exists
	public static boolean userExists(String email, String password) {
		String emailFull = email + "@email.com";
		String query = "SELECT COUNT(*) FROM Employee WHERE Email = '" + emailFull + "' AND Pwd = '" + password + "';";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if (count == 0) return false;
		return true; 
	}
	
	// ######### Queries for Home page #########
	
	// ##### For Housing table #####
	
	// ### For Double Rooms ###
	//Get Count Available Double Housings
	public static int getCountAvailaibleDoubleHousing() {
		String query = "SELECT COUNT(HousingID) FROM Housing WHERE RoomType like 'Double' AND Vacant = TRUE;";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}
	
	//Get Count All Double Housings
	public static int getCountAllDoubleHousing() {
		String query = "SELECT COUNT(HousingID) FROM Housing WHERE RoomType like 'Double';";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}

	
	//Get $ Range Double Housings
	public static double [] getRangeDoubleHousing() {
		String query = "SELECT MIN(RentPrice), MAX(RentPrice) FROM Housing WHERE RoomType like 'Double';";
		double [] range = {0.0,0.0};
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				range[0] = rs.getDouble(1);
				range[1] = rs.getDouble(2);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return range;
	}
	

	//Get $ Average Double Housings
	public static double getAverageDoubleHousing() {
		String query = "SELECT AVG(RentPrice) FROM Housing WHERE RoomType like 'Double';";
		double avg = 0.0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				avg = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return avg;
	}
	
	// ### For Single Rooms ###
	//Get Count Available Single Housings
		public static int getCountAvailaibleSingleHousing() {
			String query = "SELECT COUNT(HousingID) FROM Housing WHERE RoomType like 'Single' AND Vacant = TRUE;";
			int count = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					count = rs.getInt(1);
				}
			
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return count;
		}
		
		//Get Count All Single Housings
		public static int getCountAllSingleHousing() {
			String query = "SELECT COUNT(HousingID) FROM Housing WHERE RoomType like 'Single';";
			int count = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					count = rs.getInt(1);
				}
			
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return count;
		}

		
		//Get $ Range Single Housings
		public static double [] getRangeSingleHousing() {
			String query = "SELECT MIN(RentPrice), MAX(RentPrice) FROM Housing WHERE RoomType like 'Single';";
			double [] range = {0.0,0.0};
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					range[0] = rs.getDouble(1);
					range[1] = rs.getDouble(2);
				}
			
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return range;
		}
		

		//Get $ Average Single Housings
		public static double getAverageSingleHousing() {
			String query = "SELECT AVG(RentPrice) FROM Housing WHERE RoomType like 'Single';";
			double avg = 0.0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					avg = rs.getInt(1);
				}
			
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return avg;
		}
	
	// ### For Apartments ###
	//Get Count Available Apartment Housings
	public static int getCountAvailaibleApartmentHousing() {
		String query = "SELECT COUNT(HousingID) FROM Housing WHERE RoomType like 'Apartment' AND Vacant = TRUE;";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}
	
	//Get Count All Apartment Housings
	public static int getCountAllApartmentHousing() {
		String query = "SELECT COUNT(HousingID) FROM Housing WHERE RoomType like 'Apartment';";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}

	
	//Get $ Range Apartment Housings
	public static double [] getRangeApartmentHousing() {
		String query = "SELECT MIN(RentPrice), MAX(RentPrice) FROM Housing WHERE RoomType like 'Apartment';";
		double [] range = {0.0,0.0};
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				range[0] = rs.getDouble(1);
				range[1] = rs.getDouble(2);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return range;
	}
	

	//Get $ Average Apartment Housings
	public static double getAverageApartmentHousing() {
		String query = "SELECT AVG(RentPrice) FROM Housing WHERE RoomType like 'Apartment';";
		double avg = 0.0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				avg = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return avg;
	}
	
	// ### For Houses ###
	//Get Count Available House Housings
	public static int getCountAvailaibleHouseHousing() {
		String query = "SELECT COUNT(HousingID) FROM Housing WHERE RoomType like 'House' AND Vacant = TRUE;";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}
	
	//Get Count All House Housings
	public static int getCountAllHouseHousing() {
		String query = "SELECT COUNT(HousingID) FROM Housing WHERE RoomType like 'House';";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}

	
	//Get $ Range House Housings
	public static double [] getRangeHouseHousing() {
		String query = "SELECT MIN(RentPrice), MAX(RentPrice) FROM Housing WHERE RoomType like 'House';";
		double [] range = {0.0,0.0};
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				range[0] = rs.getDouble(1);
				range[1] = rs.getDouble(2);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return range;
	}
	

	//Get $ Average House Housings
	public static double getAverageHouseHousing() {
		String query = "SELECT AVG(RentPrice) FROM Housing WHERE RoomType like 'House';";
		double avg = 0.0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				avg = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return avg;
	}
	
	// ### For All ###
	//Get Count Available Housings
	public static int getCountAvailaibleHousing() {
		String query = "SELECT COUNT(HousingID) FROM Housing WHERE Vacant = TRUE;";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}
	
	//Get Count All Housings
	public static int getCountAllHousing() {
		String query = "SELECT COUNT(HousingID) FROM Housing;";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}

	
	//Get $ Range Housings
	public static double [] getRangeHousing() {
		String query = "SELECT MIN(RentPrice), MAX(RentPrice) FROM Housing;";
		double [] range = {0.0,0.0};
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				range[0] = rs.getDouble(1);
				range[1] = rs.getDouble(2);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return range;
	}
	

	//Get $ Average House Housings
	public static double getAverageHousing() {
		String query = "SELECT AVG(RentPrice) FROM Housing;";
		double avg = 0.0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				avg = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return avg;
	}
	
	// ##### For Customer table #####
	// ### For Count Customer ### 
	//Get Count Current Customers
	public static int getCountCurrentCustomer() {
		String query = "SELECT COUNT(DISTINCT Contract.CustomerID) FROM Contract;";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}
	//Get Count Total Customers
	public static int getCountAllCustomer() {
		String query = "SELECT COUNT(*) FROM Customer;";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}
	
	// ### For Grade Average ###
	//Get Average Grade Current Customers 
	public static double getAverageGradeCurrentCustomer() {
		String query = "SELECT AVG(Grade) FROM (SELECT Contract.CustomerID, Customer.Grade FROM Contract LEFT JOIN Customer ON Contract.CustomerID = Customer.CustomerID GROUP BY Contract.CustomerID) T;";
		double avg = 0.0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				avg = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return avg;
	}
	//Get Average Grade Total Customers
	public static double getAverageGradeAllCustomer() {
		String query = "SELECT AVG(Grade) FROM Customer;";
		double avg = 0.0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				avg = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return avg;
	}
	
	
	// ##### For Notifications #####
	//Get count unpaid rent 
	public static int getCountUnpaidRent() {
		String query = "SELECT COUNT(*) FROM Payment WHERE PaymentStatus = 'Unpaid' AND Deadline < current_date();";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}
	
	//Get count expiring contract
	public static int getCountExpiringSoon() {
		String query = "SELECT COUNT(*) FROM Contract WHERE EndDate > current_date() AND date_add(current_date(), INTERVAL 14 DAY) > EndDate;";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}
	
	//Get on-going maintenance
	public static int getCountOnGoingMaintenance() {
		String query = "SELECT COUNT(*) FROM Maintenance WHERE MaintenanceStatus = 'Open';";
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}
	
	// ######### Queries for Admin page #########
	
	// ##### For Housing table ##### --> All get are based on HousingID
	// Create new Housing
	public static boolean createHousing(String housingID, String address, String roomType, String rentPrice, String numOfRooms, String numOfBathrooms) {
		if(housingID.equals("")) {
			return false;
		}
		String query = "INSERT INTO Housing(HousingID, Address, RoomType, RentPrice, NumOfRooms, NumOfBathrooms, Vacant) VALUES ("+Integer.parseInt(housingID)+", '"+address+"', '"+roomType+"', "+Integer.parseInt(rentPrice)+", "+Integer.parseInt(numOfRooms)+", "+Integer.parseInt(numOfBathrooms)+", TRUE);";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	// Update Housing
	public static boolean updateHousing(String searchID, String housingID, String address, String roomType, String rentPrice, String numOfRooms, String numOfBathrooms, String vacant) {
		if(housingID.equals("")) {
			return false;
		}
		String query = "UPDATE Housing SET HousingID = "+Integer.parseInt(housingID)+", Address = '"+address+"', RoomType = '"+roomType+"', RentPrice = "+Integer.parseInt(rentPrice)+", NumOfRooms = "+Integer.parseInt(numOfRooms)+", NumOfBathrooms = "+Integer.parseInt(numOfBathrooms)+", Vacant = '"+vacant.toUpperCase()+"' WHERE HousingID = "+Integer.parseInt(searchID)+";";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	// Delete Housing
	public static boolean deleteHousing(String searchID) {
		String query = "DELETE FROM Housing WHERE HousingID = "+Integer.parseInt(searchID)+";";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	// Getters
	// Get Housing address
	public static String getHousingAddress(String searchID) {
		String query = "SELECT Address FROM Housing WHERE HousingID = "+ searchID +";";
		String r = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return r;
	}
	
	// Get Housing Room Type
	public static String getHousingRoomType(String searchID) {
		String query = "SELECT RoomType FROM Housing WHERE HousingID = "+ searchID +";";
		String r = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return r;
	}
	
	// Get Housing Rent Price
	public static String getHousingRentPrice(String searchID) {
		String query = "SELECT RentPrice FROM Housing WHERE HousingID = "+ searchID +";";
		String r = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return r;
	}
	
	// Get Housing Num Of Bathrooms
	public static String getHousingNumOfBathrooms(String searchID) {
		String query = "SELECT NumOfBathrooms FROM Housing WHERE HousingID = "+ searchID +";";
		int r = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return Integer.toString(r);
	}
	
	// Get Housing Num Of Rooms
	public static String getHousingNumOfRooms(String searchID) {
		String query = "SELECT NumOfRooms FROM Housing WHERE HousingID = "+ searchID +";";
		int r = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return Integer.toString(r);
	}
	
	// Get Housing Vacant
	public static String getHousingVacant(String searchID) {
		String query = "SELECT Vacant FROM Housing WHERE HousingID = "+searchID+";";
		String r = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return r;
	}
	
	
	// ##### For Customer table ##### --> All get are based on CustomerID
	// Create new Customer
	public static boolean createCustomer(String CustomerID, String FirstName, String LastName, String DoB, String Phone, String Email) {
		if(CustomerID.equals("")) {
			return false;
		}
		String query = "INSERT INTO Customer(CustomerID, FirstName, LastName, DoB, Grade, Phone, Email, DateRegistered) VALUES ("+Integer.parseInt(CustomerID)+", '"+FirstName+"', '"+LastName+"', '"+DoB+"', 5,'"+Phone+"', '"+Email+"', current_date());";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	// Update Customer
	public static boolean updateCustomer(String searchID, String customerID, String firstName, String lastName, String doB, String phone, String email) {
		if(customerID.equals("")) {
			return false;
		}
		String query = "UPDATE Customer SET CustomerID = "+Integer.parseInt(customerID)+", FirstName = '"+firstName+"', LastName = '"+lastName+"', DoB = '"+doB+"', Phone = '"+phone+"', Email = '"+email+"' WHERE CustomerID = "+Integer.parseInt(searchID)+";";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	// Delete Customer
	public static boolean deleteCustomer(String searchID) {
		String query = "DELETE FROM Customer WHERE CustomerID = "+Integer.parseInt(searchID)+";";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	// Getters
	// Get Customer First Name
	public static String getCustomerFirstName(String searchID) {
		String query = "SELECT FirstName FROM Customer WHERE CustomerID = "+ searchID +";";
		String r = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return r;
	}
	
	// Get Customer Last Name
	public static String getCustomerLastName(String searchID) {
		String query = "SELECT LastName FROM Customer WHERE CustomerID = "+ searchID +";";
		String r = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return r;
	}
	
	// Get Customer DoB
	public static String getCustomerDoB(String searchID) {
		String query = "SELECT DoB FROM Customer WHERE CustomerID = "+ searchID +";";
		String r = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return r;
	}
	
	// Get Customer Phone
	public static String getCustomerPhone(String searchID) {
		String query = "SELECT Phone FROM Customer WHERE CustomerID = "+ searchID +";";
		String r = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return r;
	}
	
	// Get Customer Email
	public static String getCustomerEmail(String searchID) {
		String query = "SELECT Email FROM Customer WHERE CustomerID = "+ searchID +";";
		String r = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return r;
	}
	
	// ######### Queries for Search page #########
	
	public static String [][] searchList(String cityVal, String rentPriceMinVal, String rentPriceMaxVal, String typeVal, String numRoomsVal, String numBathroomsVal){
		
		String [][] availableList = new String[0][];
		
		String query = "SELECT * FROM Housing ";
		if(!cityVal.isEmpty()) {
			query += "WHERE Address LIKE '%"+cityVal+"%' ";
		}
		if(!cityVal.isEmpty() && !rentPriceMinVal.isEmpty()) {
			query += "AND RentPrice >= "+rentPriceMinVal+" ";
		}
		else if (!rentPriceMinVal.isEmpty()) {
			query += "WHERE RentPrice >= "+rentPriceMinVal+" ";
		}
		if((!cityVal.isEmpty() || !rentPriceMinVal.isEmpty()) && !rentPriceMaxVal.isEmpty()) {
			query += "AND RentPrice <= "+rentPriceMaxVal+" ";
		}
		else if (!rentPriceMaxVal.isEmpty()) {
			query += "WHERE RentPrice <= "+rentPriceMaxVal+" ";
		}
		if((!cityVal.isEmpty() || !rentPriceMinVal.isEmpty() || !rentPriceMaxVal.isEmpty()) && !typeVal.isEmpty()) {
			query += "AND RoomType = '"+typeVal+"' ";
		}
		else if (!typeVal.isEmpty()) {
			query += "WHERE RoomType = '"+typeVal+"' ";
		}
		if((!cityVal.isEmpty() || !rentPriceMinVal.isEmpty() || !rentPriceMaxVal.isEmpty() || !typeVal.isEmpty()) && !numRoomsVal.isEmpty()) {
			query += "AND NumOfRooms = "+numRoomsVal+" ";
		}
		else if (!numRoomsVal.isEmpty()) {
			query += "WHERE NumOfRooms = "+numRoomsVal+" ";
		}
		if((!cityVal.isEmpty() || !rentPriceMinVal.isEmpty() || !rentPriceMaxVal.isEmpty() || !typeVal.isEmpty() || !numRoomsVal.isEmpty()) && !numBathroomsVal.isEmpty()) {
			query += "AND NumOfBathrooms = "+numBathroomsVal+" ";
		}
		else if (!numBathroomsVal.isEmpty()) {
			query += "WHERE NumOfBathrooms = "+numBathroomsVal+" ";
		}
		if(!cityVal.isEmpty() || !rentPriceMinVal.isEmpty() || !rentPriceMaxVal.isEmpty() || !typeVal.isEmpty() || !numRoomsVal.isEmpty() || !numBathroomsVal.isEmpty()) {
			query += "AND Vacant = 'TRUE' ";
		}
		else{
			query += "WHERE Vacant = 'TRUE' ";
		}
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			String queryCount = "SELECT COUNT(*) FROM ("+query+") T;";
			Statement stmtCount = con.createStatement();
			ResultSet rsCount = stmtCount.executeQuery(queryCount);
			
			int count = 0;
			if(rsCount.next()) {
				count = rsCount.getInt(1);
			}
			
			availableList = new String[count][];
			int i = 0;
			
			while(rs.next()) {
				
				String [] housingAvailable = new String[6];
				
				housingAvailable[0] = Integer.toString(rs.getInt(1));
				housingAvailable[1] = rs.getString(2);
				housingAvailable[2] = rs.getString(3);
				housingAvailable[3] =Integer.toString(rs.getInt(4));
				housingAvailable[4] =Integer.toString(rs.getInt(5));
				housingAvailable[5] =Integer.toString(rs.getInt(6));
				
				availableList[i] = housingAvailable;
				i++;
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return availableList;
	}
	
	// ######### Queries for Client page #########

	// Get the date since registered
	public static String getCustomerRegisteredSince(String customerID) {
		String query = "SELECT DateRegistered FROM Customer WHERE CustomerID = "+ Integer.parseInt(customerID) +";";
		String r = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return r;
	}
	
	// Get the num of complaint of a customer
	public static String getCustomerComplaintsNum(String customerID) {
		String query = "SELECT COUNT(ComplaintID) FROM Customer JOIN Complaint ON Customer.CustomerID = Complaint.CustomerID WHERE Customer.CustomerID = "+ Integer.parseInt(customerID) +";";
		int r = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return Integer.toString(r);
	}

	// Get the num of unpaid of a customer
	public static String getCustomerUnpaidsNum(String customerID) {
		String query = "SELECT COUNT(PaymentID) FROM Customer JOIN Payment ON Customer.CustomerID = Payment.CustomerID WHERE Customer.CustomerID = "+ Integer.parseInt(customerID) +" AND Payment.PaymentStatus = 'Unpaid';";
		int r = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return Integer.toString(r);
	}
	
	// Get Customer Grade
	public static String getCustomerGrade(String searchID) {
		String query = "SELECT Grade FROM Customer WHERE CustomerID = "+ searchID +";";
		int r = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				r = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return Integer.toString(r);
	}
	
	//Verify customer exists
		public static boolean customerExists(String customerID) {
			String query = "SELECT COUNT(*) FROM Customer WHERE CustomerID = "+customerID+";";
			int count = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					count = rs.getInt(1);
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			if (count == 0) return false;
			return true; 
		}

	
	// ######### Queries for Account page #########
	
	// Get the full name of the employee
	public static String getEmployeeFullName() {
		String query = "SELECT FirstName FROM Employee WHERE Email = '"+ Login.accountUsername +"@email.com';";
		String name = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				name = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return name;
	}
	
	// Get the birthday of the employee
	public static String getEmployeeBirthday() {
		String query = "SELECT DoB FROM Employee WHERE Email = '"+ Login.accountUsername +"@email.com';";
		String name = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				name = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return name;
	}
	
	// Get the position of the employee
	public static String getEmployeePosition() {
		String query = "SELECT Position FROM Employee WHERE Email = '"+ Login.accountUsername +"@email.com';";
		String name = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				name = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return name;
	}
	
	// Get the phone number of the employee
	public static String getEmployeePhone() {
		String query = "SELECT Phone FROM Employee WHERE Email = '"+ Login.accountUsername +"@email.com';";
		String name = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				name = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return name;
	}
	
	// Get the email of the employee
	public static String getEmployeeEmail() {
		String query = "SELECT Email FROM Employee WHERE Email = '"+ Login.accountUsername +"@email.com';";
		String name = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				name = rs.getString(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return name;
	}
	
	// ############## Search For Unpaid Page ###################
public static String [][] searchListUnpaid(){
		
		String [][] availableList = new String[0][];
		
		String query = "SELECT CustomerID, Customer_Name AS 'Customer Name', COUNT(*) AS 'Number of Unpaid', Deadline FROM (SELECT Customer.CustomerID, CONCAT(FirstName, ' ', LastName) AS 'Customer_Name', Deadline FROM Customer JOIN Payment ON Customer.CustomerID = Payment.CustomerID WHERE Payment.PaymentStatus = 'Unpaid' ORDER BY Deadline DESC) T GROUP BY CustomerID";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			String queryCount = "SELECT COUNT(*) FROM ("+query+") T;";
			Statement stmtCount = con.createStatement();
			ResultSet rsCount = stmtCount.executeQuery(queryCount);
			
			int count = 0;
			if(rsCount.next()) {
				count = rsCount.getInt(1);
			}
			
			availableList = new String[count][];
			int i = 0;
			
			while(rs.next()) {
				
				String [] housingAvailable = new String[4];
				
				housingAvailable[0] = Integer.toString(rs.getInt(1));
				housingAvailable[1] = rs.getString(2);
				housingAvailable[2] = Integer.toString(rs.getInt(3));
				housingAvailable[3] = rs.getString(4);
				
				availableList[i] = housingAvailable;
				i++;
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return availableList;
	}

// ############## Search For Contract Page ###################
public static String [][] searchListContract(){
	
	String [][] availableList = new String[0][];
	
	String query = "SELECT CustomerID, Customer_Name AS 'Customer Name', ContractID, EndDate FROM (SELECT Customer.CustomerID, CONCAT(FirstName, ' ', LastName) AS 'Customer_Name', ContractID, EndDate FROM Customer JOIN Contract ON Customer.CustomerID = Contract.CustomerID WHERE EndDate > current_date() AND date_add(current_date(), INTERVAL 14 DAY) > EndDate ORDER BY Customer.customerID) T";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		String queryCount = "SELECT COUNT(*) FROM ("+query+") T;";
		Statement stmtCount = con.createStatement();
		ResultSet rsCount = stmtCount.executeQuery(queryCount);
		
		int count = 0;
		if(rsCount.next()) {
			count = rsCount.getInt(1);
		}
		
		availableList = new String[count][];
		int i = 0;
		
		while(rs.next()) {
			
			String [] housingAvailable = new String[4];
			
			housingAvailable[0] = Integer.toString(rs.getInt(1));
			housingAvailable[1] = rs.getString(2);
			housingAvailable[2] = Integer.toString(rs.getInt(3));
			housingAvailable[3] = rs.getString(4);
			
			availableList[i] = housingAvailable;
			i++;
		}
	
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	return availableList;
}

// ############## Search For Maintenance Page ###################
public static String [][] searchListMaintenance(){
	
	String [][] availableList = new String[0][];
	
	String query = "SELECT HousingID, MaintenanceID, Reason FROM Maintenance WHERE MaintenanceStatus = 'Open'";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		String queryCount = "SELECT COUNT(*) FROM ("+query+") T;";
		Statement stmtCount = con.createStatement();
		ResultSet rsCount = stmtCount.executeQuery(queryCount);
		
		int count = 0;
		if(rsCount.next()) {
			count = rsCount.getInt(1);
		}
		
		availableList = new String[count][];
		int i = 0;
		
		while(rs.next()) {
			
			String [] housingAvailable = new String[3];
			
			housingAvailable[0] = Integer.toString(rs.getInt(1));
			housingAvailable[1] = Integer.toString(rs.getInt(2));
			housingAvailable[2] = rs.getString(3);
			
			availableList[i] = housingAvailable;
			i++;
		}
	
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	return availableList;
}
}




