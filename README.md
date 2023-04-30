# ESOF423-Project

This is a repository for the 2023 ESOF423 Project working on the problem established by Dr. Bain focusing on helping create a tool for more practical and efficent prognosis of patients by answering series of questions, in the form of a java based executable software.

## Documentation for Users
### Description of the Project
This is a Feature Complete Release of the DrRx software. It is able to complete a search query for a patient's information, open a separate window to display that information, and provide results from the most recent test data from the patient's survey results.

### To Obtain and Install the Software
On the main page of the repository, download all files into one folder onto our computer. A fast and easy way to do this will be clicking the green '<> Code' button, and downloading the zip file from that dropdown menu. Inside the zip folder will be a folder that is named 'G4-DrRx-main'. That folder can be placed anywhere. Ensure that the files PatientApplication(CLICKME!).lnk and run.sh are in the top level of the file system. This means that when the folder is opened, the two files can be seen without going into any more folders. The DrRx software is now installed.

### To Run the Software
Find the folder on your desktop where the files are located. Double click on the PatientApplication(CLICKME!).lnk file from the previous step. The Patient Search Window is displayed and the application is now running. 

### To Use the Software
With the DrRx application running, the Patient Search Window is displayed. Patients can be searched by LAST NAME ONLY. A set of data has been provided and can be accessed by searching for 'Bob', 'Wagner', or 'Smith'. Searching these names will provide a new window of patient information. To search another name, click the 'Back' button at the bottom of the screen or simply close the Patient Information Window. 

To add more patients into the current system, open the sampleinput.csv file by opening the 'G4-DrRx-main' file, then opening the Project file, opening the testData file, and double clicking on the sampleinput.csv file. You will see each patient is a separate line. To add a patient into the system, follow this exact format documented here and shown in the provided patients:

FirstName,LastName,DOB,PHQ-9,#,#,#,#,#,#,#,#,#,GAD-7,#,#,#,#,#,#,#,ISI,#,#,#,#,#,#,#,ASRS,#,#,#,#,#,#,CSS,#,#,#,#,#,#,#

Sample Data:  
First Name - Joe  
Last Name - Smith  
DOB - 3_29_2019 (March 29, 2019)  
PHQ-9,2,1,1,2,3,1,0,1,1,  
GAD-7,0,0,3,1,0,2,1,  
ISI,2,2,2,2,2,2,2,  
ASRS,0,1,2,3,4,0,  
CSS,1,1,1,1,1,1,1  

Sample Data in Correct Formatting:  
Joe,Smith,3_29_2019,PHQ-9,2,1,1,2,3,1,0,1,1,GAD-7,0,0,3,1,0,2,1,ISI,2,2,2,2,2,2,2,ASRS,0,1,2,3,4,0,CSS,1,1,1,1,1,1,1

### To Report a Bug
In the Github Repository Website, find the current highlighted tab titled '<> Code' underneath the name of the repository. To the right of this tab is another tab named 'Issues'.
In this tab, if your issue does not have an open issue ticket, click the 'New' button. Please give the issue a descriptive title as well as a well detailed comment explaining your issue.
When you are ready to post your issue, scroll down to the bottom of the page and click the 'Submit new Issue' button.

## Documentation for Developers
### Obtain the Source Code 
The source code for the latest version of the software can be obtained by downloading the JavaCode folder within Project folder, in its entirety.

### File Locations
For this project, all source code can be found under the Project/JavaCode directory.
Executable files can be found on the top level of the repository.
Documentation, artifacts and version history can be found under the Tracking directory.

### Build Instructions
* No extra build instructions are currently associated with this software, but may be included at a later date.

### Test Suite
* Currently, no test suite is available for this software. Testing must be done manually by running the source code.

### Unit Testing
* The Test Suite from above is referencing the source code Unit Testing that can be found in the 'Test' folder on the top level of the repository.

### Versions
* When a new version of the software is created, documentation and artifacts will be updated and the executable file will be updated to run the most recent version of the software.

### Bugs
* All bugs, bug resolutions and pending features will be tracked in the GitHub issues tab.

## Layout

This displays how to find specific files in the repository:

  * `/Project` All of the code *(Java, etc.)*
  * `/Tracking` Backlogs and burndown charts *(Along with their history)*
  * `Artifacts.md` Displayed artifacts
  
