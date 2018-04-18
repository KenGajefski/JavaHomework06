package MillennialMart;

import java.util.concurrent.ThreadLocalRandom;

public class HW6 {

    private static int itemMin = 1;
    private static int itemMax = 40;
    private static int costMin = 1;
    private static int costMax = 200;


    public static void insertCustomer(Customer ptr){

        int items = ThreadLocalRandom.current().nextInt(itemMin, itemMax + 1);
        double cost = ThreadLocalRandom.current().nextDouble(costMin, costMax);

        Customer test = new Customer(items, cost);

    }

    /*public static Customer removeCustomer(){
        Customer test;

        return test;
    }*/

    public static void printCustomers(){

    }

    public static void main(String[] args) {


    }

}
