class Order {
    private int orderId;
    private String itemName;
    private double price;
    private int quantity;
    private int restaurantId;

    public Order(int orderId, String itemName, double price, int quantity, int restaurantId) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.restaurantId = restaurantId;
    }

    public int getOrderId() { return orderId; }
    public int getRestaurantId() { return restaurantId; }

    public double totalAmount() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", restaurantId=" + restaurantId +
                ", totalAmount=" + totalAmount() +
                '}';
    }
}
