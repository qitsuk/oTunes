# oTunes
Second Java Assignment, primarily concerned with exposing DB's as APIs using Spring.

<img src="https://images.macrumors.com/t/vMbr05RQ60tz7V_zS5UEO9SbGR0=/1600x900/smart/article-new/2018/05/apple-music-note.jpg"/>

[![standard-readme compliant](https://img.shields.io/badge/standard--readme-OK-green.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)
[![web](https://img.shields.io/static/v1?logo=heroku&message=Online&label=Heroku&color=430098)](https://otunes-spring-app.herokuapp.com/)

## Table of Contents

- [Background](#background)
- [Install](#install)
- [Usage](#usage)
- [Maintainers](#maintainers)
- [Online Deployment](#online-deployment)
- [License](#license)

## Background

This Spring applicaiton is concerned with exposing the Chinook Sqlite database as an API using Spring. The application is deployed on Heroku.

The application consists of the following:

- A basic Rest Controller with one endpoint (`/`) which produces a JSON output.
- An OpenAPI configuration endpoint at `/.well-known/oas`. The path for this is configured in `./src/main/resources/application.properties`. This is also not a "real" `.well-known` endpoint, however it probably will be at some point and this puts it out of the way. Without specifying this, the path is set to `/v3/api-docs`.
- The Swagger documentation UI at `https://otunes-spring-app.herokuapp.com//swagger-ui/index.html`.

### A Primer on URIs

The API endpoints for the `CustomerContoller` look like this:

```
GET http://localhost:8080/api/getAlleCustomers
GET http://localhost:8080/api/getCustomerById
GET http://localhost:8080/api/getCustomerByName
GET http://localhost:8080/api/getCustomerSection
GET http://localhost:8080/api/getCustomerInCountry
POST http://localhost:8080/api/addCustomer
PUT http://localhost:8080/api/updateCustomerById
GET http://localhost:8080/api/customerSpender
GET http://localhost:8080/api/customerGenre
```

## Install

Gradle will automatically initialize itself and download necessary dependencies the first time the wrapper is run. No explicit installation necessary.

## Maintainers

[Kasper Gade Andreasen (@qitsuk)](https://github.com/qitsuk)

[Jakob Henriksen (@jakobah37)](https://gitlab.com/jakobah37)

## Online-Deployment

A live version of this project is deployed on Heroku and can be found at https://otunes-spring-app.herokuapp.com/

## License

This project is licensed under the MIT license.

