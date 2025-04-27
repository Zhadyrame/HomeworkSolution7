public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("S1E1", 1800));
        season1.addEpisode(new Episode("S1E2", 1900));

        Season season2 = new Season();
        season2.addEpisode(new Episode("S2E1", 2000));
        season2.addEpisode(new Episode("S2E2", 2100));

        Series series = new Series();
        series.addSeason(season1);
        series.addSeason(season2);

        System.out.println("Normal Order:");
        EpisodeIterator iterator = new SeasonIterator(season1);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }

        System.out.println("\nReverse Order:");
        EpisodeIterator reverseIterator = new ReverseSeasonIterator(season1);
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next().getTitle());
        }

        System.out.println("\nShuffle Order:");
        EpisodeIterator shuffleIterator = new ShuffleSeasonIterator(season1);
        while (shuffleIterator.hasNext()) {
            System.out.println(shuffleIterator.next().getTitle());
        }

        System.out.println("\nBinge Watching:");
        EpisodeIterator bingeIterator = new BingeIterator(series);
        while (bingeIterator.hasNext()) {
            System.out.println(bingeIterator.next().getTitle());
        }
    }
}
