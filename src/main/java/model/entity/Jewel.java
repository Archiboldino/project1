package model.entity;

/**
 * Jewel
 * created on 29.11.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class Jewel {
    private double weight;
    private double price;
    private double transparency;
    private String name;
    private String color;

//    public Jewel(double weight, double price, double transparency, String name, String color) {
//        this.weight = weight;
//        this.price = price;
//        this.name = name;
//        this.color = color;
//        this.transparency = transparency;
//    }

    private Jewel(Builder builder) {
        this.weight = builder.weight;
        this.price = builder.price;
        this.name = builder.name;
        this.color = builder.color;
        this.transparency = builder.transparency;
    }

    public static class Builder {
        private double weight;
        private double price;
        private double transparency;
        private String name = "";
        private String color = "";


        public Builder(double weight, double price, double transparency) {
            this.weight = weight;
            this.price = price;
            this.transparency = transparency;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Jewel build() {
            return new Jewel(this);
        }
    }

    public double getWeight() {

        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    @Override
    public String toString() {
        return String.format("Jewel = { weight: %.3f, price: %.3f, transparency: %.3f, name: %s, color: %s\n",
                weight, price, transparency, name, color);
    }
}
