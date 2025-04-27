package Classes01;

import Classes02.Episode;
import Classes02.Season;
import interfaces.EpisodeIterator;
import java.util.List;

public class SeasonIterator implements EpisodeIterator {
    private List<Episode> episodes;
    private int currentIndex;

    public SeasonIterator(Season season) {
        this.episodes = season.getEpisodes();
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < episodes.size();
    }

    @Override
    public Episode next() {
        return episodes.get(currentIndex++);
    }
}
