package es.csir.metric;

public class DevMet 
{
    String devId;
    int nCommits;
    int nCommittedPyFiles;
	int nRepoTotalCommits; 
    int nIntroductions;
    int nRemovals;
    double IEntropy;
    double REntropy;
    int nFilesInIntroductions;
    int nFilesInRemovals;

    public String getDevId()
    {
        return devId;
    }

	public int getNumTotalRepoCommits()
	{
		return nRepoTotalCommits;
	}

    public int getnCommits() {
		return nCommits;
	}

	public void setnCommits(int nCommits) {
		this.nCommits = nCommits;
	}

	public int getnFilesInRemovals() {
		return nFilesInRemovals;
	}

	public void setnFilesInRemovals(int nFilesInRemovals) {
		this.nFilesInRemovals = nFilesInRemovals;
	}

	public int getnFilesInIntroductions() {
		return nFilesInIntroductions;
	}

	public void setnFilesInIntroductions(int nFilesInIntroductions) {
		this.nFilesInIntroductions = nFilesInIntroductions;
	}

	public double getREntropy() {
		return REntropy;
	}

	public void setREntropy(double rEntropy) {
		this.REntropy = rEntropy;
	}

	public double getIEntropy() {
		return IEntropy;
	}

	public void setIEntropy(double iEntropy) {
		this.IEntropy = iEntropy;
	}

	public int getnRemovals() {
		return nRemovals;
	}

	public void setnRemovals(int nRemovals) {
		this.nRemovals = nRemovals;
	}

	public int getnIntroductions() {
		return nIntroductions;
	}

	public void setnIntroductions(int nIntroductions) {
		this.nIntroductions = nIntroductions;
	}

	public int getnCommittedPyFiles() {
        return nCommittedPyFiles;
    }

    public void setnCommittedPyFiles(int nCommittedPyFiles) {
        this.nCommittedPyFiles = nCommittedPyFiles;
    }

    public String devType()
    {
        if( getnIntroductions() > 0 && getnRemovals() == 0 )  return "Introducer";
        if( getnIntroductions() == 0 && getnRemovals() > 0 )  return "Remover";
        if( getnIntroductions() > 0 && getnRemovals() > 0 )  return "IntroducerAndRemover";
        return "Neutral";        
    }
}
