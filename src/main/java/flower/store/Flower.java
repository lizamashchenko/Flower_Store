package flower.store;

import lombok.Getter;
import lombok.Setter;

@Setter
public class Flower {
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter
    private double price;
    @Getter
    private FlowerType flowerType;

    public Flower() { }
    public Flower(FlowerType type) {
        flowerType = type;
    }
    public Flower(Flower other) {
        this.sepalLength = other.sepalLength;
        this.color = other.color;
        this.price = other.price;
        this.flowerType = other.flowerType;

    }
    public String getColor() {
        return color.toString();
    }
}
