package servlet;

import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.PathToJsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private List<Product> products = new ArrayList<>();

    {
        products.add(new Product(1,"Mars","sweet",200,1,null));
        products.add(new Product(2,"Mors","drink",30,10,null));
        products.add(new Product(3,"Tea","drink",50,100,null));
        products.add(new Product(4,"Tesla","a car",20000,0,null));
        products.add(new Product(5,"QQQ","QQQ",999,10,null));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(products);
        req.setAttribute("products",products);
        req.getRequestDispatcher(PathToJsp.create("home.jsp")).forward(req,resp);
    }
}
