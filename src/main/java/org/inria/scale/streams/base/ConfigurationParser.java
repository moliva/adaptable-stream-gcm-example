package org.inria.scale.streams.base;

import org.inria.scale.streams.windows.WindowConfigurationObject;

import com.google.gson.Gson;

public class ConfigurationParser {

	public CombinatorConfigurationObject parseCombinatorConfiguration(final String json) {
		return parse(json, CombinatorConfigurationObject.class);
	}

	public WindowConfigurationObject parseWindowConfiguration(final String json) {
		return parse(json, WindowConfigurationObject.class);
	}

	private <T> T parse(final String json, final Class<T> clazz) {
		return new Gson().fromJson(json.replaceAll("\\(", "{").replaceAll("\\)", "}"), clazz);
	}

	public String serialize(final Object configuration) {
		return new Gson().toJson(configuration).replaceAll("\\{", "(").replaceAll("\\}", ")");
	}

}
