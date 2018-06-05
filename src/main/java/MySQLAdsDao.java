import java.sql.*;
import com.mysql.jdbc.Driver;
import java.util.List;

public class MySQLAdsDao implements Ads{
    private Connection connection;

    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
        );
    }

    @Override
    public List<Ad> all() {
       return null;
    }

    @Override
    public Long insert(Ad ad) {
        return null;
    }
}
