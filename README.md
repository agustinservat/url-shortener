# url-shortener

Steps:

1) git clone https://github.com/agustinservat/url-shortener.git

2) Change to the repository directory

3) mvn clean package

4) docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=url_shortener -e MYSQL_USER=user -e MYSQL_PASSWORD=1234 -d mysql:5.6

5) docker build -f Dockerfile -t url-shortener .

6) docker run -p 8080:8080 --name url-shortener --link mysql-standalone:mysql -d url-shortener
