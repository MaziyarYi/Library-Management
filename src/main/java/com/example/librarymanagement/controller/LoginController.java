package com.example.librarymanagement.controller;

import com.example.librarymanagement.daoRepository.UserDAO;
import com.example.librarymanagement.model.user.UserAccount;
import com.example.librarymanagement.util.FxOperationUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginController {
    private final UserDAO userDAO = UserDAO.getInstance();

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label warningLabel;

    @FXML
    public void initialize(){
        List<String> types = new ArrayList<>(Arrays.asList("member","staff","admin"));
        typeComboBox.getItems().addAll(types);
    }

    public void login(ActionEvent event) {
        try {
            String id = usernameField.getText();
            String password = passwordField.getText();
            String type = typeComboBox.getSelectionModel().getSelectedItem();

            UserAccount userAccount = userDAO.getUserAccountByUserName(id);
//            if (!Objects.isNull(person)) {
//                Repository.currentPerson = person;
//                try {
//                    if (type.equals("nurse"))
//                        Repository.changeView(event, "nurseMenu");
//                    else if (type.equals("doctor"))
//                        Repository.changeView(event, "doctorMenu");
//                    else if (type.equals("patient"))
//                        Repository.changeView(event, "patientMenu");
//                    else if (type.equals("receptionist"))
//                        Repository.changeView(event, "receptionistMenu");
//
//                    Repository.current = type;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            } else {
//                warningLabel.setText("No user found!!!");
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close(ActionEvent event) {
        FxOperationUtil.close(event);
    }
}
