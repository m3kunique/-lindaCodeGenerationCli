plugins {
	java
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
	id("org.graalvm.buildtools.native") version "0.9.28"
}

group = "dev.lxqtpr"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}
repositories {
	mavenCentral()
	gradlePluginPortal()
}

extra["springShellVersion"] = "3.1.4"

dependencies {
	implementation("org.springframework.shell:spring-shell-starter")
	implementation("org.atteo:evo-inflector:1.3")
	compileOnly("org.projectlombok:lombok:1.18.30")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.shell:spring-shell-dependencies:${property("springShellVersion")}")
	}
}
tasks.withType<Test> {
	useJUnitPlatform()
}
