package barrelofmonkeys;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BarrelOfMonkeysEndToEnd {
	
	XPathParser fileParser;

	@Before
	public void parseFile() throws Exception {
		fileParser = new XPathFileParser("SongLibrary.xml");
	}
	
	@Test
	public void testFinderForTenSongs() throws Exception {
		SongLoader loader = new XPathSongLoader(fileParser);
		SongFinderStrategy strategy = new FirstCharacterFinderStrategy('c', 5);
		List<Song> playList = strategy.playlist(loader);
		
		List<Song> expected = new ArrayList<Song>();
		expected.add(new Song("Caught Up In You", ".38 Special"));
		expected.add(new Song("Under Attack", "ABBA"));
		expected.add(new Song("Kelly Watch The Stars", "Air [French Band]"));
		expected.add(new Song("Second Chance", ".38 Special"));
		expected.add(new Song("Eden", "10,000 Maniacs"));

		assertEquals(expected, playList);
	}
	
	@Ignore
	public void testFinderWithFirstAndLastSong() throws Exception {
		// TODO
	}
		
	@Ignore
	public void testFinderWithShortestPlaylistBetweenTwoSongs() throws Exception {
		// TODO
	}

	@Ignore
	public void testFinderWithSpecificDuration() throws Exception {
		// TODO
	}
}
