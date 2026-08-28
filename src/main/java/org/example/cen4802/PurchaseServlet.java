package org.example.cen4802;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class PurchaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        double total = price * quantity;

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Purchase Calculator</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Purchase Calculator</h1>");

        out.println("<p>Price: $" + String.format("%.2f", price) + "</p>");
        out.println("<p>Quantity: " + quantity + "</p>");

        out.println("<h2>Total: $" + String.format("%.2f", total) + "</h2>");

        out.println("<a href='index.jsp'>Calculate Another Purchase</a>");

        out.println("</body>");
        out.println("</html>");
    }
}