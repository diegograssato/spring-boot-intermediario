# Download dependencies

```
 ./gradlew build
 
```


# SpringBoot bootRun

 
 ```
  ./gradlew bootRun
  
 ```
 
# Generate docker

### Build using JAR
 
```
  
  
  make build-jar 
  
```
 
### Build using Class map
 
```
  
  
  make build-class
  
 ```
 
 
 ### Requests
  
 
```

reset && curl \
  -H 'Content-Type:application/x-www-form-urlencoded' \
  -X POST 'http://localhost:8080/customers' \
  -d 'name=Diego&age=12' | jq .


reset && curl \
  -H 'Content-Type:application/json' \
  -X POST 'http://localhost:9001/visitors' \
  -d '{ "name" : "Hudson Mendes" }' # | python -m json.tool

reset && curl \
  -H 'Content-Type:application/json' \
  -X GET 'http://localhost:8080/customers'| jq .
  
 ```