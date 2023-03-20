## Postman:

### Routers :

#### Idees :

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
DELETE By Id : http://localhost:8080/idees/delete/52
to delete an idea by id
```json
[]
```

GET By Id : http://localhost:8080/idees/52
to find an idea with it's id 

```json
{
    "id": 52,
    "vote": null,
    "titre": "test8",
    "description": "teeeeeeeeeeeeeeeeeeeeeeeest"
}
```

#### Users : 


POST : http://localhost:8080/users/create
  to create a user. For example :
```json
{
  "id": 1,
  "nom":"John",
  "prenom": "Doe",
  "username": "jpal"

}
```

GET All : http://localhost:8080/users/all
to find all users
````json
[
  {
    "id": 302,
    "nom": "John",
    "prenom": "Doe",
    "username": "jpal",
    "dateNaissance": null,
    "email": null,
    "phone": null,
    "motPasse": null,
    "role": null
  }
]
````
DELETE By Id : http://localhost:8080/users/delete/302
to delete a user by id
```json
[]
```

GET By Id : http://localhost:8080/users/302
to find a user by id

```json
 {
  "id": 302,
  "nom": "John",
  "prenom": "Doe",
  "username": "jpal",
  "dateNaissance": null,
  "email": null,
  "phone": null,
  "motPasse": null,
  "role": null
}
```
#### Events :


POST : http://localhost:8080/events/create
to create an event. For example :
```json
{
  "lieu" : "Lille",
  "category" : SPORT,
  "date" : 15/12/2023 10:50

}
```

GET All : http://localhost:8080/events/all
to find all events
````json
[
  {
    "id": 302,
    "nom": "John",
    "prenom": "Doe",
    "username": "jpal",
    "dateNaissance": null,
    "email": null,
    "phone": null,
    "motPasse": null,
    "role": null
  }
]
````
DELETE By Id : http://localhost:8080/events/delete/302
to delete an event by id
```json
[]
```

GET By Id : http://localhost:8080/events/302
to find an event by id

```json
 {
  "id": 302,
  "nom": "John",
  "prenom": "Doe",
  "username": "jpal",
  "dateNaissance": null,
  "email": null,
  "phone": null,
  "motPasse": null,
  "role": null
}
```
