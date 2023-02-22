package es.csir;

import java.util.List;
import java.util.Map;

public class ParsePylintCommitHistory 
{
    public static Repo parse( List<AuthorCommit> listAuthorCommits )
    {
        AuthorCSIRStatePool authorCSIRStatePool = new AuthorCSIRStatePool();
        PyFileCSStatePool pyFileCSStatePool = new PyFileCSStatePool();

        for( AuthorCommit aCommit : listAuthorCommits ) 
        {
            String author = aCommit.author;

            AuthorCSIRState aCSIRState = authorCSIRStatePool.get( author );
            aCSIRState.addNumCommits(1);

            for( PyFileLintMsg pyFileLintMsg : aCommit.listPyFileLintMsg )
            {
                String filePath = pyFileLintMsg.path;
                Map<String, Integer> prev = pyFileCSStatePool.get( filePath );
                Map<String, Integer> cur = pyFileLintMsg.getLintMsgCount();
                pyFileCSStatePool.put( filePath, cur );

                CSIR csir = ComputeCSIR.compute(prev, cur);

                aCSIRState.addCommittedPyFile(filePath);
                if ( csir.hasCSIntroduction() ) aCSIRState.addNumIntroduction( filePath, 1 );
                if ( csir.hasCSRemoval() ) aCSIRState.addNumRemoval( filePath, 1 );
                aCSIRState.incCategoryIn(csir.getCategoryIn());
                aCSIRState.incCategoryRm(csir.getCategoryRm());
            }

            authorCSIRStatePool.put(author, aCSIRState);
        }

        return new Repo(listAuthorCommits.size(), authorCSIRStatePool);
    }
    
}
