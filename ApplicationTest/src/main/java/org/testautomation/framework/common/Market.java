package org.testautomation.framework.common;

/**
 * Stands for the types of markets available on the menu.
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public enum Market {

	CANADA("markets/canada");

	private String elementPath;

	Market(String path) {
		this.elementPath = path;
	}
	
	public String getPath() {
		return this.elementPath;
	}

}
