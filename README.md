# Java Socket Server and Client
This is a simple Java-based socket server and client project.
The server can handle client connections, and clients can send messages
to the server.
The server will print all received messages and can be stopped by
sending the "exit" command from a client.

## Features
- Client-server communication: Clients can send messages to the server, which the server will display.
- Graceful shutdown: The server can shut down gracefully when a client sends the "exit" command.

### Server
The Server class is responsible for:
- Listening for incoming client connections.
- Creating a new thread to handle each client connection.
- Managing the server socket and shutting down the server when needed.

### Client
- Handling communication with an individual client.
- Reading messages from the client.
- Closing the client socket when the client disconnects or sends the "exit" command.

## How to Run
### Step 1: Clone the repo
``` bash
git clone https://github.com/nokonkwo-jpg/BroadcastServer.git
cd BroadcastServer
```
### Step 2: Compile the project
``` bash
javac src/main/java/sockets/*.java
```
### Step 3: Start the server & client
``` bash
java -cp src/main/java sockets.Server
java -cp src/main/java sockets.Client
```
### Step 4: Send messages
Once connected, you can send messages from the client to the
server. The server will print the received messages.
To disconnect the client and stop the server, send the
"exit" command from the client.
## Customization
You can easily customize this project by:

- Changing the port number used by the server (currently 8080).
- Implementing additional logic in the Client class to process client messages differently.
- Extending the client to receive messages from the server or support more complex interactions.

# License