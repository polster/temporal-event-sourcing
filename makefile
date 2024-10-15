#!makefile

COMPOSE_FILE_INFRA = "./etc/docker-compose/local-dev-infra.yml"
COMPOSE_VOLUMES = $(shell docker volume ls --filter "name=${COMPOSE_PROJECT_NAME}-*" --format "{{.Name}}")

docker-infra-up:
	COMPOSE_PROFILES=$(profiles) \
	docker compose -f ${COMPOSE_FILE_INFRA} up -d

docker-infra-down:
	COMPOSE_PROFILES=$(profiles) \
	docker compose -f ${COMPOSE_FILE_INFRA} down

docker-infra-destroy: docker-infra-down
	docker volume rm ${COMPOSE_VOLUMES}

database-migrate:
	mvn clean -N flyway:migrate \
	    -Dflyway.validateMigrationNaming=true \
        -Dflyway.configFiles=./etc/flyway/flyway.conf

schema-provision:
	mvn clean package \
	    -pl ./services/campaign-events-processor \
	    -Pschema

docker-infra-status:
	docker ps -a \
		--filter "name=${COMPOSE_PROJECT_NAME}*" \
		--format "table {{.ID}}\t{{.Names}}\t{{.Status}}"

.PHONY: docker-infra-up \
    docker-infra-down \
    docker-infra-destroy \
    database-migrate \
    schema-provision \
    docker-infra-status