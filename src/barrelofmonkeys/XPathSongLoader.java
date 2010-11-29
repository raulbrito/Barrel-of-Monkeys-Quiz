package barrelofmonkeys;

import java.util.ArrayList;
import java.util.List;

/**
 * provides a SongLoader based on xpath searching of
 * XML file - not efficient at all
 * @author raul
 *
 */
public class XPathSongLoader implements SongLoader{

	private XPathParser pathParser;
	private List<Song> songList = new ArrayList<Song>();
	
	public XPathSongLoader(XPathParser pathParser) {
		this.pathParser = pathParser;
	}

	public int numberOfSongs() {
		return songList.size();
	}

	public void load() throws Exception {
		String authorN = null;
		String songN = null;
		try {
			for(String authorName: pathParser.xpathAttribute("//Library/Artist", "name")) {
				authorN = authorName;
				for (String songName: pathParser.xpathAttribute("//Library/Artist[@name='"+ authorName + "']/Song", "name")) {
					songN = songName;
					songList.add(new Song(songName, authorName));
				}
			}
		} catch (Exception e) {
			System.out.println(e + " " + authorN + "|" + songN);
		}
		
	}

	public List<Song> getSongs() {
		return this.songList;
	}

}
