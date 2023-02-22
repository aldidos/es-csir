package es.csir;

// Code Smell Introduction and removal counts of a developer.

public class DevCSIR
{
	private String devId;
	private int introductionCount;
	private int removalCount;
	
	public DevCSIR(String devId)
	{
		this.devId = devId;
		this.introductionCount = 0;
		this.removalCount = 0;
	}
	
	public String getDevId()
	{
		return devId;		
	}
	
	public int getIntroductionCount()
	{
		return introductionCount;
	}
	
	public int getRemovalCount()
	{
		return removalCount;
	}

	public void add(DevCSIR other)
	{
		if( this.devId.equals(other.devId) ) 
		{
			this.addIntroductionCount(other.introductionCount);
			this.addRemovalCount(other.removalCount);
		}		
	}
	
	public void addIntroductionCount(int n)
	{
		introductionCount += n;
	}
	
	public void addRemovalCount(int n)
	{
		removalCount += n;
	}
	
}