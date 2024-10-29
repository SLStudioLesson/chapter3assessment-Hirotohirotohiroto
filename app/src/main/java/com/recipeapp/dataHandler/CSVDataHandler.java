package com.recipeapp.dataHandler;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.recipeapp.model.Recipe;
import com.recipeapp.model.Ingredient;


public class CSVDataHandler implements DataHandler {
    private String filePath;

    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getMode() {
        return "CSV";
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException {
        ArrayList<Recipe> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            //1行ずつ読み取ってリストへ追加
            while ((line = reader.readLine()) != null) {
                String recipeName = "";
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                String[] aa = line.split(",", 2);
                //料理名を代入
                recipeName = aa[0];
                //材料名を分割
                String[] bb = aa[1].split(",");
                // for loop
                for(String cc : bb){
                    Ingredient ingredient = new Ingredient(cc);
                    ingredients.add(ingredient);
                }
                //Recipe型をインスタンスして、上記で作ったものを引数で渡す
                Recipe recipe = new Recipe(recipeName, ingredients);
                //受け取った変数ごとリストへ格納
                list.add(recipe);
            }
            return list;
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    return list;
    }

    //新しいレシピを`recipes.csv`に追加します。
    @Override
    public void writeData(Recipe recipe) throws IOException {
        //ファイルの書き込み
        String writeString = "";
        ArrayList<Ingredient> ingredients = recipe.getIngredients();
        //上書きとなるよう「true」を記載
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            //料理名を代入（入力値）
            writeString = recipe.getName();
            //材料名を1つずつ取得し、料理名が入った変数へ足していく
            for(int i = 0; i < ingredients.size(); i++){
                writeString += ", " + ingredients.get(i).getName();
            }
            
            writer.write(writeString);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) {
        return null;
    }
}
