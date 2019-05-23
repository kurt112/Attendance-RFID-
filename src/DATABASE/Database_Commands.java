package DATABASE;

import ATTENDANCE_LOGIN.DATAMODEL.Student_Attendance;
import ATTENDANCE_LOGIN.DATAMODEL.Student_School_Information;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ATTENDANCE_LOGIN.DATAMODEL.Student_Datamodel;

import java.sql.*;
import java.util.Objects;

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

public class Database_Commands {

    private static final String Db_Name = "Student_Db.db";
    private static final String Db_Path = "jdbc:sqlite:C:\\Users\\orioque35\\IdeaProjects\\RFID_PROJECT\\src\\DATABASE\\"+ Db_Name;
    private static Connection conn;
    private static ResultSet resultSet;
    private static ObservableList<Student_Datamodel> Student_data = FXCollections.observableArrayList();


    private Database_Commands() {

    }

    private static void open() {

        try {
            conn = DriverManager.getConnection(Db_Path);
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    private static void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Statement Create_Statement() {

        try {

            return conn.createStatement();

        }catch(SQLException e){

            e.printStackTrace();

        }

        return null;
    }

//    public static boolean Student_Attendance(String id){
//
//        Student_data.clear();
//        int Id_int = Integer.parseInt(id);
//
//        open();
//
//        try{
//
//          resultSet = Objects.requireNonNull(Create_Statement()).executeQuery("SELECT * FROM  STUDENT_PERSONAL_INFORMATION INNER JOIN STUDENT_SCHOOL_HISTORY_ATTENDANCE\n" +
//                  "ON STUDENT_PERSONAL_INFORMATION.STUDENT_ID = STUDENT_SCHOOL_HISTORY_ATTENDANCE.STUDENT_ID WHERE\n" +
//                  "STUDENT_PERSONAL_INFORMATION.STUDENT_ID = '"+Id_int+"'" );
//
//
//          if (resultSet.next()){
//
//              int Id_result = resultSet.getInt(1);
//              String first_name = resultSet.getString(2);
//              String Last_name = resultSet.getString(3);
//              String middle_name = resultSet.getString(4);
//              String photo = resultSet.getString(5);
//
//              //second table
//
//              String grade = resultSet.getString(7);
//              String section = resultSet.getString(8);
//              String adviser = resultSet.getString(9);
//              String time_in = resultSet.getString(10);
//              String time_out = resultSet.getString(11);
//              int verify = resultSet.getInt(12);
//              String person_to_contact = resultSet.getString(13);
//
//
//              Student_data.add(new Student_Datamodel(Id_result,first_name,Last_name,middle_name,
//                      grade,section,adviser,time_in,time_out,photo,verify,person_to_contact));
//              resultSet.close();
//              close();
//              return true;
//          }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        close();
//        return false;
//
//
//    }

    public static void update_Timein(String time, int id,int number){

        open();

        try (Statement statement = Create_Statement()){

            statement.execute("UPDATE STUDENT_SCHOOL_HISTORY_ATTENDANCE set TIME_IN ='" + time + "' where STUDENT_ID = '" + id + "'");


        }catch (SQLException e){
            e.printStackTrace();
        }

        update_verify(number,id);
        close();
    }

    public static void update_Timeout(String time, int id,int number){

        open();

        try (Statement statement = Create_Statement()){

            statement.execute("UPDATE STUDENT_SCHOOL_HISTORY_ATTENDANCE set TIME_OUT ='" + time + "' where STUDENT_ID = '" + id + "'");

        }catch (SQLException e){
            e.printStackTrace();
        }
        update_verify(number,id);
        close();

    }

    public static void update_verify(int number, int id){
        number++;
        System.out.println("im verified");
        open();

        try (Statement statement = Create_Statement()){

            statement.execute("UPDATE STUDENT_SCHOOL_HISTORY_ATTENDANCE set VERIFY ='" + number + "' where STUDENT_ID = '" + id + "'");

        }catch (SQLException e){
            e.printStackTrace();
        }

        close();

    }

    private static ObservableList<Student_Attendance> History_Attendance = FXCollections.observableArrayList();
    private static ObservableList<Student_School_Information> Student_List = FXCollections.observableArrayList();

    public static void Attendace_History(String date, String stats){
        open();
        History_Attendance.clear();

        try {

                resultSet = Objects.requireNonNull(Create_Statement()).executeQuery("SELECT * FROM  STUDENT_PERSONAL_INFORMATION, STUDENT_SCHOOL_INFORMATION\n" +
                        " INNER JOIN STUDENT_SCHOOL_HISTORY_ATTENDANCE ON " +
                        " STUDENT_PERSONAL_INFORMATION.STUDENT_ID = " +
                        " STUDENT_SCHOOL_HISTORY_ATTENDANCE.STUDENT_ID WHERE STUDENT_SCHOOL_HISTORY_ATTENDANCE.DATE = '" + date + "'"+
                " AND STUDENT_SCHOOL_HISTORY_ATTENDANCE.STATUS ='" + stats+ "'");

                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String first_name = resultSet.getString(2);
                    String last_name = resultSet.getString(3);
                    String middle_name =resultSet.getString(4);
                    String photo = resultSet.getString(5);
                    String grade = resultSet.getString(7);
                    String section = resultSet.getString(8);
                    String adviser = resultSet.getString(9);
                    int verify = resultSet.getInt(10);
                    String contact = resultSet.getString(11);
                    String time_in = resultSet.getString(13);
                    String time_out = resultSet.getString(14);
                    String dates = resultSet.getString(15);
                    String status = resultSet.getString(16);
                    System.out.println(id);
                    System.out.println(first_name);
                    System.out.println(adviser);
                    System.out.println(contact);
                    History_Attendance.add(new Student_Attendance(id,first_name,middle_name,last_name,photo,
                            grade,section,adviser,verify,contact,time_in,time_out,dates,status));

                }
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        close();

    }
    public static void Student_list(){
        Student_List.clear();
        try {
            resultSet = Create_Statement().executeQuery("SELECT * FROM  STUDENT_PERSONAL_INFORMATION " +
                    "INNER JOIN STUDENT_SCHOOL_INFORMATION ON STUDENT_PERSONAL_INFORMATION.STUDENT_ID STUDENT_SCHOOL_INFORMATION.STUDENT_ID");
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String first_name = resultSet.getString(2);
            String last_name = resultSet.getString(3);
            String middle_name = resultSet.getString(4);
            String photo = resultSet.getString(5);
            String grade = resultSet.getString(7);
            String section = resultSet.getString(8);
            String adviser = resultSet.getString(9);
            int verify = resultSet.getInt(10);
            String contact = resultSet.getString(11);

            Student_List.add(new Student_School_Information(id,first_name,last_name,middle_name,
                    photo,grade,section,adviser,verify,contact));

        }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static ObservableList<Student_Attendance> getHistory_Attendance() {
        return History_Attendance;
    }

    public static ObservableList<Student_Datamodel> getStudent_data() {
        return Student_data;
    }



}
