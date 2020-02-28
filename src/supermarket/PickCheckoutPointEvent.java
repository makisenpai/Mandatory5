package supermarket;

import eventsim.Event;

public class PickCheckoutPointEvent extends Event {
    Customer customer;

    public PickCheckoutPointEvent(Customer customer){

        super(customer.endShoppingTime);
        this.customer = customer;

    }

    public int cTime(){

        //checks if there is another person in queue
        if (Checkout.q.size() >= 0) {

            //Adds the duration of every otherperson into queueWaitTime
            for (Customer customer : Checkout.q) {
                customer.setCheckoutTime(Checkout.PAY_DURATION + (Checkout.PROD_DURATION * customer.getNumProducts()));
                customer.queueWaitDuration = customer.queueWaitDuration + customer.getCheckoutDuration();
            }
        } else {
            // dose the same as the for loop just once for the current customer
            customer.setCheckoutDuration(Checkout.PAY_DURATION + Checkout.PROD_DURATION * customer.getNumProducts());
            //sets wait time to 0 sins there is no customers in the queue
            customer.queueWaitDuration = 0;
        }

        customer.setCheckoutTime(customer.queueWaitDuration + super.getTime());
        return customer.getCheckoutTime() - customer.getCheckoutDuration();
    }


    @Override
    public Event happen() {
        Checkout.addToQueue(customer);
        return new CheckoutEvent(cTime(), customer);
    }
}
