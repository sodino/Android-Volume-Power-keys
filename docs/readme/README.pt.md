# Botões de volume e energia para Android

[简体中文](../../README.md) · [繁體中文](README.zh-Hant.md) · [English](README.en.md) · [日本語](README.ja.md) · [한국어](README.ko.md) · [العربية](README.ar.md) · [ไทย](README.th.md) · [Tiếng Việt](README.vi.md) · [Русский](README.ru.md) · [Español](README.es.md) · [Français](README.fr.md) · **Português (Brasil)**

O app **Botões virtuais** adiciona três botões grandes na tela para ajustar o volume, bloquear a tela e abrir o menu de energia do sistema. Funciona no Android 9 ou mais recente e foi testado em um Huawei Mate 20 X com Android 10 e EMUI 14.

[Baixar APK v1.3](https://github.com/sodino/Android-Volume-Power-keys/raw/refs/heads/develop/apk/android-volume-power-keys-v1.3.apk)

## Instalação e uso

1. Baixe o APK assinado com a chave de depuração, abra o arquivo no celular e siga as instruções de instalação do Android.
2. Abra **Botões virtuais**. Toque em **Aumentar volume** ou **Diminuir volume** para ajustar um nível por vez. Deslize para cima em qualquer botão de volume para aumentar, ou para baixo para diminuir. O volume muda em etapas enquanto você desliza.
3. Na primeira vez que usar **Ligar/desligar**, toque no botão e escolha **Abrir configurações**. Ative **Botões virtuais** nas configurações de acessibilidade do Android e volte ao app. No Huawei testado, o caminho é **Acessibilidade → Serviços instalados → Botões virtuais**.
4. Toque em **Ligar/desligar** para bloquear a tela. Mantenha o botão pressionado para abrir o menu do sistema e escolher desligar ou reiniciar.

Com o celular totalmente desligado, o app não consegue ligá-lo. Se o botão físico de energia estiver quebrado e você quiser reiniciar o aparelho, selecione **Reiniciar** no menu do sistema.

## Captura de tela

<img src="../screenshots/mate20x.png" alt="Interface em chinês simplificado em um Huawei Mate 20 X com os botões de diminuir volume, aumentar volume e ligar/desligar" width="360">

## Idioma do app

O app oferece os 12 idiomas listados acima. Ele segue o idioma do sistema e usa inglês quando não há uma tradução correspondente. A partir do Android 13, o idioma do app também pode ser escolhido nas configurações do sistema.

## Compilar a partir do código-fonte

Use o JDK 17 e o Android SDK Platform 35. Abra o projeto no Android Studio ou configure `ANDROID_HOME` com o caminho da pasta do Android SDK. Use o Gradle Wrapper para gerar o APK.

```sh
./gradlew :app:assembleDebug
```

O APK é gerado em `app/build/outputs/apk/debug/app-debug.apk`.
