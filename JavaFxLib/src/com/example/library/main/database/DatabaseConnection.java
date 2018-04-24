package com.example.library.main.database;

import com.example.library.main.log.TinyLog;
import com.example.library.main.modul.Author;
import com.example.library.main.modul.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private final String USER="root";
    private final String PASS="admin";
    private final String DRIVER_CLASS="com.mysql.jdbc.Driver";
    private final String NAME_DATABASE="library";
    public static final String URL = "jdbc:mysql://localhost:3306";
    private String path ;
    private Statement statement;
    private DatabaseImportExport databaseImportExport;
    private static DatabaseConnection instance = null;
    private ObservableList<Author> authorObservableList = FXCollections.observableArrayList();
    private List<Book> bookList = new ArrayList<>();
    private DatabaseConnection() {
        try {
            Class.forName(DRIVER_CLASS);
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
            statement.execute("use " + NAME_DATABASE + ";");
            ResultSet showVar = statement.executeQuery
                    ("SHOW VARIABLES LIKE \"secure_file_priv\";");
            showVar.next();
            path = showVar.getString("Value");
            TinyLog.trace("Path : " + path);
            ResultSet resultSet = statement.executeQuery("show tables;");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Tables_in_library"));
            }
        } catch (ClassNotFoundException e) {
            TinyLog.warn("ClassNotFound: " + e.getMessage());
        } catch (SQLException e) {
            TinyLog.warn("Sql error: " + e.getMessage());
        }

    }

    public static DatabaseConnection getInstance() {
        synchronized (DatabaseConnection.class) {
            if (instance == null) {
                instance = new DatabaseConnection();
                instance.databaseImportExport = new InlineOutlineImportExport();
            }
        }
        return instance;

    }

    public ResultSet executeQuery(String command) {
        try {
            return statement.executeQuery(command);
        } catch (SQLException e) {
            TinyLog.warn("ExecuteQuery Error: " + e.getMessage());
            return null;
        }
    }

    public boolean execute(String command) {
        try {
            return statement.execute(command);
        } catch (SQLException e) {
            TinyLog.warn("Execute Error: " + e.getMessage());
            return false;
        }
    }

    public void exportDataBase() {
        databaseImportExport.exportDatabase();
    }

    public void importDataBase() {
        databaseImportExport.importDatabase();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ObservableList<Author> returnAuthor(){
        String sql ="";

        try {
           ResultSet resultSet = statement.executeQuery(sql);
            long id =resultSet.getLong("id");
            String firstName = resultSet.getString("firstname");
            String middleName = resultSet.getString("middlename");
            String lastName = resultSet.getString("lastName");
            String alias = resultSet.getString("alias");
            Date dateBith = resultSet.getDate("dateBith");
            Date goneDate = resultSet.getDate("goneDate");
            authorObservableList.add(new Author(id,firstName,middleName,lastName,alias,dateBith.toLocalDate(),goneDate.toLocalDate()));
        } catch (SQLException e) {
            TinyLog.trace("Author not create: "+e.getMessage());
        }

        return null;
    }

    public void returnBooks() {
        String sql = "";
        try {
            ResultSet resultSet = statement.executeQuery(sql);

            long id = resultSet.getLong("id");
            String title = resultSet.getString("title");
            String isbn = resultSet.getString("isbn");
            String description = resultSet.getString("description");
            Date realeaseDate = resultSet.getDate("realeaseDate");
            String coverLink = resultSet.getString("coverLink");
            int volume = resultSet.getInt("volume");
            long authorId = resultSet.getLong("authorId");
            Author author = getAuthorById(authorId);
            bookList.add(new Book(title, author, realeaseDate.toLocalDate(), isbn, coverLink, description, id));
        } catch (SQLException e) {
            TinyLog.trace("Books nor create:" + e.getMessage());
        }
    }



    public Author getAuthorById(long id){
        for (Author author:authorObservableList) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }
}
