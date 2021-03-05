# ossrep-account-db

## Run Local Integration Tests
```
./mvnw clean test
```

## Create Image
```
docker build -t quay.io/ossrep/ossrep-account-db:1.0.0 .
```

## Create a Bridge Network
```
docker network create pgnetwork
```

## Run Local Database
```
docker run -d \
    --name test-postgres \
    --network pgnetwork \
    -e POSTGRES_DB=account_db \
    -e POSTGRES_USER=local_user \
    -e POSTGRES_PASSWORD=local_pass \
    -p 5432:5432 \
    postgres:13
```

## Run Image Against Running Database
```
docker run --rm \
    --network pgnetwork \
    quay.io/ossrep/ossrep-account-db:1.0.0 \
    -url=jdbc:postgresql://test-postgres:5432/account_db \
    -user=local_user \
    -password=local_pass \
    info migrate info
```

## Push to Quay.io
```
docker push quay.io/ossrep/ossrep-account-db:1.0.0
```
