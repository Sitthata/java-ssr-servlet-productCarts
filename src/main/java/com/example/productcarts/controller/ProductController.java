package com.example.productcarts.controller;

import com.example.productcarts.model.Product;
import com.example.productcarts.model.ProductCart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductCart productCart = (ProductCart) session.getAttribute("productCart");
        if (productCart == null) {
            productCart = new ProductCart();
            session.setAttribute("productCart", productCart);
        }
        request.setAttribute("cartList", productCart.getProductCart());
        request.getRequestDispatcher("product-cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectedProductId = request.getParameterValues("selectedId");
        System.out.println(Arrays.toString(selectedProductId));
        if (selectedProductId == null) {
            request.setAttribute("message", "Please select the product to continue");
            doGet(request, response);
            return;
        }
        HttpSession session = request.getSession();
        ProductCart productCart = (ProductCart) session.getAttribute("productCart");
        List<Product> selectedCart = (List<Product>) session.getAttribute("selectedCart");
        if (selectedCart == null) {
            selectedCart = new ArrayList<>();
        }
        for (String id : selectedProductId) {
            Product selectedProduct = productCart.findById(id);
            if (selectedProduct != null) selectedCart.add(selectedProduct);
        }
        session.setAttribute("selectedCart", selectedCart);
        response.sendRedirect("SelectedCart");
    }
}