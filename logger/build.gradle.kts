plugins {
    kotlin("multiplatform")
    id("com.android.library")
    `maven-publish`
    signing
}

group = Details.groupId
version = Versions.app

kotlin {
    if (Features.isAndroidEnabled) {
        android {
            publishLibraryVariants("release", "debug")
        }
    }
    jvm()
    js(BOTH)
    ios {
        binaries {
            framework {
                baseName = "KLogger"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }
}

publishing {
    publications {
        group = Details.groupId
        publications.withType<MavenPublication> {
            groupId = Details.groupId
            pom {
                name.set("Multiplatform logger")
                description.set("Logger classes")
                url.set("http://www.dragossusi.ro/logger")
            }
        }
    }
}

if (Features.isAndroidEnabled) {
    apply(plugin = "install-android")
}

apply<PublishPlugin>()