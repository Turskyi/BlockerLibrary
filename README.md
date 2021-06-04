# Blocker Library

Distance blocker for mobile apps.
Why? In case if developer does not trust the customer.

Created under impression from [The Hummingbird Project](https://youtu.be/3-IlhKbakFA) 2018 movie.

[![](https://jitpack.io/v/Turskyi/BlockerLibrary.svg)](https://jitpack.io/#Turskyi/BlockerLibrary)

## Instruction of using the blocker library:

### 1. Add maven { url 'https://jitpack.io' } in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {

			maven { url 'https://jitpack.io' }
		}
	}
```

### 2. Add "com.github.Turskyi:BlockerLibrary:$blocker_version" to the app dependencies:

```
dependencies {

    implementation "com.github.Turskyi:BlockerLibrary:$blocker_version"

}
```

### 3. In "onCreate(savedInstanceState: Bundle?)" of MainActvity,  add this line of code

```
checkIfAppIsBlocked (this, BLOCK_NAME, PROFILE_ID)
```

and import

```
import ua.turskyi.blocker.Blocker.checkIfAppIsBlocked
```

, where **BLOCK_NAME** and **PROFILE_ID** is the name of the project (BLOCK_NAME) that will need to be created in the profile (PROFILE_ID) on [GitLab.com](https://gitlab.com/).

  If the project is public, then the application will simply not allow opening.
  In general, that is enough because the application will be useless.

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

• Programming language: **Kotlin**;

• HTTP client: [Retrofit](https://square.github.io/retrofit/);

• Data storage: [SharedPreferences](https://developer.android.com/training/data-storage/shared-preferences);

• Package repository: [JitPack](https://jitpack.io/).
