package ATTENDANCE_LOGIN.CONTROLLER_FILE;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import DATABASE.Database_Commands;
import ATTENDANCE_LOGIN.DATAMODEL.Student_Datamodel;
import ATTENDANCE_LOGIN.GSM_MODEM.GSMConnect;

import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
public class Controller {

    //    private DateTimeFormatter Date_format = DateTimeFormatter.ofPattern("MMMM d, yyyy");
    private DateTimeFormatter Time_format = DateTimeFormatter.ofPattern("h : m : s : a");

    @FXML
    private Label Time;

    @FXML
    private TextField text;

//    private HBox parent;
//    private Parent parent1;

    @FXML
    private Label lblname_1, lblgrade_section_1,
            lbl_adviser_1, lbl_timein_1, lbl_timeout_1;

    @FXML
    private Label lblname_2, lblgrade_section_2,
            lbl_adviser_2, lbl_timein_2, lbl_timeout_2;

    @FXML
    private Label lblname_3, lblgrade_section_3,
            lbl_adviser_3, lbl_timein_3, lbl_timeout_3;

    @FXML
    private Label lblname_4, lblgrade_section_4,
            lbl_adviser_4, lbl_timein_4, lbl_timeout_4;

    @FXML
    private Label lblname_5, lblgrade_section_5,
            lbl_adviser_5, lbl_timein_5, lbl_timeout_5;

    @FXML
    private ImageView imageview_1, imageview_2, imageview_3, imageview_4, imageview_5;

    private static ObservableList<Student_Datamodel> NotSend_Timein = FXCollections.observableArrayList();

    private static ObservableList<Student_Datamodel> NotSend_TimeOut = FXCollections.observableArrayList();


    private int number = 0;


    private static String number_send;
    private static String message_send;
    private static String time = "";

    //   private boolean continues = false;
    Runnable Sms_runnable = () -> SendSMS();

    Thread Sms_Thread =new Thread(Sms_runnable);


