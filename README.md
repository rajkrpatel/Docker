# Docker command
1) docker run image-name
2) docker pull image-name 
3) docker ps
4) docker stop container-name
5) docker run -d nginx // run image in detach mode
6) docker run -d -p 8080:80 --name web-server nginx   // change port, add name to container
7) docker stop container-name
8) docker ps -a // shows all the container running or stopped
9) docker images // shoes all the images downloaded locally in the system
10) docker start container-id // start container with given id
11) docker rm container-id1 container-id2 // remove container
12) docker logs -f web-server //shows live logs
13) docker logs container-name // shoes current logs
14) curl http://localhost:8080 //hit localhost url from cmd
15) docker exec -it container-name sh // execute into the terminal inside running container interactive terminal sh stand for shell command
16) example docker exec -it first-app sh
17) docker build -t tag-name .   // to build docker image from docker file run this command from same folder location where Dockerfile is present  DOT is important don't miss it. DOT stand for current build directly from use cmd is executed
18) docker push mailrajkrpatel/first-app:1.0.0 // push the changes to docker registry
19) docker rmi images-id //remove image
20) docker rm $(docker ps -aq) //remove all the non running containers
21) docker rmi -f $(docker images -aq) // force delete all the images
22) docker pause container-name // pause a running container so in memory data will not lost
23) docker unpause container-name // unpause a paused a container
24) docker kill container-name
25) docker history image-name // shows layered history of images
26) docker run --rm -it image-id sh // view image directoy
27) docker run -e PORT=5001 // set environment variable which running the docker
28) docker run -e PORT=5001 -e APP_NAME = "Test APP name" // setting multiple environment from CLI
29) docker run -f custom-docker-file-name . // use this command to build an image if dockerfile name is different then Dockerfile'
30) docker volume create volume-name // create a named volume
31) docker run -d -p 8080:80 --name website-main -v volume-name:/path/to/container/data/ image-name // map named volume to data
32) docker run -d -p 8080:80 --name website-maim -v  ./localhostpath:/app/path image-name // using bind mount
33) docker volumne ls
34) docker volume inspect volume-name
35) docker volume rm volume-name
36) docker volume ls -f dangling=true // find unused dangling volume mean volume which are not used by any containers7
37) docker inspect container-name
38) docker run container-name --restart on-failure
39) docker run container-name --restart on-failure:3 // 3 is limit number, it will try 3 restart
40) docker network ls // shows all the network driver


Container lifecycle stages
1) Container Running
2) Container Stopped
3) Container Removed

# Doker File syntax
1) FROM base-image
2) INSTRUCTION1 args1 args2
3) INSTRUCTION2 args1
4) INSTRUCTION args1 args2......
5) CBM [.....]
6) ENV environment-variable name
7) RUN cmd // npm ci
8) ENTRYPOINT
9) 

# Example 
1) FROM nginx:1.27.0

2) RUN apt-get update
3) RUN apt-get -y install vim

