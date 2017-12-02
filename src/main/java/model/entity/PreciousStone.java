package model.entity;

/**
 * PreciousStone
 * created on 29.11.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class PreciousStone extends Stone implements PreciousStoneNecklace {
    private double transparency;

    public PreciousStone(double weight, double price, double transparency, String name, String color) {
        super(weight, price, name, color);
        this.transparency = transparency;
    }

    private PreciousStone(Builder builder) {
        super(builder);
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
        return String.format("PreciousStone = { weight: %.3f, price: %.3f, transparency: %.3f, name: %s, color: %s",
                weight, price, transparency, name, color);
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

}
