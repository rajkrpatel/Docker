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
docker rm container-id1 container-id2 // remove container
docker logs -f web-server //shows live logs
docker logs container-name // shoes current logs
curl http://localhost:8080 //hit localhost url from cmd



Container lifecycle stages
1) Container Running
2) Container Stopped
3) Container Removed
