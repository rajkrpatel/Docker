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
15) docker exec -it container-name sh // execute into the terminal inside running container interactive terminal
16) 


Container lifecycle stages
1) Container Running
2) Container Stopped
3) Container Removed
