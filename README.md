# ESOF423-Project

This is a repository for the 2023 ESOF423 Project working on the problem established by Dr. Bain focusing on helping create a tool for more practical and efficent prognosis of patients by answering series of questions, in the form of a java based executable software.

## Documentation for Users
### Description of the Project
This is a Feature Complete Release of the DrRx software. It is able to complete a search query for a patient's information, open a separate window to display that information, and provide results from the most recent test data from the patient's survey results.

### To Obtain and Install the Software
Within this repository, navigate through to the Project/JavaCode folder. Inside are three files, Questionnaire_Application, Check_Data, and DrRx_Application; download all three and place them all within the same folder, perferably onto the desktop. In the same repository, navigate to the Project/testData folder. Download the sampleinput.csv file and place it in the same folder as the other previously downloaded files. The DrRx software is now installed.

### To Run the Software
Find the folder on your desktop where the files are located. Double click on the DrRx_Application.jar file from the previous step. The Patient Search Window is displayed and the application is now running. 

### To Use the Software
With the DrRx application running, the Patient Search Window is displayed. Patients can be searched by LAST NAME ONLY. A set of data has been provided and can be accessed by searching for 'Bob', 'Wagner', or 'Smith'. Searching these names will provide a new window of patient information. To search another name, click the 'Back' button at the bottom of the screen or simply close the Patient Information Window. 

To add more patients into the current system, open the sampleinput.csv file from the same folder where the DrRx_Application.jar file is located. You will see each patient is a separate line. To add a patient into the system, follow this exact format documented here and shown in the provided patients:

FirstName,LastName,DOB,PHQ-9,#,#,#,#,#,#,#,#,#,GAD-7,#,#,#,#,#,#,#,ISI,#,#,#,#,#,#,#,ASRS,#,#,#,#,#,#,CSS,#,#,#,#,#,#,#

Sample Data: 
First Name - Joe
Last Name - Smith
DOB - 3_29_2019
PHQ-9,2,1,1,2,3,1,0,1,1,
GAD-7,0,0,3,1,0,2,1,
ISI,2,2,2,2,2,2,2,
ASRS,0,1,2,3,4,0,
CSS,1,1,1,1,1,1,1

Sample Data in Correct Formatting:
Joe,Smith,3_29_2019,PHQ-9,2,1,1,2,3,1,0,1,1,GAD-7,0,0,3,1,0,2,1,ISI,2,2,2,2,2,2,2,ASRS,0,1,2,3,4,0,CSS,1,1,1,1,1,1,1

### To Report a Bug


## Documentation for Developers
* Source code for the latest version of the software can be obtained by downloading the Project folder in its entirety.
* All source code and .jar files can be found under the Project/JavaCode directory. Documentation, artifacts and version history can be found under the Tracking directory.
* No extra build instructions are currently associated with this software, but may be included at a later date.
* Currently, no test suite is available for this software. Testing must be done manually by running the source code.
* An automated weekly build and test will be implemented at a later date.
* When a new version of the software is created, documentation and artifacts will be updated and the .jar executable file will be updated to run the most recent version of the software.
* All bugs, bug resolutions and pending features will be tracked in a file under the Tracking directory.

## Layout

This displays how to find specific files in the repository:

  * `/Project` All of the code *(Java, etc.)*
  * `/Tracking` Backlogs and burndown charts *(Along with their history)*
  * `Artifacts.md` Displayed artifacts
  
