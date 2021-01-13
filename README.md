#### spring boot and mysql demo

### deploying on ocp 

```
oc new-project demo-app 

oc new-app mysql -e MYSQL_PASSWORD=Passw0rd_ -e MYSQL_USER=demouser -e MYSQL_DATABASE=demodb

oc new-build ubi8-openjdk-11:1.3~https://github.com/wohshon/sb-mysql-demo.git --name=demo-app 

oc new-app --image-stream=demo-app --env MYSQL_HOST=mysql

oc expose svc demo-app

```

## testing

```
curl http://<your route>/rest/products/all

curl http://<your route>/rest/users/all


```

### accessing the db

<pre>

$ oc rsh <your mysql pod> 
sh-4.4$ mysql -udemouser -pPassw0rd_ demodb
mysql: [Warning] Using a password on the command line interface can be insecure.
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 18
Server version: 8.0.21 Source distribution

Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> select * from product;
+----+--------------+---------------------------------------+------------------+---------+------------+------------------------------+
| id | name         | description                           | img              | price   | product_id | short_desc                   |
+----+--------------+---------------------------------------+------------------+---------+------------+------------------------------+
|  1 | Mac Book Pro | Mac Book Pro 16 long description .... | img/mbp16.png    | 2500.99 | p0001      | Mac Book Pro 16 2020 Edition |
|  2 | Mac Book Pro | Mac Book Pro 13 long description .... | img/mbp13.png    | 1500.99 | p0002      | Mac Book Pro 13 2020 Edition |
|  3 | IPhone 12    | IPhone 12 long description ....       | img/iphone12.png |  700.99 | p0003      | IPhone 12 latest edition     |
|  4 | IPhone 11    | IPhone 11 long description ....       | img/iphone11.png |  690.99 | p0004      | IPhone 12 latest edition     |
+----+--------------+---------------------------------------+------------------+---------+------------+------------------------------+
4 rows in set (0.00 sec)


</pre>
