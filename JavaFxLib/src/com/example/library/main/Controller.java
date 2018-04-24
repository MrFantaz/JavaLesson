package com.example.library.main;

import com.example.library.main.modul.Author;
import com.example.library.main.modul.Book;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableColumn<Book,String> TableTitle;
    @FXML
    private TableColumn<Book,String> TableAuthor;
    @FXML
    private TableColumn<Book,LocalDate> TableYear;
    @FXML
    private javafx.scene.control.TableView<Book> TableView;
    @FXML
    private ComboBox Author;
    @FXML
    private TextField TextTitle;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea Disc;



    private ObservableList<Book> book;
    private  ObservableList<com.example.library.main.modul.Author> authors;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("SampleController init");
    }
    public void onActionButton(){

      System.out.println("Book name "+ TextTitle.getText()+" Author ");
      TextTitle.clear();
      datePicker.getEditor().clear();
      Author.getSelectionModel().clearSelection();
      Disc.clear();
    }

    public void onActionButtonSave(){
        String title = TextTitle
                .getText();
        Author authorText =(Author) Author.getSelectionModel().getSelectedItem();
        LocalDate time = datePicker.getValue();
        Book book = new Book(title,authorText,time);

        System.out.println("Save done");
    }
    public void setAuthor(ObservableList<Author> author){
        this.authors=author;
        Author.setItems(this.authors);
    }

    public void setBook(ObservableList<Book> book) {
        System.out.println("das");
        this.book = book;
        TableView.setItems(book);
        TableTitle.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
        TableAuthor.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        TableYear.setCellValueFactory(new PropertyValueFactory<Book,LocalDate>("releaseDate"));
        TextTitle.setText("Title");
    }
    public  void AddAuthorAuthor(){

    }





   public interface AddAuthorListener{
        public void addAuthor(Book book);
   }
}
