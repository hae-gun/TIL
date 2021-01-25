package hello.hellospring.repository;


import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseRepository implements Repository {

    private final String driver = "oracle.jdbc.driver.OracleDriver";
    private final String protocol = "jdbc:oracle:thin:@localhost:49161:";
    private final String dbName = "USERS";
    private Connection conn;

    public DatabaseRepository() throws Exception{
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(protocol+dbName);
    }

    @Override
    public Seller findById(String id) {
        return null;
    }

    @Override
    public void add(Seller seller) {

    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void remove(Seller seller) {

    }
}
