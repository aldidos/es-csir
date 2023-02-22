package es.csir.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.csir.CSCategory;
import es.csir.metric.DevCategoryCSIR;
import es.csir.metric.DevMet;
import es.csir.util.ReadJSON;

public class FilteringData 
{
    Map<String, Set<String>> mapDevs ;
    
    public static Map<String, Set<String>> readDevs(String path) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        Map<String, Set<String>> mapDevs = new HashMap<String, Set<String>>();
        String line = null;
        while( reader.ready() )
        {
            line = reader.readLine();
            String[] s = line.split("\t");
            Set<String> set = mapDevs.get(s[0]);
            if ( set == null ) set = new HashSet<String>();
            
            set.add(s[1]);
            mapDevs.put(s[0], set);
        }

        reader.close();
        return mapDevs;
    }

    public static void main(String[] args) throws IOException 
    {
        Map<String, Set<String>> mapDevs = readDevs( "./devset.txt" );
        
        String output_path_devmet = "e:/research/data/DL-Code_Smells/json_devMet/";
        String output_path_devCatCSIR = "e:/research/data/DL-Code_Smells/json_devCategoryCSIR/";

        BufferedWriter wDevMet = new BufferedWriter(new FileWriter("./newDevMet.txt"));

        for( File f : Paths.get(output_path_devmet).toFile().listFiles() ) 
        {
            String repo = f.getName();
            repo = repo.replace(".json", "");

            List<DevMet> devmets = ReadJSON.readDevMet(f.getAbsolutePath());
            for( DevMet dm : devmets)
            {
                Set<String> setDevs = mapDevs.get(repo);
                if( setDevs != null ) 
                {
                    if ( setDevs.contains(dm.getDevId()) ) 
                    {
                        String temp = 
                            dm.getDevId() + "\t" +
                            repo + "\t" + 
                            dm.getnCommits() + "\t" + 
                            dm.getnCommittedPyFiles() + "\t" +
                            dm.getNumTotalRepoCommits() + "\t" + 
                            dm.getnIntroductions() + "\t" + 
                            dm.getnRemovals() + "\t" + 
                            dm.getIEntropy() + "\t" + 
                            dm.getREntropy() + "\t" + 
                            dm.getnFilesInIntroductions() + "\t" + 
                            dm.getnFilesInRemovals() + "\t" + 
                            dm.devType() ; 

                            wDevMet.write(temp + "\n");
                        System.out.println( temp );                        
                    }                    
                }
            }
        }

        //
        BufferedWriter wDevCategoryCSBufferedWriter = new BufferedWriter(new FileWriter("./newDevCateCSIR.txt"));
        for( File f : Paths.get(output_path_devCatCSIR).toFile().listFiles() ) 
        {
            String repo = f.getName();
            repo = repo.replace(".json", "");

            List<DevCategoryCSIR> d = ReadJSON.readDevCategoryCSIR(f.getAbsolutePath());
            for( DevCategoryCSIR dm : d)
            {
                Set<String> setDevs = mapDevs.get(repo);
                if( setDevs != null ) 
                {
                    if ( setDevs.contains(dm.getDevId()) ) 
                    {
                        String devId = dm.getDevId();                        

                        for( CSCategory category : CSCategory.values() ) 
                        {
                            int n = dm.getNumIntroduction(category.name());
                            System.out.println( devId + "\t" + repo + "\t" + category.name() + "\t" + "Introduction" + "\t" + n );
                            wDevCategoryCSBufferedWriter.write( devId + "\t" + repo + "\t" + category.name() + "\t" + "Introduction" + "\t" + n + "\n" );
                        }

                        for( CSCategory category : CSCategory.values() ) 
                        {
                            int n = dm.getNumRemoval(category.name());
                            wDevCategoryCSBufferedWriter.write( devId + "\t" + repo + "\t" + category.name() + "\t" + "Removal" + "\t" + n + "\n" );
                        }                                                
                    }                    
                }
            }
        }

        wDevMet.close();
        wDevCategoryCSBufferedWriter.close();        
    }
    
}

