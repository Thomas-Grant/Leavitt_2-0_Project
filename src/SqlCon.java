
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
	//Get Count All Housings
	//Get $ Range Housings
	//Get $ Average Housings
	
	// ### For Single Rooms ###
	//Get Count Available Housings
	//Get Count All Housings
	//Get $ Range Housings
	//Get $ Average Housings
	
	// ### For Apartments ###
	//Get Count Available Housings
	//Get Count All Housings
	//Get $ Range Housings
	//Get $ Average Housings
	
	// ### For Houses ###
	//Get Count Available Housings
	//Get Count All Housings
	//Get $ Range Housings
	//Get $ Average Housings
	
	// ### For All ###
	//Get Count Available Housings
	//Get Count All Housings
	public static int getCountAllHousing() {
		String query = "SELECT COUNT(*) FROM Housing";
		int countAllHousing = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leavitt_3100", "root", "DataFor2.0");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				countAllHousing = rs.getInt(1);
			}
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return countAllHousing;
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
	
}




