package MillennialMart;

public class Customer {

    private static int totalCustomers = 0;
    private static double totalCost = 0;
    private static int totalItems = 0;
    private int ID  ;
    private int items;
    private double cost;
    private Customer next;

    public Customer(){
        totalCustomers = totalCustomers + 1;
        ID = -1;
        items = -1;
        cost = -1;
        next = null;
    }

    public Customer(int items, int cost){
        totalCustomers = totalCustomers + 1;
        totalCost = totalCost + cost;
        totalItems = totalItems + items;
        ID = totalCustomers;
        this.items = items;
        this.cost = cost;
        next = null;
    }
}
