package ar.utn.ddsi.logger.adapters;

import java.util.Map;

public interface DataBaseAdapter {

  void connect();

  void insert(String tablename, Map<String, Object> stringObjectMap);

  void disconnect();
}
