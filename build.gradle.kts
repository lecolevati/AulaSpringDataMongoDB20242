plugins {
	java
	war
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "br.edu.fateczl"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.session:spring-session-core")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	// https://mvnrepository.com/artifact/org.thymeleaf/thymeleaf
	implementation("org.thymeleaf:thymeleaf:3.1.2.RELEASE")
	// https://mvnrepository.com/artifact/org.thymeleaf/thymeleaf-spring6
	implementation("org.thymeleaf:thymeleaf-spring6:3.1.2.RELEASE")
	// https://mvnrepository.com/artifact/org.apache.tomcat.embed/tomcat-embed-jasper
	implementation("org.apache.tomcat.embed:tomcat-embed-jasper:10.1.33")
	// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation
	implementation("org.springframework.boot:spring-boot-starter-validation:3.3.5")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
