package es.csir;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * This class can be used to compute code smell introduction and removal counts of a developer.
 */

public class ComputeCSIR 
{	
	public static DevCSIR compute( String authorId, Map<CSMsg, Integer> prevCS_counts, Map<CSMsg, Integer> curCS_counts)
	{
		DevCSIR devCSIR = new DevCSIR(authorId);
		
		Set<CSMsg> setMsgId = new HashSet<CSMsg>();
		if( prevCS_counts != null )
			setMsgId.addAll( prevCS_counts.keySet() );
		if( curCS_counts != null ) 
			setMsgId.addAll( curCS_counts.keySet() );
		
		for ( CSMsg csMsg : setMsgId )
		{
			Integer curCount = 0;
			if( curCS_counts != null ) 
			{
				curCount = curCS_counts.get(csMsg);
				if( curCount == null ) 
					curCount = 0;
			}
			
			Integer prevCount = 0;
			
			if( prevCS_counts != null ) 
			{
				prevCount = prevCS_counts.get(csMsg);
				if ( prevCount == null ) 
					prevCount = 0;
			}			
			
			Integer diffCount = curCount - prevCount;
			
			if( diffCount > 0 )
				devCSIR.addIntroductionCount(1);
			if( diffCount < 0 ) 
				devCSIR.addRemovalCount(1);
		}
		
		return devCSIR;
	}	

}
