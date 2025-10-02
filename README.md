## Installation du frontend 
 - Étape 1: Installer NPM et Node JS
   ```
   sudo apt update && sudo apt upgrade -y
   sudo apt install nodejs npm -y
   ```
 - Étape 2: Vérifier l'installation de Node JS et NPM
     ```
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
  sudo apt update
  sudo apt upgrade -y
  sudo apt install mariadb-server mariadb-client -y
  ```
- Étape 6: Installer IntelliJ via ce lien : https://www.jetbrains.com/idea/download/?section=linux

- Étape 7: Installer HeidiSQL via ce lien:  https://www.heidisql.com/download.php
- Étape 8: Créer une session Heidi avec le port 3306
-  Étape 9: créer une base de données nommée maintenance
-  Étape 10: cloner le projet backend
   ````
   git clone https://github.com/BradLeneus/simple_website_backend.git
   ````
- Étape 11: ouvrir le projet frontend et backend dans IntelliJ ensemble
- Étape 12: lancer le projet backend avant le projet frontend
  
   
