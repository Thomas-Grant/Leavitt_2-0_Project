
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
	//Get Count Available Housings
	//SELECT COUNT(HousingID) FROM Housing WHERE Type = double AND Vacancy = available; <- i dont see a thing for this in the database
	//Get Count All Housings
	//SELECT COUNT(HousingID) FROM Housing WHERE Type = double;
	//Get $ Range Housings
	//SELECT MIN(RentPrice), MAX(RentPrice) FROM Housing WHERE Type = double;
	//Get $ Average Housings
	//SELECT AVG(RentPrice) FROM Housing WHERE Type = double;
	
	// ### For Single Rooms ###
	//Get Count Available Housings
	//SELECT COUNT(HousingID) FROM Housing WHERE Type = single AND Vacancy = available;
	//Get Count All Housings
	//SELECT COUNT(HousingID) FROM Housing WHERE Type = single;
	//Get $ Range Housings
	//SELECT MIN(RentPrice), MAX(RentPrice) FROM Housing WHERE Type = single;
	//Get $ Average Housings
	//SELECT AVG(RentPrice) FROM Housing WHERE Type = single;
	
	// ### For Apartments ###
	//Get Count Available Housings
	//SELECT COUNT(HousingID) FROM Housing WHERE Type = apartment AND Vacancy = available;
	//Get Count All Housings
	//SELECT COUNT(HousingID) FROM Housing WHERE Type = apartment;
	//Get $ Range Housings
	//SELECT MIN(RentPrice), MAX(RentPrice) FROM Housing WHERE Type = apartment;
	//Get $ Average Housings
	//SELECT AVG(RentPrice) FROM Housing WHERE Type = apartment;
	
	// ### For Houses ###
	//Get Count Available Housings
	//SELECT COUNT(HousingID) FROM Housing WHERE Type = house AND Vacancy = available;
	//Get Count All Housings
	//SELECT COUNT(HousingID) FROM Housing WHERE Type = house;
	//Get $ Range Housings
	//SELECT MIN(RentPrice), MAX(RentPrice) FROM Housing WHERE Type = house;
	//Get $ Average Housings
	//SELECT AVG(RentPrice) FROM Housing WHERE Type = house;
	
	// ### For All ###
	//Get Count Available Housings
	//SELECT COUNT(HousingID) FROM Housing WHERE Vacancy = available;
	//Get Count All Housings
	public static int getCountAllHousing() {
		String query = "SELECT COUNT(*) FROM Housing";
		int countTotalAllHousing = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				countTotalAllHousing = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return countTotalAllHousing;
	}
	//Get $ Range Housings
	//Get $ Average Housings
	
	// ##### For Customer table #####
	
	// ### For Grade Range ###
	//Get Count Current Customers
	//Get Count Total Customers
	
	// ### For Grade Average ###
	//Get Count Current Customers
	//Get Count Total Customers
	
	
	// ######### Queries for Admin page #########
	
	// ##### For Housing table ##### --> All get are based on HousingID
	
	// 
	
	
	
}




