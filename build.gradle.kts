plugins {
    application
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "application")

    application {
        mainClass.set("com.insiderser.kpi.java.Main")
    }

    tasks.getByName<JavaExec>("run") {
        standardInput = System.`in`
    }
}
