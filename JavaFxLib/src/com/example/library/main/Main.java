package com.example.library.main;

import com.example.library.main.database.DatabaseConnection;
import com.example.library.main.modul.Author;
import com.example.library.main.modul.Book;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.time.LocalDate;


public class Main extends Application implements Controller.AddAuthorListener,Controller.AddBookListener{
    private ObservableList<Book> books = FXCollections.observableArrayList();
    private ObservableList<Author> authors = FXCollections.observableArrayList();
    //TODO connect MySql , create user and pass,URL(localhost:3306), download driver Connecrion/J
    //TODO gitlab download ,import;

    {
        authors.add(new Author("Pushin"));
        authors.add(new Author("Dante"));
    }
    {

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
        controller.setAddAuthorListener(this);
        controller.setAddBookListener(this);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public Main(){
        System.out.println("Main Start");
        DatabaseConnection connection = DatabaseConnection.getInstance();
        books.addAll(connection.getBooksList());
        authors.addAll(connection.getAuthorsList());
    }
    public static void main(String[] args) {
        System.out.println("psvm");
        launch(args);
    }



    @Override
    public void showAuthorDialog() {
        new CreateAuthorDialog();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }
}
