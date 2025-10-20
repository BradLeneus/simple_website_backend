IMAGE_NAME=bradleneus/simple-website-backend
CONTAINER_NAME=maintenance_backend
 
build:
	docker build -t $(IMAGE_NAME) .
 
run:
	docker run -d --name $(CONTAINER_NAME) -p 8182:8182 $(IMAGE_NAME)
 
exec:
	docker exec -it $(CONTAINER_NAME) bash
 
stop:
	docker stop $(CONTAINER_NAME)
	docker rm $(CONTAINER_NAME)
 
test:
	docker run --rm $(IMAGE_NAME) mvn clean test
 
restart:
	@$(MAKE) stop
	@$(MAKE) build
	@$(MAKE) run