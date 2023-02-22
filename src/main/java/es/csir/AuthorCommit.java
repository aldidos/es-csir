package es.csir;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthorCommit 
{
    String id;
	String parentCommit;
	String author;
	Date date;	
	List< PyFileLintMsg > listPyFileLintMsg;	
	
	public AuthorCommit(String id, String parentCommit, String author, Date date)
	{
		this.id = id;
		this.parentCommit = parentCommit;
		this.author = author;
		this.date = date;
		this.listPyFileLintMsg = new ArrayList<PyFileLintMsg>();
	}

	public Date getDate()
	{
		return date;
	}

	public void addPyFileLintMsg( PyFileLintMsg pyFileLintMsg )
	{
		this.listPyFileLintMsg.add(pyFileLintMsg);
	}    
}
