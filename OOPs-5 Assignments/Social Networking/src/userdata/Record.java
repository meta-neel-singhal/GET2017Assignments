package userdata;

/**
 * Record class holds all the post of entity.
 * 
 * @author Neel Singhal
 */
public class Record {
	private String title;
	private String content;

	/**
	 * Parameterized constructor.
	 * 
	 * @param title      Title of the post.
	 * @param content    Content in the post.
	 */
	public Record(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
