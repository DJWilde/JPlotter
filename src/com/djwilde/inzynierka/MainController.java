package com.djwilde.inzynierka;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MainController {
    @FXML
    private BorderPane mainWindowPane;
    @FXML
    private MenuItem closeAppMenu;
    @FXML
    private MenuItem aboutMenu;
    @FXML
    private MenuItem newCommandMenuItem;

    public void initialize() {
        newCommandMenuItem.setOnAction(actionEvent -> {
            TextInputDialog inputDialog = new TextInputDialog();
            inputDialog.setTitle("Wpisz polecenie");
            inputDialog.setHeaderText("Wpisz polecenie");
            inputDialog.setContentText("Wpisz polecenie programu gnuplot: ");

            inputDialog.getDialogPane().setMinWidth(600);

            ((Button) inputDialog.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Anuluj");
            ((Button) inputDialog.getDialogPane().lookupButton(ButtonType.OK)).setText("Wykonaj");
            Optional<String> result = inputDialog.showAndWait();
            result.ifPresent(text -> {

            });
        });

        aboutMenu.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader();
            try {
                Pane pane = fxmlLoader.load(getClass().getResource("aboutDialog.fxml").openStream());
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(mainWindowPane.getScene().getWindow());
                stage.setScene(new Scene(pane));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        closeAppMenu.setOnAction(actionEvent -> System.exit(0));
    }
}
