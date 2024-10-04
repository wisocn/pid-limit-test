# Introduction
This directory is about testing how pid-limits affect native thread allocation in JVM.

# Prerequisites
- Docker
- jdk 21
- curl
- Docker Compose
- just installed for task automation
- Gradle

Or Nix package manager that handles this all for you via flake.nix.

# How to build?

You can build using `just build` command.

```
build:
    ./gradlew clean build -xtest
```

# How to start? 

You can build and package your application in dockerfile. 

You have several steps available.

1. pids_limit set as 1: `just start-p1`
2. pids_limit set as 100: `just start-p100`
2. pids_limit set as unlimited: `just start-p-unlimited`

# How to spawn threads and test?

Verify that the app is running on `http://localhost:8080/info`

Now you can spawn threads with: `just spawn-threads {num}`.
Example: `just spawn-threads 100`

# Spoiler alert:
pids-limit in docker-compose affects how many threads you can spawn. :)

```
The Linux kernel handles both a process and a thread in the same way. 
So, values limiting the number of processes will indirectly also limit the number of threads.

source: https://www.baeldung.com/linux/max-threads-per-process
```

# Useful reading:
1. [Maximum Number of Threads per Process in Linux](https://www.baeldung.com/linux/max-threads-per-process#:~:text=So%2C%20values%20limiting%20the%20number,for%20the%20server%20to%20work
)
