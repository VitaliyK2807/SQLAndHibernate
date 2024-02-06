package ConnectFiles;
import java.sql.*;
import java.util.ArrayList;

public class ConnectVariantOne {
    private Connection connection;
    private Statement statement;
    private ArrayList<String> resultListCourses;

    public ConnectVariantOne(String url, String user, String pass) {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            resultListCourses = new ArrayList<>();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void getResultListCourses () throws SQLException {
        ResultSet resultSet = statement.executeQuery(
                "SELECT pl.course_name, " +
                        "COUNT(pl.subscription_date) /" +
                        " (MAX(MONTH(pl.subscription_date)) - MIN(MONTH(pl.subscription_date))) " +
                    "FROM purchaselist pl " +
                    "GROUP BY pl.course_name;");
        while (resultSet.next()) {
            Double averageCount = Double.valueOf(resultSet.getString(2));
            resultListCourses.add(resultSet.getString(1) + ": "
                                    + String.format("%.2f", averageCount));
        }
    }
    public String toString () {
        StringBuilder builder = new StringBuilder();
        try {
            getResultListCourses ();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        resultListCourses.forEach(line -> builder.append(line + "\n"));
        return  builder.toString();
    }
}
