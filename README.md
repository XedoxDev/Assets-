# Assets++
Helper lib on android for simpled work with assets.

# how use
Download latest verison lib in releases, move file to app/libs and add this file in dependencies in build.gradle:
```groovy
dependencies {
  implementation files("libs/Assetspp-v$[version]-by-Xedox")
}
```

For read assets, use next code:
```java
Assets
  .from(context).
  asset("asset-name").
  read();
```
For copy file to your dir, use it:
```java
Assets
  .from(context)
  .asset("asset-name")
  .toPath("you/path")
  .copy();
```
