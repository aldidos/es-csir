package es.csir.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import es.csir.AuthorCommit;
import es.csir.ParsePylintCommitHistory;
import es.csir.Repo;
import es.csir.metric.DevCSIRMetric;
import es.csir.util.ReadJSON;
import es.csir.util.WriteJSON;

public class CollectExpData 
{
    public static void main(String[] args) throws IOException 
    {
        String basePathStr = "e:/research/data/DL-Code_Smells/valid_pylint_commit_state/";
        Path basePath = Paths.get(basePathStr);        

        String output_path_devmet = "e:/research/data/DL-Code_Smells/json_devMet/";
        String output_path_devCatCSIR = "e:/research/data/DL-Code_Smells/json_devCategoryCSIR/";

        for( File f : basePath.toFile().listFiles() ) 
        {
            List<AuthorCommit> listAuthorCommits = ReadJSON.readAuthorCommitHistory(f);
            Repo repo = ParsePylintCommitHistory.parse(listAuthorCommits);

            WriteJSON.writeDevMet(output_path_devmet + f.getName(), DevCSIRMetric.measureDevMet( repo ) );
            WriteJSON.writeDevCategoryCSIR(output_path_devCatCSIR + f.getName(), DevCSIRMetric.summaryCategoryCSIR( repo ));
        }        
    }

}
