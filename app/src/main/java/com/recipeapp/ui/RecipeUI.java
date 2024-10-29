package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.recipeapp.dataHandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;


public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }
    //DataHandlerから読み込んだレシピデータを整形してコンソールに表示
    private void displayRecipes() throws IOException {
        ArrayList<Recipe> recipe = dataHandler.readData();
        if(recipe.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }

        System.out.println("Recipes:");
        System.out.println("-----------------------------------");

        for(Recipe rr : recipe){
            System.out.print("Recipe Name: ");
            System.out.println(rr.getName());
            System.out.print("Main Ingredients: ");
            //材料名を取得して出力
            ArrayList<Ingredient> ingredients = rr.getIngredients();
            for (int i = 0; i < ingredients.size(); i++) {
                System.out.print(ingredients.get(i).getName());
                //最後にはカンマを付けない
                if (i < ingredients.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
            System.out.println("-----------------------------------");
        }
    }
        
    private void addNewRecipe() throws IOException {
        try {
            //料理名の入力受付
            System.out.println("Adding a new recipe.");
            System.out.println("Enter recipe name: ");
            String recipeName = reader.readLine();

            //材料名を受け取るためのリストを用意
            ArrayList<Ingredient> aa = new ArrayList<>();
            //材料名の入力受付
            System.out.println("Enter ingredients (type 'done' when finished):");
            while(true){
                System.out.println("Ingredient: ");
                String ingredients = reader.readLine();

                Ingredient ingredient = new Ingredient(ingredients);
                aa.add(ingredient);

                //doneを入力された場合、メッセージを出力して終了
                if(ingredients.equals("done")){
                    System.out.println("Recipe added successfully.");
                    break;
                }
            }
                Recipe rr = new Recipe(recipeName, aa);
                dataHandler.writeData(rr);
            
            


        }catch (IOException e) {
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }
        //料理名の入力受付
        
            
            

    
}
