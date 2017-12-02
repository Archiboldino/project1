import model.entity.PreciousStone;
import model.entity.Stone;

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
                .price(10)
                .weight(10)
                .color("red")
                .name("opal")
                .transparency(10)
                .build();

        System.out.println(jewel);
    }


}
