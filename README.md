[![](https://jitpack.io/v/CPPAlien/VinciLog.svg)](https://jitpack.io/#CPPAlien/VinciLog)
# VinciLog

Friendly android log lib, includes crash info collection, log saving, and more friendly log printing format

## Features
1, When unexpected crash happened, it can save crash info and device info to local file.
2, Friendly log format: log info includes thread id, class name, method name and line num of logging place, make you easy find where the log happened.
3, Divide the log into different level, you can chose to display different level log.
## How to use

### Import lib
```
repositories{
    maven { url "https://jitpack.io" }
}
dependencies {
    compile 'com.github.CPPAlien:VinciLog:2.0.0'
}
```

### Initiation
```
VinciLog.init(LogLevel, TAG, Context context);
```
You should init VinciLog before using it, if else the log will not be displayed
So you are suggested putting the init code in the Application onCreate method

###log level instruction
LogLevel.NONE : Do not show any log info

LogLevel.DEBUG : Show debug and above log

LogLevel.INFO : show info and below level log

LogLevel.WARN  : show warn and below level log

LogLevel.ERROR : only show error log

### Example
VinciLog.init(LogLevel.DEBUG, "PENG", this);

VinciLog.e("This is a test");

If the code run, you can see the log displayed in Logcat:

`07-21 14:18:01.738 8529-8529/? E/PENG: [1] MainActivity.onCreate(MainActivity.java:17):This is a test`


`PENG` is the tag

`[1]` is the id of thread the log printed in, 1 means in main thread.

`MainActivity.onCreate` means the log printed in onCreate Method of MainActivity class

`(MainActivity.java:17)` means the log is at 17 lines of the file

`This is a test` is the content of the log

## TODO
More friendly log format, like logger(https://github.com/orhanobut/logger)

Can set different tag of different log

Maybe send crash or debug info to Slack
