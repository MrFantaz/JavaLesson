package com.example.library.main;


import com.example.library.main.modul.Author;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DialogController implements Initializable {
    @FXML
    private TextField fullName;
    @FXML
    private TextField occupation;
    @FXML
    private DatePicker dateBorn;
    @FXML
    private DatePicker dateGone;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public Author getAuthor() {
        String name = fullName.getText();
        String occup = occupation.getText();
        LocalDate born = dateBorn.getValue();
        LocalDate gone = dateGone.getValue();
        Author author = null;
        if (name != null && occup != null && born != null) {
            author = new Author(name, occup, born, gone);
        }
        return author;
    }
}
