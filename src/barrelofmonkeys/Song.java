package barrelofmonkeys;

/**
 * Song class
 * @author raul
 *
 */
public class Song {

	String title;
	String author;
	
	public Song(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public boolean isFirstLetter(char ch) {
		return Character.toLowerCase(title.charAt(0)) == Character.toLowerCase(ch);
	}

	public  boolean isLastLetter(char ch) {
		return getLastLetter() == Character.toLowerCase(ch);
	}

	public char getLastLetter() {
		for(int index = title.length() - 1; index >= 0; index--) {
			char findCharacter = title.charAt(index);
			if (Character.isLetter(findCharacter)) {
				return findCharacter;
			}
		}
		return 'a';
	}


	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	public String toString() {
		return "<" + this.title + "|" + this.author + ">"; 
	}
	
	
}
