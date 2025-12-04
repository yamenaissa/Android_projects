// build.gradle.kts (au niveau du projet)

plugins {
    // Gardez les plugins qui sont déjà là
    id("com.android.application") version "8.13.1" apply false // Exemple de version

    // AJOUTEZ CETTE LIGNE :
    id("com.google.gms.google-services") version "4.4.2" apply false
}
    