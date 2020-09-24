/*******************************************************************************
 * insert_test_data.sql - inserts test data into the MealPlanner database
 *  
 * Author: Garrick Smith
 * Revision Date: 9/29/19
 ******************************************************************************/
USE MealPlanner;
 
/* Add user */
INSERT INTO Users (
    username,
    user_password,
    name,
    security_level
)
VALUES (
    'user',
    'pass',
    'name',
    0
);
 
/* Add Recipes */
INSERT INTO Recipes (
    recipe_name,
    recipe_desc
)
VALUES (
    'Egg and Cheese Bagel',
    'A bagel with egg and cheese'
);
 
INSERT INTO Recipes (
    recipe_name,
    recipe_desc
)
VALUES (
    'Chicken Parmesean',
    'Chicken breast coated in marinara and topped with parmesean cheese'
);

/* Add Ingredients */
INSERT INTO Ingredients (
    ingredient_name,
    ingredient_desc,
    serving_metric
)
VALUES (
    'Bagel',
    'Round ball of boiled dough',
    NULL
);

INSERT INTO Ingredients (
    ingredient_name,
    ingredient_desc,
    serving_metric
)
VALUES (
    'Egg',
    'Unfertalized chicken offspring',
    NULL
);

INSERT INTO Ingredients (
    ingredient_name,
    ingredient_desc,
    serving_metric
)
VALUES (
    'Cheese',
    'Somehow made out of milk?',
    'Slice'
);

INSERT INTO Ingredients (
    ingredient_name,
    ingredient_desc,
    serving_metric
)
VALUES (
    'Chicken Breast',
    'Cut right off of a dead chicken',
    NULL
);

INSERT INTO Ingredients (
    ingredient_name,
    ingredient_desc,
    serving_metric
)
VALUES (
    'Marinara Sauce',
    'Nectar of the tomato',
    'Cup'
);

INSERT INTO Ingredients (
    ingredient_name,
    ingredient_desc,
    serving_metric
)
VALUES (
    'Parmesean Cheese',
    'Somehow made out of milk, but different',
    'Slice'
);

/* Add Ingredients to Recipes */
INSERT INTO RecipesIngredients (
    ingredient_id,
    recipe_id,
    num_ingredient_servings
)
VALUES (
    (SELECT ingredient_id FROM Ingredients WHERE ingredient_name = 'Bagel'),
    (SELECT recipe_id FROM Recipes WHERE recipe_name = 'Egg and Cheese Bagel'),
    1
);

INSERT INTO RecipesIngredients (
    ingredient_id,
    recipe_id,
    num_ingredient_servings
)
VALUES (
    (SELECT ingredient_id FROM Ingredients WHERE ingredient_name = 'Egg'),
    (SELECT recipe_id FROM Recipes WHERE recipe_name = 'Egg and Cheese Bagel'),
    2
);

INSERT INTO RecipesIngredients (
    ingredient_id,
    recipe_id,
    num_ingredient_servings
)
VALUES (
    (SELECT ingredient_id FROM Ingredients WHERE ingredient_name = 'Cheese'),
    (SELECT recipe_id FROM Recipes WHERE recipe_name = 'Egg and Cheese Bagel'),
    2
);

INSERT INTO RecipesIngredients (
    ingredient_id,
    recipe_id,
    num_ingredient_servings
)
VALUES (
    (SELECT ingredient_id FROM Ingredients WHERE ingredient_name = 'Chicken Breast'),
    (SELECT recipe_id FROM Recipes WHERE recipe_name = 'Chicken Parmesean'),
    1
);

INSERT INTO RecipesIngredients (
    ingredient_id,
    recipe_id,
    num_ingredient_servings
)
VALUES (
    (SELECT ingredient_id FROM Ingredients WHERE ingredient_name = 'Parmesean Cheese'),
    (SELECT recipe_id FROM Recipes WHERE recipe_name = 'Chicken Parmesean'),
    1
);

INSERT INTO RecipesIngredients (
    ingredient_id,
    recipe_id,
    num_ingredient_servings
)
VALUES (
    (SELECT ingredient_id FROM Ingredients WHERE ingredient_name = 'Marinara Sauce'),
    (SELECT recipe_id FROM Recipes WHERE recipe_name = 'Chicken Parmesean'),
    2
);

/* Add Recipes to User */
INSERT INTO UsersRecipes (
    recipe_id,
    user_id,
    meal_date,
    meal_time
)
VALUES (
    (SELECT recipe_id FROM Recipes WHERE recipe_name = 'Egg and Cheese Bagel'),
    (SELECT user_id FROM Users WHERE username = 'user'),
    '01/15/2019',
    'Breakfast'
);

INSERT INTO UsersRecipes (
    recipe_id,
    user_id,
    meal_date,
    meal_time
)
VALUES (
    (SELECT recipe_id FROM Recipes WHERE recipe_name = 'Chicken Parmesean'),
    (SELECT user_id FROM Users WHERE username = 'user'),
    '01/15/2019',
    'Dinner'
);
