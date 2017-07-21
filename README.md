# Springboot example
## Run postgresql container
$ docker run -p 5432:5432 -t --name postgres-db -e POSTGRES_PASSWORD=mysecretpassword -d postgres
## Run docker container
docker run -p 8080:8080 -t iuccio/springboot