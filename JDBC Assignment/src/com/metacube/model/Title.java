package com.metacube.model;

/**
 * Class containing attributes of 'title' table.
 * 
 * @author Neel Singhal
 *
 */
public class Title {
	private int id;
	private String title;
	private int subjectId;
	private int publisherId;
	
	/**
	 * Parameterized Constructor.
	 * 
	 * @param id             id of the title.
	 * @param title          title of the book.
	 * @param subjectId      subject id of the title.
	 * @param publisherId    publisher id of the title.
	 */
	public Title(int id, String title, int subjectId, int publisherId) {
		this.id = id;
		this.title = title;
		this.subjectId = subjectId;
		this.publisherId = publisherId;
	}
	
	public Title() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
}
