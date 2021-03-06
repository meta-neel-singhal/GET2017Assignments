package entity;

import java.util.List;
import userdata.Record;;

/**
 * Abstract class having common details of Entity.
 * 
 * @author Neel Singhal
 */
public abstract class Entity {
	private String entityId;
	private String name;
	private String type;
	private long contact;
	private String password;
	private List<Record> posts;

	public Entity(String entityId, String name, String password, long contact,
			String type) {
		this.entityId = entityId;
		this.name = name;
		this.type = type;
		this.contact = contact;
		this.password = password;
	}

	public String getId() {
		return this.entityId;
	}

	public void setId(String id) {
		this.entityId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void addPost(Record record) {
		posts.add(record);
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Record> getPosts() {
		return posts;
	}

	public void setPosts(List<Record> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contact ^ (contact >>> 32));
		result = prime * result	+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Entity other = (Entity) obj;

		if (entityId == null) {
			if (other.entityId != null) {
				return false;
			}
		} else if (!entityId.equals(other.entityId)) {
			return false;
		}

		return true;
	}

}
