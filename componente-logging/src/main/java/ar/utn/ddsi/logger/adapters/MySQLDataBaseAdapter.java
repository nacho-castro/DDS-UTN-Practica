package ar.utn.ddsi.logger.adapters;

import ar.utn.ddsi.logger.adapters.connectors.MySQLConnector;
import ar.utn.ddsi.logger.utils.ConfigReader;

import java.util.Map;

public class MySQLDataBaseAdapter implements DataBaseAdapter {
  private MySQLConnector mySQLConnector;
  private ConfigReader configReader;

  public MySQLDataBaseAdapter() {
    this.mySQLConnector = new MySQLConnector();
    this.configReader = new ConfigReader();
  }

  @Override
  public void connect() {
    try {
      this.mySQLConnector.connect(
          this.configReader.getProperty("mySQLUrlConnection"),
          this.configReader.getProperty("mySQLUsername"),
          this.configReader.getProperty("mySQLPassword")
      );
    } catch (Exception e) {
      //TODO e.
    }
  }

  @Override
  public void insert(String tablename, Map<String, Object> stringObjectMap) {
    try {
      String[] columnNames = stringObjectMap.keySet().toArray(new String[0]);
      Object[] values = stringObjectMap.values().toArray();
      this.mySQLConnector.insert(tablename, columnNames, values);
    } catch (Exception e) {
      //TODO
    }
  }

  @Override
  public void disconnect() {
    try {
      this.mySQLConnector.disconnect();
    } catch (Exception e) {
      //TODO
    }
  }
}
