package MillennialMart;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HW6 {

    private static Customer top = null;

    private static int left;
    private static int total;
    private static int current;
    private static final int itemMin = 1;
    private static final int itemMax = 40;
    private static final int costMin = 1;
    private static final int costMax = 200;

    private static final String COL_ONE = "%-20s";
    private static final String COL_TWO_INT = "%10d";
    private static final String COL_TWO_DUB = "%10.2f";

    public static void insertCustomer(){

        int items = ThreadLocalRandom.current().nextInt(itemMin, itemMax + 1);
        double tempCost = ThreadLocalRandom.current().nextDouble(costMin, costMax);
        // Without going through the DecimalFormat for the cost, all values get truncated to one decimal spot of value 0
        DecimalFormat df = new DecimalFormat("###.##");
        double cost = Double.parseDouble(df.format(tempCost));

        Customer temp = new Customer(items, cost);

        temp.setNext(top);
        top = temp;
        current++;
        total++;
    }

    public static Customer removeCustomer(){
        Customer temp;

        if (top == null || top.getNext() == null) {
            // Since the if statement in Main is ignored, this will add a new customer if the stack is empty
            insertCustomer();
            return null;
        }
        else{
            temp = top;
            top = top.getNext();
            current--;
            return temp;
        }

    }

    public static void printCustomers(){
        Customer temp = top;

        while (temp != null){
            temp.customerToString();
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            // For some reason, this is ALWAYS ignored. Forced to implement in removeCustomer
            if (top == null){
                insertCustomer();
            }

            boolean decideNext = random.nextBoolean();
            if (decideNext) {
                insertCustomer();
            }
            else {
                removeCustomer();
            }

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                System.out.println("Error in Thread.sleep.");
            }
        }
        // End of for loop

        System.out.println("Customers in queue");
        printCustomers();

        System.out.println("Summary Information");
        System.out.printf(COL_ONE + COL_TWO_INT + "\n", "Customers handled:", total - current);
        System.out.printf(COL_ONE + COL_TWO_INT + "\n", "Customers in queue:", current);
        System.out.printf(COL_ONE + COL_TWO_INT + "\n","Total customers:", total);
        System.out.printf(COL_ONE + COL_TWO_INT + "\n", "Total items:", Customer.getTotalItems());
        System.out.printf(COL_ONE + COL_TWO_DUB + "\n", "Total cost:", Customer.getTotalCost());


        System.out.println("End of Millennial Mart");
    }

}
