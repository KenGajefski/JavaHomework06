package MillennialMart;

public class Customer {

    private static int totalCustomers = 0;
    private static double totalCost = 0;
    private static int totalItems = 0;
    private int ID;
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

    public Customer(int items, double cost){
        totalCustomers = totalCustomers + 1;
        totalCost = totalCost + cost;
        totalItems = totalItems + items;
        ID = totalCustomers;
        this.items = items;
        this.cost = cost;
        next = null;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Customer getNext() {
        return next;
    }

    public void setNext(Customer next) {
        this.next = next;
    }

    public static int getTotalCustomers(){
        return totalCustomers;
    }

    public static int getTotalItems(){
        return totalItems;
    }

    public static double getTotalCost(){
        return totalCost;
    }

    public boolean equals(Customer b)
    {
        if (this.ID == (b.ID) && this.next == (b.next))
            return true;
        else
            return false;
    }

    public void customerToString()
    {
        System.out.printf("%8s" + "%8s" + "%11s" + "\n", "ID", "Items", "Cost ($)");
        System.out.printf("%8d" + "%8d" + "%11.2f" + "\n", ID, items, cost);

    }
}
