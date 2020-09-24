

public class Ingredients {
	private int ingredientId;
	private String ingredientName;
	private String ingredientDesc;
	private String servingMetric;
	private int calories;
	private int gUnsaturatedFat;
	private int gSaturatedFat;
	private int gTransFat;
	private int mgCholesterol;
	private int mgSodium;
	private int gFiber;
	private int gSugar;
	private int gProtein;
	public static class Builder{
		private int ingredientId=0;
		private String ingredientName=null;
		private String ingredientDesc=null;
		private String servingMetric=null;
		private int calories=0;
		private int gUnsaturatedFat=0;
		private int gSaturatedFat=0;
		private int gTransFat=0;
		private int mgCholesterol=0;
		private int mgSodium=0;
		private int gFiber=0;
		private int gSugar=0;
		private int gProtein=0;
		public Builder ingredientId(int ingredientId) {
			this.ingredientId = ingredientId;
			return this;
		}
		public Builder ingredientName(String ingredientName) {
			this.ingredientName = ingredientName;
			return this;
		}
		public Builder ingredientDesc(String ingredientDesc) {
			this.ingredientDesc = ingredientDesc;
			return this;
		}
		public Builder servingMetric(String servingMetric) {
			this.servingMetric = servingMetric;
			return this;
		}
		public Builder calories(int calories) {
			this.calories = calories;
			return this;
		}
		public Builder gUnsaturatedFat(int gUnsaturatedFat) {
			this.gUnsaturatedFat = gUnsaturatedFat;
			return this;
		}
		public Builder gSaturatedFat(int gSaturatedFat) {
			this.gSaturatedFat = gSaturatedFat;
			return this;
		}
		public Builder gTransFat(int gTransFat) {
			this.gTransFat = gTransFat;
			return this;
		}
		public Builder mgCholesterol(int mgCholesterol) {
			this.mgCholesterol = mgCholesterol;
			return this;
		}
		public Builder mgSodium(int mgSodium) {
			this.mgSodium = mgSodium;
			return this;
		}
		public Builder gFiber(int gFiber) {
			this.gFiber = gFiber;
			return this;
		}
		public Builder gSugar(int gSugar) {
			this.gSugar = gSugar;
			return this;
		}
		public Builder gProtein(int gProtein) {
			this.gProtein = gProtein;
			return this;
		}
		public Ingredients create() {
			return new Ingredients(this);
		}
	}
	public Ingredients(Builder builder) {
		this.ingredientId = builder.ingredientId;
		this.ingredientName = builder.ingredientName;
		this.ingredientDesc = builder.ingredientDesc;
		this.servingMetric = builder.servingMetric;
		this.calories = builder.calories;
		this.gUnsaturatedFat = builder.gUnsaturatedFat;
		this.gSaturatedFat = builder.gSaturatedFat;
		this.gTransFat = builder.gTransFat;
		this.mgCholesterol = builder.mgCholesterol;
		this.mgSodium = builder.mgSodium;
		this.gFiber = builder.gFiber;
		this.gSugar = builder.gSugar;
		this.gFiber = builder.gFiber;
		this.gProtein = builder.gProtein;
		
	}
	public int getId() {
		return ingredientId;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public String getIngredientDesc() {
		return ingredientDesc;
	}
	public String getServingMetric() {
		return servingMetric;
	}
	public int getCalories() {
		return calories;
	}
	public int getGUnsaturatedFat() {
		return gUnsaturatedFat;
	}
	public int getGSaturatedFat() {
		return gSaturatedFat;
	}
	public int getGTransFat() {
		return gTransFat;
	}
	public int getMgCholesterol() {
		return mgCholesterol;
	}
	public int getMgSodium() {
		return mgSodium;
	}
	public int getGFiber() {
		return gFiber;
	}
	public int getGSugar() {
		return gSugar;
	}
	public int getGProtein() {
		return gProtein;
	}
	public int setId(int ingredientId) {
		this.ingredientId = ingredientId;
		return this.ingredientId;
	}
	public String setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
		return this.ingredientName;
	}
	public String setIngredientDesc(String ingredientDesc) {
		this.ingredientDesc = ingredientDesc;
		return this.ingredientDesc;
	}
	public String setServingMetric(String servingMetric) {
		this.servingMetric = servingMetric;
		return this.servingMetric;
	}
	public int setCalories(int calories) {
		this.calories = calories;
		return this.calories;
	}
	public int setGUnsaturatedFat(int gUnsaturatedFat) {
		this.gUnsaturatedFat = gUnsaturatedFat;
		return this.gUnsaturatedFat;
	}
	public int setGSaturatedFat(int gSaturatedFat) {
		this.gSaturatedFat = gSaturatedFat;
		return this.gSaturatedFat;
	}
	public int setGTransFat(int gTransFat) {
		this.gTransFat = gTransFat;
		return this.gTransFat;
	}
	public int setMgCholesterol(int mgCholesterol) {
		this.mgCholesterol = mgCholesterol;
		return this.mgCholesterol;
	}
	public int setMgSodium(int mgSodium) {
		this.mgSodium = mgSodium;
		return this.mgSodium;
	}
	public int setGFiber(int gFiber) {
		this.gFiber = gFiber;
		return gFiber;
	}
	public int setGSugar(int gSugar) {
		this.gSugar = gSugar;
		return this.gSugar;
	}
	public int setGProtein(int gProtein) {
		this.gProtein = gProtein;
		return this.gProtein;
	}
	
	public String toString() {
		return ingredientName + ": " + ingredientDesc;
	}
	
	
	
	
	
	
	
}
