import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by mel on 2/1/17.
 */
class MySQLAdsDao implements Ads {
    private Connection connection;

    MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ad> all(){
        String sql = "SELECT * FROM ads";
        List<Ad> ads = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                long userId = resultSet.getLong("user_id");

                Ad ad = new Ad(id, userId, title, description);
                ads.add(ad);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ads;
    }

    @Override
    public void insert(Ad ad) {
        String sql = "INSERT INTO ADS (user_id, title, description) VALUES ('" + ad.getUserId() + "', '" + ad.getTitle() + "', '" + ad.getDescription() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generateKeys = statement.getGeneratedKeys();
            generateKeys.next();
            long id = generateKeys.getLong(1);
            ad.setId(id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ad find(long id) {
        String sql = "SELECT * FROM ads WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                long userId = resultSet.getLong("user_id");
                return new Ad(id, userId, title, description);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
