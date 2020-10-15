# spring-boot-with-keycloak

### Downloading and Installing Keycloak:
There're several distributions to choose from `https://www.keycloak.org/downloads.html`.
However, in this tutorial, we'll be using the standalone version.
Download `keycloak-8.0.1.Final` Standalone server distribution from the official source.

Once we've downloaded the Standalone server distribution, we can unzip and start Keycloak from the terminal:
```
1. unzip keycloak-8.0.1.Final.zip
2. cd keycloak-8.0.1.Final/bin
3. ./standalone.sh -Djboss.socket.binding.port-offset=100
After running ./standalone.sh, Keycloak will be starting its services. Once we see a line containing keycloak-8.0.1.Final (WildFly Core 8.0.1.Final) started, we'll know its start-up is complete.
```
Open a browser and visit `http://localhost:8180`. We'll be redirected to `localhost:8180/auth/admin` to create an administrative login:
### Creating a Realm
Set realm name `spring-boot-keycloak'

### Creating a Client
Client name `keycloak-login`
Valids redirect URL `http://localhost:8089`

### Creating a Role and a User
Add role > role name `user`
Add user > usernane `user` > Credentials(password) > `user` 
User role mapping > realm role `user` to assigned role `user`

### import spring-boot-with-keycloak project
1. `$ mvn clean install`
2. `$ mvn spring-boot:run`
3. Or spring-boot-with-keycloak project import in IDE

### Run spring-boot-with-keycloak project
 Go to browser and enter on browser URL `http://localhost:8089`
