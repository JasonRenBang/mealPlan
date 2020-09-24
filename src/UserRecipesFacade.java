import java.sql.*;
import java.util.*;
public class UserRecipesFacade {
	UserRecipes[] ingArray = new UserRecipes[100];
	
	

	public UserRecipes[] getUserRecipesByUserID(int userId)throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
		
		
		PreparedStatement stmt = con.prepareStatement("SELECT recipe_id, user_id, meal_date, meal_time from usersrecipes WHERE user_id = ?");
		stmt.setInt(1,  userId);
		ResultSet rs = stmt.executeQuery();
	
		int count = 0;
		while(rs.next()) {
			int recipeId = rs.getInt("recipe_id");
			int  userId2= rs.getInt("user_id");
			String mealdate = rs.getString("meal_date");
			String mealtime = rs.getString("meal_time");
			
			UserRecipes ing = new UserRecipes(userId2, recipeId, mealdate, mealtime);
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
	
	public UserRecipes[] getUserRecipes() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
	
		PreparedStatement stmt = con.prepareStatement("SELECT recipe_id, user_id, meal_date, meal_time from usersrecipes order by meal_date");
		ResultSet rs = stmt.executeQuery();
	
		int count = 0;
		while(rs.next()) {
			int recipeId = rs.getInt("recipe_id");
			int  userId= rs.getInt("user_id");
			String mealdate = rs.getString("meal_date");
			String mealtime = rs.getString("meal_time");

			UserRecipes ing = new UserRecipes(userId, recipeId, mealdate, mealtime);
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
	
	
	public UserRecipes[] createUserRecipes(UserRecipes theUserRecipesToAdd) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
		
		
		PreparedStatement cstmt = con.prepareStatement("INSERT INTO usersrecipes(recipe_id, user_id, meal_date, meal_time) VALUE ((SELECT recipe_id FROM recipes WHERE recipe_id = ?), (SELECT user_id FROM users WHERE user_id = ?),?,?);");
		cstmt.setInt(1, theUserRecipesToAdd.getRecipesId());
		cstmt.setInt(2, theUserRecipesToAdd.getUsersId());
		cstmt.setString(3, theUserRecipesToAdd.getMealDate());
		cstmt.setString(4, theUserRecipesToAdd.getMealTime());

		int res = cstmt.executeUpdate();
		if(res==1) {
			PreparedStatement retrieveStmt = con.prepareStatement("Select * from usersrecipes WHERE recipe_id=? AND user_id = ? AND meal_date = ? AND meal_time = ?");
			retrieveStmt.setInt(1, theUserRecipesToAdd.getRecipesId());
			retrieveStmt.setInt(2, theUserRecipesToAdd.getUsersId());
			retrieveStmt.setString(3, theUserRecipesToAdd.getMealDate());
			retrieveStmt.setString(4, theUserRecipesToAdd.getMealTime());

			ResultSet rs = retrieveStmt.executeQuery();
			int count = 0;

			
			while(rs.next()) {
				int theRecipeId = rs.getInt("recipe_id");
				int theUserID = rs.getInt("user_id");
				String themealdate = rs.getString("meal_date");
				String themealtime = rs.getString("meal_time");
	
				
				UserRecipes ing = new UserRecipes(theUserID, theRecipeId, themealdate, themealtime);
				
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
			UserRecipes[] blankIngArray = new UserRecipes[1];
			blankIngArray[0] = new UserRecipes();
			return blankIngArray;
		}
		
		
		
		
	}
	
	public UserRecipes[] deleteUserRecipesByIdAndMealInformation(int therecipesId, int theuserId, String mealDate, String mealTime) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
		
		PreparedStatement cstmti = con.prepareStatement("delete from usersrecipes WHERE recipe_id = ? and user_id = ? and meal_date = ? and meal_time = ?");
		cstmti.setInt(1, therecipesId);
		cstmti.setInt(2, theuserId);
		cstmti.setString(3, mealDate);
		cstmti.setString(4, mealTime);
		int ressi = cstmti.executeUpdate();
		

		if(ressi==1) {
			
			PreparedStatement stmt = con.prepareStatement("SELECT recipe_id, user_id, meal_date, meal_time from usersrecipes order by meal_date");
			ResultSet rs = stmt.executeQuery();
			int count = 0;
			while(rs.next()) {
				int recipeId = rs.getInt("recipe_id");
				int  userId= rs.getInt("user_id");
				String mealdate = rs.getString("meal_date");
				String mealtime = rs.getString("meal_time");

				UserRecipes ing = new UserRecipes(userId, recipeId, mealdate, mealtime);
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
		else {
			UserRecipes[] blankIngArray = new UserRecipes[1];
			blankIngArray[0] = new UserRecipes();
			return blankIngArray;
		}

		
		
		
	}

}


