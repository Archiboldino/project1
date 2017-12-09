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
    private Integer id;
    private List<PreciousStone> preciousStones = new ArrayList<PreciousStone>();
    private String name;

    public Necklace(String name) {
        this.name = name;
    }

    public Necklace() {
    }

    public List<PreciousStone> getPreciousStones() {
        return preciousStones;
    }

    public void setPreciousStones(List<PreciousStone> preciousStones) {
        this.preciousStones = preciousStones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Necklace={name: %s}", name) + getPreciousStones().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
