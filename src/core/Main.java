/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import entities.Money;
import entities.Order;
import entities.Product;
import services.MenuService;
import services.MoneyService;
import services.OrderService;
import services.ProductService;

/**
 *
 * @author Lenovo
 */
public class Main {

    public static void main(String[] args) {
        int choice;
        int balance = 0;
        float winRate = 0.1F;
        int budget = 50000;

        ProductService products = new ProductService();
        products.addAProduct(new Product("Coke", 10000));
        products.addAProduct(new Product("Pepsi", 10000));
        products.addAProduct(new Product("Soda", 20000));

        MenuService menu = new MenuService(5);
        products.forEach((product) -> {
            menu.add(product.toString());
        });

        menu.add("Top-up");
        menu.add("Cancel request");

        MoneyService money = new MoneyService();
        money.addMoney(new Money(10000));
        money.addMoney(new Money(20000));
        money.addMoney(new Money(50000));
        money.addMoney(new Money(100000));
        money.addMoney(new Money(200000));

        MenuService topUpMenu = new MenuService(money.size() + 1);
        money.forEach((item) -> {
            topUpMenu.add(item.toString());
        });
        topUpMenu.add("Back");

        OrderService orders = new OrderService();
        do {
            System.out.println("\nVENDINH MACHINE\n***********");
            System.out.println("Balance: " + balance + " VND");
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    if (balance < products.get(choice - 1).getPrice()) {
                        System.out.println("Not enough balance!");
                    } else {
                        orders.add(new Order(products.get(choice - 1)));
                        balance -= products.get(choice - 1).getPrice();
                        winRate = orders.calculateWinRate(budget, winRate);
                        if (orders.isResetBudget()) {
                            budget = 50000;
                        }
                        if (orders.isEnoughCondition() && orders.isWin(winRate)) {
                            System.out.println("You received a free lucky product!");
                        }

                        System.out.println("Order success!");
                    }
                    break;
                case 4:
                    System.out.println("\nTOP-UP MENU\n***********");
                    int topUpChoice = topUpMenu.getChoice();
                    switch (topUpChoice) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            balance += money.get(topUpChoice - 1).getValue();
                            break;
                        case 6:
                            break;
                    }
                    break;
                case 5:
                    if (balance != 0) {
                        balance = 0;
                        System.out.println("Cancel success! You received a refund!");
                    } else {
                        System.out.println("Not enough balance!");
                    }
                    break;
            }
        } while (true);
    }
}
