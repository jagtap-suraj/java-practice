enum Laptop {
    Macbook(2000), XPS(2200), Surface(2200), ThinkPad(1500);

    private int price;

    Laptop(int price) {
        this.price = price;
        System.out.println("in Laptop " + this.name());
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

public class EnumPractice {

    public static void main(String[] args) {
        for (Laptop laptop : Laptop.values()) {
            System.out.println(laptop + ": " + laptop.getPrice());
        }
    }

}
