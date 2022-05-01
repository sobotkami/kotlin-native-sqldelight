plugins {
    kotlin("multiplatform") version "1.6.21"
    id("com.squareup.sqldelight") version "1.5.3"
}

group = "me.mira"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    linuxX64("native") {
        binaries {
            executable {
                entryPoint = "me.mira.main"
                // A hack for Fedora since Fedora has the libraries under /usr/lib64 compared to other distros
                freeCompilerArgs += listOf("-linker-options", "-lsqlite3 -L/usr/lib/x86_64-linux-gnu -L/usr/lib -L/usr/lib64")
            }
        }
    }
    sourceSets {
        val nativeMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:native-driver:1.5.3")
            }
        }
        val nativeTest by getting
    }
}

sqldelight {
    database("DbHockey") {
        packageName = "me.mira.database"
        sourceFolders = listOf("resources")
    }
}
