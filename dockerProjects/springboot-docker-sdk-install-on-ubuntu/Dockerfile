FROM ubuntu:18.04
RUN apt-get update; apt-get install -y curl zip unzip
RUN rm /bin/sh; ln -s /bin/bash /bin/sh
RUN curl -s "https://get.sdkman.io" | bash; \
source "$HOME/.sdkman/bin/sdkman-init.sh"; \
sdk version; \
sdk install java 12.0.2-zulu ;\
sdk install gradle ;\
gradle -version
COPY myapp.jar /myapp.jar
COPY apprun.sh /apprun.sh
RUN chmod 770 /apprun.sh
ENTRYPOINT ["/bin/bash", "/apprun.sh"]