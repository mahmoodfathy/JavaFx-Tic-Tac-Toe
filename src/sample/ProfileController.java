package sample;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static sample.MenuController.is_loggedin;

public class ProfileController implements Initializable{

    @FXML
    Label profileName;
    @FXML
    Label profileRank;
    @FXML
    Label profileScore;
    @FXML
    Label profileRatio;
    @FXML
    Label profileWin;
    @FXML
    Label profileLose;
    @FXML
    Button profileLogin;
    
    public static boolean profileCheck = false;
    private ScreenLoader screenLoader=new ScreenLoader();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(MenuController.is_loggedin)
        {
            HashMap<String , String> currentPlayerInfo = OnlineGame.databaseObj.displayUserInfo(OnlineGame.userId);
            profileName.setText(currentPlayerInfo.get("Name"));
            profileRank.setText(currentPlayerInfo.get("Rank"));
            profileScore.setText(currentPlayerInfo.get("Score"));
            profileWin.setText(currentPlayerInfo.get("Win"));
            profileLose.setText(currentPlayerInfo.get("Lose"));
            profileRatio.setText(currentPlayerInfo.get("percentage")+"%");
            profileLogin.setVisible(false);
        }
        else
        {
            profileLogin.setVisible(true);
        }
        profileCheck = false;
    }
    
    @FXML
    private void back(ActionEvent event) {
        screenLoader.loadScene(event,"Menu.fxml");
    }

    @FXML
    private void login(ActionEvent event) {
        profileCheck = true;
        screenLoader.loadScene(event,"login.fxml");
    }
    
}