    public void initialize() {

        text.textProperty().addListener(e -> {


//            if (text.getText().length() >= 10) {
//
//                if (Database_Commands.Student_Attendance(text.getText())) {
//
//                    Runnable runnable = () -> Platform.runLater(() -> {
//                        for (Student_Datamodel student_datamodel : Database_Commands.getStudent_data()) {
//                            if (number == 1) {
//                                set_Second();
//                            } else if (number == 2) {
//                                set_Third();
//                                set_Second();
//                            } else if (number == 3) {
//                                set_Fourth();
//                                set_Third();
//                                set_Second();
//                            } else {
//                                set_Fifth();
//                                set_Fourth();
//                                set_Third();
//                                set_Second();
//                            }
//
//
//                            if (student_datamodel.getVerify() % 2 == 0) {
//
//                                lbl_timein_1.setText(time);
//                                lbl_timeout_1.setText("?");
//                                Database_Commands.update_Timein(time, student_datamodel.getId(), student_datamodel.getVerify());
//                                String message = student_datamodel.getFirst_name() + " " + student_datamodel.getLast_name() +
//                                        "\n Time in: " + student_datamodel.getTime_in();
//                                number_send = student_datamodel.getPerson_to_contact();
//                                message_send = message;
//
//                                Sms_Thread.run();
//                            } else {
//
//                                lbl_timeout_1.setText(time);
//                                Database_Commands.update_Timeout(time, student_datamodel.getId(), student_datamodel.getVerify());
//                                String message = student_datamodel.getFirst_name() + " " + student_datamodel.getLast_name() +
//                                        "\n Time in: " + student_datamodel.getTime_in()
//                                        + "\n Time out: " + student_datamodel.getTime_out();
//                                number_send = student_datamodel.getPerson_to_contact();
//                                message_send = message;
//                                Sms_Thread.run();
//                            }
//
//                            lblname_1.setText(student_datamodel.getFirst_name() + " " + student_datamodel.getMiddle_name() + " "
//                                    + student_datamodel.getLast_name());
//
//                            lblgrade_section_1.setText(student_datamodel.getGrade() + " " + student_datamodel.getSection());
//
//                            lbl_adviser_1.setText(student_datamodel.getAdviser());
//
//                            imageview_1.setImage(new Image(new File(student_datamodel.getPhoto()).toURI().toString()));
//                            number++;
//                        }
//
//                        text.setText("");
//                    });
//                    new Thread(runnable).start();
//                }
//
//            }

        });


        Runnable clock_runnable = () -> {

            try {

                while (true) {
                    Thread.sleep(1000);
                    Platform.runLater(() -> {
                        time = Time_format.format(LocalTime.now());
                        Time.setText(Time_format.format(LocalTime.now()));

                    });
                }

            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        };

//        NotSend_Timein.addListener((ListChangeListener<Student_Datamodel>) change -> {
//            Runnable runnable1 = () -> {
//
//                for (Student_Datamodel student_datamodel : NotSend_Timein) {
//
//                    String message = student_datamodel.getFirst_name() + " " + student_datamodel.getLast_name() +
//                            "\n Time in: " + student_datamodel.getTime_in();
//
////                    SendMessage(student_datamodel.getPerson_to_contact(),message);
//                }
//
//            };
//            new Thread(runnable1).start();
//        });

//        NotSend_TimeOut.addListener((ListChangeListener<Student_Datamodel>) change -> {
//
//            Runnable runnable2 = () -> {
//
//                for (Student_Datamodel student_datamodel : NotSend_TimeOut) {
//
//                    String message = student_datamodel.getFirst_name() + " " + student_datamodel.getLast_name() +
//                            "\n Time in: " + student_datamodel.getTime_in()
//                            + "\n Time out: " + student_datamodel.getTime_out();
//
////                    SendMessage(student_datamodel.getPerson_to_contact(),message);
//                }
//
//            };
//
//
//            new Thread(runnable2).start();
//        });


        new Thread(clock_runnable).start();

//        RunGSM();

    }

    public boolean SendSMS() {

        GSMConnect gsm = new GSMConnect("COM1");
//            gsm.init();
        if (gsm.init()) {
            if (gsm.connect()) {
                gsm.sendMessage(number_send, message_send);
                gsm.closePort();
                Sms_Thread.interrupt();
                System.out.println(number_send);
                System.out.println(message_send);
                return true;
            } else {
                System.out.println("Can't Connect");
                return false;
            }

        }
        return false;

    }






    private void set_Second(){
        next_Data(imageview_1,lblname_1,lblgrade_section_1,
                lbl_adviser_1,lbl_timein_1,lbl_timeout_1
                ,imageview_2,lblname_2,lblgrade_section_2,
                lbl_adviser_2,lbl_timein_2,lbl_timeout_2);
    }

    private void set_Third(){
        next_Data(imageview_2,lblname_2,lblgrade_section_2,
                lbl_adviser_2,lbl_timein_2,lbl_timeout_2
                ,imageview_3,lblname_3,lblgrade_section_3,
                lbl_adviser_3,lbl_timein_3,lbl_timeout_3);
    }

    private void set_Fourth(){
        next_Data(imageview_3,lblname_3,lblgrade_section_3,
                lbl_adviser_3,lbl_timein_3,lbl_timeout_3
                ,imageview_4,lblname_4,lblgrade_section_4,
                lbl_adviser_4,lbl_timein_4,lbl_timeout_4);
    }

    private void set_Fifth(){
        next_Data(imageview_4,lblname_4,lblgrade_section_4,
                lbl_adviser_4,lbl_timein_4,lbl_timeout_4
                ,imageview_5,lblname_5,lblgrade_section_5,
                lbl_adviser_5,lbl_timein_5,lbl_timeout_5);
    }



    private void next_Data(ImageView imageView_1, Label name_1, Label grade_section_1,
    Label adviser_1, Label time_in1, Label time_out1,
                           ImageView imageView_2, Label name_2, Label grade_section_2,
                           Label adviser_2, Label time_in2, Label time_out2){

        imageView_2.setImage(imageView_1.getImage());
        name_2.setText(name_1.getText());
        grade_section_2.setText(grade_section_1.getText());
        adviser_2.setText(adviser_1.getText());
        time_in2.setText(time_in1.getText());
        time_out2.setText(time_out1.getText());


    }


//    private void loadTime(){
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML_FILE/timein.fxml"));
//        Stage stage = new Stage();
//        stage.initOwner(parent.getScene().getWindow());
//
//        try {
//            parent1 = fxmlLoader.load();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        Scene scene = new Scene(parent);
//        stage.initModality(Modality.WINDOW_MODAL);
//        stage.setTitle("Top up");
//        stage.initStyle(StageStyle.UNDECORATED);
//        stage.centerOnScreen();
//        stage.setResizable(false);
//        stage.setScene(scene);
//        stage.show();
//
//    }




}
