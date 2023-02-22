package es.csir.metric;

import java.util.Map;
import java.util.Map.Entry;

/* 
 * This class can be used to compute IEntropy and REntropy metrics.
 * The key-value pair of the argument, mapCategory, is an identification of a python source file and the number of code smell introduction/removal counts to the source file.
 */

public class EntropyMeasurement 
{	
	public static Double H( Map<String, Integer> mapCategory )
	{	
		Integer size = mapCategory.size();
		if( mapCategory.size() < 2 )
			return 0.0;
		
		Double h = 0.0;
		Double N = 0.0;
		
		for( Entry<String, Integer> ent : mapCategory.entrySet() )
		{
			N += ent.getValue();			
		}
		
		for( Entry<String, Integer> ent : mapCategory.entrySet() )
		{
			Double p = ent.getValue() / N;			
			Double lp = Math.log(p) / Math.log( size ) ; //** normalization 
			h += p * lp;
		}
		
		h *= -1;
		
		return h;
	}

}