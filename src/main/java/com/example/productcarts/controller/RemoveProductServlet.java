package com.example.productcarts.controller;

import com.example.productcarts.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RemoveProductServlet", value = "/SelectedCart")
public class RemoveProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> selectedProduct = (List<Product>) session.getAttribute("selectedCart");
        if (selectedProduct == null) {
            response.sendRedirect("ProductController");
            return;
        }
        double totalPrice = selectedProduct.stream().mapToDouble(Product::getPrice).sum();
        request.setAttribute("total", totalPrice);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("productId");
        HttpSession session = request.getSession();
        List<Product> selectedProduct = (List<Product>) session.getAttribute("selectedCart");
        Product productToRemove = selectedProduct.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
        selectedProduct.remove(productToRemove);
        doGet(request, response);
    }
}