# Springboot example

## Postgresql
* Build postgresql container from Dockerfile:
    * go to the folder **docker/db** and in terminal type:
~~~docker
$ docker build -t iuccio/postgresql:0.0.1 .
~~~

* Run postgresql container
~~~docker
$ docker run -p 5432:5432 -t --name postgres-db -e POSTGRES_PASSWORD=mysecretpassword -d postgres
~~~

* Run postgresql container with data persistence
~~~docker
$ docker run -d -p 5432:5432 --name postgres-db -v postgres_data:/var/lib/postgresql/data iuccio/postgresql:0.0.1
~~~

* data persistence usefully links:
    * [stackoverflow](https://stackoverflow.com/questions/40167245/how-to-persist-data-using-postgres-docker-image)
    * [Youtube](https://www.youtube.com/watch?v=A-ab9YrvriA)
## Docker commands to remove *
[Remove images, containers, volumes, ...](https://www.digitalocean.com/community/tutorials/how-to-remove-docker-images-containers-and-volumes#removing-volumes)

## Springboot App
* Run springboot app container
~~~docker
docker run -p 8080:8080 -t iuccio/springboot
~~~
* Run docker-compose:
~~~docker
docker-compose up
~~~

The web application is published on *http://localhost:8080/*

## Docker commands

### docker build
~~~docker
docker build -t iuccio/node-web-app:0.0.1 .
~~~
### docker run
~~~docker
docker run -p 3000:3000 --name node-js-web-app -d iuccio/node-web-app
~~~
**-p**: specifies the port that will expose (e.g. -p 3000:3000 -> localhost:3000)

**-d**: runs the container in detached modes (background)

**--name**: gives a name to the running container

### Print log
~~~docker
docker logs <container-id>
~~~
### Enter in the container
~~~docker
docker exec -it <container-id> /bin/bash
~~~

