package barrelofmonkeys;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class FirstCharacterFinderStrategyTest {
	
	private final Song SONG_A_H = new Song("Aleluiah", "Jeff Buckley");
	private final Song SONG_B_E = new Song("Bullya To Me", "author2");
	private final Song SONG_B_A = new Song("Basta", "anotherauthor");
	private final Song SONG_C_K = new Song("Carla with a K", "author");
	private final Song SONG_E_B = new Song("Envy Carb", "author");
	
	private SongLoader createSongLoader() {
		SongLoader loader = mock(SongLoader.class);
		
		List<Song> listOfSongs = new ArrayList<Song>();
		listOfSongs.add(SONG_A_H);
		listOfSongs.add(SONG_B_E);
		listOfSongs.add(SONG_B_A);
		listOfSongs.add(SONG_C_K);
		listOfSongs.add(SONG_E_B);
		
		when(loader.getSongs()).thenReturn(listOfSongs);
		return loader;
	}
	
	
	@Test
	public void createPlaylistWithDifferentSongs() throws NoNextSongException {

		SongLoader loader = createSongLoader();
		
		SongFinderStrategy strategy = new FirstCharacterFinderStrategy('b', 2);
		
		List<Song> expectedSongList = new ArrayList<Song>();
		expectedSongList.add(SONG_B_E);
		expectedSongList.add(SONG_E_B);
		
		List<Song> resultSongList = strategy.playlist(loader);
		assertEquals(expectedSongList, resultSongList);

	}
	
	@Test
	public void createPlaylistTakingIntoAccountAlreadyPlayedOnes() throws NoNextSongException {

		SongLoader loader = createSongLoader();
		
		SongFinderStrategy standardFinder = new FirstCharacterFinderStrategy('b', 3);
		
		List<Song> expectedSongList = new ArrayList<Song>();
		expectedSongList.add(SONG_B_E);
		expectedSongList.add(SONG_E_B);
		expectedSongList.add(SONG_B_A);
		
		List<Song> resultSongList = standardFinder.playlist(loader);

		assertEquals(expectedSongList, resultSongList);
	}
	
}
