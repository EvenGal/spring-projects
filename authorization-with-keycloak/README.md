# Authorization with keycloak

## How to run:

Copy the .env.template file and add admin as password:

[.env.template](.env.template)

Start up the keycloak service:
```shell
docker-compose up -d
```
Access the keycloak admin at: http://localhost:8080

To run the application:
```shell
./mvnw clean install spring-boot:run
```

Request a token from the realm:
```shell
TOKEN=$(curl -X POST http://localhost:8080/realms/main-realm/protocol/openid-connect/token \
     -H "Content-Type: application/x-www-form-urlencoded" \
     -d "grant_type=password" \
     -d "client_id=YOUR_CLIENT_ID" \
     -d "client_secret=YOUR_SECRET" \
     -d "username=YOUR_USERNAME" \
     -d "password=YOUR_PASSWORD" \
     | jq -r '.access_token')
```

Authenticate using the token:
```shell
curl -i http://localhost:8082/me \
-H "Authorization: Bearer ${TOKEN}"
```

Sample response:
```json
{
  "name": "evegal",
  "roles": [
    "handler",
    "offline_access"
  ],
  "scopes": [
    "profile email address phone offline_access"
  ]
}
```