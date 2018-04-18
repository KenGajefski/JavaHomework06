package MillennialMart;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class HW6 {

    private static Customer top = null;
    private static int itemMin = 1;
    private static int itemMax = 40;
    private static int costMin = 1;
    private static int costMax = 200;


    public static void insertCustomer(){

        int items = ThreadLocalRandom.current().nextInt(itemMin, itemMax + 1);
        double tempCost = ThreadLocalRandom.current().nextDouble(costMin, costMax);
        // Without going through the DecimalFormat for the cost, all values get truncated to one decimal spot of value 0
        DecimalFormat df = new DecimalFormat("###.##");
        double cost = Double.parseDouble(df.format(tempCost));
        Customer temp = new Customer(items, cost);

        temp.setNext(top);
        top = temp;
    }

    public static Customer removeCustomer(){
        Customer temp;

        if (top == null)
            return null;
        else{
            temp = top;
            top = top.getNext();
            return temp;
        }

    }

    public static void printCustomers(){
        Customer temp = top;

        while (temp != null){
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {


    }

}
