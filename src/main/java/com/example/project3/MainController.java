package com.example.project3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private RadioButton ba;

    @FXML
    private RadioButton ba2;

    @FXML
    private RadioButton connecticut;

    @FXML
    private TextField credits;

    @FXML
    private RadioButton cs;

    @FXML
    private RadioButton cs2;

    @FXML
    private RadioButton ee;

    @FXML
    private RadioButton ee2;

    @FXML
    private TextField finAid;

    @FXML
    private RadioButton international;

    @FXML
    private RadioButton it;

    @FXML
    private RadioButton it2;

    @FXML
    private RadioButton me;

    @FXML
    private RadioButton me2;

    @FXML
    private TextField name;

    @FXML
    private TextField name2;

    @FXML
    private RadioButton new_york;

    @FXML
    private RadioButton non_resident;

    @FXML
    private TextArea output;

    @FXML
    private TextArea output2;

    @FXML
    private TextArea output3;

    @FXML
    private DatePicker paymentDate;

    @FXML
    private TextField payments;

    @FXML
    private RadioButton resident;

    @FXML
    private CheckBox studyAbroad;

    @FXML
    private RadioButton tristate;

    private Roster roster;

    /**
     * Main Controller Constructor
     */
    public MainController(){
        roster = new Roster();
    }

    @FXML
    void addStudent(ActionEvent event) {

    }

    @FXML
    void calculateTuitionDues(ActionEvent event) {

    }

    @FXML
    void pay(ActionEvent event) {

    }

    @FXML
    void printByNames(ActionEvent event) {
        roster.printRosterByNames(output3);
    }

    @FXML
    void printByPaymentDates(ActionEvent event) {
        roster.printRosterByPaymentDates(output3);
    }

    @FXML
    void printRoster(ActionEvent event) {
        roster.printRoster(output3);
    }

    @FXML
    void printTuitionDue(ActionEvent event) {

    }

    @FXML
    void removeStudent(ActionEvent event) {

    }

    @FXML
    void setFinAid(ActionEvent event) {

    }

    @FXML
    void tuitionOutput(ActionEvent event) {

    }

    @FXML
    void enableStudyAbroadOption(ActionEvent event) {
        new_york.setDisable(true);
        new_york.setSelected(false);

        connecticut.setDisable(true);
        connecticut.setSelected(false);

        studyAbroad.setDisable(false);
    }

    @FXML
    void enableTristateOptions(ActionEvent event) {
        studyAbroad.setSelected(false);
        studyAbroad.setDisable(true);

        new_york.setDisable(false);
        connecticut.setDisable(false);
    }

    void disableResidentButtons(){
        tristate.setDisable(true);
        tristate.setSelected(false);

        new_york.setDisable(true);
        new_york.setSelected(false);

        connecticut.setDisable(true);
        connecticut.setSelected(false);

        international.setDisable(true);
        international.setSelected(false);

        studyAbroad.setDisable(true);
        studyAbroad.setSelected(false);
    }

    @FXML
    void setResidentStatus(ActionEvent event) {
        disableResidentButtons();

        if(non_resident.isSelected()){
            tristate.setDisable(false);
            international.setDisable(false);
        }
    }



}
