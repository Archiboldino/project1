package util;

import model.entity.Jewel;
import model.entity.Necklace;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * NecklaceUtilTest
 * created on 29.11.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class NecklaceUtilTest {
    private Necklace necklace;
    private Double expectedTotalWeight = 12d;
    private List<Jewel> expectedFilteredJewels;

    @Before
    public void setUp() throws Exception {
        necklace = new Necklace();
        necklace.getJewels().add(new Jewel.Builder(1, 8, 3)
                .name("Test 1")
                .build());
        necklace.getJewels().add(new Jewel.Builder(4, 2, 6)
                .name("Test 2")
                .build());
        necklace.getJewels().add(new Jewel.Builder(7, 5, 9)
                .name("Test 3")
                .build());

        expectedFilteredJewels = new ArrayList<>();
        expectedFilteredJewels.add(necklace.getJewels().get(1));
    }

    @Test
    public void getTotalPriceTest() throws Exception {
        Double actual = NecklaceUtil.getTotalWeight(necklace);

        Assert.assertEquals(expectedTotalWeight, actual);
    }

    @Test
    public void sortJewelsPriceTest() throws Exception {
        List<Jewel> actual = NecklaceUtil.sortJewelsPrice(necklace);

        for (int i = 0; i < actual.size() - 1; i++) {
            if(actual.get(i).getPrice() > actual.get(i + 1).getPrice())
                Assert.fail();
        }
    }

    @Test
    public void getJewelsTransparencyRangeTest() {
        List<Jewel> actual = NecklaceUtil.getJewelsTransparencyRange(necklace, 4d, 7d);

        Assert.assertEquals(expectedFilteredJewels, actual);
    }
}
