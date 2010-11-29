package barrelofmonkeys;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.endsWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SongLoaderTest {
	
	@Test
	public void loadSongsFromXMLFile() throws Exception {
		
		XPathSongLoader songLoader = loadSongs();
		
		assertEquals(6, songLoader.numberOfSongs());
		
	}

	protected XPathSongLoader loadSongs() throws Exception {
		XPathParser parser = mock(XPathParser.class);

		List<String> authors = Arrays.asList("Author1", "Author2");
		List<String> songs = Arrays.asList("Song one", "Song two", "Song three");
		
		when(parser.xpathAttribute(endsWith("/Artist"),anyString())).thenReturn(authors);
		when(parser.xpathAttribute(endsWith("/Song"), anyString())).thenReturn(songs);
		
		XPathSongLoader songLoader = new XPathSongLoader(parser);
		songLoader.load();
		return songLoader;
	}
	
	@Test
	public void provideListOfSongsFromLoader() throws Exception {

		XPathSongLoader songLoader = loadSongs();
		
		List<Song> listSongs = songLoader.getSongs();
		
		List<Song> expected = new ArrayList<Song>();
		expected.add(new Song("Song one", "Author1"));
		expected.add(new Song("Song two", "Author1"));
		expected.add(new Song("Song three", "Author1"));
		expected.add(new Song("Song one", "Author2"));
		expected.add(new Song("Song two", "Author2"));
		expected.add(new Song("Song three", "Author2"));
		
		assertEquals(expected, listSongs);
		
	}

}
