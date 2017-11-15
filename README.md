### Identity ###

This module exposes a REST-interface for the Identity database.

Dev
===
```docker run --name mysql -e MYSQL_DATABASE=register -e MYSQL_USER=db -e MYSQL_PASSWORD=secret -e MYSQL_RANDOM_ROOT_PASSWORD=yes -p 3306:3306 -d mysql:5.7```