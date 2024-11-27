# Assets++
Helper lib on android for simpled work with assets.

# Installing
1. Download latest verison lib in releases, move file to app/libs and add this file in dependencies in build.gradle:
```gradle
dependencies {
  implementation files("libs/Assetspp-v$[version]-by-Xedox")
}
```
Or
```gradle
implementation fileTree(dir: 'libs', include: ['*.jar', '*.aar']) 
```
2. Add lib in dependencies with jitpack.io. add in settings.gradle, in dependencyResolutionManagement in repositories:
```gradle
maven { url 'https://jitpack.io' }
```
And add its to app/build.gradle dependencies:
```gradle
implementation 'com.github.XedoxDev:Assets_pp:version'
```
# How use
For read assets, use next code:
```java
Assets
  .from(context)
  .asset("asset-name")
  .readAsset();
```
For copy file to your dir, use it:
```java
Assets
  .from(context)
  .asset("asset-name")
  .toPath("you/path")
  .copy();
```
