# Backend component for the "ESports-NBA" CAS service

This backend component is a Spring Boot project, and it was used in the ['SSO and SLO for Spring Boot and Angular applications with CAS'](https://debbabi-nader.github.io/cas-spring-angular/index.html) blog post.

## Requirements

The required tools and their respective versions used, at the time the blog post associated to this repository was written:

* Maven 3.6.2
* Java 1.8
* Apache Tomcat Server 9.0.22
* PostgreSQL 11.5

## Build

```bash
mvn clean package
```

## Deployment

The artifact of this CAS service, was deployed on an Apache Tomcat server, under a folder named `esports#nba`.

After a successful deployment, this CAS service should be available at `https://localhost:8443/esports/nba`.

The "ESports-NBA" CAS service artifact, expects a successful connection to a database named `esports-nba` provided by a running Postgres server.

The `esports-nba.sql` file can be used to populate the `esports-nba` database with some test data.
