# SchoolManagement
#Adding a new Entity:
By Post method at:http://localhost:8080/createresource
Adding a new teacher to the database
input:
{
    "firstName":"Bharti",
    "lastName":"Singla",
    "departmentName":"SecondarySection",
    "employmentType":"Fresher",
    "email":"bharti234@abc.com",
    "subjects":[
        {
        "name":"English",
        "description":"English",
        "numberofclasses":"10",
        "email":""
        },
        {
        "name":"Science",
        "description":"Science",
        "numberofclasses":"10",
        "email":""
        }

    ]

}
output:"Resource added successfully!"
![image](https://user-images.githubusercontent.com/106802733/175223563-d6220cab-99a3-4d1e-9b92-a61612d1f444.png)


#Reading Entity:
Using Get method at :
Read all the resources that are added to the database.

output:
[
    {
        "firstName": "Manjulika",
        "lastName": "Tiwari",
        "departmentName": "PrimarySection",
        "employmentType": "Fresher",
        "email": "manju123@abc.com",
        "subjects": [
            {
                "name": "Maths",
                "description": "Maths",
                "numberofclasses": "4",
                "email": "manju123@abc.com"
            },
            {
                "name": "English",
                "description": "English",
                "numberofclasses": "3",
                "email": "manju123@abc.com"
            }
        ]
    },
    {
        "firstName": "Divya",
        "lastName": "Agarwal",
        "departmentName": "SecondarySection",
        "employmentType": "Proessional",
        "email": "divya003@abc.com",
        "subjects": [
            {
                "name": "English",
                "description": "English",
                "numberofclasses": "4",
                "email": "divya003@abc.com"
            },
            {
                "name": "Science",
                "description": "Science",
                "numberofclasses": "5",
                "email": "divya003@abc.com"
            }
        ]
    },
    {
        "firstName": "Virat",
        "lastName": "Kohli",
        "departmentName": "SecondarySection",
        "employmentType": "Professional",
        "email": "vishal443@abc.com",
        "subjects": [
            {
                "name": "English",
                "description": "English",
                "numberofclasses": "4",
                "email": "vishal443@abc.com"
            },
            {
                "name": "Science",
                "description": "Science",
                "numberofclasses": "15",
                "email": "vishal443@abc.com"
            }
        ]
    },
    {
        "firstName": "Bharti",
        "lastName": "Singla",
        "departmentName": "SecondarySection",
        "employmentType": "Fresher",
        "email": "bharti234@abc.com",
        "subjects": [
            {
                "name": "English",
                "description": "English",
                "numberofclasses": "10",
                "email": "bharti234@abc.com"
            },
            {
                "name": "Science",
                "description": "Science",
                "numberofclasses": "10",
                "email": "bharti234@abc.com"
            }
        ]
    }
]
![image](https://user-images.githubusercontent.com/106802733/175224365-acaa8803-6dc1-4847-9335-e46d9c225fd9.png)

#Updating Entity
Update resource using PUT Method at:http://localhost:8080/updateresource
output:"Resource was updated successfully".
![image](https://user-images.githubusercontent.com/106802733/175224843-38ecec83-59e5-4188-ba32-d920d473f6c9.png)

#Delete Entity:
Using DELETE Method at:http://localhost:8080/deleteresource
output:"Removed successfully!"

![image](https://user-images.githubusercontent.com/106802733/175225262-2f1a5f55-275d-43c0-9c1a-c7c7e35d8731.png)

#Database connected to MySql:
![image](https://user-images.githubusercontent.com/106802733/175226424-cc145dae-313a-4be1-b709-aff625d8e8e2.png)



#Database connected to MongoDb:
![image](https://user-images.githubusercontent.com/106802733/175225982-35eb224d-48f8-4dab-b013-6bbd2deb6118.png)




