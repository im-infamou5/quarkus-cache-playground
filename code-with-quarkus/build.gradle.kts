import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
    kotlin("plugin.allopen") version "1.5.21"
    id("io.quarkus") version "2.7.0.Final"
    java
    application
    idea
}

group = "org.acme"

java { toolchain { languageVersion.set(JavaLanguageVersion.of(11)) } }

object Versions {
    val quarkus = "2.7.0.Final"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    // quarkus
    implementation(enforcedPlatform("io.quarkus:quarkus-universe-bom:${Versions.quarkus}"))
    implementation(quarkus("kotlin"))
    implementation(quarkus("cache"))

    testImplementation(quarkus("junit5"))
    testImplementation("io.kotest:kotest-runner-junit5:4.6.3")
    testImplementation("io.kotest:kotest-property:4.6.3")
    testImplementation("io.kotest:kotest-assertions-core:4.6.3")
    testImplementation("io.mockk:mockk:1.12.0")
    testImplementation(quarkus("junit5-mockito"))
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")

}

tasks.test {
    useJUnitPlatform()
    systemProperty("kotest.proptest.default.iteration.count", "10")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

fun quarkus(module: String) = "io.quarkus:quarkus-$module"