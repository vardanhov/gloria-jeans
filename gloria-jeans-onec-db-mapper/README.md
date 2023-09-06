# Маппер 1С базы данных для проектов на JAVA.
Проект предназначен для взаимодействия с конфигурационным файлом 1С (*.md) и СУБД MSSQL с приложениями, разработанными на технологии JAVA.
## Требования
- JAVA 11
- Spring boot 2.6.6
- Maven >= 3.6
## Настройка доступа к приватному репозиторию
Для настройки доступа к приватному репозиторию необходимо добавить файл `settings.xml` в директорию `.m2` которая находятся в домшней директории.

Пример:

```
C:\Users\{YOUR_USER}\.m2\settings.xml
``` 
```
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd">
  <servers>
    <server>
      <id>gitlab-maven</id>
      <configuration>
        <httpHeaders>
        <property>
          <name>Private-Token</name>
          <value>X2EadVFk4iRZfrU4DfRx</value>
        </property>
        </httpHeaders>
      </configuration>
    </server>
  </servers>
</settings>
```
## Подключение библиотеки
Для подключения библиотеки необходимо выполнить в проекте в файле `pom.xml` следующее:
- Указать maven приватный репазиторий
```
<repositories>
  <repository>
    <id>gitlab-maven</id>
    <url>https://gitlab.gloria.aaanet.ru/api/v4/projects/116/packages/maven</url>
  </repository>
</repositories>
```
- Добавить в проект пакет
```
<dependency>
  <groupId>ru.gloria-jeans</groupId>
  <artifactId>1c-db-mapper</artifactId>
  <version>1.0.0</version>
</dependency>
```
- Выполнить команду `mvn clean install`
## Настройка проекта
Перед использованием библиотеки необходимо настроить проект в файле `application.properties` или `application.yml`.
- Добавить путь к файлу конфигурации 1С:
```
onec.md.path=C:/1С/ARM_MSsql_2008/1Cv7.MD
```
- Добавить подключение к базе данных:
```
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName={ИМЯ ВАШЕЙ БД};encrypt=false
spring.datasource.username={ИМЯ ПОЛЬЗОВАТЕЛЯ БД}
spring.datasource.password={ПАРОЛЬ ПОЛЬЗОВАТЕЛЯ БД}
spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
```
- Настройки Spring Data JPA
```
spring.jpa.hibernate.dialect=org.hibernate.dialect.SQLServer2016Dialect
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.physical_naming_strategy=ru.gloria_jeans.onecdbmapper.NamingStrategy
```
## Использование библиотеки
Желательно использовать библиотеку со стандиртизацией Spring Boot в виде сервисов, репозиториев и моделей.
Классы сервисов находятся в пакете `ru.gloria_jeans.onecdbmapper.dao.component`, классы репозиториев в пакете `ru.gloria_jeans.onecdbmapper.dao.repository`, 
классы моделей в пакете `ru.gloria_jeans.onecdbmapper.dao.repository` и классы моделей `ru.gloria_jeans.onecdbmapper.dao.model`.

_Пример:_
```
@Autowired
private JournalRepository journalRepository;
...
Iterator<Journal> journalIterator = journalRepository.findAll().iterator();
```
```
@Autowired
private CurrencyRepository currencyRepository;
@Autowired
private CurrencyService currencyService;
...
Iterator<Currency> currencyIterator = currencyRepository.findAll().iterator();

while (currencyIterator.hasNext()) {
    Currency currency = currencyIterator.next();
    System.out.println(currency.getRate());
    System.out.println(currency.getMultiplicity());
}

List<Currency> currencyList = currencyService.getAll();

for (Currency currency : currencyList) {
    System.out.println(currency.getRate());
    System.out.println(currency.getMultiplicity());
}
```
