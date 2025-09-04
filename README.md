# FIle System Simulator

A file system simulator, that run and accept the main commands like a shell.

## Running the project

First, you need to install and configure Docker. Go to <https://docs.docker.com/engine/install/> and follow the step-by-step instructions.

### 1. Clone the repository

Clone the project repository to your local machine using:

```bash
git clone https://github.com/iLorenzz/fileSystemSimulator.git
cd fileSystemSimulator
```

### 2. Build docker image

Make sure you are in the filSystemSimulator directory and build the docker image using:

```bash
docker build -t "fileSystemSimulator" .
```

### 3. Create and run a new container
Make sure the image was created successfully and run the container with the interactive parameters "-it", using:

```bash
docker run -it file_system_simulator
```
