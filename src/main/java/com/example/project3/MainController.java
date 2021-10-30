package com.example.project3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.InputMismatchException;

public class MainController {

    private final int MINIMUM_NUM_CREDITS = 3;
    private final int MAXIMUM_NUM_CREDITS = 24;

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

    /**
     * Gets the selected major
     * @return - the major selected
     * @throws InputMismatchException if major has not been selected
     */
    private Major getMajor() throws InputMismatchException {
        if(cs.isSelected())
            return Major.CS;
        else if(it.isSelected())
            return Major.IT;
        else if(ee.isSelected())
            return Major.EE;
        else if(me.isSelected())
            return Major.ME;
        else if(ba.isSelected())
            return Major.BA;
        else
            throw new InputMismatchException();
    }

    /**
     * Builds the profile for a student
     * @return student profile
     */
    private Profile buildStudentProfile(){
        String studentName = name.getText();
        if(studentName.isEmpty()){
            output.appendText("Student name field is empty. \n");
            return null;
        }

        try{
            Major major = getMajor();
            return new Profile(studentName, major);
        }catch (InputMismatchException majorNotSelected){
            output.appendText("Student major has not been selected \n");
        }

        return null;
    }

    /**
     * Adds a resident student to the roster.
     * @param profile - the profile of the student to add
     */
    public void addResidentStudent(Profile profile){
        int creditHours = MINIMUM_NUM_CREDITS;

        try {
            creditHours = Integer.parseInt(credits.getText());
        }catch(NumberFormatException badInput){
            output.appendText("Invalid credit hours. \n");
            return;
        }

        if(creditHours < MINIMUM_NUM_CREDITS){
            output.appendText("Minimum credit hours is 3. \n");
            return;
        }else if(creditHours > MAXIMUM_NUM_CREDITS){
            output.appendText("Credit hours exceed the maximum 24. \n");
            return;
        }

        Resident residentStudent = new Resident(profile, creditHours);
        boolean studentAdded = roster.add(residentStudent);

        if(studentAdded){
            output.appendText("Student added. \n");
        }else{
            output.appendText("Student is already in the roster. \n");
        }
    }

    /**
     * Adds a non-resident student to the roster
     * @param profile - the profile of the student to add
     */
    public void addNonResidentStudent(Profile profile){
        int creditHours = MINIMUM_NUM_CREDITS;

        try {
            creditHours = Integer.parseInt(credits.getText());
        }catch(NumberFormatException badInput){
            output.appendText("Invalid credit hours. \n");
            return;
        }

        if(creditHours < MINIMUM_NUM_CREDITS){
            output.appendText("Minimum credit hours is 3. \n");
            return;
        }else if(creditHours > MAXIMUM_NUM_CREDITS){
            output.appendText("Credit hours exceed the maximum 24. \n");
            return;
        }

        NonResident nonResidentStudent = new NonResident(profile, creditHours);
        boolean studentAdded = roster.add(nonResidentStudent);

        if(studentAdded){
            output.appendText("Student added. \n");
        }else{
            output.appendText("Student is already in the roster. \n");
        }
    }

    public void addTriStateStudent(Profile profile){

    }

    public void addInternationalStudent(Profile profile){

    }

    /**
     * Adds a student to the roster
     * @param event - the event to be handled
     */
    @FXML
    void addStudent(ActionEvent event) {
        Profile studentProfile = buildStudentProfile();
        if(studentProfile == null){
            return;
        }

        boolean isResidentStudent = resident.isSelected();
        boolean isNonResidentStudent = non_resident.isSelected() &&
                !tristate.isSelected() && !international.isSelected();
        boolean isTriStateStudent = tristate.isSelected();
        boolean isIntlStudent = international.isSelected();

        if(isResidentStudent)
            addResidentStudent(studentProfile);
        else if(isNonResidentStudent)
            addNonResidentStudent(studentProfile);
        else if(isTriStateStudent)
            addTriStateStudent(studentProfile);
        else if(isIntlStudent)
            addInternationalStudent(studentProfile);
        else
            output.appendText("Student status has not been selected \n");
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
