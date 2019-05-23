package STUDENT_INFORMATION.CONTROLLER;

import ATTENDANCE_LOGIN.DATAMODEL.Student_Attendance;
import ATTENDANCE_LOGIN.DATAMODEL.Student_Datamodel;
import DATABASE.Database_Commands;
import com.jfoenix.controls.JFXRadioButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DataFormat;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Kurt Lupin C. Orioque
 * Email Address: kurtorioque112@gmail.com
 * ContactNumber: 09953045981
 * Linkedin: https://github.com/kurt112
 * Github: https://www.linkedin.com/in/kurt-lupin-orioque-2946a6157/
 * Bitbucket: https://bitbucket.org/%7B49153846-f85c-4553-9ecb-714516a680b7%7D/
 * Date: 05 19, 2019
 * Time: 2:14 AM
 * User: orioque35
 */


public class DashBoard_StudentAttendance_Controller {

    @FXML private TableView<Student_Attendance> Attendance_Table;
    @FXML private TableColumn<Student_Datamodel,String> first_name, last_name,grade,section,adviser,time_in, time_out,date, status;
    private DateTimeFormatter Date_format = DateTimeFormatter.ofPattern("MMMM d, yyyy");
    private DateTimeFormatter Time_format = DateTimeFormatter.ofPattern("h : m : s : a");
    private static String Status  ="PRESENT",date_pick="";
    @FXML private DatePicker date_picker;
    @FXML JFXRadioButton Present;
    public void initialize(){
        Present.setSelected(true);
        date_picker.setValue(LocalDate.now());
        date_pick=Date_format.format(date_picker.getValue());
        Table_SetItem();
        SetCellValue();

        date_picker.valueProperty().addListener((observableValue, localDate, t1) -> {
            date_pick=Date_format.format(date_picker.getValue());
            System.out.println(date_pick);
            Table_SetItem();
        });
    }


    /*
    Just setting the value of the table
     */
    public void SetCellValue(){

        first_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        grade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        section.setCellValueFactory(new PropertyValueFactory<>("section"));
        adviser.setCellValueFactory(new PropertyValueFactory<>("adviser"));
        time_in.setCellValueFactory(new PropertyValueFactory<>("time_in"));
        time_out.setCellValueFactory(new PropertyValueFactory<>("time_out"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    public void change_date(){

        if(date_picker.getValue() != LocalDate.now()){


        }

    }

    public void Table_SetItem(){
        Database_Commands.Attendace_History(date_pick,Status);
        Attendance_Table.setItems(Database_Commands.getHistory_Attendance());

    }

   @FXML public void Absent_Clicked() {
        Status = "ABSENT";
        Table_SetItem();
       System.out.println(date_pick);
       System.out.println(Status);
    }

   @FXML public void Present_Clicked() {
        Status = "PRESENT";
       Table_SetItem();
    }
}
