package com.example.project3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private RadioButton ba;

    @FXML
    private RadioButton connecticut;

    @FXML
    private TextField credits;

    @FXML
    private RadioButton cs;

    @FXML
    private RadioButton ee;

    @FXML
    private RadioButton international;

    @FXML
    private RadioButton it;

    @FXML
    private RadioButton me;

    @FXML
    private TextField name;

    @FXML
    private RadioButton new_york;

    @FXML
    private RadioButton non_resident;

    @FXML
    private TextArea output;

    @FXML
    private RadioButton resident;

    @FXML
    private CheckBox studyAbroad;

    @FXML
    private RadioButton tristate;

    @FXML
    void addStudent(ActionEvent event) {

    }

    @FXML
    void removeStudent(ActionEvent event) {

    }

    @FXML
    void setCredits(ActionEvent event) {

    }

    @FXML
    void setName(ActionEvent event) {

    }

    @FXML
    void tuitionDue(ActionEvent event) {

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

    @FXML
    void setMajor(ActionEvent event) {

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
