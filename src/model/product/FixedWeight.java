package model.product;

public class FixedWeight  implements Shippable{
    private final String name;
    //weight in g
    private final double weight;

    public FixedWeight (String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    @Override
    public double getWeight() { return weight; }
    @Override
    public String getName() { return name; }
}
