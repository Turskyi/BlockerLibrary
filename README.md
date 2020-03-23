[![](https://jitpack.io/v/Turskyi/BlockerLibrary.svg)](https://jitpack.io/#Turskyi/BlockerLibrary)

Instruction for the blocker at the moment:
1. You add this dependency to Gradle 
implementation 'com.github.Turskyi:BlockerLibrary:0.1.0',
2. in onСreate in MainActvity, add this line of code

checkIfAppIsBlocked (this, BLOCK_NAME, PROFILE_ID)

, where BLOCK_NAME and PROFILE_ID is the name of the project (BLOCK_NAME) that will need to be created in the profile (PROFILE_ID) on GitLab.com,

if the project is public, then the application will simply not allow opening.
To unlock a project, just make the project private
In general, that is enough because the application will be useless.

3. Additionally, it is possible for old users to create a Worker and add 

checkIfAppIsBlocked (AppCompatActivity (), BLOCK_NAME, PROFILE_ID)
and for example 

if (appIsBlocked (applicationContext)) {
// and prescribe what should happen to the old user application
}

4. if there is an application class, you also can add

if (appIsBlocked (this)) {
// and you write what should happen
}
