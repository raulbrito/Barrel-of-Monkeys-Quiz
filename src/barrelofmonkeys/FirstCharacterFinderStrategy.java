package barrelofmonkeys;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the basic BarrelOfMonkeys strategy:
 * - find the next song whose first letter starts with
 *   the last letter of the previous song
 * @author raul
 *
 */
public class FirstCharacterFinderStrategy implements SongFinderStrategy {
	
	private char firstCharacter;
	private int maxNumberOfSongs;

	public FirstCharacterFinderStrategy(char firstCharacter, int maxNumberOfSongs) {
		this.firstCharacter = firstCharacter;
		this.maxNumberOfSongs = maxNumberOfSongs;
	}


	@Override
	public List<Song> playlist(SongLoader loader) throws NoNextSongException {
	
		//make sure the songs are loaded
		try {
			loader.load();
		} catch (Exception e) {
			throw new NoNextSongException();
		}
		List<Song> result = new ArrayList<Song>();
		
		char startSongWith = this.firstCharacter;
		for(int i = 0; i < this.maxNumberOfSongs; i++) {
			List<Song> songList = loader.getSongs();
			for(Song song : songList) {
				if (song.isFirstLetter(startSongWith)) {
					result.add(song);
					songList.remove(song);
					startSongWith = song.getLastLetter();
					break;
				}
			}
		}
		
		return result;
	}
}
