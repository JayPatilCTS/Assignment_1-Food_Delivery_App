import java.util.ArrayList;

class InvalidRestaurantException extends Exception {
    public InvalidRestaurantException(String message) {
        super(message);
    }
}

class EmptyOrderListException extends Exception {
    public EmptyOrderListException(String message) {
        super(message);
    }
}

class DeliverySystem {
    private ArrayList<Restaurant> restaurants;
    private ArrayList<Order> orders;

    public DeliverySystem() {
        restaurants = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void placeOrder(Order order) throws InvalidRestaurantException {
        boolean exists = false;
        for (Restaurant r : restaurants) {
            if (r.getId() == order.getRestaurantId()) {
                exists = true;
                break;
            }
        }
        if (!exists) throw new InvalidRestaurantException("Restaurant ID " + order.getRestaurantId() + " not found!");
        orders.add(order);
    }

    public ArrayList<Order> getOrdersByRestaurant(int restaurantId) throws EmptyOrderListException {
        ArrayList<Order> result = new ArrayList<>();
        for (Order o : orders) {
            if (o.getRestaurantId() == restaurantId) result.add(o);
        }
        if (result.isEmpty()) throw new EmptyOrderListException("No orders found for restaurant ID " + restaurantId);
        return result;
    }

    public double calculateTotalRevenue(int resId) throws EmptyOrderListException {
        if (orders.isEmpty()) throw new EmptyOrderListException("No orders placed yet!");
        double total = 0;
        for (Order o : orders) {
            if(o.getRestaurantId() == resId){
                total += o.totalAmount();

            }
        }
        return total;
    }

    // Bonus: Find Top-rated Restaurant
    public Restaurant getTopRatedRestaurant() {
        Restaurant best = null;
        double maxRating = 0;
        for (Restaurant r : restaurants) {
            if (r.getAverageRating() > maxRating) {
                maxRating = r.getAverageRating();
                best = r;
            }
        }
        return best;
    }

    // Bonus: List orders > ₹500
    public ArrayList<Order> getHighValueOrders() {
        ArrayList<Order> result = new ArrayList<>();
        for (Order o : orders) {
            if (o.totalAmount() > 500) result.add(o);
        }
        return result;
    }


























































































//    // Bonus: String search for restaurants containing keyword
//    public ArrayList<Restaurant> searchRestaurantsByKeyword(String keyword) {
//        ArrayList<Restaurant> result = new ArrayList<>();
//        for (Restaurant r : restaurants) {
//            if (r.getName().toLowerCase().contains(keyword.toLowerCase())) {
//                result.add(r);
//            }
//        }
//        return result;
//    }
}
