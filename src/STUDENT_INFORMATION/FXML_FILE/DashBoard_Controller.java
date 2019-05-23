package STUDENT_INFORMATION.FXML_FILE;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by Kurt Lupin C. Orioque
 * Email Address: kurtorioque112@gmail.com
 * ContactNumber: 09953045981
 * Linkedin: https://github.com/kurt112
 * Github: https://www.linkedin.com/in/kurt-lupin-orioque-2946a6157/
 * Bitbucket: https://bitbucket.org/%7B49153846-f85c-4553-9ecb-714516a680b7%7D/
 * Date: 05 18, 2019
 * Time: 10:11 PM
 * User: orioque35
 */


public class DashBoard_Controller {

    @FXML private Pane Home_Button,Attendance_Button,StudentList_Button,
            Register_Button,DropStudent_Button,SendSms_Button,Messages_Button,
            FeedBack_Button, Logout_Button;

    @FXML private Label Home_ID,Attendance_ID, StudentList_ID,Register_ID,
                        DropStudent_ID, SendSms_ID, Messages_ID, FeedBack_ID,Logout_ID;

    @FXML VBox Vbox_Change;

    private final String dropstud_path = "DashBoard_DropStudent_Ui.fxml";
    private final String DashBoard_FeedBack_path = "DashBoard_FeedBack.fxml";
    private final String DashBoard_Messages_path = "DashBoard_Messages_Ui.fxml";
    private final String DashBoard_RegisterStudent_path = "DashBoard_RegisterStudent_Ui.fxml";
    private final String DashBoard_SendSms = "DashBoard_SendSms_Ui.fxml";
    private final String DashBoard_Statistic = "DashBoard_Statistic_Ui.fxml";
    private final String DashBoard_StudentAttendance_path = "DashBoard_StudentAttendance_Ui.fxml";
    private final String DashBoard_StudentList_path = "DashBoard_StudentList_Ui.fxml";

    private Runnable DropStudent_Ui_Runnable = () -> Platform.runLater(() -> Dash_Board_Item(dropstud_path));
    private Runnable FeedBack_Ui_Runnable = () -> Platform.runLater(() -> Dash_Board_Item(DashBoard_FeedBack_path));
    private Runnable Messages_Ui_Runnable = () -> Platform.runLater(() -> Dash_Board_Item(DashBoard_Messages_path));
    private Runnable RegisterStudent_Ui_Runnable = () -> Platform.runLater(() -> Dash_Board_Item(DashBoard_RegisterStudent_path));
    private Runnable SendSms_Ui_Runnable = () -> Platform.runLater(() -> Dash_Board_Item(DashBoard_SendSms));
    private Runnable Statistic_Ui_Runnable = () -> Platform.runLater(() -> Dash_Board_Item(DashBoard_Statistic));
    private Runnable StudentAttendance_Ui_Runnable = () -> Platform.runLater(() -> Dash_Board_Item(DashBoard_StudentAttendance_path));
    private Runnable StudentList_Ui_Runnable = () -> Platform.runLater(() -> Dash_Board_Item(DashBoard_StudentList_path));

    public void initialize(){
        new Thread(Statistic_Ui_Runnable).start();
    }

    private void Dash_Board_Item(String path){

        Vbox_Change.getChildren().clear();
        Vbox_Change.getChildren().setAll(New_Vbox(path));

    }

    private VBox New_Vbox(String path){

        try {

            return (VBox) FXMLLoader.load(getClass().getResource(path));

        }catch (IOException e){
            e.printStackTrace();
        }

        return null;

    }

    // -----------------------------------------------------------------------------//
    @FXML public void Home_Entered() {
        Home_ID.setText("");
        Home_Button.setPrefWidth(300);
    }

    @FXML public void Home_MouseExited() {
        Home_ID.setText("Home");
        Home_Button.setPrefWidth(33);
    }

    @FXML public void Goto_Home() {

        new Thread(Statistic_Ui_Runnable).start();

    }

    // -----------------------------------------------------------------------------//

    @FXML public void Attendance_MouseEntered() {
        Attendance_ID.setText("");
        Attendance_Button.setPrefWidth(300);
    }

    @FXML public void Attendance_MouseExited() {
        Attendance_ID.setText("Attendance");
        Attendance_Button.setPrefWidth(33);
    }

    @FXML public void Goto_Attendance() {
        new Thread(StudentAttendance_Ui_Runnable).start();
    }

    // -----------------------------------------------------------------------------//

    @FXML public void StudentList_MouseEntered() {
        StudentList_ID.setText("");
        StudentList_Button.setPrefWidth(300);
    }

    @FXML public void StudentList_MouseExited() {
        StudentList_ID.setText("Student List");
        StudentList_Button.setPrefWidth(33);
    }

    @FXML public void Goto_StudentList() {
        new Thread(StudentList_Ui_Runnable).start();
    }

    // -----------------------------------------------------------------------------//

    @FXML public void Register_MouseEntered() {
        Register_ID.setText("");
        Register_Button.setPrefWidth(300);
    }

    @FXML public void Register_MouseExited() {
        Register_ID.setText("Register");
        Register_Button.setPrefWidth(33);
    }

    @FXML public void Goto_Register() {
        new Thread(RegisterStudent_Ui_Runnable).start();
    }

    // -----------------------------------------------------------------------------//

    @FXML public void DropStudent_MouseEntered() {
        DropStudent_ID.setText("");
        DropStudent_Button.setPrefWidth(300);
    }

    @FXML public void DropStudent_MouseExited() {
        DropStudent_ID.setText("Drop Student");
        DropStudent_Button.setPrefWidth(33);
    }

    @FXML public void Goto_DropStudent() {
        new Thread(DropStudent_Ui_Runnable).start();
    }

    // -----------------------------------------------------------------------------//

    @FXML public void SendSms_MouseEntered() {
        SendSms_ID.setText("");
        SendSms_Button.setPrefWidth(300);
    }

    @FXML public void SendSms_MouseExited() {
        SendSms_ID.setText("Send Sms");
        SendSms_Button.setPrefWidth(33);
    }

    @FXML public void Goto_SendSms() {
        new Thread(SendSms_Ui_Runnable).start();
    }

    // -----------------------------------------------------------------------------//

    @FXML public void Messages_MouseEntered() {
        Messages_ID.setText("");
        Messages_Button.setPrefWidth(300);
    }

    @FXML public void Messages_MouseExited() {
        Messages_ID.setText("Messages");
        Messages_Button.setPrefWidth(33);
    }

    @FXML public void Goto_Messages() {
        new Thread(Messages_Ui_Runnable).start();
    }

    // -----------------------------------------------------------------------------//

    @FXML public void FeedBack_MouseEntered() {
        FeedBack_ID.setText("");
        FeedBack_Button.setPrefWidth(300);
    }

    @FXML public void FeedBack_MouseExited() {
        FeedBack_ID.setText("Feed Back");
        FeedBack_Button.setPrefWidth(33);
    }

    @FXML public void Goto_FeedBack() {
        new Thread(FeedBack_Ui_Runnable).start();
    }

    // -----------------------------------------------------------------------------//

    @FXML public void Logout_MouseEntered() {
        Logout_ID.setText("");
        Logout_Button.setPrefWidth(300);
    }

    @FXML public void Logout_MouseExited() {
        Logout_ID.setText("Home");
        Logout_Button.setPrefWidth(33);
    }

    @FXML public void Goto_Logout() {
    }

    // -----------------------------------------------------------------------------//


}
