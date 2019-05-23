package ATTENDANCE_LOGIN.DATAMODEL;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Kurt Lupin C. Orioque
 * Email Address: kurtorioque112@gmail.com
 * ContactNumber: 09953045981
 * Linkedin: https://github.com/kurt112
 * Github: https://www.linkedin.com/in/kurt-lupin-orioque-2946a6157/
 * Bitbucket: https://bitbucket.org/%7B49153846-f85c-4553-9ecb-714516a680b7%7D/
 * Date: 05 20, 2019
 * Time: 12:54 PM
 * User: orioque35
 */


public class Student_Attendance extends Student_School_Information {

    private SimpleStringProperty time_in = new SimpleStringProperty();
    private SimpleStringProperty time_out = new SimpleStringProperty();
    private SimpleStringProperty date = new SimpleStringProperty();
    private SimpleStringProperty status = new SimpleStringProperty();

    public Student_Attendance(int id, String first_name, String last_name, String middle_name, String photo, String grade, String section, String adviser, int verify, String person_to_contact
    ,String time_in, String time_out, String date, String status) {
        super(id, first_name, last_name, middle_name, photo, grade, section, adviser, verify, person_to_contact);

        this.status.set(status);
        this.time_out.set(time_out);
        this.time_in.set(time_in);
        this.date.set(date);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getTime_in() {
        return time_in.get();
    }

    public SimpleStringProperty time_inProperty() {
        return time_in;
    }

    public void setTime_in(String time_in) {
        this.time_in.set(time_in);
    }

    public String getTime_out() {
        return time_out.get();
    }

    public SimpleStringProperty time_outProperty() {
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out.set(time_out);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
