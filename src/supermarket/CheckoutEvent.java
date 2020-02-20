package supermarket;

import eventsim.Event;

public class CheckoutEvent extends Event {
Customer customer;
    public CheckoutEvent(int checkoutTime, Customer customer){
        super(checkoutTime);
        this.customer = customer;

    }

    public void checkOut(){
        Customer customer = Checkout.q.remove();
        this.setTime(this.getTime() + customer.getCheckoutDuration());
    }

    @Override
    public Event happen() {
        checkOut();
        return new EndShoppingEvent(customer);
    }
}
