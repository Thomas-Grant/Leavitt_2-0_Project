
import java.sql.*; 

public class SqlCon {
	public static void main(String[] args) {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/leavitt_3100","root","DataFor2.0");
			
			//Test getCountAllHousing()
			System.out.println(getCountAllHousing());
			
			con.close();  
		}
		catch(Exception e){ System.out.println(e);}  
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
	
	// 
	
	
	
}




