package Web;

import DAO.ItemDAO;
import Model.Item;
import javafx.scene.chart.ScatterChart;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ItemServlet", urlPatterns = "/")
public class ItemServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID =1L;
    private ItemDAO itemDAO = new ItemDAO();
    public void init (){
        itemDAO = new ItemDAO();
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/new":
                showNewForm(request,response);
                break;
            case "/insert":
                insertItem(request,response);
                break;
            case "/delete":
                try {
                    deleteItem(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit":
                showEditForm(request,response);
                break;
            case "/Update":
                itemDAO.updateItem(request,response);
                break;
            default:
                try {
                    listUser(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Item> listItem = itemDAO.selectAllitem();
        request.setAttribute("listItem",listItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request,response);
    }

   private void updateItem(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("NameofItem");
    String price =request.getParameter("Price");
    String quantity =request.getParameter("Quantity");
    String color = request.getParameter("Color");
    String mota = request.getParameter("Descrition");
    String category =request.getParameter("Category_id");

    Item item = new Item(id,name,price,quantity,color,mota,category);
    itemDAO.updateItem(item);
    response.sendRedirect("list");


   }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
    int id =Integer.parseInt(request.getParameter("id"));
    itemDAO.deleteItem(id);
    response.sendRedirect("list");
    }

    private void insertItem(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
    }
}
