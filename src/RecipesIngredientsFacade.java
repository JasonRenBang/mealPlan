import java.sql.*;
import java.util.*;
public class RecipesIngredientsFacade {
	RecipesIngredients[] ingArray = new RecipesIngredients[100];
	
	
	
	public RecipesIngredients[] getRecipesIngredientsByRecipID(int recipedId)throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
		
		
		PreparedStatement stmt = con.prepareStatement("SELECT ingredient_id, recipe_id, num_ingredient_servings from recipesingredients WHERE recipe_id = ?");
		stmt.setInt(1,  recipedId);
		ResultSet rs = stmt.executeQuery();
	
		int count = 0;
		while(rs.next()) {
			int ingredientId = rs.getInt("ingredient_id");
			int  recipedId2= rs.getInt("recipe_id");
			int nus = rs.getInt("num_ingredient_servings");

			
			RecipesIngredients ing = new RecipesIngredients(ingredientId, recipedId2, nus);
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
	
	public RecipesIngredients[] getRecipesIngredients() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
	
		PreparedStatement stmt = con.prepareStatement("SELECT ingredient_id, recipe_id, num_ingredient_servings from recipesingredients");
		ResultSet rs = stmt.executeQuery();
	
		int count = 0;
		while(rs.next()) {
			int ingredientId = rs.getInt("ingredient_id");
			int  recipedId= rs.getInt("recipe_id");
			int nus = rs.getInt("num_ingredient_servings");

			RecipesIngredients ing = new RecipesIngredients(ingredientId, recipedId, nus);
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
	
	
	public RecipesIngredients[] createRecipesIngredients(RecipesIngredients theRecipesIngredientsToAdd) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
		
		
		PreparedStatement cstmt = con.prepareStatement("INSERT INTO recipesingredients(ingredient_id, recipe_id, num_ingredient_servings) VALUE ((SELECT ingredient_id FROM ingredients WHERE ingredient_id = ?), (SELECT recipe_id FROM recipes WHERE recipe_id = ?),?);");
		cstmt.setInt(1, theRecipesIngredientsToAdd.getIngredientId());
		cstmt.setInt(2, theRecipesIngredientsToAdd.getRecipesId());
		cstmt.setInt(3, theRecipesIngredientsToAdd.getNumIngredientServings());
		

		int res = cstmt.executeUpdate();
		if(res==1) {
			PreparedStatement retrieveStmt = con.prepareStatement("Select * from recipesingredients WHERE ingredient_id=? AND recipe_id = ? AND num_ingredient_servings = ?");
			retrieveStmt.setInt(1, theRecipesIngredientsToAdd.getIngredientId());
			retrieveStmt.setInt(2, theRecipesIngredientsToAdd.getRecipesId());
			retrieveStmt.setInt(3, theRecipesIngredientsToAdd.getNumIngredientServings());
			

			ResultSet rs = retrieveStmt.executeQuery();
			int count = 0;

			
			while(rs.next()) {
				int ingredientId = rs.getInt("ingredient_id");
				int  recipedId= rs.getInt("recipe_id");
				int nus = rs.getInt("num_ingredient_servings");

				
	
				
				RecipesIngredients ing = new RecipesIngredients(ingredientId, recipedId, nus);
				
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
			RecipesIngredients[] blankIngArray = new RecipesIngredients[1];
			blankIngArray[0] = new RecipesIngredients();
			return blankIngArray;
		}
		
		
		
		
	}

}
