# demo


## Использование


Установите проект с помощью команды:

```sh
$ https://github.com/bogdanmuh/fulfillment-center-task.git
```

##  Настройка базы данных
```sql
create database fulfillment_db;
create database fulfillment_db_test;
```


## Настройка параметров окружение

создайте файл .env  и заполните 
```
POSTGRES_DB=jdbc:postgresql://localhost:5432/fulfillment_db
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres

TEST_POSTGRES_DB=jdbc:postgresql://localhost:5432/fulfillment_db_test
TEST_POSTGRES_USER=postgres
TEST_POSTGRES_PASSWORD=postgres
```

## Работа с API



