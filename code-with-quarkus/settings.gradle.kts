pluginManagement {
    resolutionStrategy {
        val credentials: (PasswordCredentials).() -> Unit = {
            username = System.getenv()["ARTIFACTORY_USER"]
            password = System.getenv()["ARTIFACTORY_PASS"]
        }
        repositories {
            maven("https://artifactory.example.com/repository/plugins.gradle.org_m2") { credentials(credentials) }
            maven("https://artifactory.example.com/repository/maven-central/") { credentials(credentials) }
        }
    }
}

dependencyResolutionManagement {
    val credentials: (PasswordCredentials).() -> Unit = {
        username = System.getenv()["ARTIFACTORY_USER"]
        password = System.getenv()["ARTIFACTORY_PASS"]
    }
    repositories {
        maven("https://artifactory.example.com/repository/maven-central/") { credentials(credentials) }
    }
}

rootProject.name = "code-with-quarkus"
