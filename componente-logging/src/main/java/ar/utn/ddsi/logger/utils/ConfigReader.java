package ar.utn.ddsi.logger.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
  private String filepath;

  //lee el archivo y obtiene las properties
  public ConfigReader(){
    this.filepath = "loggerconfig.properties";
  }

  public Properties getProperties() throws IOException {
    Properties prop = new Properties();
    try (InputStream input = getClass().getClassLoader().getResourceAsStream(filepath)){
      prop.load(input);
    }
    return prop;
  }

  public String getProperty(String key) throws IOException{
    Properties prop = getProperties();
    return prop.getProperty(key);
  }
}
