package com.company;
import java.util.Scanner;
public class Homework1 {
    static double funds = 100; // gave an error of non_static so made it static as prompted by intellij
    static Scanner scnr = new Scanner(System.in); // gave an error of non-static variable scnr cannot be reference so put static scanner...

    public static void main(String [] args){
        double totalCost = 0;
        int order;


        while (true){
            order = Menu();
            if (order == 1) {
                totalCost = MenuView(totalCost);
            }else if (order == 2){
                if(TotalPaymentDue(totalCost)){
                    totalCost=0;

                }

                break;
            }else if (order == 3){
                funds += 5;
                System.out.printf("Credit available: $%.2f%n", funds);
            }else if(order == 4){
                System.out.println("Current order balance has been cleared. Current due: $0.00");
                totalCost =0;

            }else{
                break;
            }
        }



    }
    public static int Menu(){

        System.out.println("Please select a menu item from the list below:");
        System.out.println("1 – View item menu");
        System.out.println("2 – Pay total due");
        System.out.println("3 – Add $5 in credit");
        System.out.println("4 – Clear order");
        int order = scnr.nextInt();
        if (order >= 1 && order <= 4 ){
            return order;
        }
        else{
            System.out.println("Please enter a valid option!");
            Menu();
        }
        return 0; // gave an error of return statement so just put this so put this in order to terminate the main function with this return statement.
    }
    // first MenuView gave an error because put void instead of double
    public static double MenuView(double totalCost)  {
        int option; // option that the user will put in for the menu to pop up
        System.out.println("What would you like to add to your order?");
        System.out.println("(1) Toaster: $19.99");
        System.out.println("(2) Coffee maker: $29.49");
        System.out.println("(3) Waffle maker: $15.79");
        System.out.println("(4) Blender: $24.99");
        System.out.println("(5) Kettle: $24.99");
        System.out.println("(6) Go to the main menu");
        System.out.printf("Your current total is: $%.2f%n", totalCost);


        option = scnr.nextInt(); // first put this before the menu so it was asking for the input before showing the menu itself

        if (option == 6) {
            return totalCost;
        }else if(option == 1){
            System.out.println("You have added a Toaster to your order.");
            totalCost += 19.99;
        }else if(option == 2){
            System.out.println("You have added a Coffee maker to your order.");
            totalCost += 29.49;
        }else if(option == 3){
            System.out.println("You have added a Waffle maker to your order.");
            totalCost += 15.79;
        }else if(option == 4){
            System.out.println("You have added a Blender to your order.");
            totalCost += 24.99;
        }else if(option == 5){
            System.out.println("You have added a Kettle to your order.");
            totalCost += 24.99;
        }else{
            System.out.println("Invalid item number please try again.");

        }
        return MenuView(totalCost);

    }

    public static boolean TotalPaymentDue(double totalCost) {
        double payment = totalCost;
        if (payment > 50){
            if(payment <= funds * 0.2 +funds){

                System.out.printf("Your total due is: $%.2f%n", payment);
                System.out.printf("Thank you! You saved: $%.2f Your change is: $%.2f\n",(payment * 0.2),(funds - ((payment - (payment * 0.2))  + (((payment - payment * 0.2)) * 0.085))));
                System.out.println("Your items will be on their way soon!");
            }else
            {
                System.out.printf("Your total due is: $%.2f%n", payment);
                System.out.println("Insufficient funds!");
                return false;

            }
        }else
        {
            System.out.printf("Your total due is: $%.2f%n", payment);
            System.out.printf("Thank you!  Your change is: $%.2f%n", (funds - (payment + payment * 0.085)));
            System.out.println("Your items will be on their way soon!");
        }
        return true;
    }



}
