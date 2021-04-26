import com.google.protobuf.gradle.*

plugins {
    java
    idea
    id("com.google.protobuf") version "0.8.13"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    "org.projectlombok:lombok:1.18.12".let {
        compileOnly(it)
        annotationProcessor(it)
        testCompileOnly(it)
        testAnnotationProcessor(it)
    }

    implementation("io.grpc:grpc-stub:1.37.0")
    implementation("io.grpc:grpc-protobuf:1.37.0")

    implementation("com.google.protobuf:protobuf-java:3.14.0")
    implementation("com.google.protobuf:protobuf-java-util:3.14.0")
    implementation("javax.annotation:javax.annotation-api:1.3.2")

    implementation("org.capnproto:runtime:0.1.5")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
tasks.named<JavaCompile>("compileJava") {
    dependsOn("generateProto")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.13.0"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.15.1"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach { it.plugins { id("grpc") } }
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
