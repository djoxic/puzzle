package dataProvider;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private String dir = System.getProperty("user.dir");

    private Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = dir + "//configs//configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("URL");
        if (url != null)
            return url;
        else
            throw new RuntimeException("URL not specified in the configuration.properties file.");
    }
}
