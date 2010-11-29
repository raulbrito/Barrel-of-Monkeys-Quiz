package barrelofmonkeys;

import java.util.List;

public interface SongFinderStrategy {
	
	List<Song> playlist(SongLoader loader) throws NoNextSongException;

}
