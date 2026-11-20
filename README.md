# Ocarina Player for Android

This Android Studio project packages the live Ocarina Player website in a lightweight Android app using WebView.

## Build an APK
1. Install Android Studio (current stable version).
2. Open this `OcarinaAndroid` folder in Android Studio.
3. Allow Gradle sync and install the Android SDK Platform 35 if prompted.
4. Choose **Build → Build Bundle(s) / APK(s) → Build APK(s)**.
5. Android Studio will show the generated APK location. Copy it to your Android phone and install it. You may need to allow installation from that file manager.

## Notes
- Internet access is required because the app loads `https://ocarina.toomuchofheaven.com/` live.
- This is an Android wrapper, not an offline/native rewrite of the website.
- The original project is publicly described by its author as an MIT-licensed React app: https://github.com/vaexenc/ocarina
