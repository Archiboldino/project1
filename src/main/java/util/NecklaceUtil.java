package util;

import model.entity.StoneNecklace;
import model.entity.Necklace;

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
     * Calculates total jewel weight in necklace
     * @param necklace necklace containing jewels
     * @return total jewels weight
     */
    public static Double getTotalWeight(Necklace necklace) {
        return necklace.getJewels().stream()
                .mapToDouble(StoneNecklace::getWeight).sum();
    }

    /**
     * Sorts jewels in necklace ascending by price
     * @param necklace necklace containing jewels to sort
     * @return sorted jewels list
     */
    public static List<StoneNecklace> sortJewelsPrice(Necklace necklace) {
        return necklace.getJewels().stream()
                .sorted(Comparator.comparingDouble(StoneNecklace::getPrice))
                .collect(Collectors.toList());
    }

    /**
     * Filters jewels from necklace according to transparency
     * @param necklace necklace containing jewels to filter
     * @param lower lower transparency bound
     * @param upper upper transparency bound
     * @return filtered list of jewels
     */
    public static List<StoneNecklace> getJewelsTransparencyRange(Necklace necklace, Double lower, Double upper) {
        return necklace.getJewels().stream()
                .filter(j -> j.getTransparency() >= lower && j.getTransparency() <= upper)
                .collect(Collectors.toList());
    }
}
