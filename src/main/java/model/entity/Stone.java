package model.entity;

/**
 * Abstract Stone class
 * created on 02.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public abstract class Stone {
    protected String name;
    protected double price;
    protected double weight;
    protected String color;

    public Stone() {
    }

    /**
     * Basic constructor using builder to be used in child classes
     * @param builder
     */
    protected Stone(Builder builder) {
        this.weight = builder.weight;
        this.price = builder.price;
        this.name = builder.name;
        this.color = builder.color;
    }

    public Stone(double weight, double price, String name, String color) {
        this.weight = weight;
        this.price = price;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Abstract Builder class
     * All subclasses must implement build() method
     * @param <T> type of concrete builder to be returned by each setter
     */
    public abstract static class Builder<T extends Builder> {
        protected double weight;
        protected double price;
        protected String name = "";
        protected String color = "";


        public T weight(double weight) {
            this.weight = weight;
            return (T) this;
        }

        public T price(double price) {
            this.price = price;
            return (T) this;
        }

        public T name(String name) {
            this.name = name;
            return (T) this;
        }

        public T color(String color) {
            this.color = color;
            return (T) this;
        }

        public abstract Stone build();
    }
}
