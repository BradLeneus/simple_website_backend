



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
 
## ScreenShot


<img width="1716" height="951" alt="image" src="https://github.com/user-attachments/assets/bc9e1366-3183-4da6-bf73-98bd4ef8dea6" />

  
   
