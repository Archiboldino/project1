package model.entity;

/**
 * model.entity.SemiPreciousStone
 * created on 02.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class SemiPreciousStone extends Stone {
    private double hardness;

    public SemiPreciousStone(Builder builder) {
        super(builder);
        this.hardness = builder.hardness;
    }

    public double getHardness() {
        return hardness;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public static class Builder extends Stone.Builder<Builder> {
        private double hardness;

        public Builder hardness(double hardness) {
            this.hardness = hardness;
            return this;
        }

        @Override
        public SemiPreciousStone build() {
            return new SemiPreciousStone(this);
        }
    }
}
