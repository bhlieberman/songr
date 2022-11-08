# Songr SpringBoot app

Start this application with `./gradlew bootRun`. The app exposes the following routes on `http://localhost:8080`:

- `/`: This displays a form where users can add their favorite albums. This data is persisted in a PostgreSQL database and returned to the user.
- `/hello`: This greets a generic user
- `/capitalize/{insertWordsHere}`: Replace the brackets and the contained words with a string of your choice to see those words capitalized and echoed back. Beware of URL encoding, though!
- `/albums`: Shows a list of hardcoded albums

This application requires a local installation of PostgreSQL. Once configuration for your environment is complete, a file called `application.properties` should be created in your `/resources` folder. This will look like this:

```#TODO: STEP 1: add in DB url
spring.datasource.url=jdbc:postgresql://localhost:5432/?user=<user>&password=<user>
#spring.datatsource.username=
#spring.datasource.password=

#//spring.jpa.hibernate.dll-auto=create //creates and drops tables everytime you run your app
# UPDATE means check current STATE of DB, updates what it needs to
# NONE, CREATE-DROP,
spring.jpa.hibernate.dll-auto=update
spring.jpa.generate-ddl=true```
```
where `user` and `password` are for your local Postgres setup. Please also be sure to use a JDBC-compliant connection string like the one shown above. Optionally, you can provide your username and password in the `spring.datasource.username` and `spring.datasource.password` properties, respectively.
