package com.viraneel.apartmentspot.entities;

import java.io.Serializable;

import com.google.gson.Gson;

public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	protected static final long serialVersionUID = -3203586492258871452L;

	public String serializedJSON() {
		Gson gson = new Gson();
		String jsonSerializedString = gson.toJson(this);
		return jsonSerializedString;
	}

}
