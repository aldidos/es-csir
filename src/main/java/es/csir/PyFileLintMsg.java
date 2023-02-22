package es.csir;

import java.util.HashMap;
import java.util.Map;

import es.csir.util.MapUtil;

public class PyFileLintMsg 
{
    String path;
	Map<String, Integer> mapLintMsgCount;
	
	public PyFileLintMsg(String path, Map<String, Integer> mapLintMsgCount)
	{
		this.path = path;
		this.mapLintMsgCount = mapLintMsgCount;
	}

	public Map<String, Integer> getLintMsgCount()
	{
		return mapLintMsgCount;
	}

	public int totalMsgCounts()
	{
		int totalCounts = 0;
		for( Integer count : mapLintMsgCount.values() ) 
		{
			totalCounts += count;
		}

		return totalCounts;
	}	

	public Map<String, Integer> getCategoryCount()
	{
		Map<String, Integer> mapCategoryCounts = new HashMap<String, Integer>();
		for ( Map.Entry<String, Integer> ent : this.mapLintMsgCount.entrySet() ) 
		{
			String category = CSCategory.category( ent.getKey() );
			Integer msgCount = ent.getValue();

			Integer categoryCount = MapUtil.getValue(mapCategoryCounts, category);
			categoryCount += msgCount;
			mapCategoryCounts.put( category, categoryCount );
		}

		return mapCategoryCounts;
	}

}
