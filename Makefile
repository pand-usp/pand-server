.PHONY: help build dev start stop clean db mongo setup

help:
	@echo -e "PAND Server - \x1b[1;4;33mMakefile\x1b[m"
	@echo
	@echo "Choose one of the following options:"
	@echo -e "- \x1b[1;4mbuild\x1b[m builds the java application"
	@echo -e "- \x1b[1;4mdev\x1b[m   compiles and runs the server"
	@echo -e "- \x1b[1;4mstart\x1b[m starts the containers"
	@echo -e "- \x1b[1;4mstop\x1b[m  stops the running containers"
	@echo -e "- \x1b[1;4mclean\x1b[m cleans the docker environment and maven's autogenerated files"
	@echo -e "- \x1b[1;4mdb\x1b[m    starts the database container"
	@echo -e "- \x1b[1;4mmongo\x1b[m accesses the database through the already started container"
	@echo -e "- \x1b[1;4msetup\x1b[m configures the \x1b[1mdocker-compose\x1b[m environment for the first time"

build:
	@./mvnw package

dev: stop db
	@./mvnw compile quarkus:dev

start: setup
	@docker-compose up -d
	
stop:
	@docker-compose down

clean:
	@docker-compose stop
	@docker-compose rm -f
	@./mvnw clean

db:
	@docker-compose up -d mongo

mongo: db
	@docker-compose exec mongo mongo

setup:
	@echo "Creating network 'development'..."
	@docker network create --gateway 172.28.0.1 --subnet 172.28.0.0/16 development 2>/dev/null; true
