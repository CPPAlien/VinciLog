# PtLog

Friendly android log lib, includes crash info collection, log saving, and more friendly log printing format

## Features
1, When unexpected crash happened, it can save crash info and device info to local file.
2, Friendly log format: log info includes class name, method name and line num of logging place, make you easy find where the log happened.

## How to use

### Import lib
```
repositories{
    maven { url "https://jitpack.io" }
}
dependencies {
    compile 'com.github.CPPAlien:PtLog:1.0.7'
}
```

### Initiation
```
PtLog.init(boolean isEnable, String tag, Context context)
```
You should init PtLog before using it, if else the log will not be displayed
So you are suggested putting the init code in the Application onCreate method

***Tips: You may use BuildConfig.DEBUG as first parameter, like PtLog.init(BuildConfig.DEBUG, "peng", this); This will make the log printing opened in Debug version and closed in Release version.***

### Save log to local file

```
PtLog.startLogSave()
```
After the code called, the log printed next will be saved.
```
String path = PtLog.getLogPath()
```
Get the log absolute path, you can handle it by yourself. For example, you can show it in a TextView, or upload to your server.
```
PtLog.deleteLog()
```
Delete the log, return true or false

#### Usage
PtLog.d("test");

PtLog.e("test");
...



## TODO
More friendly log format, like logger(https://github.com/orhanobut/logger)

Can set different tag of different log

Maybe send crash or debug info to Slack
