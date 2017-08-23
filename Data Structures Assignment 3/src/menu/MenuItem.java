package menu;

/**
 * The MenuItem class.
 *
 * @author Neel Singhal
 */
public abstract class MenuItem {

	// The name of menu item.
	private String displayName;

	/**
	 * Gets the display name.
	 *
	 * @return    Display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName    New display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
