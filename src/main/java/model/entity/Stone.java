package model.entity;

/**
 * Stone
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

    public abstract static class Builder<T extends Builder>  {
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

        public abstract PreciousStone build();
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
}
