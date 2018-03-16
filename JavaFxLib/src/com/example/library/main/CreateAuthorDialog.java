package com.example.library.main;

import com.example.library.main.modul.Author;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;

public class CreateAuthorDialog extends Dialog<Author> {
    public CreateAuthorDialog(){
        this.setTitle("Dialog");
        this.setHeaderText("prieri");
        ButtonType createButtonType = new ButtonType("Create", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        getDialogPane().setContent(grid);
    }
}
