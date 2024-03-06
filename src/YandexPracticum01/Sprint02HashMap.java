package YandexPracticum01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Sprint02HashMap {
    public static void main(String[] args) {
    ArrayList<HamsterFeed> blabla = new ArrayList<HamsterFeed>();

//    blabla.add(new HamsterFeed(1, false));

        Scratch.filter(blabla);

    }

     class Scratch {

        public static ArrayList<HamsterFeed> filter(ArrayList<HamsterFeed> hamsterFeeds) {

            Iterator <HamsterFeed> iterator = hamsterFeeds.iterator();

            while (iterator.hasNext()) {
                HamsterFeed foodFreshness = iterator.next();
                if (!foodFreshness.isFresh) {
                    iterator.remove();
                }
            }

            return hamsterFeeds;
        }
    }

    static class HamsterFeed {

        final boolean isFresh;
        final int num;

        public HamsterFeed(final int num, final boolean isFresh) {
            this.isFresh = isFresh;
            this.num = num;
        }
    }
}

//class Hamster {
//    String name;
//
//    Hamster(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {   //когда попросят объект стать строкой - сделай это
//        return "Хомяк " + name;
//    }
//}

