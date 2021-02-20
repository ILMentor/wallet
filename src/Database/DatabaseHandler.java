package Database;

import java.sql.*;

public class DatabaseHandler extends Configs{

    Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName
                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(url, dbUser, dbPassword);
        return connection;
    }

    public void insertNote(Note note){

        String insert = "INSERT INTO " + TableProperty.TABLE_NAME + "("
                + TableProperty.VALUE + ","
                + TableProperty.DATE + ","
                + TableProperty.CATEGORY + ","
                + TableProperty.TYPE + ","
                + TableProperty.DESCRIPTION + ")"
                + "VALUES (?,?,?,?,?)";

        try {

            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);

            preparedStatement.setString(1, note.getValue());
            preparedStatement.setString(2, note.getDate());
            preparedStatement.setString(3, note.getCategory());
            preparedStatement.setString(4, note.getType());
            preparedStatement.setString(5, note.getDescription());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    ResultSet resultSet;
    public ResultSet select(){

        //todo Я не уверен, что этот метод будет работать правильно.
        // Когда буду доставать данные из базы, его нужно проверить.
        String select = "SELECT * FROM " + TableProperty.TABLE_NAME;
        try {
            Statement statement = getConnection().createStatement();
            resultSet = statement.executeQuery(select);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return resultSet;
    }
}
