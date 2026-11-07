### Quiz App in JAVA

This has two controllers - Quiz and Questions

Questions - this allows a user to check the questions in the database and add questions to the db

Quiz - this allows a user to create a quiz with n random questions and retrieve the quiz

Model binding was used here - 

1. @PathVariable - used to get data from route/url  
2. @RequestParam - used to get query params
3. @RequestBody - used to get data from the request body

Spring Data JPA was used to connect to the database

1. I was able to create a class to represent a table 
2. If the table did not exist it would be created
3. For the Quiz class I specified a ManyToMany relation with the Question Class
4. The table to implement the many-to-many using @ManyToMany relation was also auto created by jpa
5. I could use JpaRepository interface to extend a DAO interface ⇒ This would implement several basic queries for me
6. For more custom queries ⇒ we can create a function in the DAO interface and specify the query required via @Query annotation
7. @Query ⇒ The query specified can be in JPA Query language or Database specific query