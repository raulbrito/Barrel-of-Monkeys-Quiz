package barrelofmonkeys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SongTest {
	
	private Song song = null;
	
	@Before
	public void createSong() {
		song = new Song("title", "author");
	}
	
	@Test
	public void testSongCreation() {
		assertNotNull(song);
	}
	
	@Test
	public void testGetTitle() {
		assertEquals("title", song.getTitle());
	}
	
	@Test
	public void testGetAuthor() {
		assertEquals("author", song.getAuthor());
	}
	
	@Test
	public void testSongFirstCharacter() {
		assertTrue(song.isFirstLetter('t'));
		assertTrue(song.isFirstLetter('T'));
		
		assertTrue(!song.isFirstLetter('e'));
	}
	
	@Test
	public void testGetLastLetter() {
		assertEquals('e', song.getLastLetter());
	}
	
	@Test
	public void testGetLastLetterWithFinishParenthesis() {
		Song songFinishingInParenthesis = new Song("Something in the Way (She Moves)", "author");
		assertEquals('s', songFinishingInParenthesis.getLastLetter());
	}
	


}
