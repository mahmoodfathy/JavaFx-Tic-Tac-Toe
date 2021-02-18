package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public  Parent root;
    
    //dakhly
    //static Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        //dakhly
        //primaryStage = primary;
        
         root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, 859.0, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
