import java.sql.*;
import com.mysql.jdbc.Driver;

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
            e.printStackTrace();
        }
    }


    @Override
    public List<Ad> all(){
        List<Ad> ads = new ArrayList<>();
        long id;
        long user_id;
        String title;
        String description;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            while(rs.next()) {
                id = rs.getLong("id");
                user_id = rs.getLong("user_id");
                title = rs.getString("title");
                description = rs.getString("description");

                Ad ad = new Ad(id, user_id, title, description);
                ads.add(ad);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong", e);
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO ads(user_id, title, description) VALUES"
            + "('"+ad.getUserId()+"',"
            + "'"+ad.getTitle()+"',"
            + "'"+ad.getDescription()+"')", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
                throw new RuntimeException("Could not create ad.", e);
        }
    }
}
