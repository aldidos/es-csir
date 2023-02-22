package es.csir;

import java.util.Collection;

public class Repo 
{
    int nTotalRepoCommits;
    AuthorCSIRStatePool authorCSIRStatePool ;    

    public Repo(int nTotalRepoCommits, AuthorCSIRStatePool authorCSIRStatePool )
    {
        this.nTotalRepoCommits = nTotalRepoCommits;
        this.authorCSIRStatePool = authorCSIRStatePool;
    }

    public int getNumTotalRepoCommits()
    {
        return nTotalRepoCommits;
    }

    public Collection<AuthorCSIRState> getAuthorCommitState()
    {
        return authorCSIRStatePool.getMapAuthorCommitState().values();
    }
    
}
