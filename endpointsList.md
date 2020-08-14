# Endpoints list


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