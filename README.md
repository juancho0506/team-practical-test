# team-practical-test
Practical test to develop the concepts required for Team International.

Instructions: 

The project is using H2 memory database to avoid to create scripts and infraestructure issues.
It only runs in Wildfly (I used wildfly-10.1.0.Final version), that why I'm using the ExampleDS datasorce already provided 
int the WildflyServer

1- Run mvn clean install in the pom.xml at the root of the project. This will install all the artifacts and modules.
2- Copy or add the ear file to a wildfly deployments directory. (Or just use the eclipse IDE server tools).
3- The context deployed will be: /team-practical-test-web
4- The part 1 the client form is at the path: /team-practical-test-web/client
5 - The 2 part is a rest endpoint at: /team-practical-test-web/rest/v1/clients GET