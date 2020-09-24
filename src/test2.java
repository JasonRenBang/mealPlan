import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.geometry.*;

public class test2 extends Application{  
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Meal Planner Login");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Text scenetitle = new Text("Meal Planner: Sign in");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle,0,0,2,1);
        
        Label userName = new Label("User Name:");
        grid.add(userName,0,1);
        
        TextField userTextField = new TextField();
        grid.add(userTextField,1,1);
        
        Label pw = new Label("Password:");
        grid.add(pw,0,2);
        
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox,1,2);
        
        StackPane layout = new StackPane();
        layout.getChildren().add(grid);
        
        Button btn = new Button("Sign In");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn,1,4);
        
        Button btn2 = new Button("Create Account");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(btn2);
        grid.add(hbBtn2,1,3);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                UsersFacade uf = new UsersFacade();
                Users[] u = new Users[1];
                try {
					u = uf.getUsersByUsername(userTextField.getText());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                if(u[0] != null) {
                    if(u[0].checkPassword(pwBox.getText())){
                        System.out.println("Login Successful");
                        primaryStage.close();
                        try {
							mainMenu(u[0], new Stage());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                        
                    }
                    else {
                        System.out.println("Password does not match user");
                    }
                }
                else {
                    System.out.println("User does not exist");
                }
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.close();
                try {
					createUser(new Stage());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void createUser(Stage newUserStage) throws Exception{
        newUserStage.setTitle("Meal Planner New User Menu");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Text scenetitle = new Text("Create New User:");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle,0,0,2,1);
        
        Label userName = new Label("User Name:");
        grid.add(userName,0,1);
        
        TextField userTextField = new TextField();
        grid.add(userTextField,1,1);
        
        Label pw1 = new Label("Password:");
        grid.add(pw1,0,2);
        
        PasswordField pwBox1 = new PasswordField();
        grid.add(pwBox1,1,2);
        
        Label pw2 = new Label("Confirm Password:");
        grid.add(pw2,0,3);
        
        PasswordField pwBox2 = new PasswordField();
        grid.add(pwBox2,1,3);
        
        StackPane layout = new StackPane();
        layout.getChildren().add(grid);
        
        Label name = new Label("Name:");
        grid.add(name,0,4);
        
        TextField nameTextField = new TextField();
        grid.add(nameTextField,1,4);
        
        Button btn = new Button("Create User");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn,1,5);
        
        btn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                boolean taken = false;
                UsersFacade uf = new UsersFacade();
                Users[] users = new Users[100];
                try {
					users = uf.getUsers();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                if(pwBox1.getText().equals(pwBox2.getText())) {
                    for(int i = 0; i < users.length; i++) {
                        if(userTextField.getText().equals(users[i].getName())) {
                            System.out.println("Username is taken");
                            taken = true;
                            break;
                        }
                    }
                }
                else {
                    System.out.println("Passwords do not match");
                    taken = true;
                }
                if(!taken) {
                    Users u = new Users(0,userTextField.getText(), pwBox1.getText(), nameTextField.getText(), 0);
                    try {
						users = uf.createUsers(u);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    System.out.println("User created!");
                    
                    newUserStage.close();
                    try {
						start(new Stage());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }
        });
        
        Scene scene = new Scene(layout, 300, 250);
        newUserStage.setScene(scene);
        newUserStage.show();
    }
    
    public void mainMenu(Users u, Stage menuStage) throws Exception{
        menuStage.setTitle("Meal Planner Main Menu");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Button backBtn = new Button("Log Out");
        HBox hbBtn = new HBox(5);
        hbBtn.setAlignment(Pos.TOP_LEFT);
        hbBtn.getChildren().add(backBtn);
        grid.add(hbBtn,0,0);
        
        
        Text scenetitle = new Text("Welcome " + u.getName());
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle,0,1,2,1);
        
        Button userMeals = new Button("Show My Meals");
        grid.add(userMeals,0,2);
        
        Button allMeals = new Button("Show All Meals");
        grid.add(allMeals,1,2);
        
        StackPane layout = new StackPane();
        layout.getChildren().add(grid);
        
        allMeals.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                RecipesFacade rf = new RecipesFacade();
                Recipes[] r = new Recipes[100];
                try {
					r = rf.getRecipes();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                menuStage.close();
                displayAllMeals(r, u, new Stage());
            }
        });
        
        userMeals.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                RecipesFacade rf = new RecipesFacade();
                ArrayList<Recipes> r = new ArrayList<>();
                r = rf.getUserRecipesByUserName(u.getUsername());
                menuStage.close();
                displayMeals(r, u, new Stage());
            }
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                menuStage.close();
                try {
					start(new Stage());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        Scene scene = new Scene(layout, 300, 250);
        menuStage.setScene(scene);
        menuStage.show();
    } 
    
    public void displayMeals(ArrayList<Recipes> recipes, Users u, Stage displayMealsStage) {
        displayMealsStage.setTitle("Meals");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Button backBtn = new Button("Back");
        HBox hbBtn = new HBox(5);
        hbBtn.setAlignment(Pos.TOP_LEFT);
        hbBtn.getChildren().add(backBtn);
        grid.add(hbBtn,0,0);
        
        Text sceneTitle = new Text("Meals: ");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle,0,1,2,1);
        
        UserRecipesFacade urf = new UserRecipesFacade();
        UserRecipes[] uf = new UserRecipes[100];
        try {
			uf = urf.getUserRecipesByUserID(u.getId());
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
        ArrayList<Button> rLabels = new ArrayList<>();
        for(int i = 0; i < uf.length; i++) {
        	String date = uf[i].getMealDate();
        	String time = uf[i].getMealTime();
        	for(int j = 0; j < recipes.size(); j++) {
        		if(recipes.get(j).getId() == uf[i].getRecipesId()) {
		            Button rLabel = new Button(date + " " + time + ": " + recipes.get(i).getName());
		            rLabels.add(rLabel);
		            grid.add(rLabel,0,i+2);
		            break;
        		}
        	}
        }
        
        ArrayList<Recipes> newr = recipes;
        for(int j = 0; j < rLabels.size(); j++) {
        	Button rLabel = rLabels.get(j);
	        rLabel.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	                Recipes returnRecipe = null;
	                String rText = rLabel.getText();
	                String[] texts = rText.split(":");
	                String[] texts2 = texts[0].split(" ");
	                String date = texts2[0];
	                String time = texts2[1];
	                rText = texts[1].trim();
	                for(int j = 0; j < newr.size(); j++) {
	                    if(newr.get(j).getName().equals(rText)) {
	                        returnRecipe = newr.get(j);
	                    }
	                }
	                displayMealsStage.close();
	                displayMyRecipe(returnRecipe, newr, u, new Stage(),date,time);
	            }
	        });
        }
        
        StackPane layout = new StackPane();
        layout.getChildren().add(grid);
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayMealsStage.close();
                try {
					mainMenu(u, new Stage());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        Scene scene = new Scene(layout, 650, 500);
        displayMealsStage.setScene(scene);
        displayMealsStage.show();
    }

    public void displayMyRecipe(Recipes r, ArrayList<Recipes> recipes, Users u, Stage recipeStage, String date, String time) {
        recipeStage.setTitle("Recipe");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Button backBtn = new Button("Back");
        HBox hbBtn = new HBox(5);
        hbBtn.setAlignment(Pos.TOP_LEFT);
        hbBtn.getChildren().add(backBtn);
        grid.add(hbBtn,0,0);
        
        Text sceneTitle = new Text(r.getName());
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle,0,1,2,1);
        
        IngredientsFacade ingf = new IngredientsFacade();
        ArrayList<Ingredients> ings = new ArrayList<Ingredients>();
        ings = ingf.getRecipesIngredientsByRecipesId(r.getId());
        
        int i = 0;
        for(; i < ings.size(); i++) {
        	Label ingLabel = new Label(ings.get(i).toString());
        	grid.add(ingLabel, 0, i+2);
        }
        
        Label nutrients = new Label("Nutrients:");
        grid.add(nutrients, 0, i+2);
        
        int totalCals = 0;
        int totalUnsFat = 0;
        int totalSatFat = 0;
        int totalTransFat = 0;
        int totalChol = 0;
        int totalSod = 0;
        int totalFiber = 0;
        int totalSugar = 0;
        int totalProtein = 0;
        
        for(int j = 0; j < ings.size(); j++) {
        	totalCals = totalCals + ings.get(j).getCalories();
        	totalUnsFat = totalUnsFat + ings.get(j).getGUnsaturatedFat();
        	totalSatFat = totalSatFat + ings.get(j).getGSaturatedFat();
        	totalTransFat = totalTransFat + ings.get(j).getGTransFat();
        	totalChol = totalChol+ ings.get(j).getMgCholesterol();
        	totalSod = totalSod + ings.get(j).getMgSodium();
        	totalFiber  = totalFiber + ings.get(j).getGFiber();
        	totalSugar = totalSugar + ings.get(j).getGSugar();
        	totalProtein = totalProtein + ings.get(j).getGProtein();
        }
        
        Label calLabel =  new Label("Total Calories: " + totalCals);
        Label usfLabel =  new Label("Total Unsaturated Fat: " + totalUnsFat + "g");
        Label sfLabel =  new Label("Total Saturated Fat: " + totalSatFat + "g");
        Label tfLabel =  new Label("Total Trans Fat: " + totalTransFat + "g");
        Label cholLabel =  new Label("Total Cholesterol: " + totalChol + "mg");
        Label sodLabel =  new Label("Total Sodium: " + totalSod + "mg");
        Label fibLabel =  new Label("Total Fiber: " + totalFiber + "g");
        Label sugLabel =  new Label("Total Sugar: " + totalSugar + "g");
        Label proLabel =  new Label("Total Protein: " + totalProtein + "g");
        
        grid.add(calLabel,0,i+3);
        grid.add(usfLabel,0,i+4);
        grid.add(sfLabel,0,i+5);
        grid.add(tfLabel,0,i+6);
        grid.add(cholLabel,0,i+7);
        grid.add(sodLabel,0,i+8);
        grid.add(fibLabel,0,i+9);
        grid.add(sugLabel,0,i+10);
        grid.add(proLabel,0,i+11);
   
        StackPane layout = new StackPane();
        layout.getChildren().add(grid);
        
    	Button removeMeal = new Button("Remove Meal");
        HBox hbBtn3 = new HBox(5);
        hbBtn3.setAlignment(Pos.TOP_LEFT);
        hbBtn3.getChildren().add(removeMeal);
        grid.add(hbBtn3,1,i+12);
        
        removeMeal.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		UserRecipesFacade urf = new UserRecipesFacade();
        		UserRecipes[] ura = new UserRecipes[100];
        		System.out.println(r.getId() + " "+u.getId() + " "+ date + " " + time);
        		try {
					ura = urf.deleteUserRecipesByIdAndMealInformation(r.getId(),u.getId(),date,time);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		recipeStage.close();
                displayMeals(recipes, u, new Stage());
        	}            	
        });
        
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                recipeStage.close();
                displayMeals(recipes, u, new Stage());
            }
        });
        
        Scene scene = new Scene(layout, 300, 600);
        recipeStage.setScene(scene);
        recipeStage.show();
    }
    
    public void displayAllMeals(Recipes[] r, Users u, Stage displayAllStage) { 
    	displayAllStage.setTitle("All Meals");
    	
    	RecipesFacade rf = new RecipesFacade();
        r = new Recipes[100];
        try {
			r = rf.getRecipes();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Button backBtn = new Button("Back");
        HBox hbBtn = new HBox(5);
        hbBtn.setAlignment(Pos.TOP_LEFT);
        hbBtn.getChildren().add(backBtn);
        grid.add(hbBtn,0,0);
        
        Text sceneTitle = new Text("Meals: ");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle,0,1,2,1);
        
        ArrayList<Button> rLabels = new ArrayList<>();
        int i = 0;
        for(; i < r.length; i++) {
            Button rLabel = new Button(r[i].toString());
            rLabels.add(rLabel);
            grid.add(rLabel,0,i+2);
        }
        
        Button createMeal = new Button("Create Meal");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.CENTER);
        hbBtn2.getChildren().add(createMeal);
        grid.add(hbBtn2,0,i+2);
        
        StackPane layout = new StackPane();
        layout.getChildren().add(grid);
        
        Recipes[] newr = r;
        createMeal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayAllStage.close();
                createMeal(new Recipes(), newr, u, new Stage());
            }
        });
        
        for(int j = 0; j < rLabels.size(); j++) {
        	Button rLabel = rLabels.get(j);
	        rLabel.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	                Recipes returnRecipe = null;
	                String rText = rLabel.getText();
	                for(int j = 0; j < newr.length; j++) {
	                    if(newr[j].toString().equals(rText)) {
	                        returnRecipe = newr[j];
	                    }
	                }
	                displayAllStage.close();
	                displayRecipe(returnRecipe, newr, u, new Stage());
	            }
	        });
        }
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayAllStage.close();
                try {
					mainMenu(u, new Stage());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        Scene scene = new Scene(layout, 650, 500);
        displayAllStage.setScene(scene);
        displayAllStage.show();
        
        
    }
    
    
    public void displayRecipe(Recipes r, Recipes[] recipes, Users u, Stage recipeStage) {
        recipeStage.setTitle("Recipe");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Button backBtn = new Button("Back");
        HBox hbBtn = new HBox(5);
        hbBtn.setAlignment(Pos.TOP_LEFT);
        hbBtn.getChildren().add(backBtn);
        grid.add(hbBtn,0,0);
        
        Text sceneTitle = new Text(r.getName());
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle,0,1,2,1);
        
        IngredientsFacade ingf = new IngredientsFacade();
        ArrayList<Ingredients> ings = new ArrayList<Ingredients>();
        ings = ingf.getRecipesIngredientsByRecipesId(r.getId());
        
        int i = 0;
        for(; i < ings.size(); i++) {
        	Label ingLabel = new Label(ings.get(i).toString());
        	grid.add(ingLabel, 0, i+2);
        }
        
        Label nutrients = new Label("Nutrients:");
        grid.add(nutrients, 0, i+2);
        
        int totalCals = 0;
        int totalUnsFat = 0;
        int totalSatFat = 0;
        int totalTransFat = 0;
        int totalChol = 0;
        int totalSod = 0;
        int totalFiber = 0;
        int totalSugar = 0;
        int totalProtein = 0;
        
        for(int j = 0; j < ings.size(); j++) {
        	totalCals = totalCals + ings.get(j).getCalories();
        	totalUnsFat = totalUnsFat + ings.get(j).getGUnsaturatedFat();
        	totalSatFat = totalSatFat + ings.get(j).getGSaturatedFat();
        	totalTransFat = totalTransFat + ings.get(j).getGTransFat();
        	totalChol = totalChol+ ings.get(j).getMgCholesterol();
        	totalSod = totalSod + ings.get(j).getMgSodium();
        	totalFiber  = totalFiber + ings.get(j).getGFiber();
        	totalSugar = totalSugar + ings.get(j).getGSugar();
        	totalProtein = totalProtein + ings.get(j).getGProtein();
        }
        
        Label calLabel =  new Label("Total Calories: " + totalCals);
        Label usfLabel =  new Label("Total Unsaturated Fat: " + totalUnsFat + "g");
        Label sfLabel =  new Label("Total Saturated Fat: " + totalSatFat + "g");
        Label tfLabel =  new Label("Total Trans Fat: " + totalTransFat + "g");
        Label cholLabel =  new Label("Total Cholesterol: " + totalChol + "mg");
        Label sodLabel =  new Label("Total Sodium: " + totalSod + "mg");
        Label fibLabel =  new Label("Total Fiber: " + totalFiber + "g");
        Label sugLabel =  new Label("Total Sugar: " + totalSugar + "g");
        Label proLabel =  new Label("Total Protein: " + totalProtein + "g");
        
        grid.add(calLabel,0,i+3);
        grid.add(usfLabel,0,i+4);
        grid.add(sfLabel,0,i+5);
        grid.add(tfLabel,0,i+6);
        grid.add(cholLabel,0,i+7);
        grid.add(sodLabel,0,i+8);
        grid.add(fibLabel,0,i+9);
        grid.add(sugLabel,0,i+10);
        grid.add(proLabel,0,i+11);
   
        StackPane layout = new StackPane();
        layout.getChildren().add(grid);
        
        Button addMeal = new Button("Add To Meals");
        HBox hbBtn2 = new HBox(5);
        hbBtn2.setAlignment(Pos.TOP_LEFT);
        hbBtn2.getChildren().add(addMeal);
        grid.add(hbBtn2,0,i+12);
        
        if(u.getSecurity_level() == 1) {
        	Button removeMeal = new Button("Remove Meal");
            HBox hbBtn3 = new HBox(5);
            hbBtn3.setAlignment(Pos.TOP_LEFT);
            hbBtn3.getChildren().add(removeMeal);
            grid.add(hbBtn3,1,i+12);
            
            removeMeal.setOnAction(new EventHandler<ActionEvent>() {
            	@Override
            	public void handle(ActionEvent e) {
            		RecipesFacade rf = new RecipesFacade();
            		Recipes[] ra = new Recipes[100];
            		try {
						ra = rf.deleteRecipesById(r.getId());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		
            		recipeStage.close();
                    displayAllMeals(recipes, u, new Stage());
            	}            	
            });
        }
        
        addMeal.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		recipeStage.close();
        		addToUserMeals(r, recipes, u, new Stage());
        		
        	}
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                recipeStage.close();
                displayAllMeals(recipes, u, new Stage());
            }
        });
        
        Scene scene = new Scene(layout, 300, 600);
        recipeStage.setScene(scene);
        recipeStage.show();
    }
    
    public void addToUserMeals(Recipes r, Recipes[] recipes, Users u, Stage addToMealsStage) {
    	addToMealsStage.setTitle("Add to meals");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Text scenetitle = new Text("Add to meals:");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle,0,1,2,1);
        
        Label date = new Label("Date:");
        grid.add(date,0,2);
        TextField dateField = new TextField();
        grid.add(dateField,1,2);
        
        Label mealTime = new Label("Meal(Breakfast/Lunch/Dinner):");
        grid.add(mealTime,0,3);
        TextField mealTimeField = new TextField();
        grid.add(mealTimeField,1,3);
        
        Button addMeal = new Button("Add To Meals");
        HBox hbBtn = new HBox(5);
        hbBtn.setAlignment(Pos.TOP_LEFT);
        hbBtn.getChildren().add(addMeal);
        grid.add(hbBtn,0,4);
        
        Button backBtn = new Button("Back");
        HBox hbBtn2 = new HBox(5);
        hbBtn2.setAlignment(Pos.CENTER);
        hbBtn2.getChildren().add(backBtn);
        grid.add(hbBtn2, 0, 0);
        
        StackPane layout = new StackPane();
        layout.getChildren().add(grid);
        
        addMeal.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		UserRecipes ur = new UserRecipes(u.getId(), r.getId(), dateField.getText(), mealTimeField.getText());
        		UserRecipesFacade urf = new UserRecipesFacade();
        		UserRecipes[] urs = new UserRecipes[100];
        		try {
					urs = urf.createUserRecipes(ur);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		addToMealsStage.close();
                displayAllMeals(recipes, u, new Stage());
        	}
        });
        
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                addToMealsStage.close();
                displayRecipe(r,recipes, u, new Stage());
            }
        });
        
        Scene scene = new Scene(layout, 500, 400);
        addToMealsStage.setScene(scene);
        addToMealsStage.show();
    }
    
    public void createMeal(Recipes r, Recipes[] recipes, Users u, Stage createMealStage) {
        createMealStage.setTitle("Create New Recipe");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Text scenetitle = new Text("Create New Recipe:");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle,0,1,2,1);
        
        Label name = new Label("Name:");
        grid.add(name,0,2);
        
        TextField nameTextField = new TextField();
        grid.add(nameTextField,1,2);
        
        Label desc = new Label("Description:");
        grid.add(desc,0,3);
        
        TextField descBox = new TextField();
        grid.add(descBox,1,3);
        
        TilePane tp = new TilePane();
        Label ingLabel = new Label("Add Ingredients");
        tp.getChildren().add(ingLabel);
        
        Ingredients[] ingredients = new Ingredients[100];
        IngredientsFacade ingf = new IngredientsFacade();
        try {
			ingredients = ingf.getIngredients();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        StackPane layout = new StackPane();
        layout.getChildren().add(grid);
        
        ArrayList<Ingredients> ingToAdd = new ArrayList<Ingredients>();
        
        for(int i = 0; i < ingredients.length; i++) {
            CheckBox c = new CheckBox(ingredients[i].getIngredientName());
            tp.getChildren().add(c);
            
            int j = i;
            Ingredients[] ings = ingredients;
            c.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {    
                    if(c.isSelected()) {
                        ingToAdd.add(ings[j]);
                    }
                    else {
                        ingToAdd.remove(ings[j]);
                    }
                }
            });
        }
        
        grid.add(tp,1,4);
        
        Button addIngredient = new Button("Create Ingredient");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(addIngredient);
        grid.add(hbBtn2,1,5);
        
        Button btn = new Button("Create Recipe");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn,1,6);
                
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                RecipesFacade rf = new RecipesFacade(); 
                Recipes r = new Recipes(0,nameTextField.getText(),descBox.getText());
                
                try {
					rf.createRecipes(r);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                Recipes[] ra = new Recipes[10];
				try {
					ra = rf.getRecipesByRecipesName(r.getName());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
                for(int i = 0; i < ingToAdd.size(); i++) {
                    RecipesIngredientsFacade rif = new RecipesIngredientsFacade();
                    RecipesIngredients ri = new RecipesIngredients(ingToAdd.get(i).getId(),ra[0].getId(),0);
                    RecipesIngredients[] ria = new RecipesIngredients[10];
                    
                    try {
						ria = rif.createRecipesIngredients(ri);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                
                createMealStage.close();
                displayAllMeals(recipes,u, new Stage());
            }
        });
        
        addIngredient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                createMealStage.close();
                createIngredient(r, recipes, u, new Stage());
            }
        });
        
        Scene scene = new Scene(layout, 500, 400);
        createMealStage.setScene(scene);
        createMealStage.show();
    }
    
    
    public void createIngredient(Recipes r, Recipes[] recipes, Users u, Stage createIngredientStage) {
        createIngredientStage.setTitle("Create New Ingredient");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Text scenetitle = new Text("Create New Ingredient:");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle,0,1,2,1);
        
        Label nameL = new Label("Name:");
        grid.add(nameL,0,2);
        TextField nameField = new TextField();
        grid.add(nameField,1,2);
        
        Label descL = new Label("Description:");
        grid.add(descL,0,3);
        TextField descField = new TextField();
        grid.add(descField,1,3);
        
        Label metricL = new Label("Measuring Metric:");
        grid.add(metricL,0,4);
        TextField metricField = new TextField();
        grid.add(metricField,1,4);
        
        Label ufL = new Label("Unsaturated Fat(g):");
        grid.add(ufL,0,5);
        TextField ufField = new TextField();
        grid.add(ufField,1,5);
        
        Label sfL = new Label("Saturated Fat(g):");
        grid.add(sfL,0,6);
        TextField sfField = new TextField();
        grid.add(sfField,1,6);
        
        Label tfL = new Label("Trans Fat(g):");
        grid.add(tfL,0,7);
        TextField tfField = new TextField();
        grid.add(tfField,1,7);
        
        Label cholL = new Label("Cholesterol(mg):");
        grid.add(cholL,0,8);
        TextField cholField = new TextField();
        grid.add(cholField,1,8);

        Label sodiumL = new Label("Sodium(mg):");
        grid.add(sodiumL,0,9);
        TextField sodiumField = new TextField();
        grid.add(sodiumField,1,9);
        
        Label fiberL = new Label("Fiber(g):");
        grid.add(fiberL,0,10);
        TextField fiberField = new TextField();
        grid.add(fiberField,1,10);
        
        Label sugarL = new Label("Sugar(g):");
        grid.add(sugarL,0,11);
        TextField sugarField = new TextField();
        grid.add(sugarField,1,11);
        
        Label proteinL = new Label("Protein(g):");
        grid.add(proteinL,0,12);
        TextField proteinField = new TextField();
        grid.add(proteinField,1,12);
        
        Label calLabel = new Label("Calories:");
        grid.add(calLabel, 0, 13);
        TextField calField = new TextField();
        grid.add(calField, 1, 13);
        
        Button btn = new Button("Create Ingredient");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn,1,14);
        
        StackPane layout = new StackPane();
        layout.getChildren().add(grid);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Ingredients i = new Ingredients.Builder().ingredientId(0).ingredientName(nameField.getText()).ingredientDesc(descField.getText()).servingMetric(metricField.getText()).calories(Integer.parseInt(calField.getText())).gUnsaturatedFat(Integer.parseInt(ufField.getText())).gSaturatedFat(Integer.parseInt(sfField.getText())).gTransFat(Integer.parseInt(tfField.getText())).mgCholesterol(Integer.parseInt(cholField.getText())).mgSodium(Integer.parseInt(sodiumField.getText())).gFiber(Integer.parseInt(fiberField.getText())).gSugar(Integer.parseInt(sugarField.getText())).gProtein(Integer.parseInt(proteinField.getText())).create();
                
                IngredientsFacade ingf = new IngredientsFacade();
                Ingredients[] ings = new Ingredients[100];
                
                try {
					ings = ingf.createIngredients(i);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                createIngredientStage.close();
                createMeal(r, recipes, u, new Stage());
            }
        });
        
        Scene scene = new Scene(layout, 300, 650);
        createIngredientStage.setScene(scene);
        createIngredientStage.show();
    }
    
    
    
    
}