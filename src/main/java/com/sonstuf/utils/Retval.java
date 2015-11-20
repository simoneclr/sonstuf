package com.sonstuf.utils;

/**
 * This class is used as a generic type to return information about certain 
 * operations.
 * @author rigel
 */
public class Retval {
	
	private boolean success;
	private String description;
	
	/**
	 * Empty constructor; does nothing
	 */
	public Retval(){}
	
	/**
	 * Allows to specify a boolean value to state wether the operation 
	 * was carried out correctly or not.
	 * @param success the boolean value
	 */
	public Retval(boolean success){
		this.success = success;
		if (this.success){
			description = "OK";
		} else {
			this.description = "AN UNSPECIFIED ERROR OCCURRED";
		}
	}
	
	/**
	 * Allows to specify a boolean value to state wether the operation 
	 * was carried out correctly or not, adding a textual description.
	 * @param success boolean value
	 * @param description description of the operation result
	 */
	public Retval(boolean success, String description){
		this.success = success;
		this.description = description;
	}

	/**
	 * @return the success
	 */
	public boolean getSuccess(){
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success){
		this.success = success;
	}

	/**
	 * @return the description
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
	@Override
	public String toString(){
		return(this.description);
	}
	
}