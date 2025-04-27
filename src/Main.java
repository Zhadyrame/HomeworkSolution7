import Classes01.BingeIterator;
import Classes01.ReverseSeasonIterator;
import Classes01.SeasonIterator;
import Classes01.ShuffleSeasonIterator;
import Classes02.Episode;
import Classes02.Season;
import Classes02.Series;
import interfaces.EpisodeIterator;

public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("S1E1", 1800));
        season1.addEpisode(new Episode("S1E2", 1900));
        season1.addEpisode(new Episode("S1E3", 1850));

        Season season2 = new Season();
        season2.addEpisode(new Episode("S2E1", 2000));
        season2.addEpisode(new Episode("S2E2", 2100));

        Series series = new Series();
        series.addSeason(season1);
        series.addSeason(season2);

        System.out.println("Season Iterator:");
        EpisodeIterator iterator = new SeasonIterator(season1);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }

        System.out.println("\nReverse Season Iterator:");
        EpisodeIterator reverseIterator = new ReverseSeasonIterator(season1);
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next().getTitle());
        }

        System.out.println("\nShuffle Season Iterator:");
        EpisodeIterator shuffleIterator = new ShuffleSeasonIterator(season1);
        while (shuffleIterator.hasNext()) {
            System.out.println(shuffleIterator.next().getTitle());
        }

        System.out.println("\nBinge Iterator:");
        EpisodeIterator bingeIterator = new BingeIterator(series);
        while (bingeIterator.hasNext()) {
            System.out.println(bingeIterator.next().getTitle());
        }
    }
}

