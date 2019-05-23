module RFID.PROJECT {

    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires javafx.swt;
    requires javafx.media;
    requires sqlite.jdbc;
    requires java.sql;
    requires AnimateFX;
//    requires comm;
    requires com.fazecast.jSerialComm;
    requires log4j;
    requires RXTXcomm;
    requires com.jfoenix;
//    requires java.desktop;

    opens ATTENDANCE_LOGIN;
    opens ATTENDANCE_LOGIN.DATAMODEL;
    opens DATABASE;
//    opens ATTENDANCE_LOGIN.PICTURE;
    opens ATTENDANCE_LOGIN.FXML_FILE;
    opens ATTENDANCE_LOGIN.CONTROLLER_FILE;
    opens ATTENDANCE_LOGIN.GSM_MODEM;

    opens STUDENT_INFORMATION.CONTROLLER;
    opens STUDENT_INFORMATION.FXML_FILE;
    opens STUDENT_INFORMATION;
//    opens CSS_FILE;
//    opens PICTURE;

}