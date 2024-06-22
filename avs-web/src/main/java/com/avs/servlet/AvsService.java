package com.avs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.avs.db.Address;
import com.avs.db.AvsRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AvsService extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Hello World</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Retrieve form data
        String pincode = request.getParameter("pincode");
        PrintWriter out = response.getWriter();

        try {
            AvsRepository avsRepo = new AvsRepository();
            Address searchedAddress = avsRepo.queryData(Integer.valueOf(pincode));

            // Example output to confirm receipt of data
            out.println("<html><body>");
            out.println("<h1>Address Form Data Received</h1>");
            out.println("<p>Locality: " + searchedAddress.getLocality() + "</p>");
            out.println("<p>Pincode: " + searchedAddress.getPincode() + "</p>");
            out.println("<p>Sub-district: " + searchedAddress.getSubDistname() + "</p>");
            out.println("<p>District: " + searchedAddress.getDistrictname() + "</p>");
            out.println("<p>State: " + searchedAddress.getStateName() + "</p>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h1>Error</h1>");
            out.println("<p>Invalid pincode format.</p>");
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("<html><body>");
            out.println("<h1>Error</h1>");
            out.println("<p>An error occurred while processing your request.</p>");
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}
