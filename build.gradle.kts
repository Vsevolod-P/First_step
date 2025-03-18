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
val fuelLibraryVersion = "2.3.1"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDateTime")
    testImplementation("org.seleniumhq.selenium:selenium-java:$seleniumVersion")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.fatboyindustrial.gson-javatime-serialisers:gson-javatime-serialisers:1.1.2")
    implementation("io.qameta.allure:allure-junit5:$allureJunitVersion")
    implementation("com.github.kittinunf.fuel:fuel:$fuelLibraryVersion")
    implementation("com.github.kittinunf.fuel:fuel-gson:$fuelLibraryVersion")
    implementation("com.github.kittinunf.fuel:fuel-json:$fuelLibraryVersion")
    implementation("com.github.kittinunf.fuel:fuel-coroutines:$fuelLibraryVersion")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}