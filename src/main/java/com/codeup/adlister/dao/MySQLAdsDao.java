package com.codeup.adlister.dao;

import java.sql.*;

import com.mysql.jdbc.Driver;
import com.codeup.adlister.models.Ad;

import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config){

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Cannot obtain database connection", e);
        }
    }


    @Override
    public List<Ad> all(){
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM ads");
            List<Ad> adsFromDB = createAdsFromDB(resultSet);
            return adsFromDB;
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong", e);
        }
    }

    private List<Ad> createAdsFromDB(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while(rs.next()) {
            long id = rs.getLong("id");
            long user_id = rs.getLong("user_id");
            String title = rs.getString("title");
            String description = rs.getString("description");

            Ad ad = new Ad(id, user_id, title, description);
            ads.add(ad);
        }
        return ads;

    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement stmt = connection.createStatement();

            String sql = createInsertQuery(ad);
            System.out.println("Preparing to run query: " + sql);

            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
                throw new RuntimeException("Could not create ad.", e);
        }
    }

    private String createInsertQuery(Ad ad) {
        String sql = "INSERT INTO ads(user_id, title, description) VALUES(%d, '%s', '%s')";
        return String.format(
                sql,
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription()
        );
    }

//    public void update(models.Ad ad) {
//        try {
//            String sql = "UPDATE ads SET user_id=?, title=?, description=? WHERE id=?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, (ad.getUserId(), Statement.RETURN_GENERATED_KEYS)
//        } catch (SQLException e) {
//            throw new RuntimeException("Could not update ad.", e);
//        }
//    }


}
