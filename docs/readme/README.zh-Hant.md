# Android 音量與電源虛擬按鍵

[简体中文](../../README.md) · **繁體中文** · [English](README.en.md) · [日本語](README.ja.md) · [한국어](README.ko.md) · [العربية](README.ar.md) · [ไทย](README.th.md) · [Tiếng Việt](README.vi.md) · [Русский](README.ru.md) · [Español](README.es.md) · [Français](README.fr.md) · [Português (Brasil)](README.pt.md)

「虛擬按鍵」為 Android 手機提供三個大型螢幕按鈕，可以調整音量、鎖定螢幕及開啟系統電源選單。適用於 Android 9 以上版本，已在華為 Mate 20 X（Android 10 / EMUI 14）上測試。

[下載 APK v1.3](https://github.com/sodino/Android-Volume-Power-keys/raw/refs/heads/develop/apk/android-volume-power-keys-v1.3.apk)

## 安裝與使用

1. 下載以偵錯金鑰簽署的 APK，在手機上開啟檔案，並依照系統提示安裝。
2. 開啟「虛擬按鍵」。輕觸 **音量加** 或 **音量減** 一次調整一格。在任一音量按鈕上向上滑動可提高音量，向下滑動可降低音量，滑動時會逐格調整。
3. 首次使用 **電源** 時，輕觸按鈕並選擇「開啟設定」。在系統無障礙設定中啟用「虛擬按鍵」，再回到應用程式。在測試用的華為手機上，路徑為「無障礙 → 已安裝的服務 → 虛擬按鍵」。
4. 輕觸 **電源** 可鎖定螢幕，長按可開啟系統電源選單，選擇關機或重新啟動。

手機完全關機後，應用程式無法開機。若實體電源鍵已故障，想重新啟動時請在系統電源選單中選擇「重新啟動」。

## 實機截圖

<img src="../screenshots/mate20x.png" alt="華為 Mate 20 X 上的簡體中文介面，由上至下為音量減、音量加及電源" width="360">

## 應用程式語言

應用程式支援上方列出的 12 種語言，預設跟隨系統語言，沒有對應語言時會顯示英文。Android 13 以上版本也可以在系統設定中為此應用程式單獨選擇語言。

## 從原始碼建置

使用 JDK 17 和 Android SDK Platform 35。在 Android Studio 開啟專案，或將 `ANDROID_HOME` 指向 Android SDK 目錄，再用 Gradle Wrapper 建置。

```sh
./gradlew :app:assembleDebug
```

建置完成後，APK 位於 `app/build/outputs/apk/debug/app-debug.apk`。
