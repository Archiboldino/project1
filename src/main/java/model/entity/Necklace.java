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
    List<Jewel> jewels = new ArrayList<>();

    public List<Jewel> getJewels() {
        return jewels;
    }

    public void setJewels(List<Jewel> jewels) {
        this.jewels = jewels;
    }
}
