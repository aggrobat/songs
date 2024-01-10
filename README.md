# Read Me First
The following was discovered as part of building this project:

* The original package name 'spring-experiments.spring-mongodb' is invalid and this project uses 'springexperiments.springmongodb' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/#build-image)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#data.nosql.mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

### AG: Comments
* Starting MongoDB: sudo systemctl start mongod
* In collection `customer`, when app has run, the inserts do not only contain an `id` field but also a `_class` field `'com.example.accessingdatamongodb.Customer'` &hellip; if you can even call it "fields"
