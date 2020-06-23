package edu.psu.abington.ist.ist242;
/*
Project: Lab 8 Pizza Shop Ordering Syetem
Purpose Details: A text based pizza shop order handling system: show a menu, handle an order with menu items, and accept the transaction payment
Course: IST 242
Author: Khaled Aldhanhani
Date Developed: 6/20/2020
Last Date Changed:
Revision: 3
        */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int PIZZA_MENU_ID = 1;
    static final int ADDONS_MENU_ID = 2;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Pizza Shop!");
        Customer theCustomer = generateCustomer(scan);

        System.out.print("\nPress 'm' to see the menu: ");
        char optionMenu = scan.next().charAt(0);

        while (optionMenu != 'm') {
            System.out.print("Press 'm' to see the menu: ");
            optionMenu = scan.next().charAt(0);
        }

        // Pizza ordering starts here...
        char optionOrderMore;
        ArrayList<Item> orderedItems = new ArrayList <>();
        Item pizzaOrdered;
        Menu pizzaMenu = generatePizzaMenu();
        Menu addOnsMenu = generateAddOnsMenu();

        do {
            // Show Pizza menu
            pizzaMenu.printMenu();

            System.out.print("Pick item id from the pizza menu: ");
            int pizzaItemId = scan.nextInt();

            // Add pizza ordered to list of orderedItems
            pizzaOrdered = pizzaMenu.getMenu().get(pizzaItemId - 1);
            orderedItems.add(pizzaOrdered);
            pizzaOrdered.numTimesOrdered++;

            System.out.println("Would you like to add some add-ons to the pizza? y or n: ");
            char optionOrderAddOns = scan.next().charAt(0);

            conditionalOrderAddOns(addOnsMenu, scan, optionOrderAddOns, orderedItems);

            System.out.print("\nWould you like to order more pizzas? y or n: ");
            optionOrderMore = scan.next().charAt(0);

        } while (optionOrderMore == 'y');

        // Build an Order object
        Order myOrder = new Order(1, theCustomer, orderedItems);

        // Build a Transaction object
        Transaction t1 = new Transaction(100, myOrder, PaymentType.CASH);

        t1.printReceipt();

    } // end main()

    public static Menu generatePizzaMenu() {
        List<Item> pizzas = new ArrayList <>();
        pizzas.add(new Item(1, "Pepperoni Pizza (" +
                PizzaSize.SMALL.toString() + ")", PizzaSize.SMALL,
                8.99, true));
        pizzas.add(new Item(2, "Pepperoni Pizza (" +
                PizzaSize.MEDIUM.toString() + ")", PizzaSize.MEDIUM,
                12.99, true));
        pizzas.add(new Item(3, "Pepperoni Pizza (" +
                PizzaSize.LARGE.toString() + ")", PizzaSize.MEDIUM,
                16.99, true));
        pizzas.add(new Item(4, "Pepperoni Pizza (" +
                PizzaSize.EXTRALARGE.toString() + ")", PizzaSize.EXTRALARGE,
                20.99, true));
        pizzas.add(new Item(5, "Hawaiian Pizza (" +
                PizzaSize.SMALL.toString() + ")", PizzaSize.SMALL,
                9.99, true));
        pizzas.add(new Item(6, "Hawaiian Pizza (" +
                PizzaSize.MEDIUM.toString() + ")", PizzaSize.MEDIUM,
                15.99, true));
        pizzas.add(new Item(7, "Hawaiian Pizza (" +
                PizzaSize.LARGE.toString() + ")", PizzaSize.LARGE,
                19.99, true));
        pizzas.add(new Item(8, "Hawaiian Pizza (" +
                PizzaSize.EXTRALARGE.toString() + ")", PizzaSize.EXTRALARGE,
                25.99, true));

        return new Menu(PIZZA_MENU_ID, new ArrayList <>(pizzas));
    } // end generatePizzaMenu()

    public static Menu generateAddOnsMenu() {
        List <Item> addOns = new ArrayList <>();

        addOns.add(new Item(11, "Canadian Bacon", 2.50, true));
        addOns.add(new Item(22, "Ground Beef", 3.25, true));
        addOns.add(new Item(33, "Onions", 1.00, true));
        addOns.add(new Item(44, "Pepperoni", 2.00, true));
        addOns.add(new Item(55, "Pineapple", 1.75, true));
        addOns.add(new Item(66, "Mushrooms", 1.00, true));
        addOns.add(new Item(77, "Black Olives", 1.00, true));
        addOns.add(new Item(88, "Sausage", 3.25, true));

        return new Menu(ADDONS_MENU_ID, new ArrayList <>(addOns));
    } // end generateAddOnsMenu()

    /**
     * This method provides the user the option to add add-ons to pizza.
     *
     * @param m      the menu
     * @param s      Scanner object
     * @param choice user choice
     * @param order  ArrayList of Item
     */
    public static void conditionalOrderAddOns(Menu m, Scanner s, char choice, ArrayList <Item> order) {
        while (choice == 'y') {
            m.printMenu();
            System.out.print("Pick item id from the add-ons menu: ");
            int addOnsItemId = s.nextInt();
            int idx = -1;
            for (Item addOn : Collections.unmodifiableList(m.getMenu())) {
                if (addOn.getItemId() == addOnsItemId) {
                    idx = m.getMenu().indexOf(addOn);
                } // end if
            } // end for

            // Add add-on ordered to list of orderedItems
            Item addOnOrdered = m.getMenu().get(idx);
            order.add(addOnOrdered);
            addOnOrdered.numTimesOrdered++;

            System.out.print("Would you like to add some add-ons to the pizza? y or n: ");
            choice = s.next().charAt(0);
        } // end while
    } // end conditionalOrderAddOns()

    /**
     * This creates a Customer object.
     *
     * @param s Scanner object
     *
     * @return Customer object
     */
    public static Customer generateCustomer(Scanner s) {
        System.out.print("Please enter customer name: ");
        String cName = s.next();

        System.out.print("\nWould you like to enter customer's phone #? y or n: ");
        char optionPhone = s.next().charAt(0);

        while (optionPhone != 'y' && optionPhone != 'n') {
            System.out.println("Choose only either y or n.");
            System.out.print("Would you like to enter customer's phone #? y or n: ");
            optionPhone = s.next().charAt(0);
        }

        Customer newCustomer;
        if (optionPhone == 'y') {
            System.out.print("Enter phone #: ");
            String phoneNum = s.next();
            newCustomer = new Customer(cName, phoneNum);
        } else { //optionPhone == 'n'
            newCustomer = new Customer(cName);
        }

        return newCustomer;
    } // end generateCustomer()

}












