# Strict mode
set shell := ["bash", "-euo", "pipefail", "-c"]

# Globals
export GIT_SHA := `git rev-parse --short HEAD`

[private]
default:
	@just --list --unsorted

start-p1: build
    docker-compose -f docker-compose.pid1.yml up

start-p100: build
    docker-compose -f docker-compose.pid100.yml up

start-p-unlimited: build
    docker-compose -f docker-compose.pid-unlimited.yml up

spawn-threads threads="100":
    curl http://localhost:8080/threads/platform/{{threads}}

build:
    ./gradlew clean build -xtest



