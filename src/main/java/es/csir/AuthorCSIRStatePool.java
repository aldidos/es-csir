package es.csir;

import java.util.HashMap;
import java.util.Map;

public class AuthorCSIRStatePool 
{
    private Map<String, AuthorCSIRState> mapAuthorCommitState;
    
    public AuthorCSIRStatePool()
    {
        this.setMapAuthorCommitState(new HashMap<String, AuthorCSIRState>());
    }

    public Map<String, AuthorCSIRState> getMapAuthorCommitState() {
        return mapAuthorCommitState;
    }

    public void setMapAuthorCommitState(Map<String, AuthorCSIRState> mapAuthorCommitState) {
        this.mapAuthorCommitState = mapAuthorCommitState;
    }

    public AuthorCSIRState get(String devId)
    {
        AuthorCSIRState devMet = getMapAuthorCommitState().get(devId);
        if( devMet == null ) 
        {
            devMet = new AuthorCSIRState(devId);
            getMapAuthorCommitState().put(devId, devMet);
        }

        return devMet;
    }

    public void put(String devId, AuthorCSIRState authorCommitState)
    {
        getMapAuthorCommitState().put(devId, authorCommitState);
    }

}
