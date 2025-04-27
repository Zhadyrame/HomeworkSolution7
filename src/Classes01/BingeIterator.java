package Classes01;

import Classes02.Episode;
import Classes02.Season;
import Classes02.Series;
import interfaces.EpisodeIterator;

import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private List<Season> seasons;
    private EpisodeIterator currentIterator;
    private int currentSeasonIndex;

    public BingeIterator(Series series) {
        this.seasons = series.getSeasons();
        this.currentSeasonIndex = 0;
        if (!seasons.isEmpty()) {
            this.currentIterator = seasons.get(0).createIterator();
        }
    }

    @Override
    public boolean hasNext() {
        while (currentIterator != null && !currentIterator.hasNext()) {
            currentSeasonIndex++;
            if (currentSeasonIndex < seasons.size()) {
                currentIterator = seasons.get(currentSeasonIndex).createIterator();
            } else {
                currentIterator = null;
            }
        }
        return currentIterator != null && currentIterator.hasNext();
    }

    @Override
    public Episode next() {
        if (hasNext()) {
            return currentIterator.next();
        }
        return null;
    }
}
