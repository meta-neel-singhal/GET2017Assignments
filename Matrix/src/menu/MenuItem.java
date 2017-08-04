package menu;

/**
 * Helps to get and set the name of the menu item.
 * 
 * @author Neel Singhal
 */
public abstract class MenuItem {
	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
