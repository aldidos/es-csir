package es.csir;

import java.util.HashMap;
import java.util.Map;

public class PyFileCSStatePool
{
    Map<String, Map<String, Integer> > mapPyFileCSCounts;

    public PyFileCSStatePool()
    {
        this.mapPyFileCSCounts = new HashMap<String, Map<String, Integer>>();
    }

    public void put(String filePath, Map<String, Integer> csCounts)
    {
        this.mapPyFileCSCounts.put(filePath, csCounts);
    }
    
    public Map<String, Integer> get(String filePath)
    {
        Map<String, Integer> csCounts = mapPyFileCSCounts.get(filePath);
        if( csCounts == null ) 
        {
            csCounts = new HashMap<>();
        }
        return csCounts;
    }
}
