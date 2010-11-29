package barrelofmonkeys;

import java.util.List;

public interface SongLoader {
	
	void load() throws Exception;

	List<Song> getSongs();
}
