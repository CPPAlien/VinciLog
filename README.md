# PtLog

Friendly log lib, include crash collection and save log to local file

### Features
1, When unexpected crash happened, it can save crash info and device info in local file.
2, Friendly log: log info includes class, method name, and line num of logging place 

### How to use

#### import lib
```
repositories{
    maven { url "https://jitpack.io" }
}
dependencies {
    compile 'com.github.CPPAlien:PtLog:1.0.0'
}
```

#### Initiation
```
PtLog.init(boolean isEnable, String tag, Context context)
```
You should init PtLog before using it, if else the log will not be displayed
So you are suggested putting the init code in the Application onCreate method


#### Start save log in file

```
try {
    PtLog.saveLog("log.txt");
} catch (IOException e) {
    PtLog.e("create log failed", e);
}
```
After the code called, the log printed next will save in log.txt file, 
which under /Android/data/{package_name}/log directory. If you want to save log
in different files, just called the method again, and pass in a different file name.

#### Usage
PtLog.d("test");
PtLog.e("test");
...

### I want to do next
More friendly logging, like logger(https://github.com/orhanobut/logger)
