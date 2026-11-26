# Android Volume & Power Keys

「虚拟按键」为 Android 手机提供三个大号屏幕按钮，可调节音量、锁屏和打开系统电源菜单。适用于 Android 9 及以上，已在华为 Mate 20 X（Android 10 / EMUI 14）上验证。

[下载 APK v1.3](https://github.com/sodino/Android-Volume-Power-keys/raw/refs/heads/develop/apk/android-volume-power-keys-v1.3.apk)

## 安装和使用

1. 下载 APK，在手机上打开并按系统提示安装。这是调试签名安装包。
2. 打开「虚拟按键」。轻点 **音量加** 或 **音量减** 调一档。从任一音量按钮上滑增加音量，下滑减少音量，滑动时会逐档调节。
3. 首次使用电源功能时，轻点 **电源**，选择「打开设置」，在系统无障碍设置中开启「虚拟按键」，然后返回 App。华为手机的入口是「无障碍 → 已安装的服务 → 虚拟按键」。
4. 轻点 **电源** 锁屏，长按打开系统电源菜单，可以选择关机或重启。

手机完全关机后，App 无法开机。如果实体电源键已失灵，只想重新启动时请在系统菜单里选「重启」。

## 真机截图

<img src="docs/screenshots/mate20x.png" alt="华为 Mate 20 X 上的虚拟按键主界面，从上到下是音量减、音量加和电源" width="360">

## 语言

支持简体中文、繁体中文、英文、日语、韩语、阿拉伯语、泰语、越南语、俄语、西班牙语、法语和葡萄牙语。默认跟随系统语言，无匹配语言时显示英文。Android 13 及以上也可在系统设置中为 App 单独选择语言。

## Build from source

Use JDK 17 and Android SDK Platform 35. Open the project in Android Studio or set `ANDROID_HOME` to the SDK directory. Build the APK with the Gradle wrapper.

```sh
./gradlew :app:assembleDebug
```

The build writes the APK to `app/build/outputs/apk/debug/app-debug.apk`.

## English quick start

Install the APK on Android 9 or later. Tap **Volume Up** or **Volume Down** to change volume by one step. Swipe up or down on either volume button to increase or decrease it as you move.

To enable **Power**, tap it and choose **Open Settings**. Turn on **Virtual Keys** in Android Accessibility settings, then return to the app. Tap **Power** to lock the screen or hold it to open the system power menu. If your physical power button is broken, choose **Restart** whenever you want to reboot.
