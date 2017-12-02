package model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Necklace
 * created on 29.11.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class Necklace {
    private List<StoneNecklace> jewels = new ArrayList<>();

    public List<StoneNecklace> getJewels() {
        return jewels;
    }

    public void setJewels(List<StoneNecklace> jewels) {
        this.jewels = jewels;
    }
}
