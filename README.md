# Backend

# Konfiguracja
W celu konfiguracji połączenia z API należy skopiować plik 
>backend/src/main/application.properties

i zapisać go jako 
>backend/src/main/application-LOCAL.properties

Następnie w pliku tym należy ustawić wartości wybranych parametrów.

Przykładowa konfiguracja może wyglądać w następujący sposób
```
spring.h2.console.enabled=true
spring.h2.console.settings.web-allow-others=true
// port na którym aplikacja będzie uruchamiana
server.port=8080 
//konfiguracja połączenia z bazą danych
spring.jpa.database=POSTGRESQL
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/pet-finder
spring.datasource.username=postgres
spring.datasource.password=MTts9204
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
//konfiguracja jwt
jwt.secret=pet-finder

```


## Wymagania
- Java 8 lub nowsza
- maven

## Instalacja
```
mvn clean install
```
## Uruchomienie (port 8080)
```
java -jar target/pet-finder-{WERSJA}-SNAPSHOT.jar
```
np.
```
java -jar target/pet-finder-0.2.0-SNAPSHOT.jar
```
# Frontend

## Konfiguracja połączenia z API
W celu konfiguracji połączenia z API należy skopiować plik 
>frontend/src/config/default.js

i zapisać go jako 
>frontend/src/config/override.js

Następnie w pliku tym należy ustawić wartośc apiUrl. W przypadku uruchamiania aplikacji lokalnie konfiguracja może wyglądać w następujący sposób:

```js
export default {
    apiUrl: "localhost:8080"
};
```

## Instalacja i uruchamianie

(w katalogu frontend)
### Instalacja komponentów
```
npm install
```

### Uruchamianie frontendu (port 8050)
```
npm run serve
```

### Build produkcyjny
Należy za pomocą polecenia
```
npm run build
```
wygenerować pliki, które zostaną umieszczone w katalogu 
>/frontend/dist

i skonfigurować serwer, żeby korzystał z wygenerowanych plików.

### Obecna wersja
0.2.0