# Endpoints list

## User 

### change logged user password

```
PUT api/user/password
```
Request:
```
{
	newPassword: string,
	oldPassword: string
}
```

### update logged user profile

```
PUT api/user/profile
```
Request
```
{
	firstname: string,
	lastname: string,
	email: string
}
```
Response
```
{
	id: long,
	username: string,
	firstName: string,
	lastName: string,
	email: string
}
```

### deactivate logged user

```
DELETE api/user
```

### get logged user

```
GET api/user/profile
``` 

Response
```
{
	id: long,
	username: string,
	firstName: string,
	lastName: string,
	email: string
}
```

### get user by id

```
GET api/user/{userId}
```

Response
```
{
	id: long,
	username: string,
	firstName: string,
	lastName: string,
	email: string
}
```

### get user by email

```
GET api/user/email/{email}
```

Response
```
{
	id: long,
	username: string,
	firstName: string,
	lastName: string,
	email: string
}
```

### get all users

```
GET api/users
```

Response
```
{
	userResponseList: 
	[
		id: long,
		username: string,
		firstName: string,
		lastName: string,
		email: string 
	]
}
```

## Shelter

### get shelter by id

```
GET api/shelter/{id}
```

Response
```
{
	id: long,
    name: string,
    addressStreet: string,
    addressBuilding: string,
    addressCity: string,
    addressPostCode: string,
    email: string,
    phone: string,
    description: string 
}
```

### add shelter

```
POST api/shelter
```

Request
```
{
    name: string,
    addressStreet: string,
    addressBuilding: string,
    addressCity: string,
    addressPostCode: string,
    email: string,
    phone: string,
    description: string  
}
```


Response
```
{
	id: long,
    name: string,
    addressStreet: string,
    addressBuilding: string,
    addressCity: string,
    addressPostCode: string,
    email: string,
    phone: string,
    description: string 
}
```

### get shelter by city

```
GET api/shelter/city/{city}
```

Response
```
{
	id: long,
    name: string,
    addressStreet: string,
    addressBuilding: string,
    addressCity: string,
    addressPostCode: string,
    email: string,
    phone: string,
    description: string 
}
```


## AnimalType

### find animalType by id

```
GET api/animalType/{id}
```

Response
```
{
	id: long,
	name: string,
	attributes: 
	[
		id: long,
		name: string,
		type: string
	]
}
```

### add animalType

```
POST api/animalType
```

Request
```
{
	name: name,
	attributesIds:
	[
		attributeId: long
	]
}
```

Response
```
{
	id: long,
	name: string,
	attributes: 
	[
		id: long,
		name: string,
		type: string
	]
}
```

### add attribute to animalType

```
PUT api/animalType/attribute
```

Request
```
{
	attributeId: long,
	animalTypeId: long
}
```

Response
```
{
	id: long,
	name: string,
	attributes: 
	[
		id: long,
		name: string,
		type: string
	]
}
```

## Attribute

### get attribute by id

```
GET api/attribute/{id}
```

Response
```
{
	id: long,
	name: string,
	type: string
}
```

### add attribute

```
POST api/attribute
```
Request

```
{
	name: string,
	type: string
}
```
Response
```
{
	id: long,
	name: string,
	type: string
}
```

## AnimalAttribute

### get animalAttribute by id

```
GET api/animalAttribute/{id}
```

### add animalAttribute

```
POST api/animalAttribute
```

Request:
```
{
	animalId: long,
	attributeId: string,
	value: string
}
```

## Animal

### Get animal by given id
```
GET api/animal/{animalId}
```
Response:
```
{
	id: long,
	name: string,
	descriprion: string,
	typeId: long,
	shelterId: long
}
```

### Add new animal
```
POST api/animal
```
Request:
```
{
	name: string,
	shelterId: long,
	typeId: long,
	description: string
}
```

### Update animal profile

```
PUT api/animal
```
Request:
```
{
	id: long,
	name: string,
	description: string
}
```
Response:
```
{
	id: long,
	name: string,
	description: string,
	typeId: long,
	shelterId: long
}
```

### Get animals by given animal type
```
GET api/animals/type/{animalTypeId}
```
Response:
```
{
	typeId: animalTypeId,
	animalResponseList: 
		[
			id: long,
			name: string,
			description: string,
			typeId: long,
			shelterId: long
		]
}
```

### Get animals by given shelter
```
GET api/animals/shelter/{shelterId}
```
Response:
```
{
	shelterId: shelterId,
	animalResponseList: 
		[
			id: long,
			name: string,
			description: string,
			typeId: long,
			shelterId: long
		]
}
```

## Article

### get article by id
```
GET api/article/{id}
```

### add article
```
POST api/article
```

Request:
```
{
	shelterId: long,
	date: date,
	title: string,
	content: string
}
```