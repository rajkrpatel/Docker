# Docker command

docker run image-name
docker pull image-name 
docker ps
docker stop container-name
docker run -d nginx // run image in detach mode
docker run -d -p 8080:80 --name web-server nginx   // change port, add name to container
docker stop container-name
docker ps -a // shows all the container running or stopped
docker images // shoes all the images downloaded locally in the system
docker start container-id // start container with given id


Container lifecycle stages
1) Container Running
2) Container Stopped
3) Container Removed
