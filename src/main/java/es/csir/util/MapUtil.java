package es.csir.util;

import java.util.Map;

public class MapUtil 
{   
    public static void addValue(Map<String, Integer> target, Map<String, Integer> src)
    {
        for ( Map.Entry<String, Integer> ent : src.entrySet() )
        {
            Integer targetValue = getValue(target, ent.getKey());
            targetValue += src.get(ent.getKey());
            target.put( ent.getKey(), targetValue );
        }
    }

    public static void incValue(Map<String, Integer> target, Map<String, Integer> src)
    {
        for ( Map.Entry<String, Integer> ent : src.entrySet() )
        {
            Integer targetValue = getValue(target, ent.getKey());
            targetValue++;
            target.put( ent.getKey(), targetValue );
        }
    }

    public static void addValue(Map<String, Integer> target, String key, Integer value) 
    {
        Integer tValue = getValue( target, key);        
        tValue += value;
        target.put(key, tValue);
    }

    public static Integer getValue(Map<String, Integer> map, String key)
    {
        Integer value = map.get(key);
        if( value == null ) value = 0;
        return value;
    }

    public static Integer getSumValue(Map<String, Integer> map)
    {
        int sumValues = 0;
        for( Integer value : map.values() )
        {
            sumValues += value;
        }
        return sumValues;
    }
}
