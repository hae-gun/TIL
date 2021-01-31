package hello.hellospring.repository;


import hello.hellospring.domain.Member;

import java.sql.*;

public class DatabaseRepository implements Repository {

    private final String driver = "org.h2.Driver";
    private final String url = "jdbc:h2:tcp://localhost/~/test";
    private Connection conn;

    public DatabaseRepository() throws Exception{
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url);
    }

    @Override
    public Member findById(Long id) {
        PreparedStatement stmt = null;
        ResultSet rs =null;
        Member member = null;
        try{
            String query = "select id, name from member where ID = ?";
            stmt = conn.prepareStatement(query);
            stmt.setLong(1,id);
            rs = stmt.executeQuery();
            if(!rs.next()){
                throw new SQLException("NO Data");
            }
            member = new Member(rs.getLong(1),rs.getString(2));
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return member;
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
