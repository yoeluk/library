# Library Example

This is an example app generated using the openapi generator. You can find step-by-step guide [here](https://guides.micronaut.io/latest/micronaut-openapi-generator-server-gradle-java.html).

## TODO

* ~~refactor to use Onion Architecture~~
* refactor to use multiple storage layers (ie Postgres as well as MySQL)
* improve build flow with Jib
* add k8s deployment (helm chart)
* add integration and component tests

## openapi-micronaut

This is a generated server based on [Micronaut](https://micronaut.io/) framework.

## Configuration

To run the whole application, use [Application.java](src/main/java/example/micronaut/Application.java) as main class.

Read **[Micronaut Guide](https://docs.micronaut.io/latest/guide/#ideSetup)** for detailed description on IDE setup and Micronaut Framework features.

All the properties can be changed in the [application.yml](src/main/resources/application.yml) file or when creating micronaut application as described in **[Micronaut Guide - Configuration Section](https://docs.micronaut.io/latest/guide/#config)**.

## Controller Guides

Description on how to create Apis is given inside individual api guides:

* [BooksController](docs/controllers/BooksController.md)

## Author

Yoel Garcia Diaz
