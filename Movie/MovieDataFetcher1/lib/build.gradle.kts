plugins {
    id("java")
    id("application")
}

group = "com.tmdb"
version = "1.0"

application {
    mainClass.set("_MovieDataFetcher1.MainClass") // 메인 클래스 경로
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.9.3") // OkHttp 라이브러리
    implementation("org.json:json:20210307") // JSON 파싱 라이브러리
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2") // JUnit 5 버전
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2") // Jackson Databind
	implementation("org.openjfx:javafx-controls:20") // JavaFX 버전
    implementation("org.openjfx:javafx-fxml:20")
    implementation("mysql:mysql-connector-java:8.0.33")
}

java {
    sourceSets {
        main {
            java.srcDirs("src/main/java")
            resources.srcDirs("src/main/resources")
        }
        test {
            java.srcDirs("src/test/java")
            resources.srcDirs("src/test/resources")
        }
    }
}
