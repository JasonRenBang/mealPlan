
import java.sql.*;
import java.util.*;

public class UsersFacade {
	
	
	Users[] ingArray = new Users[100];

	
	public Users[] getUsersById(int theId)throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
	
		PreparedStatement stmt = con.prepareStatement("SELECT user_id, username, user_password, name, security_level from users WHERE user_id =?");
		stmt.setInt(1,  theId);
		ResultSet rs = stmt.executeQuery();
		
		int count = 0;
		while(rs.next()) {
			int theId2 = rs.getInt("user_id");
			String username = rs.getString("username");
			String password = rs.getString("user_password");
			String name = rs.getString("name");
			int securityLevel = rs.getInt("security_level");
			Users ing = new Users(theId2, username, password, name, securityLevel);
			ingArray[count]  = ing;
			count++;
		}
		if(count>0) {
			ingArray = Arrays.copyOf(ingArray, count);
			return ingArray;
		}
		else
			return null;
		
	}

	
	public Users[] getUsersByUsername(String theUsername)throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
		
		
		PreparedStatement stmt = con.prepareStatement("SELECT user_id, username, user_password, name, security_level from users WHERE username=?");
		stmt.setString(1,  theUsername);
		ResultSet rs = stmt.executeQuery();
	
		int count = 0;
		while(rs.next()) {
			int theId = rs.getInt("user_id");
			String theUsername2 = rs.getString("username");
			String password = rs.getString("user_password");
			String name = rs.getString("name");
			int securityLevel = rs.getInt("security_level");
			Users ing = new Users(theId, theUsername2, password, name, securityLevel);
			ingArray[count]  = ing;
			count++;
		}
		if(count>0) {
			ingArray = Arrays.copyOf(ingArray, count);
			return ingArray;
		}
		else
			return null;
		
	}
	
	
	public Users[] getUsersByPassword(String thePassword)throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
	
		PreparedStatement stmt = con.prepareStatement("SELECT user_id, username, user_password, name, security_level from users WHERE user_password=?");
		stmt.setString(1,  thePassword);
		ResultSet rs = stmt.executeQuery();
		
		int count = 0;
		while(rs.next()) {
			int theId = rs.getInt("user_id");
			String username = rs.getString("username");
			String thePassword2 = rs.getString("user_password");
			String name = rs.getString("name");
			int securityLevel = rs.getInt("security_level");
			Users ing = new Users(theId, username, thePassword2, name, securityLevel);
			ingArray[count]  = ing;
			count++;
		}
		if(count>0) {
			ingArray = Arrays.copyOf(ingArray, count);
			return ingArray;
		}
		else
			return null;
		
	}
	

	public Users[] getUsersByName(String theName)throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
		
		PreparedStatement stmt = con.prepareStatement("SELECT user_id, username, user_password, name, security_level from users WHERE name=?");
		stmt.setString(1,  theName);
		ResultSet rs = stmt.executeQuery();
	
		int count = 0;
		while(rs.next()) {
			int theId = rs.getInt("user_id");
			String username = rs.getString("username");
			String password = rs.getString("user_password");
			String theName2 = rs.getString("name");
			int securityLevel = rs.getInt("security_level");
			Users ing = new Users(theId, username, password, theName2, securityLevel);
			ingArray[count]  = ing;
			count++;
		}
		if(count>0) {
			ingArray = Arrays.copyOf(ingArray, count);
			return ingArray;
		}
		else
			return null;
		
	}


	public Users[] getUsersBySecurityLevel(int theSecurityLevel)throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
		
		PreparedStatement stmt = con.prepareStatement("SELECT user_id, username, user_password, name, security_level from users WHERE security_level=?");
		stmt.setInt(1,  theSecurityLevel);
		ResultSet rs = stmt.executeQuery();
	
		int count = 0;
		while(rs.next()) {
			int theId = rs.getInt("user_id");
			String username = rs.getString("username");
			String password = rs.getString("user_password");
			String name = rs.getString("name");
			int theSecurityLevel2 = rs.getInt("security_level");
			Users ing = new Users(theId, username, password, name, theSecurityLevel2);
			ingArray[count]  = ing;
			count++;
		}
		if(count>0) {
			ingArray = Arrays.copyOf(ingArray, count);
			return ingArray;
		}
		else
			return null;
		
	}

	
	public Users[] getUsers() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
	
		PreparedStatement stmt = con.prepareStatement("SELECT user_id, username, user_password, name, security_level from users");
		ResultSet rs = stmt.executeQuery();
	
		int count = 0;
		while(rs.next()) {
			int theId = rs.getInt("user_id");
			String username = rs.getString("username");
			String password = rs.getString("user_password");
			String name = rs.getString("name");
			int securityLevel = rs.getInt("security_level");
			Users ing = new Users(theId, username, password, name, securityLevel);
			ingArray[count]  = ing;
			count++;
		}
		if(count>0) {
			ingArray = Arrays.copyOf(ingArray, count);
			return ingArray;
		}
		else
			return null;
		
	}
	
	
	public Users[] createUsers(Users theUserToAdd) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
		
		
		PreparedStatement cstmt = con.prepareStatement("INSERT INTO users(username, user_password, name, security_level) VALUE (?,?,?,?)");
		cstmt.setString(1, theUserToAdd.getUsername());
		cstmt.setString(2, theUserToAdd.getPassword());
		cstmt.setString(3, theUserToAdd.getName());
		cstmt.setInt(4, theUserToAdd.getSecurity_level());
		int res = cstmt.executeUpdate();
		if(res==1) {
			PreparedStatement retrieveStmt = con.prepareStatement("Select * from users WHERE user_id=? AND username = ? AND user_password = ? AND name = ? AND security_level = ? ");
			retrieveStmt.setInt(1, theUserToAdd.getId());
			retrieveStmt.setString(2, theUserToAdd.getUsername());
			retrieveStmt.setString(3, theUserToAdd.getPassword());
			retrieveStmt.setString(4, theUserToAdd.getName());
			retrieveStmt.setInt(5, theUserToAdd.getSecurity_level());
			ResultSet rs = retrieveStmt.executeQuery();
			
			int count = 0;

			
			while(rs.next()) {
				int theId = rs.getInt("user_id");
				String theUserName = rs.getString("username");
				String thePassword = rs.getString("user_password");
				String theName = rs.getString("name");
				int theSecurityLevel = rs.getInt("security_level");
				
				Users ing = new Users(theId, theUserName, thePassword, theName, theSecurityLevel);
				
				ingArray[count] = ing;
				count++;
				
			}
			if(count>0) {
				ingArray = Arrays.copyOf(ingArray, count);
				return ingArray;
			}
			else
				return null;
		}
		else {
			Users[] blankIngArray = new Users[1];
			blankIngArray[0] = new Users();
			return blankIngArray;
		}
		
		
		
		
	}
}
