package supermarket;

import eventsim.Event;

public class CheckoutEvent extends Event {
Customer customer;
    public CheckoutEvent(int checkoutTime, Customer customer){
        super(checkoutTime);
        this.customer = customer;

    }

    public void checkOut(){

        this.setTime(this.getTime() + customer.getCheckoutDuration());
    }

    @Override
    public Event happen() {
        customer = Checkout.removeFromQueue();
        return new EndShoppingEvent(customer);
    }
}
