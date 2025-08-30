https://www.youtube.com/watch?v=q3ZOY-bmXzM



------------------------------------------------------------
https://www.youtube.com/watch?v=RcWSch8r3Zw&t=303s
Link to Git repo
https://github.com/developer-help/nex...


1. Create a snapshot repo using nexus, or use default coming in out of the box.
2. Create a release repo using nexus, or use default coming out of the box.
3. Create a group repo having both release, snapshot and other third party repos. or use default coming out of the box.
4. Download spring initializer project
5. Go settings.xml under MAVEN_INSTALL_LOCATION\apache-maven-3.6.0\conf or C:\Users\USER_NAME\.m2
6. Create profiles named snapshot and release in settings.xml (can be done in pom.xml as well)
7. Add server user name and pwd in setting.xml (Encrypted recommended).
8. Edit pom.xml and add repository and snapshot repository in distribution management tag
9. Mark id should match in step 7 with server id of settings.xml
10. Run mvn clean deploy, this will publish to snapshot repo
11. Change the version from 1.0-Snapshot to 1.0
12. Run mvn clean deploy -P release, it will deploy it to release repo


---------------------------------------------
1. odpalamy nexusa:
c:\devtools\nexus\nexus-2.15.1-02\bin\
#nexus install
#nexus start

logwanie: http://localhost:9081/nexus
admin / admin123

tworzymy dwa repozytoria:
- maven-snapshots
- maven-release

----------------------------------------------
2. dytujemy plik settle.xml w katalogu mvn'a:

<servers>
	<server>
      <id>mavendeployment</id>
      <username>admin</username>
      <password>admin123</password>
    </server>
</servers>


	<profiles>
		<profile>
    		<id>snapshots</id>
    		 <repositories>
    			<repository>
    				<id>maven-snapshots</id>
    				<name>your custom repo</name>
    				<url>http://localhost:9081/nexus/content/repositories/maven-snapshots</url>
    			</repository>
    		 </repositories>
    	</profile>

    	<profile>
    		<id>release</id>
    		 <repositories>
    			<repository>
    				<id>maven-release</id>
    				<name>your custom repo</name>
    				<url>http://localhost:9081/nexus/content/repositories/maven-release</url>
    			</repository>
    		 </repositories>
    	</profile>
   </profiles>

----------------------------------------------
3. pom.xml

	<distributionManagement>
		<snapshotRepository>
			<id>mavendeployment</id>
			<url>http://localhost:9081/nexus/content/repositories/maven-snapshots</url>
		</snapshotRepository>
		<repository>
			<id>mavendeployment</id>
			<url>http://localhost:9081/nexus/content/repositories/maven-release</url>
		</repository>
	</distributionManagement>



--------------------------------------------------------

nvn clean package
mnv deploy
lub:
mvn clean deploy -P release


ciągnie z lokalnego nexusa :)
[...]
[INFO] --- maven-deploy-plugin:2.8.2:deploy (default-deploy) @ demo-devops ---
Downloading from mavendeployment: http://localhost:9081/nexus/content/repositories/maven-snapshots/com/example/demo-devops/0.0.1-SNAPSHOT/maven-metadata.xml
Downloaded from mavendeployment: http://localhost:9081/nexus/content/repositories/maven-snapshots/com/example/demo-devops/0.0.1-SNAPSHOT/maven-metadata.xml (772 B at 4.8 kB/s)
Uploading to mavendeployment: http://localhost:9081/nexus/content/repositories/maven-snapshots/com/example/demo-devops/0.0.1-SNAPSHOT/demo-devops-0.0.1-20221105.170814-9.war
Uploaded to mavendeployment: http://localhost:9081/nexus/content/repositories/maven-snapshots/com/example/demo-devops/0.0.1-SNAPSHOT/demo-devops-0.0.1-20221105.170814-9.war (8.4 MB at 11 MB/s)
Uploading to mavendeployment: http://localhost:9081/nexus/content/repositories/maven-snapshots/com/example/demo-devops/0.0.1-SNAPSHOT/demo-devops-0.0.1-20221105.170814-9.pom
Uploaded to mavendeployment: http://localhost:9081/nexus/content/repositories/maven-snapshots/com/example/demo-devops/0.0.1-SNAPSHOT/demo-devops-0.0.1-20221105.170814-9.pom (2.2 kB at 9.1 kB/s)
Downloading from mavendeployment: http://localhost:9081/nexus/content/repositories/maven-snapshots/com/example/demo-devops/maven-metadata.xml
Downloaded from mavendeployment: http://localhost:9081/nexus/content/repositories/maven-snapshots/com/example/demo-devops/maven-metadata.xml (282 B at 4.5 kB/s)
Uploading to mavendeployment: http://localhost:9081/nexus/content/repositories/maven-snapshots/com/example/demo-devops/0.0.1-SNAPSHOT/maven-metadata.xml
Uploaded to mavendeployment: http://localhost:9081/nexus/content/repositories/maven-snapshots/com/example/demo-devops/0.0.1-SNAPSHOT/maven-metadata.xml (772 B at 13 kB/s)
Uploading to mavendeployment: http://localhost:9081/nexus/content/repositories/maven-snapshots/com/example/demo-devops/maven-metadata.xml
Uploaded to mavendeployment: http://localhost:9081/nexus/content/repositories/maven-snapshots/com/example/demo-devops/maven-metadata.xml (282 B at 1.8 kB/s)[...]


nasz war z aplikacji demo-devops pojawił się w nexus w repozytoriach: Snapshots,maven-snapshots i maven-release
http://localhost:9081/nexus/#view-repositories;snapshots~browseindex

<dependency>
  <groupId>com.example</groupId>
  <artifactId>demo-devops</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <type>war</type>
</dependency>

