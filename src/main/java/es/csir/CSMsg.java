package es.csir;

/*
 *  A Pylint code smell message.
 *  The category and code smell message are derived from Pylint.  
 */

public class CSMsg
{
	private CSCategory category;
	private String csMessage;
	
	public CSMsg(CSCategory category, String csMessage)
	{
		this.category = category;
		this.csMessage = csMessage;
	}
	
	public CSCategory getCategory()
	{
		return category;
	}
	
	public String getCodeSmellMessage()
	{
		return csMessage;
	}
	
	public boolean equals(Object obj)
	{
		CSMsg o = (CSMsg)obj;
		return this.csMessage.equals(o.csMessage);
	}
	
	public int hashCode()
	{
		return csMessage.hashCode();
	}
}
