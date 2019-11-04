Installation instructions

First install MongoDB and MongoDB Compass on your local machine and start a local instance.

Open Compass and connect to the local DB instance.  It should be auto populated to connect to a local instance with the default
port.

Create a new DB called "Students-debug" with a collection named "Students-all"

Clone the repository and navigate to the directory you installed to on the command line

(Assume you have installed python3 and pip.  If not, install these first)
type `pip install pymongo`
type `python3 populate-localDB.py students create`

In your IDE you need to create a new project from existing sources.  In IntelliJ you click File -> New -> Project From Existing sources. This should add all the necessary files that aren't included in the repository.

If everything works you should be able to run the application and in the IDE and it will output some spring boot related information in the terminal.

With the application running you should be able to go to `localhost:8080/all/students` in a web browser and see a list of JSON formatted student objects cooresponding to the contents of the MongoDB.
