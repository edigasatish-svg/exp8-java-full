package com.inventory.InventoryManagement;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO {

    // 1. ADD PRODUCT
    public void addProduct(Product product) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(product);

        transaction.commit();
        session.close();

        System.out.println("Product added successfully!");
    }

    // 2. VIEW PRODUCTS
    public void viewProducts() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        var products = session.createQuery("from Product", Product.class).getResultList();

        for (Product product : products) {
            System.out.println(
                "ID: " + product.getId() +
                " | Name: " + product.getName() +
                " | Category: " + product.getCategory() +
                " | Price: " + product.getPrice() +
                " | Quantity: " + product.getQuantity()
            );
        }

        session.close();
    }

    // 3. UPDATE PRODUCT
    public void updateProduct(int id, double price, int quantity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Product product = session.get(Product.class, id);

        if (product != null) {
            product.setPrice(price);
            product.setQuantity(quantity);

            session.merge(product);

            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found!");
        }

        transaction.commit();
        session.close();
    }

    // 4. DELETE PRODUCT
    public void deleteProduct(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Product product = session.get(Product.class, id);

        if (product != null) {
            session.remove(product);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }

        transaction.commit();
        session.close();
    }
}