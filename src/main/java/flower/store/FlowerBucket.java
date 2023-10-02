package flower.store;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket {
    private List<FlowerPack> flowerPacks = new ArrayList<>();
    private double bucketPrice = 0;

    public void addPack(FlowerPack pack) {
        if (containsFlower(pack.getFlower())) {
            increaseQuantity(pack.getFlower(), pack.getQuantity());
        }
        flowerPacks.add(pack);
        updatePrice(pack.getPackPrice());
    }

    public void removePack(FlowerPack pack) {
        flowerPacks.remove(pack);
        updatePrice(-pack.getPackPrice());
    }

    public double getBucketPrice() {
        return bucketPrice;
    }
    private void increaseQuantity(Flower flower, int quantityAdded) {
        int i = 0;
        FlowerType flowerType = flower.getFlowerType();
        while (!flowerPacks.get(i).getFlower().equals(flowerType)) {
            i++;
        }
        flowerPacks.get(i).setQuantity(quantityAdded);
        updatePrice(flower.getPrice() * quantityAdded);
    }
    private boolean containsFlower(Flower flower) {
        for (FlowerPack flowerPack : flowerPacks) {
            if (flowerPack.getFlower().getFlowerType()
                    .equals(flower.getFlowerType())) {
                return true;
            }
        }
        return false;
    }

    private void updatePrice(double priceDif) {
        bucketPrice += priceDif;
    }
}
