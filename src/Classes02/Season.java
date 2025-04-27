package Classes02;

import Classes01.SeasonIterator;
import interfaces.EpisodeIterator;
import java.util.ArrayList;
import java.util.List;

public class Season {
    private List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public EpisodeIterator createIterator() {
        return new SeasonIterator(this);
    }
}

