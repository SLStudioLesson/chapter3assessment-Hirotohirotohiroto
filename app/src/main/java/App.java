import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
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
            //入力に沿って以下処理を実施
            if(choice.equals("1")) {
                CSVDataHandler c1 = new CSVDataHandler();
                
            }else if(choice.equals("2")) {
                JSONDataHandler j1 = new JSONDataHandler();
            }else {
                CSVDataHandler c2 = new CSVDataHandler();
            }
            
            

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}