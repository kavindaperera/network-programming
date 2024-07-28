# 🌐 Network Programming

Welcome to the Network Programming repository! This repository contains various examples and exercises related to network programming, primarily using Java.

## 📋 Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Repository Tree](#repository-tree)


## 📋 Table of Contents

This repository is a collection of network programming examples designed to help you understand and implement network communication using Java. It includes examples such as TCP echo server and client, UDP communication, and other common networking tasks.

## 📋 Table of Contents

To run the examples in this repository, you will need the following:

- ☕ Java Development Kit (JDK) 8 or higher
- 🖥️ A code editor or IDE (e.g., IntelliJ IDEA, Eclipse, VSCode)

# 🏗️ Setup

1. **Clone the repository:**

    ```sh
    git clone https://github.com/kavindaperera/network-programming.git
    ```

2. **Navigate to the project directory:**

    ```sh
    cd network-programming
    ```

3. **Open the project in your preferred IDE or code editor.**


## 🌳 Repository Tree
```
📦 
├─ .gitignore
└─ network-programming
   ├─ network-programming.iml
   ├─ pom.xml
   └─ src
      ├─ main
      │  └─ java
      │     └─ com
      │        └─ nova
      │           ├─ basicsockets
      │           │  ├─ InetAddressExample.java
      │           │  ├─ tcpsockets
      │           │  │  ├─ TCPByteToByteEchoServer.java
      │           │  │  ├─ TCPEchoClient.java
      │           │  │  └─ TCPEchoServer.java
      │           │  └─ udpsockets
      │           │     ├─ UDPEchoClientTimeout.java
      │           │     ├─ UDPEchoServer.java
      │           │     ├─ UDPReceiver.java
      │           │     ├─ UDPReceiverWithOffset.java
      │           │     └─ UDPSender.java
      │           ├─ data
      │           │  └─ BruteForceCoding.java
      │           └─ netty
      │              ├─ client
      │              │  ├─ NettyClient.java
      │              │  ├─ decoders
      │              │  │  └─ ResponseDataDecoder.java
      │              │  ├─ encoders
      │              │  │  └─ RequestDataEncoder.java
      │              │  └─ handlers
      │              │     └─ ClientHandler.java
      │              ├─ models
      │              │  ├─ RequestData.java
      │              │  └─ ResponseData.java
      │              └─ server
      │                 ├─ NettyServer.java
      │                 ├─ decorders
      │                 │  └─ RequestDecoder.java
      │                 ├─ encoders
      │                 │  └─ ResponseDataEncoder.java
      │                 └─ handlers
      │                    ├─ ProcessingHandler.java
      │                    └─ SimpleProcessingHandler.java
      └─ test
         └─ java
            └─ com
               └─ nova
                  └─ AppTest.java
```
