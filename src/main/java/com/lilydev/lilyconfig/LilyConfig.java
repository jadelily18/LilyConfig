package com.lilydev.lilyconfig;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class LilyConfig {

	private final String path;

	public Logger LOGGER;

	private final ObjectMapper objectMapper = new ObjectMapper();
	private final ObjectWriter jsonWriter = objectMapper.writer(new DefaultPrettyPrinter());

	public HashMap<String, Object> CONFIG = new HashMap<>();
	private File file;

	public LilyConfig(String path, Logger logger) {
		this.path = path;
		this.LOGGER = logger;
		getOrCreate();
	}

	private void getOrCreate() {
		file = new File(path);

		try {
			if (file.createNewFile()) {
				LOGGER.info("Created config file at: '" + path + "'!");
				saveConfig();
			} else {
				LOGGER.info("Found config file at: '" + path + "'!");
				assignValues();
			}
		} catch (IOException exception) {
			LOGGER.error(String.valueOf(exception));
		}
	}

	private void assignValues() {
		try {
			Object readValue = objectMapper.readValue(file, Object.class);
			CONFIG = objectMapper.convertValue(readValue, HashMap.class);
		} catch (IOException exception) {
			LOGGER.error(exception.toString());
		}

	}

	public void saveConfig() {
		try {
			jsonWriter.writeValue(file, CONFIG);
		} catch(IOException exception) {
			LOGGER.error(exception.toString());
		}
	}

}