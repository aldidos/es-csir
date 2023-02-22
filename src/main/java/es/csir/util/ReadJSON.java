package es.csir.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import es.csir.AuthorCommit;
import es.csir.metric.DevCategoryCSIR;
import es.csir.metric.DevMet;

public class ReadJSON 
{   
    public static List<AuthorCommit> readAuthorCommitHistory(File jsonFile) throws FileNotFoundException
    {
        List<AuthorCommit> listAuthorCommits = readAuthorCommitHistory(jsonFile.getPath());
        Collections.sort(listAuthorCommits, new Comparator<AuthorCommit>() {
            @Override
            public int compare(AuthorCommit o1, AuthorCommit o2) {

                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return listAuthorCommits;
    }

    public static List<AuthorCommit> readAuthorCommitHistory(String jsonFilePath) throws FileNotFoundException
    {
        Gson gson = new Gson();		
		JsonReader reader = new JsonReader(new FileReader(jsonFilePath));	
        	
		Type typeOfT = new TypeToken<List<AuthorCommit>>(){}.getType();
		List<AuthorCommit> listData = gson.fromJson(reader, typeOfT);		
		return listData;
    }

    public static List<DevMet> readDevMet(String path) throws FileNotFoundException
    {
        Gson gson = new Gson();		
		JsonReader reader = new JsonReader(new FileReader( path ));	
        	
		Type typeOfT = new TypeToken<List<DevMet>>(){}.getType();
		List<DevMet> listData = gson.fromJson(reader, typeOfT);		
		return listData;
    }

    public static List<DevCategoryCSIR> readDevCategoryCSIR(String path) throws FileNotFoundException
    {
        Gson gson = new Gson();		
		JsonReader reader = new JsonReader(new FileReader( path ));	
        	
		Type typeOfT = new TypeToken<List<DevCategoryCSIR>>(){}.getType();
		List<DevCategoryCSIR> listData = gson.fromJson(reader, typeOfT);		
		return listData;
    }

    
}
