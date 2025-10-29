



## Installation du frontend 
 - Étape 1: Installer NPM et Node JS
   ```
   sudo apt update && sudo apt upgrade -y
   sudo apt install nodejs npm -y
   ```
 - Étape 2: Vérifier l'installation de Node JS et NPM
     ```
     node version 20 ou plus requis.
     node -v
     npm -v
     ```
 - Étape 3: cloner le projet frontend
   ```
    git clone  https://github.com/BradLeneus/simple_website.git
   ```
 - Étape 4: se déplacer dans la racine du projet:
   ```
   cd simple_website
   ```
- Étape 5: Installer les dépendances
   ```
   npm i ou npm install
   ```
- Étape 6: démarrer le projet
  ```
  npm run dev 
  ```

  ## Installation du backend
  ps: Si environnment de l'école, allez à l'étape 7 directement.
   - Étape 1 : installer Java 21
     ```
     sudo apt update -y && sudo apt upgrade -y
     sudo apt install openjdk-21-jdk -y
     ```
 - Étape 2 : Vérifier la version
    ```
    java -version
    ```

 - Étape 3 : Installer Maven 
   ```
    sudo apt update
    sudo apt install maven -y
   ```

- Étape 4: Vérifier que c'est installé
   ```
   mvn -version
   ```
- Étape 5: Installer le serveur MariaDB
  ```
  sudo apt install mariadb-server mariadb-client -y
  
  ```
  
- Étape 6 : Création de la base de donnée et User
  ```
  mysql -u root -p
  CREATE DATABASE maintenance;
  CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
  GRANT ALL PRIVILEGES ON maintenance.* TO 'user'@'localhost';
  FLUSH PRIVILEGES;


  ```
- Étape 7: Compilation et démarrage.
  ```
  cd simple_website_backend/labo1
  
  mvn clean compile
  mvn exec:java -Dexec.mainClass="com.example.labo1.Labo1Application"
  ```
 
## Jacoco
```
minimum 75% de couverture total

dans /labo1 -> mvn clean verify

puis -> start .\target\site\jacoco\index.html
```
<img width="1668" height="867" alt="image" src="https://github.com/user-attachments/assets/11a05809-6f45-469b-87d2-3556b43d7cad" />



## Documentation
```

swagger:  http://localhost:8182/swagger-ui/index.html

javadoc -> dans /labo1 mvn clean javadoc:javadoc

Puis ->  start .\target\site\apidocs\index.html
```
<img width="1670" height="935" alt="image" src="https://github.com/user-attachments/assets/6871bd5a-071b-4c67-b117-771ab55454b9" />


## Lien de l'image du docker backend

```
https://hub.docker.com/repository/docker/bradleneus/simple-website-backend/general
```
## Jenkins   
Captures d'écran

<img width="1491" height="758" alt="image" src="https://github.com/user-attachments/assets/8d73c31e-ab4a-4526-84ec-f9542a55e81b" />

<img width="1408" height="797" alt="image" src="https://github.com/user-attachments/assets/eaee3b04-05a5-49e3-9c1d-fb14e52853bc" />

<img width="1408" height="797" alt="image" src="https://github.com/user-attachments/assets/97405c34-d806-4692-ba88-46306183e269" />
<img width="1566" height="581" alt="image" src="https://github.com/user-attachments/assets/bce6a384-4f95-4ded-858c-576bc3baa799" />




