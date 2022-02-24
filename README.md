# oTunes
Second Java Assignment, primarily concerned with exposing DB's as APIs using Spring.

<img src="https://images.macrumors.com/t/vMbr05RQ60tz7V_zS5UEO9SbGR0=/1600x900/smart/article-new/2018/05/apple-music-note.jpg"/>

[![standard-readme compliant](https://img.shields.io/badge/standard--readme-OK-green.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)
[![web]()]()
[![container]()]()

## Table of Contents

- [Background](#background)
- [Install](#install)
- [Usage](#usage)
- [Maintainers](#maintainers)
- [Contributing](#contributing)
- [License](#license)

## Background

This Spring applicaiton is concerned with exposing the Chinook Sqlite database as an API using Spring.

This demo shows a basic Spring application with a complete CI setup to test, build, and deploy the final application on Heroku.

The application consists of the following:

- A basic Rest Controller with one endpoint (`/`) which produces a JSON output.
- Placeholder tests pending additional functionality.
- An OpenAPI configuration endpoint at `/.well-known/oas`. The path for this is configured in `./src/main/resources/application.properties`. This is also not a "real" `.well-known` endpoint, however it probably will be at some point and this puts it out of the way. Without specifying this, the path is set to `/v3/api-docs`.
- The Swagger documentation UI at `/swagger-ui/index.html`.

The CI pipeline will:

- Run tests, proceeding if the tests pass.
- Build the project into a production artifact, proceeding if successful.
- Package the built application into a Docker image, proceeding if successful.
- Push the Docker image to the local registry on Gitlab. This requires a manual trigger.
- Trigger the build pipeline on Heroku to pull the latest image and replace the current running dyno.

### A Primer on URIs

URIs take the following general form:

```
scheme://username:password@target/path/to/your/resource?query=data&foo=bar#fragment
```

Where `target` can be something like a network address of the form: `host[:port]`. For example:

- `foo.example.com`
- `hello.herokuapp.com`
- `localhost:8080`

The API endpoints for the `CustomerContoller` look something like this:

```
GET http://localhost:8080/api/customer
GET http://localhost:8080/api/customer/:id
POST http://localhost:8080/api/customer
PUT http://localhost:8080/api/customer/:id
PATCH http://localhost:8080/api/customer/:id
DELETE http://localhost:8080/api/customer/:id
```

## Install

Gradle will automatically initialize itself and download necessary dependencies the first time the wrapper is run. No explicit installation necessary.

## Usage

For Linux/macOS users, open a terminal and run:

```sh
./gradlew bootRun
```

For Windows users, use `gradlew.bat` instead of `gradlew` in PowerShell.

## Maintainers

[Kasper Gade Andreasen (@)](https://gitlab.com/EternalDeiwos)

## Contributing

PRs accepted.

Small note: If editing the README, please conform to the [standard-readme](https://github.com/RichardLitt/standard-readme) specification.



