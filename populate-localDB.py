#This script autopopulates dummy student data to a local MongoDB instance
#Requred - pip install pymongo
#Just type "python3 populate-localDB.py students create"
#Does not work if there is any data in the collection, so you may need to run
#"python3 populate-localDB.py students delete" command if your having an issue

import pymongo
import sys

myclient = pymongo.MongoClient("mongodb://localhost:27017")

#Database name
mydb = myclient["Students-debug"]
#Collection name
students = mydb["Students-all"]

def StudentsCreateDB():
    mylist = [
        {
            "_id":"104",
            "name": "Sara Jones",
			"grade": 0,
			"room": 302,
			"cars": [
				"LSV 281",
				"SSS 782"
				]
        },
        {
            "_id":"276",
            "name": "Jathan Purvis",
			"grade": 2,
			"room": 166,
			"cars": [
				"XRT 455"
				]
        },
        {
            "_id":"111",
            "name": "Ameen Schaefer",
			"grade": 0,
			"room": 302,
			"cars": [
				"QTR 678",
				"TGH 342"
				]
        },
        {
            "_id":"501",
            "name": "Guiseppe Kay",
			"grade": 1,
			"room": 212,
			"cars": [
				"QAZ 211",
				"IOP 555"
				]
        },
        {
            "_id":"188",
            "name": "Winston Buckner",
			"grade": 1,
			"room": 212,
			"cars": [
				"VBN 333"
				]
        }
    ]
    students.insert_many(mylist)
    print("Populated Students-all Collection.")
def StudentsDeleteCollection():
    students.drop()
    print("Dropped Students-all Collection")




if(len(sys.argv) > 2):
    if(sys.argv[1] == "students"):
        if(sys.argv[2] == "create"):
            StudentsCreateDB()
        elif(sys.argv[2] == "delete"):
            StudentsDeleteCollection()
    else:
        print("Invalid. HELP: python3 populate-localDB.py students [OPTION]")
        print("[OPTION]: create, delete, help")
else:
    print("Invalid. HELP: python3 populate-localDB.py students [OPTION]")
    print("[OPTION]: create, delete, help")
