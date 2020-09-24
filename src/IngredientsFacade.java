import java.sql.*;
import java.util.*;
public class IngredientsFacade {
	Ingredients[] ingArray = new Ingredients[100];
	
	public Ingredients[] getIngredientById(int theId)throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
	
		PreparedStatement stmt = con.prepareStatement("SELECT * from ingredients WHERE ingredient_id=?");
		stmt.setInt(1,  theId);
		ResultSet rs = stmt.executeQuery();
		
		int count = 0;
		while(rs.next()) {
			int ingredientId = rs.getInt("ingredient_id");
			String ingredientName= rs.getString("ingredient_name");
			String ingredientDesc = rs.getString("ingredient_desc");
			String servingMetric = rs.getString("serving_metric");
			int gUnsaturatedFat = rs.getInt("g_unsaturated_fat");
			int gSaturatedFat = rs.getInt("g_saturated_fat");
			int gTransFat = rs.getInt("g_trans_fat");
			int myCholesterol = rs.getInt("mg_cholesterol");
			int mgSodium = rs.getInt("mg_sodium");
			int gFiber = rs.getInt("g_fiber");
			int gSugar = rs.getInt("g_sugar");
			int gProtein = rs.getInt("g_protein");
			
			Ingredients ing = new Ingredients.Builder().ingredientId(ingredientId).ingredientName(ingredientName).ingredientDesc(ingredientDesc).servingMetric(servingMetric).gUnsaturatedFat(gUnsaturatedFat).gSaturatedFat(gSaturatedFat).gTransFat(gTransFat).mgCholesterol(myCholesterol).mgSodium(mgSodium).gFiber(gFiber).gSugar(gSugar).gProtein(gProtein).create();

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
	
	public Ingredients[] getIngredients() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
	
		PreparedStatement stmt = con.prepareStatement("SELECT * from ingredients");
		ResultSet rs = stmt.executeQuery();
	
		int count = 0;
		while(rs.next()) {
			int ingredientId = rs.getInt("ingredient_id");
			String ingredientName= rs.getString("ingredient_name");
			String ingredientDesc = rs.getString("ingredient_desc");
			String servingMetric = rs.getString("serving_metric");
			int gUnsaturatedFat = rs.getInt("g_unsaturated_fat");
			int gSaturatedFat = rs.getInt("g_saturated_fat");
			int gTransFat = rs.getInt("g_trans_fat");
			int myCholesterol = rs.getInt("mg_cholesterol");
			int mgSodium = rs.getInt("mg_sodium");
			int gFiber = rs.getInt("g_fiber");
			int gSugar = rs.getInt("g_sugar");
			int gProtein = rs.getInt("g_protein");

			Ingredients ing = new Ingredients.Builder().ingredientId(ingredientId).ingredientName(ingredientName).ingredientDesc(ingredientDesc).servingMetric(servingMetric).gUnsaturatedFat(gUnsaturatedFat).gSaturatedFat(gSaturatedFat).gTransFat(gTransFat).mgCholesterol(myCholesterol).mgSodium(mgSodium).gFiber(gFiber).gSugar(gSugar).gProtein(gProtein).create();
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
	
	
	public Ingredients[] createIngredients(Ingredients theIngredientsToAdd) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mealplanner?useSSL=false&serverTimezone=UTC", "root", "BaoBao729825429");
		
		
		PreparedStatement cstmt = con.prepareStatement("INSERT INTO ingredients(ingredient_name,ingredient_desc, serving_metric, g_unsaturated_fat, g_saturated_fat, g_trans_fat, mg_cholesterol, mg_sodium, g_fiber, g_sugar, g_protein) VALUE (?,?,?,?,?,?,?,?,?,?,?)");

		cstmt.setString(1,theIngredientsToAdd.getIngredientName());
		cstmt.setString(2, theIngredientsToAdd.getIngredientDesc());
		cstmt.setString(3, theIngredientsToAdd.getServingMetric());
		cstmt.setInt(4, theIngredientsToAdd.getGUnsaturatedFat());
		cstmt.setInt(5, theIngredientsToAdd.getGSaturatedFat());
		cstmt.setInt(6, theIngredientsToAdd.getGTransFat());
		cstmt.setInt(7,theIngredientsToAdd.getMgCholesterol());
		cstmt.setInt(8, theIngredientsToAdd.getMgSodium());
		cstmt.setInt(9, theIngredientsToAdd.getGFiber());
		cstmt.setInt(10, theIngredientsToAdd.getGSugar());
		cstmt.setInt(11, theIngredientsToAdd.getGProtein());

		int res = cstmt.executeUpdate();
		if(res==1) {
			PreparedStatement retrieveStmt = con.prepareStatement("Select * from ingredients WHERE ingredient_id=? AND ingredient_name = ? AND ingredient_desc = ? AND serving_metric = ? AND g_unsaturated_fat=? AND g_saturated_fat=? AND g_trans_fat=? AND mg_cholesterol=? AND mg_sodium=? AND g_fiber=? AND g_sugar=? AND g_protein=?");
			retrieveStmt.setInt(1, theIngredientsToAdd.getId());
			retrieveStmt.setString(2, theIngredientsToAdd.getIngredientName());
			retrieveStmt.setString(3, theIngredientsToAdd.getIngredientDesc());
			retrieveStmt.setString(4, theIngredientsToAdd.getServingMetric());
			retrieveStmt.setInt(5, theIngredientsToAdd.getGUnsaturatedFat());
			retrieveStmt.setInt(6, theIngredientsToAdd.getGSaturatedFat());
			retrieveStmt.setInt(7, theIngredientsToAdd.getGTransFat());
			retrieveStmt.setInt(8, theIngredientsToAdd.getMgCholesterol());
			retrieveStmt.setInt(9, theIngredientsToAdd.getMgSodium());
			retrieveStmt.setInt(10, theIngredientsToAdd.getGFiber());
			retrieveStmt.setInt(11, theIngredientsToAdd.getGSugar());
			retrieveStmt.setInt(12, theIngredientsToAdd.getGProtein());

			ResultSet rs = retrieveStmt.executeQuery();
			int count = 0;

			
			while(rs.next()) {
				int theIngredientsId = rs.getInt("ingredient_id");
				String theIngredientsName = rs.getString("ingredient_name");
				String theIngredientsDesc = rs.getString("ingredient_desc");
				String theIngredientsMetric = rs.getString("serving_metric");
				int theIngredientsGUF = rs.getInt("g_unsaturated_fat");
				int theIngredientsGSF = rs.getInt("g_saturated_fat");
				int theIngredientsFTF = rs.getInt("g_trans_fat");
				int theIngredientsMC = rs.getInt("mg_cholesterol");
				int theIngredientsMS = rs.getInt("mg_sodium");
				int theIngredientsGF= rs.getInt("g_fiber");
				int theIngredientGS = rs.getInt("g_sugar");
				int theIngredientGP = rs.getInt("g_protein");
	
				
				Ingredients ing = new Ingredients.Builder().ingredientId(theIngredientsId).ingredientName(theIngredientsName).ingredientDesc(theIngredientsDesc).servingMetric(theIngredientsMetric).gUnsaturatedFat(theIngredientsGUF).gSaturatedFat(theIngredientsGSF).gTransFat(theIngredientsFTF).mgCholesterol(theIngredientsMC).mgSodium(theIngredientsMS).gFiber(theIngredientsGF).gSugar(theIngredientGS).gProtein(theIngredientGP).create();
				
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
			Ingredients[] blankIngArray = new Ingredients[1];
			blankIngArray[0] = null;
			return blankIngArray;
		}
		
		
		
		
	}
	
	public ArrayList<Ingredients> getRecipesIngredientsByRecipesId(int recipesId) {
		RecipesIngredientsFacade rif = new RecipesIngredientsFacade();
		RecipesIngredients[] ri = new RecipesIngredients[10];
		
		try {
			ri = rif.getRecipesIngredientsByRecipID(recipesId);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

		ArrayList<Ingredients> iArray = new ArrayList<>();
		IngredientsFacade ingf= new IngredientsFacade();
		Ingredients[] iiArray = new Ingredients[1];
		
		for(int i = 0;i<ri.length;i++) {
			int ingredientsId = ri[i].getIngredientId();
			try {
				iiArray =ingf.getIngredientById(ingredientsId);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			iArray.add(iiArray[0]);	
		}
		return iArray;
		
	}


}
