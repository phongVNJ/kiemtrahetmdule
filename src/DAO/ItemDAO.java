package DAO;

import Model.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/iphonemanagement";
    private String jdbcUserName = "phong";
    private String jdbcPassWord = "123456";

    private static final String SELECT_ALL_ITEM ="select item.id,item.NameofItem,Price,Quantity,Color,Descrition,catagory.NameOfItem `catagory` from item join catagory on item.category_id = catagory.id ";

    private static final String INSERT_ITEM_SQL = "insert into Item" + "(NameofItem,Price,Color,Quantity,Descrition,Category_ID value" + "?,?,?,?,?,?";

    private static final String UPDATE_ITEM_SQL = "update Item set NameOfItem=?, Price =?, Color =?,Quantity =?,Descrition =?,Category= ? Where id =?";

    private static final String DELETE_ITEM_SQL = "delete from Item Where id =?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassWord);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public List<Item> selectAllitem() throws SQLException {
        List<Item>  items = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ITEM);){
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("NameOfItem");
                String price = resultSet.getString("price");
                String color = resultSet.getString("Color");
                String quantity = resultSet.getString("Quantity");
                String mota = resultSet.getString("Descrition");
                String catagory = resultSet.getString("catagory");
                items.add(new Item(id,name,price,color,quantity,mota,catagory));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return items;
    }

    public boolean updateItem(Item item) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ITEM_SQL)) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getPrice());
            statement.setString(3, item.getColor());
            statement.setString(4, item.getQuatity());
            statement.setString(5, item.getMota());
            statement.setString(6, item.getCategory());
            statement.setInt(7, item.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteItem(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ITEM_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public void updateItem(HttpServletRequest request, HttpServletResponse response) {
    }
}
