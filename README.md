# LilyConfig
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/jadelily18/LilyConfig?color=ad4fe0&style=flat-square)](https://github.com/jadelily18/LilyConfig/releases/latest)
[![GitHub](https://img.shields.io/github/license/jadelily18/LilyConfig?color=%234690eb&style=flat-square)](https://github.com/jadelily18/LilyConfig/blob/master/LICENSE)
[![Kofi](https://badgen.net/badge/icon/kofi?icon=kofi&label=jadelily&color=pink&style=flat-square)](https://ko-fi.com/jadelily)

##### Simple JSON-based configuration library, made for my Fabric mods.


## Installation

Add the following to your `build.gradle`

```gradle

repositories {
    maven {
        url "https://repsy.io/mvn/jadelily18/repo/"
    }
}

dependencies {
    modImplementation "com.lilydev:LilyConfig:${desired_version}"
    include "com.lilydev:LilyConfig:${desired_version}"
}
```

## Usage

To use the library, simply instantiate the `LilyConfig` class and provide it with the desired file location and the Logger you'd like to use.

```java
LilyConfig myModConfig = new LilyConfig("config/my-mod-config.json", LoggerFactory.getLogger("MyMod"));
```

You can access the config contents itself from the `HashMap<String, Object>` `CONFIG` variable in `LilyConfig.java` and use the `saveConfig()` method when you are ready to write to the JSON file.


```java
myModConfig.CONFIG.put("my_integer", 123);
myModConfig.CONFIG.put("my_boolean", false);

myModConfig.saveConfig();
```


You can even use nested JSON by putting another `HashMap` into `CONFIG`!

```java
HashMap<String, Object> myNestedJson = new HashMap<>();
myNestedJson.put("my_nested_string", "string!");

myModConfig.CONFIG.put("nested_json", myNestedJson);

myModConfig.saveConfig();
```



