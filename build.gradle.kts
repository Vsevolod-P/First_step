plugins {
    kotlin("jvm") version "2.1.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
val seleniumVersion = "4.20.0"
val kotlinVersion = "2.1.0"
val kotlinxDateTime = "0.3.1"
val allureJunitVersion = "2.29.0"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDateTime")
    testImplementation("org.seleniumhq.selenium:selenium-java:$seleniumVersion")
    implementation("io.qameta.allure:allure-junit5:$allureJunitVersion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}