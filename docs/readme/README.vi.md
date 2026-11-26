# Phím âm lượng và nút nguồn cho Android

[简体中文](../../README.md) · [繁體中文](README.zh-Hant.md) · [English](README.en.md) · [日本語](README.ja.md) · [한국어](README.ko.md) · [العربية](README.ar.md) · [ไทย](README.th.md) · **Tiếng Việt** · [Русский](README.ru.md) · [Español](README.es.md) · [Français](README.fr.md) · [Português (Brasil)](README.pt.md)

Phím ảo cung cấp ba nút lớn trên màn hình để chỉnh âm lượng, khóa màn hình và mở menu nguồn của hệ thống. Ứng dụng hỗ trợ Android 9 trở lên và đã được kiểm thử trên Huawei Mate 20 X chạy Android 10 với EMUI 14.

[Tải APK v1.3](https://github.com/sodino/Android-Volume-Power-keys/raw/refs/heads/develop/apk/android-volume-power-keys-v1.3.apk)

## Cài đặt và sử dụng

1. Tải tệp APK được ký bằng khóa gỡ lỗi. Mở tệp trên điện thoại rồi làm theo hướng dẫn cài đặt của Android.
2. Mở **Phím ảo**. Chạm **Tăng âm lượng** hoặc **Giảm âm lượng** để chỉnh một mức. Vuốt lên trên một trong hai nút âm lượng để tăng hoặc vuốt xuống để giảm. Âm lượng thay đổi từng mức trong lúc vuốt.
3. Lần đầu sử dụng nút **Nguồn**, hãy chạm vào nút rồi chọn **Mở cài đặt**. Bật **Phím ảo** trong phần cài đặt Trợ năng của hệ thống, sau đó quay lại ứng dụng. Trên điện thoại Huawei dùng để kiểm thử, mục này nằm trong **Trợ năng → Dịch vụ đã cài đặt → Phím ảo**.
4. Chạm **Nguồn** để khóa màn hình. Nhấn giữ để mở menu hệ thống và chọn tắt nguồn hoặc khởi động lại.

Khi điện thoại đã tắt hẳn, ứng dụng không thể bật máy. Nếu nút nguồn vật lý bị hỏng và bạn muốn khởi động lại, hãy chọn **Khởi động lại** trong menu hệ thống.

## Ảnh chụp màn hình

<img src="../screenshots/mate20x.png" alt="Giao diện tiếng Trung giản thể trên Huawei Mate 20 X với các nút giảm âm lượng, tăng âm lượng và nguồn" width="360">

## Ngôn ngữ ứng dụng

Ứng dụng hỗ trợ 12 ngôn ngữ được liệt kê ở trên. Theo mặc định, ứng dụng dùng ngôn ngữ hệ thống và chuyển sang tiếng Anh nếu không có bản dịch phù hợp. Từ Android 13, bạn có thể chọn riêng ngôn ngữ cho ứng dụng trong phần Cài đặt.

## Biên dịch từ mã nguồn

Dùng JDK 17 và Android SDK Platform 35. Mở dự án bằng Android Studio hoặc đặt `ANDROID_HOME` trỏ tới thư mục Android SDK. Dùng Gradle Wrapper để tạo APK.

```sh
./gradlew :app:assembleDebug
```

Tệp APK được tạo tại `app/build/outputs/apk/debug/app-debug.apk`.
