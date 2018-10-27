IMAGE="diegograssato/spring_app_gradle"
CONTAINER="spring_app_gradle"

.PHONY: debug-jar \
    debug \
	build-jar \
	build-class \
	clean \
	release


debug-jar: clean \
    build-jar \
	test

debug: clean \
    build-class \
	test

test:
	docker run --name $(CONTAINER) --rm \
							-p 8080:8080 \
							-e PHP_FPM_ENABLED='true' \
							-e PHP_ENABLE_MOD='xdebug' \
							-e PHP_DIS_MOD='mongodb' \
							-t $(IMAGE)
release:
	docker build -t $(IMAGE):latest .
	docker push $(IMAGE):latest


clean:
	docker stop $(CONTAINER) || true
	docker rm $(CONTAINER) || true

build-jar:
	docker build -t $(IMAGE):latest --build-arg JAR_FILE=build/libs/spring_app_gradle-0.0.1-SNAPSHOT.jar --no-cache .

build-class:
	 ./gradlew docker