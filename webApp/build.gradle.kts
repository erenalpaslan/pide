plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("io.ktor.plugin") version "2.3.0"
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting  {
            dependencies {
                implementation(project(":shared"))
            }
        }
    }
}

compose.experimental {
    web.application {}
}