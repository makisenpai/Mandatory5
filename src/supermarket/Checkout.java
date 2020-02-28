/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Martin
 */
public class Checkout {
    // amount of time per prouct (to scan barcode)
    public static final int PROD_DURATION = 2;
    // amount of time to pay
    public static final int PAY_DURATION = 10;
    //total time for checkout = PAY_DURATION + PROD_DURATION*customer.numProd

    SuperMarket shop;
    String name;

    public static Queue<Customer> q;
    public static ArrayList<Integer> l;

    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout" + i;
        this.q = new LinkedList<>();
    }
    public static void addToQueue(Customer c){
        q.add(c);
        int x = q.size();
        l.add(x);
    }

    public static Customer removeFromQueue(){
        Customer c = q.remove();
        int x = q.size();
        l.add(x);
        return c;
    }

    public static int avgQSize(){
        int avg = 0;
        int total = 0;
        for(int i = 0; i <l.size(); i++){
            total =+ l.get(i);
        }
         avg = total / l.size();
        return avg;
    }

    public static int maxQSize(){
        int max = 0;
        int x = 0;
        for(int i = 0; i <l.size(); i++){
            if(l.get(i) < l.get(x)){
                i = x ;
            }
            max = i;
        }
        return max;
    }

    /**
     *
     * @return the size of the queue, how many customers are in queue
     */
}
