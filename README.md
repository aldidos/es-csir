# A dataset
- This dataset is collected and used for a study "An Empirical Study on Code Smell Introduction and Removal in Deep Learning Software Projects". 

# Summary of the study
- With increasing popularity of Deep Learning (DL) software development, code quality issue rises in DL software development. To understand the code smell risk in DL software development, we performed a quantitative analysis on code smell introduction and removal practices of DL developers. We collected a dataset of code smell introduction and removal history of DL developers from several open source DL software GitHub repositories and then quantitatively analyzed the collected dataset. As the result of the quantitative analysis, we observed the following three findings on code smell introduction and removal practices of DL developers. First, DL developers tend to perform code smell introduction practice more than code smell removal practice. Second, DL developers have slightly broader code smell introduction scope than code smell removal scope. Third, regular and irregular DL developers have less difference in both code smell introduction and removal practices. The results indicate that DL developers have very poor awareness on code smell risk.

# Team
- This study id designed and performed by Jungil Kim and Eunjoo Lee. If you encounter any problems, please open an issue or feel free to contact us:
Jungil Kim : A researcher at Center of Self-Organizing Software of Kyungpook National University (KNU); 2009307043@knu.ac.kr
Eunjoo Lee : Professor at KNU; ejlee@knu.ac.kr

# Description
 This repository contains a set of source code (src/es/csir) which was used to form our study dataset and the processed dataset files (preprocessed_dataset). 

 ## src/es/csir:
  * CSCategory.java : The enumeration of Pylint code smell category.
  * CSMsg.java : A class representing a Pylint code smell message.
  * ComputeCSIR.java : The code used to compute a developer's code smell introduction and removal counts.
  * DevCSIR.java : A class representing a developer's code smell introduction and removal counts.
  * EntropyMeasurement.java : The code used to compute a developer's IEntropy and REntropy.
  
 ## preprocessed_dataset:
 Our dataset consists of the following three files. 
 
 ### exp_repos.txt
 * The list of the target GitHub repositories
    * name : A name of a GitHub repository. 
    * full_name : A full name (owner name + repository name) of a GitHub repository. 
    * from_date : the start date of commit history for our study.
    * to_date :  the end date of commit history for our study.
   
 ### dataset_dev_csir_count.csv
 * The processed data related to the target DL developers' commit history and code smell introduction and removal history we defined. 
	  * devId : the developer identification (email address)
	  * repo : A repository name
	  * nCommits : A number of commits
	  * nCommittedPyFiles : A number of committed python files
	  * nRepoTotalCommits : The total number of commits in the corresponding repository
	  * nIntroduction : The number of code smell introductions
	  * IRemoval : The number of code smell removals
	  * eIntroduction : The value of code smell introduciton entropy
	  * eRemoval : The value of code smell removal entropy
	  * nFilesInIntroduction : The number of python files to which the DL developer introduced any code smell
	  * nFileInRemoval : The number of python files from which the DL developer removed any code smell
	  * devType : The types of code smell Introducer, Remover, IntroducerAndRemover and Neutral
	
 ### dataset_dev_met.csv
 * The preprocessed data which contains the target DL developer's code smell introduction and removal counts per category
	  * id : An identifier of a row
	  * devId : the developer identification (email address)
	  * repo : A repository name
	  * category : A code smell category
	  * actType : An activity of Introduction or Removal of code smell
	  * count : The number of code smell introduction or removal
