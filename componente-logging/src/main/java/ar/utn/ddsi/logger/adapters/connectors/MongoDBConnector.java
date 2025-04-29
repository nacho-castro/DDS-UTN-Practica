package ar.utn.ddsi.logger.adapters.connectors;

import ar.utn.ddsi.logger.adapters.DataBaseAdapter;
import ar.utn.ddsi.logger.utils.ConfigReader;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Map;

public class MongoDBConnector{
  private MongoClient mongoClient;
  private MongoDatabase mongoDatabase;

  public void connect(String connectionString, String databaseName) {
    mongoClient = MongoClients.create(connectionString);
    mongoDatabase = mongoClient.getDatabase(databaseName);
  }

  public void insert(String collectionName, Document document) {
    MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
    collection.insertOne(document);
  }

  public void disconnect() {
    if(mongoClient != null){
      mongoClient.close();
    }
  }
}
