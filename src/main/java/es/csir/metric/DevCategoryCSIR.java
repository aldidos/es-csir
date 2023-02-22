package es.csir.metric;

import java.util.HashMap;
import java.util.Map;

public class DevCategoryCSIR 
{
    String devId;

    Map<String, Integer> mapCSCategoryIn;
    Map<String, Integer> mapCSCategoryRm;

    public DevCategoryCSIR(String devId)
    {
        this.devId = devId;
        this.mapCSCategoryIn = new HashMap<String, Integer>();
        this.mapCSCategoryRm = new HashMap<String, Integer>();
    }

    public String getDevId()
    {
        return devId;
    }

    public void setCSCategoryIn(String category, Integer n)
    {
        this.mapCSCategoryIn.put(category, n);
    }

    public void setCSCategoryRm(String category, Integer n)
    {
        this.mapCSCategoryRm.put(category, n);
    }

    public Integer getNumIntroduction(String category)
    {
        Integer n = mapCSCategoryIn.get(category);
        if( n == null ) n = 0;
        return n;
    }

    public Integer getNumRemoval(String category)
    {
        Integer n = mapCSCategoryRm.get(category);
        if( n == null ) n = 0;
        return n;
    }

    
}
