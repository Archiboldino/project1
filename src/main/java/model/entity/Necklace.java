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
    private List<PreciousStoneNecklace> preciousStones = new ArrayList<>();

    public List<PreciousStoneNecklace> getPreciousStones() {
        return preciousStones;
    }

    public void setPreciousStones(List<PreciousStoneNecklace> preciousStones) {
        this.preciousStones = preciousStones;
    }
}
