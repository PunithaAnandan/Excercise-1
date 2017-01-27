package edu.matc.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
/**
 * Provides access the database
 * Created on 8/31/16.
 *
 * @author pwaite
 */

public class Database {

    private final Logger logger = Logger.getLogger(this.getClass());

    // create an object of the class Database
    private static Database instance = new Database();

    private Properties properties;

    private Connection connection;

    /**
     * This is the code for empty constructor
     */
    private Database() {
        loadProperties();

    }

    /**
     * This is the code for the method loadProperties
     */
    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/database.properties"));
        } catch (IOException ioe) {
            logger.error("Database.loadProperties()...Cannot load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            logger.error("Database.loadProperties()..." + e);
            e.printStackTrace();
        }

    }

    /**
     * This is the code for the method getInstance()
     * @return instance
     */
    public static Database getInstance() {
        return instance;
    }

    /**
     * This is the code for the method getConnection()
     * @return connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * This is the code for the method connect()
     * @throws Exception
     */
    public void connect() throws Exception {
        if (connection != null)
            return;

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new Exception("Database.connect()... Error: MySQL Driver not found");
        }

        String url = properties.getProperty("url");
        connection = DriverManager.getConnection(url, properties.getProperty("username"),  properties.getProperty("password"));
    }


    /**
     * This is the code for the method disconnect
     */
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Cannot close connection" + e);
            }
        }

        connection = null;
    }

}