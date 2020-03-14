package collections.mainTask;

import collections.mainTask.confection.ChocolateBar;
import collections.mainTask.confection.Lollipop;
import collections.mainTask.confection.Marshmallows;
import collections.mainTask.tastes.Flavor;
import collections.mainTask.tastes.Ingredients;
import java.util.EnumSet;

public class GiftMaker {
    private static final Gift gift = new Gift();

    static {
        gift.addSweet(new ChocolateBar("Snickers",1.2, 167, EnumSet.of(Ingredients.ALMOND,Ingredients.CARAMEL,Ingredients.NOUGAT)));
        gift.addSweet(new ChocolateBar("Mars",1.0, 69, EnumSet.of(Ingredients.ALMOND,Ingredients.CARAMEL)));
        gift.addSweet(new ChocolateBar("Bounty",0.2, 97, EnumSet.of(Ingredients.COCONUT)));
        gift.addSweet(new ChocolateBar("Kit-Kat",1.2, 107, EnumSet.of(Ingredients.WAFFLES)));
        gift.addSweet(new ChocolateBar("Twix", 2.0,150, EnumSet.of(Ingredients.CARAMEL,Ingredients.BISCUITS)));
        gift.addSweet(new Lollipop("ORANGE",1,30, Flavor.ORANGE));
        gift.addSweet(new Lollipop("LEMON",0.7,31, Flavor.LEMON));
        gift.addSweet(new Lollipop("CHERRY",1.8,32, Flavor.CHERRY));
        gift.addSweet(new Lollipop("RASPBERRY",1.2,33, Flavor.RASPBERRY));
        gift.addSweet(new Lollipop("STRAWBERRY",1,34, Flavor.STRAWBERRY));
        gift.addSweet(new Marshmallows("White",0.3,120,false));
        gift.addSweet(new Marshmallows("Black",0.9,129,true));
        gift.addSweet(new ChocolateBar("Kit-Kat",1.2, 107, EnumSet.of(Ingredients.WAFFLES)));
        gift.addSweet(new ChocolateBar("Twix", 2.0,150, EnumSet.of(Ingredients.CARAMEL,Ingredients.BISCUITS)));
        gift.addSweet(new Lollipop("ORANGE",1,30, Flavor.ORANGE));
        gift.addSweet(new Lollipop("LEMON",0.7,31, Flavor.LEMON));
    }

    public static void main(String[] args) {
        double maxAmountOfSugar = 1;
        double minAmountOfSugar = 0.8;
        System.out.println("Конфеты в подарке, соответствующую диапазону содержания сахара от "
                + minAmountOfSugar + " до " + maxAmountOfSugar);
        System.out.println(gift.getSweetsWithAmountOfSugarInRange(minAmountOfSugar, maxAmountOfSugar));
        gift.sortSweetsInAlphabetOrder();
        System.out.println("Конфеты, отсортированные в алфавитном порядке по названию");
        System.out.println(gift);
    }
}
