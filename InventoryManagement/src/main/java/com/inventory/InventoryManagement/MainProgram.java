package com.inventory.InventoryManagement;

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {

            System.out.println("\n===== PRODUCT INVENTORY SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    Product product = new Product(
                            id, name, category, price, quantity
                    );

                    dao.addProduct(product);
                    break;

                case 2:
                    dao.viewProducts();
                    break;

                case 3:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter new Price: ");
                    double newPrice = sc.nextDouble();

                    System.out.print("Enter new Quantity: ");
                    int newQuantity = sc.nextInt();

                    dao.updateProduct(updateId, newPrice, newQuantity);
                    break;

                case 4:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteProduct(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    HibernateUtil.getSessionFactory().close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}