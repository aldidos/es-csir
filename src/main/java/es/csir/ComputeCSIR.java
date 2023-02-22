package es.csir;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import es.csir.util.MapUtil;

/*
 * This class can be used to compute code smell introduction and removal counts of a developer.
 */

public class ComputeCSIR 
{	
	public static CSIR compute( Map<String, Integer> prevCS_counts, Map<String, Integer> curCS_counts )
	{
		CSIR csir = new CSIR();
		
		Set<String> setMsgId = new HashSet<String>();
		if( prevCS_counts != null )	setMsgId.addAll( prevCS_counts.keySet() );
		if( curCS_counts != null ) setMsgId.addAll( curCS_counts.keySet() );
		
		for ( String csMsg : setMsgId )
		{
			Integer curCount = 0;
			String msgCategory = CSCategory.category(csMsg);
			if( curCS_counts != null ) 
			{
				curCount = MapUtil.getValue(curCS_counts, csMsg);
			}
			
			Integer prevCount = 0;
			if( prevCS_counts != null ) 
			{
				prevCount = MapUtil.getValue(prevCS_counts, csMsg);				
			}
			
			Integer diffCount = curCount - prevCount;
			
			if( diffCount > 0 )
			{
				csir.nIntroductions += 1;
				csir.addCategoryIn(msgCategory, 1);
			}
				
			if( diffCount < 0 ) 
			{
				csir.nRemovals += 1;
				csir.addCategoryRm(msgCategory, 1);
			}
		}
		
		return csir;
	}
}