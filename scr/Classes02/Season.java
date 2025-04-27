import java.util.ArrayList;
import java.util.List;

public class Season implements Iterable<Episode> {
    private List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public java.util.Iterator<Episode> iterator() {
        return new SeasonIterator(this);
    }
}
