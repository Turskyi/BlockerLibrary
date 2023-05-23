# Blocker Library [![](https://jitpack.io/v/Turskyi/BlockerLibrary.svg)](https://jitpack.io/#Turskyi/BlockerLibrary)

Distance blocker for mobile apps.

**Why?**

In case if developer does not trust the customer.

Created under impression from [The Hummingbird Project](https://youtu.be/3-IlhKbakFA) 2018 movie.

## Instruction of using the blocker library:

### 1. Add maven { url 'https://jitpack.io' } in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {

			maven { url 'https://jitpack.io' }
		}
	}
```

### 2. Add "com.github.Turskyi:BlockerLibrary:$[blocker_version](https://jitpack.io/#Turskyi/BlockerLibrary)" to the app dependencies:

```
dependencies {

    implementation "com.github.Turskyi:BlockerLibrary:$blocker_version"

}
```

### 3. In "onCreate(savedInstanceState: Bundle?)" of MainActivity,  add this line of code

```
checkIfAppIsBlocked (this, BLOCK_NAME, PROFILE_ID)
```

and import

```
import ua.turskyi.blocker.Blocker.checkIfAppIsBlocked
```

where **BLOCK_NAME** and **PROFILE_ID** is the name of the project (BLOCK_NAME) that will need to be
created in the profile (PROFILE_ID) on [GitLab.com](https://gitlab.com/).

*for example here* https://gitlab.com/Turskyi - "Turskyi" is my PROFILE_ID

If the project is public, then the application will simply not allow opening. In general, that is
enough because the application will be useless.

To unlock a project, just make the project private.

### 4. Additionally, it is possible to create a [Worker](https://developer.android.com/reference/androidx/work/Worker#:~:text=androidx.work.ListenableWorker-,%E2%86%B3,getExecutor()%20) and add

```
checkIfAppIsBlocked (AppCompatActivity(), BLOCK_NAME, PROFILE_ID)
```

and for example 

```
if (appIsBlocked(applicationContext)) {
// and prescribe what should happen to the old user application
}
```

### 5. if there is an application class, you also can use this method there

```
if (appIsBlocked(this)) {
// and you write what should happen
}
```

## PROJECT SPECIFICATION
• Package repository: [JitPack](https://jitpack.io/#Turskyi/BlockerLibrary);

• Operating system: [Android](https://www.android.com/);

• Programming language: [Kotlin](https://kotlinlang.org/);

• Interface: [XML](https://developer.android.com/guide/topics/ui/declaring-layout);

• SDK: [Android](https://developer.android.com/studio/intro);

• HTTP client: [Retrofit](https://square.github.io/retrofit/);

• Data
storage: [SharedPreferences](https://developer.android.com/training/data-storage/shared-preferences)
;

• Functionality: App has an example project which simply shows a text message indicating if the app
is not blocked, since if it would be blocked, it would not be running and closed immediately.  
Every new update of the project, I navigate to the **"Releases"** section on the right of this
GitHub repository page and create a new release, incrementing version, then I open
the [jitpack.io](https://jitpack.io/#Turskyi/BlockerLibrary) repository page and click "Get it"
button in front of new release version, to check if it does not have errors.

• **Code Readability:** code is easily readable such that a fellow programmer can understand the
purpose of the app, all variables, methods, and resource IDs are descriptively named such that
another developer reading the code can easily understand their function, no unnecessary blank lines,
no unused variables or methods, no commented out code.
