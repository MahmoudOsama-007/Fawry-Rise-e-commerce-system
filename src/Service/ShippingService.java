package Service;

import model.product.Shippable;

import java.util.List;

public class ShippingService {
    private static final double SHIPPING_RATE_PER_KG = 30;

    public static double calculateShippingCost(List<Shippable> itemsToShip) {
        double totalWeight = 0;

        for (Shippable item : itemsToShip) {
            totalWeight += item.getWeight();
        }

        return (totalWeight/1000) * SHIPPING_RATE_PER_KG;
    }
}

