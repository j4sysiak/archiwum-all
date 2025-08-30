https://www.youtube.com/watch?v=hc3sw-njQuA&list=PLF5X0J2bZ_k44MMIJvncXgJkzy0KxBGMB&index=2



C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker build --help

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker rmi $(docker images -q)
C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker rmi $(docker images -q) -f

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker ps -a
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES


C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker build .

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker images
REPOSITORY   TAG       IMAGE ID       CREATED         SIZE
<none>       <none>    b0d29695a004   3 minutes ago   122MB

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker build -t myimage:latest .

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker images
REPOSITORY   TAG       IMAGE ID       CREATED         SIZE
myimage      latest    b0d29695a004   3 minutes ago   122MB

UWAGA - po każdej modyfikacji pliku Dockerfile trzeba robić builda:  docker build -t myimage:latest .
... i dopiero potem run:

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2> docker run myimage:latest
hello our container is running My first argument Standard argument no 2

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2> docker inspect myimage:latest


C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2> docker run --rm myimage:latest  Jacek argument here
hello our container is running Jacek argument here

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker ps -a
CONTAINER ID   IMAGE            COMMAND                  CREATED          STATUS                      PORTS     NAMES
ec62be636f70   myimage:latest   "echo 'hello our con…"   31 seconds ago   Exited (0) 28 seconds ago             nostalgic_cartwright


C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2> docker run -p 8080:8080 -p 8090:8080 myimage:latest  Jacek argument here
C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2> docker run -it myimage:latest  Jacek argument here
C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2> docker run -it myimage:latest /bin/bash


C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker ps
CONTAINER ID   IMAGE            COMMAND       CREATED          STATUS          PORTS      NAMES
64d5a15531b7   myimage:latest   "/bin/bash"   59 seconds ago   Up 56 seconds   8080/tcp   objective_sutherland


---  możemy ten docker odpalić na innym terminalu (tj. podpiąć się do niego):
w tym celu odpalamy jakiś inny terminal:

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker ps
CONTAINER ID   IMAGE            COMMAND       CREATED          STATUS          PORTS      NAMES
9f0939485249   myimage:latest   "/bin/bash"   17 seconds ago   Up 14 seconds   8080/tcp   ecstatic_ellis



bierzemy CONTAINER ID   lub     NAMES

i mamy kolejny dostęp do powłoki ubuntu

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker exec -it 9f09 /bin/bash
root@9f0939485249:/tmp#



C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script2>docker run -it -e "MYVARIABLE2"="xxxxxxxxxxxxx" myimage:latest /bin/bash
root@f560f7d6ffc1:/tmp# env
HOSTNAME=f560f7d6ffc1
PWD=/tmp
HOME=/root
LS_COLORS=rs=0:di=01;34:ln=01;36:mh=00:pi=40;33:so=01;35:do=01;35:bd=40;33;01:cd=40;33;01:or=40;31;01:mi=00:su=37;41:sg=30;43:ca=30;41:tw=30;42:ow=34;42:st=37;44:ex=01;32:*.tar=01;31:*.tgz=01;31:*.arc=01;31:*.arj=01;31:*.taz=01;31:*.lha=01;31:*.lz4=01;31:*.lzh=01;31:*.lzma=01;31:*.tlz=01;31:*.txz=01;31:*.tzo=01;31:*.t7z=01;31:*.zip=01;31:*.z=01;31:*.dz=01;31:*.gz=01;31:*.lrz=01;31:*.lz=01;31:*.lzo=01;31:*.xz=01;31:*.zst=01;31:*.tzst=01;31:*.bz2=01;31:*.bz=01;31:*.tbz=01;31:*.tbz2=01;31:*.tz=01;31:*.deb=01;31:*.rpm=01;31:*.jar=01;31:*.war=01;31:*.ear=01;31:*.sar=01;31:*.rar=01;31:*.alz=01;31:*.ace=01;31:*.zoo=01;31:*.cpio=01;31:*.7z=01;31:*.rz=01;31:*.cab=01;31:*.wim=01;31:*.swm=01;31:*.dwm=01;31:*.esd=01;31:*.jpg=01;35:*.jpeg=01;35:*.mjpg=01;35:*.mjpeg=01;35:*.gif=01;35:*.bmp=01;35:*.pbm=01;35:*.pgm=01;35:*.ppm=01;35:*.tga=01;35:*.xbm=01;35:*.xpm=01;35:*.tif=01;35:*.tiff=01;35:*.png=01;35:*.svg=01;35:*.svgz=01;35:*.mng=01;35:*.pcx=01;35:*.mov=01;35:*.mpg=01;35:*.mpeg=01;35:*.m2v=01;35:*.mkv=01;35:*.webm=01;35:*.webp=01;35:*.ogm=01;35:*.mp4=01;35:*.m4v=01;35:*.mp4v=01;35:*.vob=01;35:*.qt=01;35:*.nuv=01;35:*.wmv=01;35:*.asf=01;35:*.rm=01;35:*.rmvb=01;35:*.flc=01;35:*.avi=01;35:*.fli=01;35:*.flv=01;35:*.gl=01;35:*.dl=01;35:*.xcf=01;35:*.xwd=01;35:*.yuv=01;35:*.cgm=01;35:*.emf=01;35:*.ogv=01;35:*.ogx=01;35:*.aac=00;36:*.au=00;36:*.flac=00;36:*.m4a=00;36:*.mid=00;36:*.midi=00;36:*.mka=00;36:*.mp3=00;36:*.mpc=00;36:*.ogg=00;36:*.ra=00;36:*.wav=00;36:*.oga=00;36:*.opus=00;36:*.spx=00;36:*.xspf=00;36:
MYVARIABLE=TEST123
TERM=xterm
SHLVL=1
MYVARIABLE2=xxxxxxxxxxxxx
PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
_=/usr/bin/env
root@f560f7d6ffc1:/tmp#
















