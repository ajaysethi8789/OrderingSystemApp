package com.airasia.orderingapp.dbadapter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class PostgreSqlConnection {

    @Value("${postgresql.port}")
    private String dbPort;

    @Value("${postgresql.dbname}")
    private String dbName;

    @Value("${postgresql.user}")
    private String dbUser;

    @Value("${postgresql.password}")
    private String dbPass;


    private static final Logger LOGGER = LogManager.getLogger(PostgreSqlConnection.class);
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;

        try  {
            String url = "jdbc:postgresql://localhost:"+dbPort+"/"+dbName+"?user="+dbUser+"&password="+dbPass;
            connection = DriverManager.getConnection(url);
            Class.forName("org.postgresql.Driver");
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error("Connection failure.");
            e.printStackTrace();
            throw e;
        }
        return connection;
    }

    public ResultSet queryDB(Connection connection, String query) throws SQLException, ClassNotFoundException {
        LOGGER.info("postgre connection  :: queryDB func");
        ResultSet rs = null;
        int res;
        try{
            Connection conn = null;
            Statement stmt = null;
            if(connection == null) {
                conn = getConnection();
            }
            stmt = conn.createStatement();

            if(!query.startsWith("SELECT")) {
                stmt.execute(query);
                rs = stmt.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    long key = rs.getLong(1);
                }
            }
            else if (query.startsWith("UPDATE")){
                res = stmt.executeUpdate(query);
            }
            else {
                rs = stmt.executeQuery(query);
            }
            conn.close();
        }
        catch (SQLException | ClassNotFoundException ex) {
            LOGGER.error("Postgresql Connection :: Catch Block"+ex.getMessage());
            throw ex;
        }
        return rs;
    }

}

