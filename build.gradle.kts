import org.openjfx.gradle.JavaFXPlatform

plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
    id("org.beryx.runtime") version "1.13.1"
}

group = "edu.bsu.cs"
version = "0.3.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://mvnrepository.com/artifact/org.slf4j/slf4j-nop
    implementation("org.slf4j:slf4j-nop:2.0.16")

    // https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path
    implementation("com.jayway.jsonpath:json-path:2.9.0")

    // https://mvnrepository.com/artifact/commons-io/commons-io
    implementation("commons-io:commons-io:2.17.0")

    // https://mvnrepository.com/artifact/org.ocpsoft.prettytime/prettytime
    implementation("org.ocpsoft.prettytime:prettytime:5.0.9.Final")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("edu.bsu.cs.application.SpeedrunStatsApplication")
    applicationName = "liveboard"
}

javafx {
    version = "22"
    modules("javafx.controls", "javafx.fxml")
}

runtime {
    imageDir.set(project.file("${project.buildDir}/image"))
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    modules.set(listOf("java.desktop", "jdk.unsupported", "java.scripting", "java.logging", "java.xml"))
}