# url-shortener

### Installing

```
git clone https://github.com/agustinservat/url-shortener.git
```

```
cd url-shortener
```

```
docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=url_shortener -e MYSQL_USER=user -e MYSQL_PASSWORD=1234 -d mysql:5.6
```

```
docker build -f Dockerfile -t url-shortener .
```

```
docker run -p 8080:8080 --name url-shortener --link mysql-standalone:mysql -d url-shortener
```

*********

###### Create shortener url: 
- Post: localhost:8080/url
- Body: {"url": "value"}  

###### Access to url shortened:
- Will be redirect to original url

###### Statistics urls: 
- localhost:8080/statistics/url-report : report with dates 
- localhost:8080/statistics/adrr-visited : list of ips that most consulted
- localhost:8080/statistics/agent-visited : list of Browser and SO that most consulted
- localhost:8080/statistics/month-visited : list of number of visits per month
- localhost:8080/statistics/url-visited : list of urls most visited
- localhost:8080/statistics/shortened-visited : list of shortened urls most visited



