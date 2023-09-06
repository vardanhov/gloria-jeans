# UI Сервер

Проект предназначен для дизайна внешнего вида.

## Требования

- JAVA 11
- Spring boot 2.6.6
- Maven >= 3.6

## Настройки проекта

- Добавить URL базового проекта

_Для application.yml:_

```
base-server-url: http://{BASE_SERVER_ADDRESS}
```

_Для application.properties:_

```
base-server-url= http://{BASE_SERVER_ADDRESS}
```

- Добавить URL проектов Поставки, Интернет заказ и Каталог товаров.

_Для application.yml:_

```
services:
  receiving: http://{RECEIVING_ADDRESS}:{RECEIVING_PORT}/receiving
  orders: http://{ORDERS_ADDRESS}:{ORDERS_PORT}/orders
  catalog: http://{CATALOG_ADDRESS}:{CATALOG_PORT}/catalog
```

_Для application.properties:_

```
services.receiving= http://{RECEIVING_ADDRESS}:{RECEIVING_PORT}/receiving
services.orders= http://{ORDERS_ADDRESS}:{ORDERS_PORT}/orders
services.catalog= http://{CATALOG_ADDRESS}:{CATALOG_PORT}/catalog
```

- Добавить адрес, порт и количество потоков сервера

_Для application.yml:_

```
server:
  port: {UI_SERVER_PORT}
  address: {UI_SERVER_ADDRESS}
  jetty:
    threads:
      max: {MAX}
      min: {MIN}
```

_Для application.properties:_

```
server.port= {UI_SERVER_PORT}
server.address= {UI_SERVER_ADDRESS}
server.jetty.threads.max= {MAX}
server.jetty.threads.min= {MIN}
```

- Добавить URL и атрибут картинки товара

_Для application.yml:_

```
receiving:
  image: https://storage-cdn5.gloria-jeans.ru/pictures
  attribute: _01_300Wx300H.jpg
```

_Для application.properties:_

```
receiving.image= https://storage-cdn5.gloria-jeans.ru/pictures
receiving.attribute= _01_300Wx300H.jpg
```
- Добавить в поле "VM options" (Run - Edit Configurations - VM options) -Dspring.profiles.active  и значение dev или test 