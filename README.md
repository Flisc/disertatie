# dissertation project

Blog articles server hosting with microservices for users, articles and notifications.

localhost: When you use localhost as the host in your code (e.g., router.Run("localhost:8080")), the server will only
listen for incoming connections on the loopback interface of the container. This means that the server will only be
accessible from within the container itself, but not from the host machine or any external devices.

0.0.0.0: When you use 0.0.0.0 as the host (e.g., router.Run("0.0.0.0:8080")), the server will listen for incoming
connections on all available network interfaces, including the loopback interface as well as any external network
interfaces. This makes the server accessible not only from within the container but also from the host machine and
external devices.

In the context of a Docker container, using localhost only makes the service available within the container itself. If
you want to expose the service to the host machine or other devices, you need to use 0.0.0.0.

When you run a Docker container with the -p option (e.g., docker run -p 8080:8080 <IMAGE_NAME>), you are binding a port
on the host machine to a port in the container. In this case, the syntax -p HOST_PORT:CONTAINER_PORT indicates that any
incoming traffic to the host's HOST_PORT will be forwarded to the container's CONTAINER_PORT.

So, if you use router.Run("0.0.0.0:8080"), the server in the container listens on all interfaces and accepts incoming
connections from the host's 8080 port, which is then forwarded to the container's 8080 port.

In summary, the key difference is that 0.0.0.0 allows you to expose your service beyond the container's boundary, making
it accessible from the host machine and other devices, while localhost confines the service to the container itself.
