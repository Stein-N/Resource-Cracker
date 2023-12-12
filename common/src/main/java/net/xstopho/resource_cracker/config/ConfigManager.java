package net.xstopho.resource_cracker.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.xstopho.resource_cracker.Constants;

import java.io.*;

public class ConfigManager {
    private final File file;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ConfigManager(String path, String fileName) {
        this.file = new File(path + "/" + fileName);
        checkForConfigFile();
    }

    private void checkForConfigFile() {
        try {
            if (!file.exists()) {
                file.createNewFile();
                Constants.LOG.error("Config file not found, creating new file!");
            }
        } catch(IOException e) {
            e.printStackTrace();;
        }
    }

    public void set(String value, Object obj) {
        try {
            JsonObject jsonObj = loadJson();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private JsonObject loadJson() throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        return gson.fromJson(reader, JsonObject.class);
    }
}
