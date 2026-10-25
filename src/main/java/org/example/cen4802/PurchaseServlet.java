package org.example.cen4802;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@WebServlet("/calculate")
public class PurchaseServlet extends HttpServlet {

    private static final Logger LOGGER =
            Logger.getLogger(PurchaseServlet.class.getName());

    static {
        try (InputStream input =
                     PurchaseServlet.class.getClassLoader()
                             .getResourceAsStream("logging.properties")) {

            if (input != null) {
                LogManager.getLogManager().readConfiguration(input);
            }

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,
                    "Unable to load logging configuration", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        LOGGER.fine("Purchase calculation request received");

        try {
            double price =
                    Double.parseDouble(request.getParameter("price"));

            int quantity =
                    Integer.parseInt(request.getParameter("quantity"));

            double discountPercent =
                    Double.parseDouble(request.getParameter("discount"));

            LOGGER.info(
                    "Calculation requested: price=" + price +
                            ", quantity=" + quantity +
                            ", discount=" + discountPercent + "%"
            );

            if (discountPercent >= 50) {
                LOGGER.warning(
                        "High discount entered: " +
                                discountPercent + "%"
                );
            }

            if (price < 0 || quantity <= 0 ||
                    discountPercent < 0 ||
                    discountPercent > 100) {

                LOGGER.severe(
                        "Invalid purchase input: price=" + price +
                                ", quantity=" + quantity +
                                ", discount=" + discountPercent + "%"
                );

                response.sendError(
                        HttpServletResponse.SC_BAD_REQUEST,
                        "Invalid purchase information"
                );

                return;
            }

            PurchaseCalculator calculator =
                    new PurchaseCalculator();

            double subtotal =
                    calculator.calculateSubtotal(price, quantity);

            double discountAmount =
                    calculator.calculateDiscount(
                            subtotal, discountPercent);

            double discountedSubtotal =
                    subtotal - discountAmount;

            double salesTax =
                    calculator.calculateSalesTax(
                            discountedSubtotal);

            double finalTotal =
                    calculator.calculateFinalTotal(
                            subtotal, discountPercent);

            LOGGER.info(
                    "Calculation completed: subtotal=" +
                            String.format("%.2f", subtotal) +
                            ", discountAmount=" +
                            String.format("%.2f", discountAmount) +
                            ", salesTax=" +
                            String.format("%.2f", salesTax) +
                            ", finalTotal=" +
                            String.format("%.2f", finalTotal)
            );

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Purchase Calculator</title>");
            out.println("</head>");

            out.println("<body>");

            out.println("<h1>Purchase Calculator</h1>");

            out.println("<p>Price: $" +
                    String.format("%.2f", price) + "</p>");

            out.println("<p>Quantity: " +
                    quantity + "</p>");

            out.println("<p>Subtotal: $" +
                    String.format("%.2f", subtotal) + "</p>");

            out.println("<p>Discount (" +
                    String.format("%.2f", discountPercent) +
                    "%): -$" +
                    String.format("%.2f", discountAmount) +
                    "</p>");

            out.println("<p>Sales Tax (6.5%): $" +
                    String.format("%.2f", salesTax) + "</p>");

            out.println("<h2>Final Total: $" +
                    String.format("%.2f", finalTotal) +
                    "</h2>");

            out.println(
                    "<a href='index.jsp'>" +
                            "Calculate Another Purchase</a>"
            );

            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {

            LOGGER.log(
                    Level.SEVERE,
                    "Invalid numeric input received",
                    e
            );

            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Price, quantity, and discount must be numbers"
            );
        }
    }
}