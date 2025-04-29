package ar.utn.ddsi.logger.adapters;

import ar.utn.ddsi.logger.adapters.connectors.MongoDBConnector;
import ar.utn.ddsi.logger.utils.ConfigReader;
import org.bson.Document;

import java.util.Map;

public class MongoDataBaseAdapter implements DataBaseAdapter {
  private MongoDBConnector mongoDBConnector;
  private ConfigReader configReader;

  public MongoDataBaseAdapter() {
    this.mongoDBConnector = new MongoDBConnector();
    this.configReader = new ConfigReader();
  }

  @Override
  public void connect() {
    try {
      this.mongoDBConnector.connect(
          this.configReader.getProperty("mongoConnectionString"),
          this.configReader.getProperty("mongoDataBaseName"));
    } catch (Exception e) {

    }
  }

  @Override
  public void insert(String collectionName, Map<String, Object> stringObjectMap) {
    Document document = new Document();
    for(Map.Entry<String,Object> entry: stringObjectMap.entrySet()){
      document.append(entry.getKey(), entry.getValue());
    }
    this.mongoDBConnector.insert(collectionName,document);
  }

  @Override
  public void disconnect() {
    this.mongoDBConnector.disconnect();
  }
}
