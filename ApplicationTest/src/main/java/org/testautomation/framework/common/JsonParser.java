package org.testautomation.framework.common;

import com.google.gson.Gson;

/**
 * Wrapper class for serializing and deserializing operations with gson library
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public class JsonParser {

	private Class<?> clazz;
	private Gson gson;

	/**
	 * Construct with a class holding json model dto
	 * 
	 * @param clazz
	 *            input Class for the related model object
	 */
	public JsonParser(Class<?> clazz) {
		this.clazz = clazz;
		gson = new Gson();
	}

	/**
	 * Generic parser method to conver the response json format to objec model
	 * 
	 * @param response
	 * @return the bind object
	 */
	public Object deserializeResponse(String response) {
		return gson.fromJson(response, clazz);
	}

}
