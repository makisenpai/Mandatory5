package supermarket;

import eventsim.Event;

public class ShoppingFinishEvent extends Event {

    Customer customer;

    public ShoppingFinishEvent(Customer customer){
        super(customer.shoppingDuration);
        this.customer = customer;
    }

    @Override
    public  Event happen(){
        return new PickCheckoutPointEvent(customer);
    }
}
