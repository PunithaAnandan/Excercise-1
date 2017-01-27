package edu.matc.persistence;

import edu.matc.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());
    /**
     * This is the code for the method getAllUsers
     * @return  List of Users
     */
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return getUsers(sql);
    }

    /**
     * This is the code for the method getUsersByLastName
     * @return  List of Users
     */
    public List<User> getUsersByLastName(String lastName) {
        String sql = "SELECT * FROM users where upper(last_name)='"+lastName.toUpperCase()+"'";
        return getUsers(sql);
    }

    /**This is the code for the method getUsers
     *
     * @param sql query String
     * @return users List of users
     */
    private List<User> getUsers(String sql) {
        logger.info("In executeQuery");
        logger.error("Demonstrating error level");
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: " , e);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: " , e);
        }
        return users;
    }

    //TODO add a method or methods to return a single user based on search criteria

    /**This is the code for the method createUserFromResults
     *
     * @param results ResultSet
     * @return user
     * @throws SQLException
     */
    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setFirstName(results.getString("first_name"));
        user.setLastName(results.getString("last_name"));
        user.setUserid(results.getString("id"));
        user.setDateOfBirth(results.getString("date_of_birth"));
        // TODO map the remaining fields
        return user;
    }

}