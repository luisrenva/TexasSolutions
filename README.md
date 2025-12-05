# Texas Solutions API

Access to API in Texas IT Solutions Company
Actions:

### CRUD

We need to set vm parameters to be able to run the app that was build in Gradle
* JDK 23
* Mysql
* Gradle
* .env file in resources folder with the following variables:
  ```
  url=jdbc:mysql://127.0.0.1:3306/home?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
  username=root
  password=your_password
  driverClassName=com.mysql.cj.jdbc.Driver
  ```

### Run app locally:

* ./gradle build
* ./gradle bootRun
* or throuugh IDE -Dspring.profiles.active=local
* ####
  ```` shell 
  SPRING_PROFILES_ACTIVE="local" ./gradlew bootRun

TODO: Rename db and add new sql