plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kspandroid) apply false
    alias(libs.plugins.dagger.hilt.android) apply false

    kotlin("plugin.serialization") version "1.9.0" apply false
}
