package model.entity;

/**
 * PreciousStone
 * created on 29.11.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class PreciousStone extends Stone {
    private Integer id;
    private double transparency;

    public PreciousStone(Integer id, double weight, long price, double transparency, String name, Color color) {
        super(weight, price, name, color);
        this.id = id;
        this.transparency = transparency;
    }

    private PreciousStone(Builder builder) {
        super(builder);
        this.id = builder.id;
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
        return String.format("PreciousStone = { weight: %.3f, price: %d, transparency: %.3f, name: %s, color: %s, ref: %s}",
                weight, price, transparency, name, color, super.toString());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static class Builder extends Stone.Builder<Builder> {
        private double transparency;
        private Integer id;

        public Builder transparency(double transparency) {
            this.transparency = transparency;
            return this;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        @Override
        public Builder getThis() {
            return this;
        }

        @Override
        public PreciousStone build() {
            return new PreciousStone(this);
        }
    }
}
