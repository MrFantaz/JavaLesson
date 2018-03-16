package com.example.library.main;

import com.example.library.main.modul.Author;
import com.example.library.main.modul.Book;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.util.resources.LocaleData;

import java.time.LocalDate;


public class Main extends Application implements Controller.AddAuthorListener{
    private ObservableList<Book> books = FXCollections.observableArrayList();
    private ObservableList<Author> authors = FXCollections.observableArrayList();
    {
        authors.add(new Author("Pushin"));
        authors.add(new Author("Dante"));
    }
    {
        books.add(new Book("Hell","Dante", LocalDate.now()));
        books.add(new Book("War and Pis","Pushkin",LocalDate.now()));
        books.add(new Book("Revisor","Pushkin",LocalDate.now()));
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Application start");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Layout/FXLib.fxml"));
        AnchorPane root = loader.load();
        Controller controller = loader.getController();
        primaryStage.setTitle("LibraryFX");
        controller.setBook(books);
        controller.setAuthor(authors);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.out.println("psvm");
        launch(args);
    }

    @Override
    public void addAuthor(Book book) {
    new CreateAuthorDialog();
    }
}
