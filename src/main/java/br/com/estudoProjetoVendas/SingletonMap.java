package main.java.br.com.estudoProjetoVendas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SingletonMap{

   private static final Map<Class<?>,Map<Long, ?>> map = new HashMap<>();

    private SingletonMap() {
    }

    public static <T> void put(Class<T> tipo, Long chave, T valor){
        @SuppressWarnings("unchecked")
        Map<Long, T> interno = (Map<Long, T>) map.computeIfAbsent(tipo, k -> new HashMap<Long, T>());
        interno.put(chave,valor);
    }
    public static <T> T get(Class<T> tipo, Long chave){
        @SuppressWarnings("unchecked")
        Map<Long, T> interno = (Map<Long, T>) map.get(tipo);
        if (interno==null) return null;
        return interno.get(chave);
    }
    public static <T> void remove(Class<T> tipo, Long chave){
        @SuppressWarnings("unchecked")
        Map<Long ,T> interno =(Map<Long, T>) map.get(tipo);
        interno.remove(chave);
    }
    public static <T> T editar(Class<T> tipo, Long chave, T entity){
        @SuppressWarnings("unchecked")
        Map<Long, T> interno =(Map<Long, T>) map.get(tipo);
        interno.put(chave, entity);
        return interno.get(chave);
    }


}
