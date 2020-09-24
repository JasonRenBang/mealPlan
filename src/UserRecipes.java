
public class UserRecipes {
	private int usersId;
	private int recipesId;
	private String mealDate;
	private String mealTime;
	
	public UserRecipes() {
		usersId = 0;
		recipesId = 0;
		mealDate = null;
		mealTime = null;
	}
	public UserRecipes(int usersid, int recipesid, String mealDate, String mealTime) {
		this.usersId = usersid;
		this.recipesId = recipesid;
		this.mealDate = mealDate;
		this.mealTime = mealTime;
	}
	public int getUsersId() {
		return usersId;
	}
	public int getRecipesId() {
		return recipesId;
	}
	public String getMealDate() {
		return mealDate;
	}
	public String getMealTime() {
		return mealTime;
	}
	public int setUsersId(int usersid) {
		this.usersId = usersid;
		return this.usersId;
	}
	public  int setRecipesId(int recipesid) {
		this.recipesId = recipesid;
		return this.recipesId;
	}
	public String setMealDate(String mealDate) {
		this.mealDate = mealDate;
		return this.mealDate;
	}
	public String setMealTime(String mealTime) {
		this.mealTime = mealTime;
		return this.mealTime;
	}
	public String toString() {
		return recipesId+": "+ usersId+": "+mealDate+": "+ mealTime;
	}
}
