package com.VendingMachine;

import java.util.Scanner;

public class VendingMachineTest {

    static Scanner scanner = new Scanner(System.in);
    private static VendingMachine vendingMachine;

    public static void main(String[] args) {

        vendingMachine = new VendingMachine();

        boolean quit = false;
        int choice = 0;

        System.out.println("----------------------------------");
        System.out.println("*** Welcome to Vending Machine ***");
        System.out.println("----------------------------------");

        while (!quit) {

            System.out.println("\n --- Please Insert Coin ---");

            insertCoin();

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    vendingMachine.addAvailableBalance(1);
                    System.out.println("\nTotal Balance : " + vendingMachine.availableBalance + " Cents");
                    break;
                case 5:
                    vendingMachine.addAvailableBalance(5);
                    System.out.println("\nTotal Balance : " + vendingMachine.availableBalance + " Cents");
                    break;
                case 10:
                    vendingMachine.addAvailableBalance(10);
                    System.out.println("\nTotal Balance : " + vendingMachine.availableBalance + " Cents");
                    break;
                case 25:
                    vendingMachine.addAvailableBalance(25);
                    System.out.println("\nTotal Balance : " + vendingMachine.availableBalance + " Cents");
                    break;
                case 9:
                    selectProduct();
                    quit = true;
                    break;
                case 0:
                    quit = true;
                    vendingMachine.refund();
                    break;
                default:
                    System.out.println("\n??? Please Insert A Valid Coin ???");
                    break;
            }

        }

    }

    public static void insertCoin () {

        System.out.println("\nPress");
        System.out.println("\t 1  -> To Insert Penny");
        System.out.println("\t 5  -> To Insert Nickel");
        System.out.println("\t 10 -> To Insert Dime");
        System.out.println("\t 25 -> To Insert Quarter");
        System.out.println("\t 9  -> To Proceed to Products");
        System.out.println("\t 0  -> To Reset The Process");

    }

    public static void selectProduct () {

        boolean quit = false;
        int choice = 0;

        System.out.println("\nYour Current Balance Is : " + vendingMachine.availableBalance + " Cents");

        while (!quit) {

            System.out.println("\nPlease Choose Your Product ");
            System.out.println("--------------------------");

            productList();

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    vendingMachine.select("Coke");
                    System.out.println("\nRemaining Balance : " + vendingMachine.availableBalance + " Cents");
                    break;
                case 2:
                    vendingMachine.select("Pepsi");
                    System.out.println("\nRemaining Balance : " + vendingMachine.availableBalance + " Cents");
                    break;
                case 3:
                    vendingMachine.select("Soda");
                    System.out.println("\nRemaining Balance : " + vendingMachine.availableBalance + " Cents");
                    break;
                case 8:
                    vendingMachine.purchase();
                    quit = true;
                    break;
                case 9:
                    vendingMachine.refund();
                    quit = true;
                    break;
                default:
                    System.out.println("\n??? Wrong Choice, Please try again ???");
                    break;
            }

        }

    }

    public static void productList () {

        System.out.println("\nPress");
        System.out.println("\t 1  -> To Select Coke  : 25 Cents");
        System.out.println("\t 2  -> To Select Pepsi : 35 Cents");
        System.out.println("\t 3  -> To Select Soda  : 45 Cents");
        System.out.println("\t 8  -> To Complete Purchase");
        System.out.println("\t 9  -> To Cancel Purchase and Get Refund");
    }


}
