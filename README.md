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
    compile 'com.github.CPPAlien:PtLog:1.0.6'
}
```

### Initiation
```
PtLog.init(boolean isEnable, String tag, Context context)
```
You should init PtLog before using it, if else the log will not be displayed
So you are suggested putting the init code in the Application onCreate method

***Tips: You can use BuildConfig.DEBUG as first parameter, like PtLog.init(BuildConfig.DEBUG, "peng", this); This will make the log printing opened in Debug version and closed in Release version.***

### Save log to local file

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

**NOTICE:**

You should add permission to access external storage.

```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```

If your app run at Android 6.0 or above device, you should request the permission by yourself.

```
boolean hasPermission = (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
if (!hasPermission) {
    ActivityCompat.requestPermissions(this,
    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
        REQUEST_WRITE_STORAGE);
} else {
    logSave();
}
...
@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    switch (requestCode)
    {
        case REQUEST_WRITE_STORAGE: {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                logSave();
            } else {
                //permission not be granted
            }
        }
    }

}
```


#### Usage
PtLog.d("test");

PtLog.e("test");
...



## TODO
More friendly log format, like logger(https://github.com/orhanobut/logger)

Can set different tag of different log

Maybe send crash or debug info to Slack
