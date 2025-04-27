package Classes01;

import Classes02.Episode;
import Classes02.Season;
import interfaces.EpisodeIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private List<Episode> shuffledEpisodes;
    private int currentIndex;

    public ShuffleSeasonIterator(Season season) {
        this.shuffledEpisodes = new ArrayList<>(season.getEpisodes());
        Collections.shuffle(shuffledEpisodes);
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < shuffledEpisodes.size();
    }

    @Override
    public Episode next() {
        return shuffledEpisodes.get(currentIndex++);
    }
}
