package com.example.library.main.database;

public class InlineOutlineImportExport implements DatabaseImportExport {
    @Override
    public boolean importDatabase() {
        return false;
    }

    @Override
    public boolean exportDatabase() {
        String exportFile;
        exportFile = "select * from authors into outfile '" +
                DatabaseConnection.getInstance().getPath().replaceAll("\\\\", "/") +
                "authors_J1017_1.csv';";
        DatabaseConnection.getInstance().execute(exportFile);

        exportFile = "select * from books into outfile '" +
                DatabaseConnection.getInstance().getPath().replaceAll("\\\\", "/") +
                "books_J1017_1.csv';";
        DatabaseConnection.getInstance().execute(exportFile);

        exportFile = "select * from firstnames into outfile '" +
                DatabaseConnection.getInstance().getPath().
                        replaceAll("\\\\", "/") +
                "firstnames_J1017_1.csv';";
        DatabaseConnection.getInstance().execute(exportFile);

        exportFile = "select * from lastnames into outfile '" +
                DatabaseConnection.getInstance().getPath().replaceAll("\\\\", "/") +
                "lastnames_J1017_1.csv';";
        DatabaseConnection.getInstance().execute(exportFile);

        exportFile = "select * from middlenames into outfile '" + DatabaseConnection.getInstance().
                getPath().replaceAll("\\\\", "/") +
                "middlenames_J1017_1.csv';";
        DatabaseConnection.getInstance().execute(exportFile);

        return false;

    }
}
