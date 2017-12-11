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
    protected long price;
    protected double weight;
    protected Color color;

    public Stone() {
    }

    /**
     * Basic constructor using builder to be used in child classes
     *
     * @param builder builder filled with data
     */
    protected Stone(Builder builder) {
        this.weight = builder.weight;
        this.price = builder.price;
        this.name = builder.name;
        this.color = builder.color;
    }

    public Stone(double weight, long price, String name, Color color) {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
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
     *
     * @param <T> type of concrete builder to be returned by each setter
     */
    public abstract static class Builder<T extends Builder> {
        protected double weight;
        protected long price;
        protected String name = "";
        protected Color color;


        public abstract T getThis();

        public T weight(double weight) {
            this.weight = weight;
            return getThis();
        }

        public T price(long price) {
            this.price = price;
            return getThis();
        }

        public T name(String name) {
            this.name = name;
            return getThis();
        }

        public T color(Color color) {
            this.color = color;
            return getThis();
        }

        public abstract Stone build();
    }
}
