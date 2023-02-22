package es.csir;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import es.csir.metric.EntropyMeasurement;
import es.csir.util.MapUtil;

public class AuthorCSIRState
{
    String devId;
    int nCommits;
    Set<String> setCommittedPyFiles;
    Map<String, Integer> mapCSIntroductions;
    Map<String, Integer> mapCSRemovals;
    Map<String, Integer> mapCategoryIn;
    Map<String, Integer> mapCategoryRm;

    public AuthorCSIRState(String devId)
    {
        this.devId = devId;
        this.setCommittedPyFiles = new HashSet<String>();
        this.mapCSIntroductions = new HashMap<String, Integer>();
        this.mapCSRemovals = new HashMap<String, Integer>();
        this.mapCategoryIn = new HashMap<String, Integer>();
        this.mapCategoryRm = new HashMap<String, Integer>();
    }

    public void addNumCommits(int n)
    {
        this.nCommits += n;
    }

    public void addCommittedPyFile(String filePath)
    {
        this.setCommittedPyFiles.add(filePath);
    }

    public void addNumIntroduction(String filePath, int n)
    {
        MapUtil.addValue(this.mapCSIntroductions, filePath, n );
    }

    public void addNumRemoval(String filePath, Integer n)
    {
        MapUtil.addValue(this.mapCSRemovals, filePath, n);
    }

    public void incCategoryIn(Map<String, Integer> src)
    {
        MapUtil.incValue( this.mapCategoryIn, src);
    }

    public void incCategoryRm(Map<String, Integer> src)
    {
        MapUtil.incValue( this.mapCategoryRm, src);
    }

    public Integer getCategoryIn(String category)
    {
        return MapUtil.getValue( this.mapCategoryIn, category );
    }

    public Integer getCategoryRm(String category)
    {
        return MapUtil.getValue( this.mapCategoryRm, category );
    }

    public String getDevId()
    {
        return devId;
    }

    public Integer getNumCommits()
    {
        return nCommits;
    }

    public Integer getNumCommittedPyFiles()
    {
        return this.setCommittedPyFiles.size();
    }

    public Integer getNumIntroductions()
    {
        int nIntroduction = MapUtil.getSumValue(mapCSIntroductions);
        return nIntroduction;        
    }

    public Integer getNumRemovals()
    {
        int nRemoval = MapUtil.getSumValue(mapCSRemovals);
        return nRemoval;
    }

    public Integer getNumFilesInIntroductions()
    {
        return this.mapCSIntroductions.size();
    }

    public Integer getNumFilesInRemovals()
    {
        return this.mapCSRemovals.size();
    }

    public double getIEntropy()
    {
        return EntropyMeasurement.H(mapCSIntroductions);
    }

    public double getREntropy()
    {
        return EntropyMeasurement.H(mapCSRemovals);
    }

}
