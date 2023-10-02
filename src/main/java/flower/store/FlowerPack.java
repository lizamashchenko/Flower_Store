package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public class FlowerPack {
    @Setter
    private Flower flower;
    private int quantity = 1;
    private double packPrice;

    public FlowerPack(Flower flower, int quantity) {
        this.flower = new Flower(flower);
        this.quantity = quantity;
        updatePrice();
    }
    public FlowerPack(Flower fl) {
        flower = new Flower(fl);
        updatePrice();
    }
    public void setQuantity(int quantityDif) {
        quantity += quantityDif;
        quantity = quantity < 1 ? 1 : quantity;
        updatePrice();

    }
    private void updatePrice() {
        packPrice = quantity * flower.getPrice();
    }

}
