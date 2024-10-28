import com.recipeapp.dataHandler.CSVDataHandler;
import com.recipeapp.dataHandler.DataHandler;
import com.recipeapp.dataHandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            // 入力に沿って以下処理を実施
            if (choice.equals("1")) {
                CSVDataHandler c1 = new CSVDataHandler();
                DataHandler dataHandler1 = (DataHandler)c1;
                RecipeUI r1 = new RecipeUI(dataHandler1);
                r1.displayMenu();
            } else if (choice.equals("2")) {
                JSONDataHandler j1 = new JSONDataHandler();
                DataHandler dataHandler2 = (DataHandler)j1;
                RecipeUI r2 = new RecipeUI(dataHandler2);
                r2.displayMenu();
            } else {
                CSVDataHandler c2 = new CSVDataHandler();
                DataHandler dataHandler3 = (DataHandler)c2;
                RecipeUI r3 = new RecipeUI(dataHandler3);
                r3.displayMenu();
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}