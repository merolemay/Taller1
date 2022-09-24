# ***Cali Zoo | Back End*** 💻️

<p style="text-align: justify">
    <i>Web application that allows it to register different types of animals that are exhibited in the cali zoo</i>
</p>

## ***Build With*** 🛠️

<div style="text-align: left">
    <p>
        <a href="https://www.jetbrains.com/es-es/idea/" target="_blank"> <img alt="IntelliJ Idea" src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/intellij/intellij-original.svg" height="60" width = "60"></a>
        <a href="https://www.java.com/es/" target="_blank"> <img alt="Java" src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/java/java-original.svg" height="60" width = "60"></a>
        <a href="https://spring.io" target="_blank"> <img alt="Spring" src="https://raw.githubusercontent.com/devicons/devicon/1119b9f84c0290e0f0b38982099a2bd027a48bf1/icons/spring/spring-original.svg" height="60" width = "60"></a>
    </p>
</div>

## ***Versioned*** 📌

<div style="text-align: left">
    <a href="https://git-scm.com/" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/2ae2a900d2f041da66e950e4d48052658d850630/icons/git/git-original.svg" height="60" width = "60" alt="Git"></a>
    <a href="https://github.com/" target="_blank"> <img src="https://img.icons8.com/fluency-systems-filled/344/ffffff/github.png" height="60" width = "60" alt="GitHub"></a>
</div>

## ***Local Deploy*** 📦

*To run the web app you should follow these steps:*

1️⃣ *Clone or download the repository*

2️⃣ *Clean and install the maven dependencies*

3️⃣ *Run the application*

## ***Json Content Type*** 📧

*The Json content for each Http Request's must follow this format and follow the constraints:*

```json
{
    "name":"[animal's name (Case Sensitive)]",
    "sex":"[animal's sex (M or F)]",
    "age":"[animal's age]",
    "height":"[animal's height (Mts)]",
    "weight":"[animal's weight (KG)]",
    "arrivalDate":"[yyyy-MM-dd HH:mm:ss]",
    "father":"[father's name (Case Sensitive, nullable)]",
    "mother":"[mother's name (Case Sensitive, nullable)]"
}
```

## ***Database IntelliJ Integration*** 📁

*Since we are using an H2 TCP in memory database you could set the IntelliJ datasource following these parameters:*

```properties
connection.type=Remote
driver=H2
host=127.0.0.1
port=8082
authentication=user&password
user=sa
password=
save=forever
database=mem
url=jdbc:h2:tcp://127.0.0.1:8082/mem:zoo
```

*So, while the application is running we should be able to access the database like this*

## ***Author*** ✒️

<div style="text-align: left">
    <a href="https://github.com/cuatrosr" target="_blank"> <img alt="cuatrosr" src="https://images.weserv.nl/?url=avatars.githubusercontent.com/u/70908378?v=4&h=60&w=60&fit=cover&mask=circle"></a>
</div>

---
[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/for-you.svg)](https://forthebadge.com)