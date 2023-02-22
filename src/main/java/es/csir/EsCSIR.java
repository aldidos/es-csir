package es.csir;

import java.io.File;
import java.io.IOException;
import java.util.List;

import es.csir.metric.DevCSIRMetric;
import es.csir.util.ReadJSON;
import es.csir.util.WriteJSON;

public class EsCSIR 
{
    private static AppSetting validateCommandLineArgs(String[] args)
    {
        AppSetting appOptions = new AppSetting();

        if (args.length < 2 ) 
        {
            return appOptions;
        }

        CommandArgs cmdArgs = new CommandArgs(args);
     
        for( int i = 0; i < args.length ; i += 2 )
        {
            String arg = cmdArgs.getArgs(i);
            if( arg == null ) return appOptions;

            if( cmdArgs.isOption(arg) ) {

                String opt = arg;
                arg = cmdArgs.getArgs(i + 1);
                if( arg == null ) return appOptions;
                if( cmdArgs.isOption(arg) ) return appOptions;
                
                appOptions.put(opt, arg);
            }
            else {
                return appOptions;
            }
        }

        appOptions.setValid(true);
        return appOptions;
    }

    public static void main( String[] args ) throws IOException
    {
        AppSetting appSetting = validateCommandLineArgs(args);
        
        if ( appSetting.isValid == false ) 
        {
            System.err.println("wrong arguments");
            return ;
        }

        String inputFilePath = appSetting.get("-i");
        String outputFilePath = appSetting.get("-o");

        File inputFile = new File( inputFilePath );
        File outputFile = new File( outputFilePath );

        List<AuthorCommit> listAuthorCommits = ReadJSON.readAuthorCommitHistory(inputFile);
        Repo repo = ParsePylintCommitHistory.parse(listAuthorCommits);

        if ( appSetting.getType().equals("devmet"))
        {
            WriteJSON.writeDevMet(outputFile.getPath(), DevCSIRMetric.measureDevMet( repo ));
            String.format("The result is created to %s", outputFile.getPath());
        }

        if( appSetting.getType().equals("devcategoryCSIR"))
        {
            WriteJSON.writeDevCategoryCSIR(outputFile.getPath(), DevCSIRMetric.summaryCategoryCSIR( repo ));
            String.format("The result is created to %s", outputFile.getPath());
        }
    }

}
