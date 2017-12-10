import model.data.dao.DaoFactory;
import model.data.dao.NecklaceDao;
import model.data.dao.PreciousStoneDao;
import model.entity.Color;
import model.entity.Necklace;
import model.entity.PreciousStone;
import model.entity.SemiPreciousStone;

/**
 * Main
 * created on 29.11.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        PreciousStone jewel = new PreciousStone.Builder()
                .price(10L)
                .weight(10)
                .color(Color.RED)
                .name("ruby")
                .transparency(10)
                .build();

        SemiPreciousStone stone = new SemiPreciousStone.Builder()
                .color(Color.BLUE)
                .name("diamond")
                .price(33)
                .hardness(100)
                .weight(10)
                .build();

        NecklaceDao dao = DaoFactory.getInstance().createNecklaceDao();
        System.out.println(dao.getAll());

    }


}
