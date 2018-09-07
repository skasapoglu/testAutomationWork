package org.testautomation.framework.common;

/**
 * Enumeration for selecting menu items on home page.
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public enum SelectionMenu {

	ABOUT("ABOUT"), AGENCIES("AGENCIES AND BUSINESSES"), TALENT("TALENT"), NEWS("NEWS"), PHILANTHROPY(
			"PHILANTHROPY"), MARKETS("MARKETS"), CONTACT("CONTACT");

	private String text;

	SelectionMenu(String text) {
		this.text = text;
	}

	public String text() {
		return text;
	}

}
