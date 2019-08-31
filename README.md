# The Bank API
The application does money transfer operations between two bank accounts that have IBAN Number, owner name and balance. <br/>
In the project [SparkJava](http://sparkjava.com/) is used for creating web applications in Java. [Lombok](https://projectlombok.org/) framework is used for simple looking classes by not writing getter, setter, equals methods.
As testing frameworks, [JUnit 5](https://junit.org/junit5/) and [Mockito](https://site.mockito.org/) are used. As a Build Tool [Gradle](https://gradle.org/) is used.

### Build and Run
The datastore runs in-memory so that the required data is loaded when the application is up. Three accounts are loaded while creating an instance of the class named `AccountDaoInMemoryImpl` <br/>
The application can be easily up by running the class named `BankApi`. 

### Api usage

For instance the below post request can be called <br/>
`http://localhost:4567/bankapi/transfers/from/FR7630066100410001057380116/to/DE12500105170648489890/10.40`
