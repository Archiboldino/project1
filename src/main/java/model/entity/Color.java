package model.entity;

/**
 * Color
 * created on 07.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public enum Color {
    RED("#ff0000"), GREEN("#00ff00"), BLUE("#0000ff");
    private String colourHex;

    Color(String colourHex) {
        this.colourHex = colourHex;
    }

    public String getColourHex() {
        return colourHex;
    }
}
