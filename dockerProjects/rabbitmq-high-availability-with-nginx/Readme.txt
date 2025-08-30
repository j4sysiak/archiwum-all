
https://www.youtube.com/watch?v=Gtq9nBr1Ca0&list=PLF5X0J2bZ_k44MMIJvncXgJkzy0KxBGMB&index=8

https://github.com/ekim197711/rabbitmq-nginx/tree/master/ha


==================================================================

cd script-ha
C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\rabbitmq-high-availability-with-nginx\script-ha>
$ docker-compose build
$ docker-compose up

odpalamy rabbita  (na tym etapie będzie chodził na trzech portach):
http://localhost:15000  -- od NGNIX
i jak odpalimy n 1500 to właściwie nie wiemy na jakim będzie chodził Rabbit - mamy dwie możliwości (ngnix jakoś rozdziela ruch pomiedzy te dwie instancje - reverse proxy)
http://localhost:15600  -- od rabbitmq1
http://localhost:15700  -- od rabbitmq2
logujemy się po raz pierwszy na guest hasło: guest
potem na mike hasło: mike


odpalamy scrypt pytona (sendmessages.py), który będzie generował 1000 messagów:

cd python-script/

ale wcześniej trzeba wgrać pakiet: pika

$  conda env list
# conda environments:
#
                         C:\Users\Jacek\anaconda3
base                     c:\Users\Jacek\anaconda3

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\rabbitmq-high-availability-with-nginx\script-ha\python-script>python --version
Python 3.10.1


$ conda config --add channels conda-forge
$ conda install pika
$ python sendmessages.py

Send message to queue hello
Send message to queue hello
Send message to queue hello
[...]

odpalamy Rabbita:

http://localhost:15000
i widzimy kolejki z messagami: Send message to queue hello
W zakładce Overview widać, że cały czas ngnix przełącza Nodes -> namesię pomiędzy: rabbit@rabbitmq2 i rabbit@rabbitmq1







