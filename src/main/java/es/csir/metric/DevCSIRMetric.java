package es.csir.metric;

import java.util.ArrayList;
import java.util.List;

import es.csir.AuthorCSIRState;
import es.csir.CSCategory;
import es.csir.Repo;

public class DevCSIRMetric 
{
    public static List<DevMet> measureDevMet( Repo repo )
    {
        List<DevMet> listDevMet = new ArrayList<>();
        for( AuthorCSIRState aCSIRState : repo.getAuthorCommitState() )
        {
            DevMet devMet = measureDevMet( repo.getNumTotalRepoCommits(), aCSIRState);
            listDevMet.add(devMet);
        }
        return listDevMet;
    }

    public static DevMet measureDevMet( int nTotalRepoCommits, AuthorCSIRState aCSIRState)
    {
        DevMet dm = new DevMet();
        dm.devId = aCSIRState.getDevId();
        dm.nRepoTotalCommits = nTotalRepoCommits;
        dm.setnCommits(aCSIRState.getNumCommits());
        dm.setnCommittedPyFiles(aCSIRState.getNumCommittedPyFiles());
        dm.setnIntroductions(aCSIRState.getNumIntroductions());
        dm.setnRemovals(aCSIRState.getNumRemovals());
        dm.setnFilesInIntroductions(aCSIRState.getNumFilesInIntroductions());
        dm.setnFilesInRemovals(aCSIRState.getNumFilesInRemovals());
        dm.setIEntropy(aCSIRState.getIEntropy());
        dm.setREntropy(aCSIRState.getREntropy());
        
        return dm;
    }

    public static List<DevCategoryCSIR> summaryCategoryCSIR( Repo repo )
    {
        List<DevCategoryCSIR> listDevCategoryCSIR = new ArrayList<>();
        for( AuthorCSIRState aCSIRState : repo.getAuthorCommitState() )
        {
            DevCategoryCSIR devCategoryCSIR = summaryCategoryCSIR(aCSIRState);
            listDevCategoryCSIR.add( devCategoryCSIR );
        }
        return listDevCategoryCSIR;
    }

    public static DevCategoryCSIR summaryCategoryCSIR(AuthorCSIRState aCSIRState)
    {
        DevCategoryCSIR devCategoryCSIR = new DevCategoryCSIR(aCSIRState.getDevId());

        for( CSCategory category :  CSCategory.values() ) {

            Integer numIn = aCSIRState.getCategoryIn( category.name() );
            Integer numRm = aCSIRState.getCategoryRm( category.name() );
            
            devCategoryCSIR.setCSCategoryIn(category.name(), numIn);
            devCategoryCSIR.setCSCategoryRm(category.name(), numRm);
        }
        
        return devCategoryCSIR;
    }
    
}
