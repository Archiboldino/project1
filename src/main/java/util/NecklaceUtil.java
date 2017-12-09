package util;

import model.entity.Necklace;
import model.entity.PreciousStone;
import model.entity.PreciousStoneNecklace;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * NecklaceUtil
 * created on 29.11.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class NecklaceUtil {

    /**
     * Calculates total precious stone weight in necklace
     *
     * @param necklace necklace containing precious stones
     * @return total precious stones weight
     */
    public static Double getTotalWeight(Necklace necklace) {
        return necklace.getPreciousStones().stream()
                .mapToDouble(PreciousStone::getWeight).sum();
    }

    /**
     * Sorts precious stones in necklace ascending by price
     *
     * @param necklace necklace containing precious stones to sort
     * @return sorted precious stones list
     */
    public static List<PreciousStone> sortPrice(Necklace necklace) {
        return necklace.getPreciousStones().stream()
                .sorted(Comparator.comparingLong(PreciousStone::getPrice))
                .collect(Collectors.toList());
    }

    /**
     * Filters precious stones from necklace according to transparency
     *
     * @param necklace necklace containing precious stones to filter
     * @param lower    lower transparency bound
     * @param upper    upper transparency bound
     * @return filtered list of precious stones
     */
    public static List<PreciousStone> getTransparencyRange(Necklace necklace, Double lower, Double upper) {
        return necklace.getPreciousStones().stream()
                .filter(j -> j.getTransparency() >= lower && j.getTransparency() <= upper)
                .collect(Collectors.toList());
    }
}
