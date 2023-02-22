package es.csir;

import java.util.HashMap;
import java.util.Map;

import es.csir.util.MapUtil;

public class CSIR 
{
    Map<String, Integer> mapCategoryIn;
    Map<String, Integer> mapCategoryRm;
    int nIntroductions;
    int nRemovals;

    public CSIR()
    {
        this.mapCategoryIn = new HashMap<String, Integer>();
        this.mapCategoryRm = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getCategoryIn()
    {
        return mapCategoryIn;
    }

    public Map<String, Integer> getCategoryRm()
    {
        return mapCategoryRm;
    }

    public void addCategoryIn(String category, Integer n)
    {
        MapUtil.addValue(mapCategoryIn, category, n);
    }

    public void addCategoryRm(String category, Integer n)
    {
        MapUtil.addValue(mapCategoryRm, category, n);        
    }

    public boolean hasCSIntroduction()
    {
        if( this.nIntroductions > 0 )
            return true;
        return false;
    }

    public boolean hasCSRemoval()
    {
        if ( this.nRemovals > 0 ) 
            return true;
        return false;
    }
}
