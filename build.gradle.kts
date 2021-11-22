buildscript {
    repositories {
        google()
        mavenCentral()
    }

}

plugins {
    kotlin("multiplatform") version kotlinVersion apply false
}

allprojects {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }
}