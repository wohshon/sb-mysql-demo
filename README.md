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
