package com.recipeapp.dataHandler;

import java.util.ArrayList;

import com.recipeapp.model.Recipe;

import java.io.IOException;

public interface DataHandler {

    public String getMode();

    public ArrayList<Recipe> readData() throws IOException;

    public void writeData(Recipe recipe)throws IOException;

    public ArrayList<Recipe> searchData(String keyword)throws IOException;

}
