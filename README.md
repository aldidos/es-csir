# A dataset
 This dataset is collected and used for a study "An Empirical Study on Code Smell Introduction and Removal in Deep Learning Software Projects". 

# Summary of the study
 With increasing popularity of Deep Learning (DL) software development, code quality issue rises in DL software development. To understand the code smell risk in DL software development, we performed a quantitative analysis on code smell introduction and removal practices of DL developers. We collected a dataset of code smell introduction and removal history of DL developers from several open source DL software GitHub repositories and then quantitatively analyzed the collected dataset. As the result of the quantitative analysis, we observed the following three findings on code smell introduction and removal practices of DL developers. First, DL developers tend to perform code smell introduction practice more than code smell removal practice. Second, DL developers have slightly broader code smell introduction scope than code smell removal scope. Third, regular and irregular DL developers have less difference in both code smell introduction and removal practices. The results indicate that DL developers have very poor awareness on code smell risk.

# Team
 This study is designed and performed by Jungil Kim and Eunjoo Lee. If you encounter any problems, please open an issue or feel free to contact us:
   - Jungil Kim : A researcher at Center of Self-Organizing Software of Kyungpook National University (KNU); 2009307043@knu.ac.kr
   - Eunjoo Lee : Professor at KNU; ejlee@knu.ac.kr

# Description
 This repository contains a set of source code (src) which was used to form our study dataset and the experimental dataset (data).

## How to run the src:

 1. Create a maven java project with your favorite IDE and import this repository. 

 2. Compile the imported project executable to generate the executable class file EsCSIR.class

 3. Move the root directory of the generated class file and run the following commends you require.

 4. Run the following commends
    * To obtain a set of developer metrics for code smell introductions and removals from a repository history source.
      * java es.csir.EsCSIR -i [path to an input origianl repository history json file] -o [output path of the result file ] -t devmet"
      * ex) java es.csir.EsCSIR -i ./data/source/3DDFA.json -o ./res.json -t devmet

    * To obtain a set of developers' code smell introduction and removal counts per code smell category.
      * java es.csir.EsCSIR -i [path to an input origianl repository history json file] -o [output path of the result file ] -t devcategoryCSIR"
      * ex) java es.csir.EsCSIR -i ./data/source/3DDFA.json -o ./res.json -t devcategoryCSIR

## Experimental dataset:
 The experimental dataset consists of two parts, the original source dataset (data/source) and preprocessed datasets (data/preprocessed). 
 
### The source dataset
 * A source data file consists of a sequence of git commit metadata. The metadata is as follows. 
    * id : A git commit  identification of a commit 
    * author : The author identification (email address)
	* data : The date of commit
	* listPyFileLintMsg : A list of committed python files with lint messages.
   
### The preprocessed datasets
 The processed datasets consist of 'data/preprocessed/devMet' and 'data/preprocessed/devCategoryCSIR', which can be obtained with "-t devmet" and "-t devcategoryCSIR" options respectively.

#### devMet
 * A devMet json file has a sequence of the following info.
	  * devId : the developer identification (email address)
	  * nCommits : A number of commits
	  * nCommittedPyFiles : A number of committed python files
	  * nRepoTotalCommits : The total number of commits in the corresponding repository
	  * nIntroduction : The number of code smell introductions
	  * nRemoval : The number of code smell removals
	  * eIntroduction : The value of code smell introduciton entropy
	  * eRemoval : The value of code smell removal entropy
	  * nFilesInIntroduction : The number of python files to which the DL developer introduced any code smell
	  * nFileInRemoval : The number of python files from which the DL developer removed any code smell
	
#### devCategoryCSIR
 * A devCategoryCSIR json file has a sequence of the following info.
	  * devId : the developer identification (email address)
	  * mapCSCategoryIn : The number of code smell category introduction
	  * mapCSCategoryRm : The number of code smell category removal