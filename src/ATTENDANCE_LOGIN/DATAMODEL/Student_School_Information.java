package ATTENDANCE_LOGIN.DATAMODEL;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Kurt Lupin C. Orioque
 * Email Address: kurtorioque112@gmail.com
 * ContactNumber: 09953045981
 * Linkedin: https://github.com/kurt112
 * Github: https://www.linkedin.com/in/kurt-lupin-orioque-2946a6157/
 * Bitbucket: https://bitbucket.org/%7B49153846-f85c-4553-9ecb-714516a680b7%7D/
 * Date: 05 20, 2019
 * Time: 12:59 PM
 * User: orioque35
 */


public class Student_School_Information extends Student_Datamodel {

    private SimpleStringProperty grade = new SimpleStringProperty();
    private SimpleStringProperty section = new SimpleStringProperty();
    private SimpleStringProperty adviser = new SimpleStringProperty();
    private SimpleIntegerProperty verify = new SimpleIntegerProperty();
    private SimpleStringProperty person_to_contact = new SimpleStringProperty();
    public Student_School_Information(int id, String first_name, String last_name, String middle_name, String photo
    ,String grade, String section, String adviser, int verify, String person_to_contact) {
        super(id, first_name, last_name, middle_name, photo);

        this.grade.set(grade);
    this.section.set(section);
    this.adviser.set(adviser);
    this.verify.set(verify);
    this.person_to_contact.set(person_to_contact);

    }



    public String getGrade() {
        return grade.get();
    }

    public SimpleStringProperty gradeProperty() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public String getSection() {
        return section.get();
    }

    public SimpleStringProperty sectionProperty() {
        return section;
    }

    public void setSection(String section) {
        this.section.set(section);
    }

    public String getAdviser() {
        return adviser.get();
    }

    public SimpleStringProperty adviserProperty() {
        return adviser;
    }

    public void setAdviser(String adviser) {
        this.adviser.set(adviser);
    }

    public int getVerify() {
        return verify.get();
    }

    public SimpleIntegerProperty verifyProperty() {
        return verify;
    }

    public void setVerify(int verify) {
        this.verify.set(verify);
    }

    public String getPerson_to_contact() {
        return person_to_contact.get();
    }

    public SimpleStringProperty person_to_contactProperty() {
        return person_to_contact;
    }

    public void setPerson_to_contact(String person_to_contact) {
        this.person_to_contact.set(person_to_contact);
    }
}
