# dihaw-spring-jasperreports
Spring MVC and Jasper report


## Technology used:
	
	* Maven
	* Spring MVC
	* Ireport Design
	* Tiles: in order to create the template (header, body, menu, footer)
	* logback: Logback is intended as a successor to the popular log4j project.

## Import the Git project using STS IDE

    * Go to the File menu and choose Import.
    * Surf in the Import menu to Git and select Projects from Git.
    * Choose URI at this point...
    * After import, click the right mouse button on your project, Configure -> Convert to Maven Project.
    * Compile the project, use "clean compile install" cmd.
    * Run on server ( tomcat server )
    * Go to http://localhost:port/dihaw-spring-jasperreports/
	* The jasper's files will be created on the C:\dihaw\dihaw-spring-jasperreports\jasperreports folder (see the pom.xml file, jasperreports-maven-plugin: Configuration plugin)
    * The log will be setted on the C:\dihaw\dihaw-spring-jasperreports\logs\SystemOut.log file (see the logback.xml file)

## keyword
	
	*Spring MVC, Ireport Design, Jasper Report, Tiles.


	Developed by Wahid Gazzah
	http://team.dihaw.com
	wahid.gazzah@gmail.com
