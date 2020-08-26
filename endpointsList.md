# Endpoints list

## User 

### change logged user password

```
PUT api/user/password
```
Request:
```
{
	newPassword: newPassword,
	oldPassword: oldPassword
}
```

### update logged user profile

```
PUT api/user/profile
```
Request
```
{
	firstname: NewFirstname,
	lastname: NewLastname,
	email: NewEmail
}
```
Response
```
{
	id: userId,
	username: username,
	firstName: firstName,
	lastName: lastName,
	email: email
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
	id: userId,
	username: username,
	firstName: firstName,
	lastName: lastName,
	email: email
}
```

### get user by id

```
GET api/user/{userId}
```

Response
```
{
	id: userId,
	username: username,
	firstName: firstName,
	lastName: lastName,
	email: email
}
```

### get user by email

```
GET api/user/email/{email}
```

Response
```
{
	id: userId,
	username: username,
	firstName: firstName,
	lastName: lastName,
	email: email
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
		id: userId,
		username: username,
		firstName: firstName,
		lastName: lastName,
		email: email 
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
	id: shelterId,
    name: name,
    addressStreet: addressStreet,
    addressBuilding: addressBuilding,
    addressCity: addressCity,
    addressPostCode: addressPostCode,
    email: email,
    phone: phone,
    description: description 
}
```

### add shelter

```
POST api/shelter
```

Request
```
{
    name: name,
    addressStreet: addressStreet,
    addressBuilding: addressBuilding,
    addressCity: addressCity,
    addressPostCode: addressPostCode,
    email: email,
    phone: phone,
    description: description 
}
```

Response
```
{
	id: shelterId,
    name: name,
    addressStreet: addressStreet,
    addressBuilding: addressBuilding,
    addressCity: addressCity,
    addressPostCode: addressPostCode,
    email: email,
    phone: phone,
    description: description 
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
	id: animalTypeId,
	name: animalTypeName,
	attributes: 
	[
		id: attributeId,
		name: attributeName,
		type: attributeType
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
		attributeId
	]
}
```

Response
```
{
	id: animalTypeId,
	name: animalTypeName,
	attributes: 
	[
		id: attributeId,
		name: attributeName,
		type: attributeType
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
	id: attributeId,
	name: name,
	type: type
}
```

### add attribute

```
POST api/attribute
```
Request

```
{
	name: name,
	type: type
}
```
Response
```
{
	id: attributeId,
	name: name,
	type: type
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
	animalId: animalId,
	attributeId: attributeId,
	value: value
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
	id: animal_id,
	name: animal_name,
	descriprion: animal_description,
	typeId: animalTypeId,
	shelterId: shelterId
}
```

### Add new animal
```
POST api/animal
```
Request:
```
{
	name: animal_name,
	shelterId: shelterId,
	typeId: animalTypeId,
	description: animal_description
}
```

### Update animal profile

```
PUT api/animal
```
Request:
```
{
	id: animal_id,
	name: animal_name,
	description: animal_description
}
```
Response:
```
{
	id: animal_id,
	name: animal_name,
	description: animal_description,
	typeId: animalTypeId,
	shelterId: shelterId
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
			id: animal_id,
			name: animal_name,
			description: animal_description,
			typeId: animalTypeId,
			shelterId: shelterId
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
			id: animal_id,
			name: animal_name,
			description: animal_description,
			typeId: animalTypeId,
			shelterId: shelterId
		]
}
```