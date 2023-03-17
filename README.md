## Postman:

### Routers :

- Idees :

POST : http://localhost:8080/idees/create
to create an idea. For example : 
```json
{
    "titre" : "idea18",
    "description" : "This is an idea"
}
```

GET All : http://localhost:8080/idees/all
to find all ideas
````json
[
{
"id": 1,
"vote": null,
"titre": "idea1",
"description": "this is an idea"
}
]
````
DELETE By Id : http://localhost:8080/idees/delete/{id}
to delete an idea by id