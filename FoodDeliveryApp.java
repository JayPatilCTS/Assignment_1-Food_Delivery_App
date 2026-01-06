import java.util.Scanner;

public class FoodDeliveryApp {
    public static void main(String[] args) {
        try {
            DeliverySystem system = new DeliverySystem();

            // Add 3 restaurants
            system.addRestaurant(new Restaurant(1, "A2B", "South Indian", new int[]{4,5,3,4,5}));
            system.addRestaurant(new Restaurant(2, "Pizza Palace", "Italian", new int[]{5,4,4,5,5}));
            system.addRestaurant(new Restaurant(3, "Biryani House", "Indian", new int[]{5,5,4,5,4}));

            // Place Orders
            system.placeOrder(new Order(101, "Paneer Butter Masala", 250.0, 2, 1));
            system.placeOrder(new Order(102, "Margherita Pizza", 300.0, 1, 2));
            system.placeOrder(new Order(103, "Chicken Biryani", 200.0, 3, 3));

            // Fetch orders for Restaurant
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Restaurant ID for orders");
            int restId = sc.nextInt();
            System.out.println("Orders:");
            for (Order o : system.getOrdersByRestaurant(restId)) {
                System.out.println(o);
            }

            // Find total revenue
            System.out.println("Total Revenue: Rs. " + system.calculateTotalRevenue(restId));

            //Top Rated Restaurant
            System.out.println(" \nBonus 1:");
            System.out.println("Top Rated Restaurant: " + system.getTopRatedRestaurant());
            //Orders above 500
            System.out.println(" \nBonus 2:");
            System.out.println("Orders > Rs. 500:");
            for (Order o : system.getHighValueOrders()) {
                System.out.println(o);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
