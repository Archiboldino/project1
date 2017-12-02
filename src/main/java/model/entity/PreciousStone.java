package model.entity;

/**
 * PreciousStone
 * created on 29.11.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class PreciousStone extends Stone implements StoneNecklace {
    private double transparency;

    public PreciousStone(double weight, double price, double transparency, String name, String color) {
        super();
        this.weight = weight;
        this.price = price;
        this.name = name;
        this.color = color;
        this.transparency = transparency;
    }

    public static class Builder extends Stone.Builder<Builder> {
        private double transparency;

        public Builder transparency(double transparency) {
            this.transparency = transparency;
            return this;
        }

        @Override
        public PreciousStone build() {
            return new PreciousStone(this);
        }
    }

    private PreciousStone(Builder builder) {
        this.weight = builder.weight;
        this.price = builder.price;
        this.name = builder.name;
        this.color = builder.color;
        this.transparency = builder.transparency;
    }


    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    @Override
    public String toString() {
        return String.format("PreciousStone = { weight: %.3f, price: %.3f, transparency: %.3f, name: %s, color: %s\n",
                weight, price, transparency, name, color);
    }
}
