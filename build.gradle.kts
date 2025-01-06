plugins {
    kotlin("jvm") version "1.9.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("MainKt")
}

// Use JVM toolchain for consistent versioning
kotlin {
    jvmToolchain(18) // Specify Java 18 as the JVM target version
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(18)) // Align Java with the Kotlin target
    }
}

tasks.test {
    useJUnitPlatform()
}
