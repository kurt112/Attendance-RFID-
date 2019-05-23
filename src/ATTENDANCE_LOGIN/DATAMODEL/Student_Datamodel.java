package ATTENDANCE_LOGIN.DATAMODEL;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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

public class Student_Datamodel {

    private SimpleIntegerProperty id=  new SimpleIntegerProperty();
    private SimpleStringProperty first_name = new SimpleStringProperty();
    private SimpleStringProperty last_name = new SimpleStringProperty();
    private SimpleStringProperty middle_name = new SimpleStringProperty();
    private SimpleStringProperty photo = new SimpleStringProperty();

    public Student_Datamodel(int id, String first_name, String last_name, String middle_name, String photo){

        this.photo.set(photo);
        this.id.set(id);
        this.first_name.set(first_name);
        this.last_name.set(last_name);
        this.middle_name.set(middle_name);
        this.last_name.set(last_name);

    }

    public String getPhoto() {
        return photo.get();
    }

    public SimpleStringProperty photoProperty() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo.set(photo);
    }


    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFirst_name() {
        return first_name.get();
    }

    public SimpleStringProperty first_nameProperty() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name.set(first_name);
    }

    public String getLast_name() {
        return last_name.get();
    }

    public SimpleStringProperty last_nameProperty() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
    }

    public String getMiddle_name() {
        return middle_name.get();
    }

    public SimpleStringProperty middle_nameProperty() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name.set(middle_name);
    }


 }
