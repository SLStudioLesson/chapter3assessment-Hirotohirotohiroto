package com.recipeapp.datahandler;

import java.util.ArrayList;

import com.recipeapp.model.Recipe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface DataHandler {

    public static String getMode() {
        return getMode();
    }

    String fileName = "recipes.csv";
    public static ArrayList<Recipe> readData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            ArrayList<Recipe> list = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(Recipe recipe)throws IOException;
    
    
    public ArrayList<Recipe> searchData(String keyword)throws IOException;

}
