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

mongo:
	@docker-compose exec mongo mongo

setup:
	@echo "Creating network 'development'..."
	@docker network create --gateway 172.28.0.0/16 development 2>/dev/null; true
