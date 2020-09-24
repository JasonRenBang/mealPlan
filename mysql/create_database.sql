/*******************************************************************************
 * create_database.sql - creates the database and tables needed for the meal
 *                       meal planner application
 * Author: Garrick Smith
 *         Jason Ren
 * Revision Date: 10/2/19
 ******************************************************************************/
CREATE DATABASE IF NOT EXISTS MealPlanner;
USE MealPlanner;

CREATE TABLE IF NOT EXISTS Users (
    user_id int NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    user_password varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    security_level int,
    
    PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS Recipes (
    recipe_id int NOT NULL AUTO_INCREMENT,
    recipe_name varchar(255),
    recipe_desc varchar(255),
    
    PRIMARY KEY (recipe_id)
);

CREATE TABLE IF NOT EXISTS Ingredients (
    ingredient_id int NOT NULL AUTO_INCREMENT,
    ingredient_name varchar(255),
    ingredient_desc varchar(255),
    serving_metric varchar(255),
    g_unsaturated_fat int,
    g_saturated_fat int,
    g_trans_fat int,
    mg_cholesterol int,
    mg_sodium int,
    g_fiber int,
    g_sugar int,
    g_protein int,
    
    PRIMARY KEY (ingredient_id)
);

CREATE TABLE IF NOT EXISTS UsersRecipes (
    recipe_id int NOT NULL,
    user_id int NOT NULL,
    meal_date varchar(255),
    meal_time varchar(255),
    
    FOREIGN KEY (recipe_id) REFERENCES Recipes(recipe_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE IF NOT EXISTS RecipesIngredients (
    ingredient_id int NOT NULL,
    recipe_id int NOT NULL,
    num_ingredient_servings int,
    
    FOREIGN KEY (ingredient_id) REFERENCES Ingredients(ingredient_id),
    FOREIGN KEY (recipe_id) REFERENCES Recipes(recipe_id)
);
