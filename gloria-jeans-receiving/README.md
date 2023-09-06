#Поставка
Проект предназначен для склада и можно проводить поставку товаров в магазин.
## Требования
- JAVA 11
- Spring boot 2.6.6
- Maven >= 3.6
## Настройки проекта

- Добавить подключение к базе данных:

_Для application.yml:_
```
spring:
  datasource-onec-database:
    jdbcUrl: jdbc:sqlserver://{ADDRESS}:{PORT};databaseName={DATABASE_NAME};encrypt=false
    username: {USERNAME}
    password: {PASSWORD}
    driverClassName: com.microsoft.sqlserver.jdbc.SQLServerDriver
  datasource-internal-database:
    jdbcUrl: jdbc:sqlserver://{ADDRESS}:{PORT};databaseName={DATABASE_NAME};encrypt=false
    username: {USERNAME}
    password: {PASSWORD}
    driverClassName: com.microsoft.sqlserver.jdbc.SQLServerDriver
```

_Для application.properties:_
```
spring.datasource-onec-database.jdbcUrl=jdbc:sqlserver://{ADDRESS}:{PORT};databaseName={DATABASE_NAME};encrypt=false
spring.datasource-onec-database.username={USERNAME}
spring.datasource-onec-database.password={PASSWORD}
spring.datasource-onec-database.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.datasource-internal-database.jdbcUrl=jdbc:sqlserver://{ADDRESS}:{PORT};databaseName={DATABASE_NAME};encrypt=false
spring.datasource-internal-database.username={USERNAME}
spring.datasource-internal-database.password={PASSWORD}
spring.datasource-internal-database.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
```

- Добавить адрес, порт и количество потоков сервера

_Для application.yml:_

```
server:
  port: {PORT}
  address: {ADDRESS}
  jetty:
    threads:
      max: {MAX}
      min: {MIN}
```

_Для application.properties:_

```
server.port= {PORT}
server.address= {ADDRESS}
server.jetty.threads.max= {MAX}
server.jetty.threads.min= {MIN}
```

- Добавить путь к файлу конфигурации 1С:

_Для примера:_
```
onec:
  md:
    path: C:/1С/ARM_MSsql_2008/1Cv7.MD
```
- Добавить путь idd генератора:

_Для application.yml:_

```
idd-generator:
   url: http://{ADDRESS}:{PORT}/idd/generator
```

_Для application.properties:_

```
idd-generator.url= http://{ADDRESS}:{PORT}/idd/generator
```

- Добавить адрес сервера марок:

_Для application.yml:_

```
marks:
  server:
    url: "http://{ADDRESS}:{PORT}"
```

_Для application.properties:_

```
marks.server.url= "http://{ADDRESS}:{PORT}"
```
- Добавить авторизацию сервера марок:

_Для application.yml:_

```
marks:
  server:
    authorization:
      url: "https://{ADDRESS}"
      username: {USERNAME}
      password: {PASSWORD}
```

_Для application.properties:_

```
marks.server.authorization.url= "https://{ADDRESS}"
marks.server.authorization.username= {USERNAME}
marks.server.authorization.password= {PASSWORD}
```

- Добавить авторизацию сервера марок:

_Для application.yml:_

```
marks:
  server:
    authorization:
      url: "https://{ADDRESS}"
      username: {USERNAME}
      password: {PASSWORD}
```

_Для application.properties:_

```
marks.server.authorization.url= "https://{ADDRESS}"
marks.server.authorization.username= {USERNAME}
marks.server.authorization.password= {PASSWORD}
```

- Добавить константы idd марок:

_Для application.yml:_

```
marks:
  constants:
    retail_idd
    continent_idd 
    ecommerce_idd
    kazakhstan_idd
```

_Для application.properties:_

```
marks.constants.retail_idd
marks.constants.continent_idd 
marks.constants.ecommerce_idd
marks.constants.kazakhstan_idd
```
- Добавить константы ИНН марок:

_Для application.yml:_

```
marks:
  constants:
    retail_tin
    continent_tin
    warehouses_tin
    ecommerce_tin
    kazakhstan_tin
```

_Для application.properties:_

```
marks.constants.retail_tin
marks.constants.continent_tin 
marks.constants.warehouses_tin
marks.constants.ecommerce_tin
marks.constants.kazakhstan_tin
```

- Добавить константы КПП марок:

_Для application.yml:_

```
marks:
  constants:
    retail_rrc
    continent_rrc
    warehouse_rrc
```

_Для application.properties:_

```
marks.constants.retail_rrc
marks.constants.continent_rrc 
marks.constants.warehouse_rrc
```

- Добавить константы test марок:

_Для application.yml:_

```
marks:
  constants:
    retail_edm
    continent_edm
    warehouses_edm
```

_Для application.properties:_

```
marks.constants.retail_edm
marks.constants.continent_edm 
marks.constants.warehouses_edm
``` 
- Добавить в поле "VM options" (Run - Edit Configurations - VM options) -Dspring.profiles.active  и значение dev или test 
