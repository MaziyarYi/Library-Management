package com.example.librarymanagement.util;

import com.almasb.fxgl.net.Client;
import com.example.librarymanagement.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class FxOperationUtil {

    public static Client currentClient;

    public static String current;

    public static void close(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure?");
        alert.setHeaderText("Exiting...");
        alert.setTitle("You are about to exit");
        alert.showAndWait();
        if (alert.getResult().getText().equals("OK")) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    public static void changeView(ActionEvent event, String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(name + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(name);
        stage.setScene(scene);
        stage.show();
    }
}
