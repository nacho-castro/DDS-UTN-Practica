package ar.utn.ddsi.logger.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectToMapConversor {

  public static Map<String, Object> convertObjectToMap(Object obj){
    Map<String, Object> map = new HashMap<>();
    //RECIBE UN OBJECT Y LO CONVIERTE A MAP
    //EN CADA CLAVE METE EL NOMBRE DEL ATRIBUTO
    //EN CADA OBJECT GUARDA LOS VALORES DE ESOS ATRIBUTOS

    //Obtener todos los campos de la clase usando reflexion
    Field[] fields = obj.getClass().getDeclaredFields();

    //Iterar sobre los campos y agregarlos al mapa
    for (Field field: fields){
      try{
        //Hacer accesible el campo si es privado
        field.setAccessible(true);

        //Obtener el valor del campo y agregarlo al mapa
        Object value = field.get(obj);
        map.put(field.getName(),value);
      } catch (IllegalAccessException e){
        e.printStackTrace();
      }
    }
    return map;
  }
}
