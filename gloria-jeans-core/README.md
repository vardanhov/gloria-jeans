# Библиотека Core для проектов на JAVA

Библиотека предназначена для использования в проектах Receiving, Orders и Catalog.

## Требования

- JAVA 11
- Spring boot 2.6.6
- Maven >= 3.6

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
  <artifactId>core</artifactId>
  <version>1.0.0</version>
</dependency>
```
- Выполнить команду `mvn clean install`
## Настройка проекта
Перед использованием библиотеки необходимо настроить проект в файле `application.properties` или `application.yml`.
- Добавить путь к файлу конфигурации 1С:

_Для примера:_
```
onec.md.path=C:/1С/ARM_MSsql_2008/1Cv7.MD
```  
По стандарту этот файл расположен по пути: D:/ARM/1Cv7.MD