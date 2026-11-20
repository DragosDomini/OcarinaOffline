# Ocarina Player — Offline Android project

This version is a standalone offline player. The complete interface and JavaScript audio engine are bundled in `app/src/main/assets/index.html`; Android loads it from local app storage using `file:///android_asset/index.html`.

## Offline behavior
- No INTERNET permission is requested.
- No remote website, CDN, fonts, images, or audio files are loaded.
- Ocarina tones are synthesized locally with the Web Audio API.
- The six touch holes, tone options, volume control, and built-in songbook work without a network connection.

## Build an APK
1. Open this `OcarinaAndroid` folder in Android Studio.
2. Let Gradle sync and install Android SDK Platform 35 if prompted.
3. Choose **Build → Build Bundle(s) / APK(s) → Build APK(s)**.
4. Install the APK on your Android device. Test by enabling Airplane mode before launching.

## Note about fidelity
This is an offline recreation of the core ocarina-playing experience, not a byte-for-byte copy of the original website. The original repository's exact React source and assets were not available in the working environment, so the offline player uses locally generated instrument tones and a recreated interface/songbook.


## Majora's Mask songbook update

The offline songbook now includes the eight requested N64 ocarina phrases: Song of Healing, Song of Soaring, Song of Time, Song of Storms, New Wave Bossa Nova, Goron Lullaby, Elegy of Emptiness, and Oath to Order. Matching short Standard MIDI practice files are bundled in `app/src/main/assets/midi/`. These MIDI files are local transcriptions of the in-game button-note phrases, based on published ocarina note charts; they are not original Nintendo MIDI source files or complete soundtrack arrangements. Playback in the app uses its built-in ocarina-style synthesizer, so the timbre is an approximation, not the exact N64 sound bank.

Note references: Ocarina Tabs' Majora's Mask song chart (https://ocarinatabs.com/ocarina-of-time-songs) documents the button-note sequences; Play Ocarina's Majora's Mask song page (https://playocarina.com/songs/majoras-mask/) provides additional note/fingering references.
