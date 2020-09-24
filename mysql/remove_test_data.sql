/*******************************************************************************
 * remove_test_data.sql - deletes test data from the MealPlanner database
 *  
 * Author: Garrick Smith
 * Revision Date: 9/29/19
 ******************************************************************************/
USE MealPlanner;

DELETE FROM UsersRecipes WHERE recipe_id = (SELECT recipe_id FROM Recipes WHERE recipe_name = 'Egg and Cheese Bagel');
DELETE FROM UsersRecipes WHERE recipe_id = (SELECT recipe_id FROM Recipes WHERE recipe_name = 'Chicken Parmesean');

DELETE FROM RecipesIngredients WHERE ingredient_id = (SELECT ingredient_id FROM Ingredients WHERE ingredient_name = 'Marinara Sauce');
DELETE FROM RecipesIngredients WHERE ingredient_id = (SELECT ingredient_id FROM Ingredients WHERE ingredient_name = 'Parmesean Cheese');
DELETE FROM RecipesIngredients WHERE ingredient_id = (SELECT ingredient_id FROM Ingredients WHERE ingredient_name = 'Chicken Breast');
DELETE FROM RecipesIngredients WHERE ingredient_id = (SELECT ingredient_id FROM Ingredients WHERE ingredient_name = 'Bagel');
DELETE FROM RecipesIngredients WHERE ingredient_id = (SELECT ingredient_id FROM Ingredients WHERE ingredient_name = 'Egg');
DELETE FROM RecipesIngredients WHERE ingredient_id = (SELECT ingredient_id FROM Ingredients WHERE ingredient_name = 'Cheese');

DELETE FROM Ingredients WHERE ingredient_name = 'Egg';
DELETE FROM Ingredients WHERE ingredient_name = 'Bagel';
DELETE FROM Ingredients WHERE ingredient_name = 'Cheese';
DELETE FROM Ingredients WHERE ingredient_name = 'Chicken Breast';
DELETE FROM Ingredients WHERE ingredient_name = 'Parmesean Cheese';
DELETE FROM Ingredients WHERE ingredient_name = 'Marinara Sauce';

DELETE FROM Recipes WHERE recipe_name = 'Egg and Cheese Bagel';
DELETE FROM Recipes WHERE recipe_name = 'Chicken Parmesean';

DELETE FROM Users WHERE username = 'user';
