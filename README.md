# Java Socket Communication Project

This project implements a simple client-server architecture using Java sockets. The server listens for client connections on a specified port, and the client can send messages to the server. The server reads and displays the messages sent by the client.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
  - [Running the Server](#running-the-server)
  - [Running the Client](#running-the-client)
- [Configuration](#configuration)
- [Dependencies](#dependencies)
- [Troubleshooting](#troubleshooting)
- [Contributors](#contributors)
- [License](#license)

## Introduction

This is a simple demonstration of socket programming in Java. The project consists of two main classes:
- **Server**: A socket server that listens on port `8080` and accepts incoming client connections.
- **Client**: A client that connects to the server and sends a message.

The server continuously runs, accepting client connections, and prints the received messages to the console. The client allows a user to input a message and send it to the server.

## Features

- A simple multithreaded server that handles multiple client connections.
- Clients can send messages to the server.
- Messages from clients are displayed in the server console.
- Graceful shutdown of both server and client.

## Installation

1. Ensure you have Java installed (Java 8 or higher).
2. Clone the repository or download the source files.

```bash
git clone <repository-url>
