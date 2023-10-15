Tento program je vytvořen za pomoci Spring boot v s nasledujcími vlastnostmi:
Maven project 
Spring Boot version 3.0.4 
Java version 17 
packaging type: Jar

Při vytváření této aplkice jsem vycházel z kostry programu od uživatele Francesco Ciulla. 
https://dev.to/francescoxx/java-crud-rest-api-using-spring-boot-hibernate-postgres-docker-and-docker-compose-5cln?fbclid=IwAR3o4UYXPdBAC-9EFVjzFQRO0I9zjBIi4LA8gfR5ECBfe-rExYWFF5VzMuE

Tato Rest API aplikace slouži pro uložení uživatele do databáze, následné ověření emailu a doupravení databáze.
Databáze využívaná pro ukládání je  Postgres, ve které se automaticky vytvoří dvě tabulky. Jedna pro ukládání uživatelů a druhá pro ukládaná ověřovacích kodů.

Pro spusštění a běch aplikace využívám platformu Docker. Pro automatické vytvoření kontejnerů v Dockru používám Docker Compouse, který je vygeneruje ze soubouru docker-compose.yml , ve kterém jsou nastaveny jeho parametry.
Aplikace Obsahuje classu User a HashCode, které slouží jako kostra pro generovanou databázi. Dále sjou tu dvě třidy UserRepository a HashCodeRepository které slouží pro práci s databází.  Třída Controller slouži pro přídávání uživatele i ověřovacího kódu do databaze, a případné jeho odstranění. Nasledující třída UserValidation je pro uvěření spravné syntaxe zadané emailové adressy a telefoního čísla. A EmailValdation pro ověření emailové adressy. Poslední EmailService pro odesílání ověřovacích emailů.

Pro spuštení aplikace zadejete do příkazoveho řádku   "mvn clean package -DskipTests", který vygeneruje z kódu potřebný Jar soubor. 
Dále spustíme Docker a v tadáme příkaz  "docker compose up --build" pro vytvoření všech kontejnerů.

Pro ověření funkčnosti si V nějake API platformě (Postman) otevřeme okno a zadáme adressu: localhost:8080/api/users   přepneme na metodu POST a dáme Body, raw a formát JSON.
poté vložime do těla:
{
    "name":"Jana",
    "secondname":"Pesard",
    "email":"JanaPesrd@seznam.cz",
    "phone":"+420 198 156 478"
}
a odešleme. 

na adresu http://localhost:1080/api/emails by měl přijit ověřovací email. V něm vidíme adressát, subject a poslaný text. Po klinutí na odkaz se otevře další okno v Postmanu a mi můžeme odeslat příkaz pro ověření. 
Vše mužeme zkontrovat v databázové aplikaci (DBeaver), a ujistit se správné funkčnosti.

Tento program byl vytvořen jako aplikace pro ziskávání zkušeností a nedá se použít jako funkční program pro webobovou aplikaci.
-HashCode by měl by réálně silnější text obsahující písmena a znaky.
