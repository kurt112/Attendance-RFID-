package ATTENDANCE_LOGIN;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *Created by Kurt Lupin C. Orioque
 *Email Address: kurtorioque112@gmail.com
 *ContactNumber: 09953045981
 *Linkedin: https://github.com/kurt112
 *Github: https://www.linkedin.com/in/kurt-lupin-orioque-2946a6157/
 *Bitbucket: https://bitbucket.org/%7B49153846-f85c-4553-9ecb-714516a680b7%7D/
 *Date: ${MONTH} ${DAY}, ${YEAR}
 *Time: ${TIME}
 *User: ${USER}
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXML_FILE/Vbox.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }


    public static void main(String[] args){
//        Sender sender = new Sender("09217765961","yow")5dhz   `;
//        sender.send();
        launch(args);
    }
}
