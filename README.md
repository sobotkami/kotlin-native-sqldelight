# kotlin-native-sqldelight

A basic demonstration of how to use SQLDelight on Kotlin/Native and configure Gradle using Kotlin.

There is only a Groovy demo in the official documentation. The location of the files to generate are then similarly unclear - so here is a minimal example of a working configuration.

Additionally, for rpm-based Linux distributions, the `freeCompilerArgs` flag must be modified to look for libraries in the correct path. SQLDelight is configured to look for them only in those as defined on debian-based distributions.