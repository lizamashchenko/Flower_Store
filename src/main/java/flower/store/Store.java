package flower.store;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<FlowerPack> flowers = new ArrayList<>();
    private List<FlowerBucket> buckets = new ArrayList<>();

    public Store(List<FlowerPack> flowers) {
        this.flowers = flowers;
    }

    public boolean addFlower(Flower flower, int quantity) {
        if (quantity <= 0) {
            return false;
        }

        for (FlowerPack pack : flowers) {
            if (pack.getFlower() == flower) {
                return false;
            }
        }
        flowers.add(new FlowerPack(flower, quantity));
        return true;
    }

    public boolean createBucket(List<FlowerPack> flowerPacks) {
        if (haveAllFlowers(flowerPacks)) {
            buckets.add(new FlowerBucket(flowerPacks));
            return true;
        }
        return false;
    }

    private boolean haveAllFlowers(List<FlowerPack> flowerPacks) {
        for (FlowerPack p : flowerPacks) {
            if (!search(p)) {
                return false;
            }
        }
        return true;
    }

    public boolean sellFlowers(Flower flower, int quantity) {
        FlowerPack pack = search(flower);
        return pack != null && pack.sell(quantity);
    }
    public boolean sell(FlowerBucket bucket) {
        return buckets.removeIf(b -> b.matches(bucket));
    }

    public FlowerPack search(Flower flower) {
        for (FlowerPack f : flowers) {
            if (f.getFlower() == flower) {
                return f;
            }
        }
        return null;
    }
    public FlowerBucket search(FlowerBucket bucket) {
        for (FlowerBucket fb : buckets) {
            if (fb.matches(bucket)) {
                return fb;
            }
        }
        return null;
    }
    public boolean search(FlowerPack flowerPack) {
        for (FlowerPack fl : flowers) {
            if (fl.matches(flowerPack)) {
                return true;
            }
        }
        return false;
    }
}
