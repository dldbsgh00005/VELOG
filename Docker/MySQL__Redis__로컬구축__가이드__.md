```
# MySQL 8.4
docker run -d -p 3306:3306 --name mysql-local-container -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=database_name --restart unless-stopped mysql:8.4

# Redis
docker run -d -p 6379:6379 --name redis-local-container --restart unless-stopped redis 

```
