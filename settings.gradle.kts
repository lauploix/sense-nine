dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("com.gradle.develocity") version("4.2.2")
    id("com.gradle.common-custom-user-data-gradle-plugin") version "2.4.0"
}

develocity {
    server = "https://ge.gradle.org"
}

rootProject.name = "sense-nine"

include("com.mechanitis.demo.sense.flow",
        "com.mechanitis.demo.sense.client",
        "com.mechanitis.demo.sense.mood",
        "com.mechanitis.demo.sense.service",
        "com.mechanitis.demo.sense.service.test",
        "com.mechanitis.demo.sense.twitter",
        "com.mechanitis.demo.sense.user")
