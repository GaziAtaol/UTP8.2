import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    java
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "pj"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
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
    // Spring Boot Web Starter
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Spring Boot DevTools (opcjonalne, dla development)
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Lombok (opcjonalne, dla uproszczenia kodu)
    //compileOnly("org.projectlombok:lombok")
    //annotationProcessor("org.projectlombok:lombok")

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
/*
tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    archiveFileName.set("${archiveBaseName.get()}.jar")
    mainClass.set("pj.CircleServiceApplication")
}

tasks.named<BootRun>("bootRun") {
    // Przekazywanie argumentów systemowych
    systemProperty("circles.file.path", System.getProperty("circles.file.path", "circles.bin"))
}
*/
