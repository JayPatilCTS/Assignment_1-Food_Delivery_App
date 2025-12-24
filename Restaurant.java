class Restaurant {
    private int id;
    private String name;
    private String cuisineType;
    private int[] ratings;

    public Restaurant(int id, String name, String cuisineType, int[] ratings) {
        this.id = id;
        this.name = name;
        this.cuisineType = cuisineType;
        if (ratings.length == 5) {
            this.ratings = ratings;
        } else {
            throw new IllegalArgumentException("Ratings must have exactly 5 values.");
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCuisineType() { return cuisineType; }

    public double getAverageRating() {
        int sum = 0;
        for (int r : ratings) sum += r;
        return sum / 5.0;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cuisineType='" + cuisineType + '\'' +
                ", avgRating=" + getAverageRating() +
                '}';
    }
}
