![](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*hVKWuT24riZnx4VzDpQVJQ.png)

Live App Architecture Debugging with Kotzilla & Koin
==================

This project demonstrates the Koin & Kotzilla platform usage for live app architecture debugging. This application is a migrated version of Google's "Now in Android" app, where we've replaced Dagger Hilt with Koin dependency injection framework and integrated Kotzilla's monitoring platform.

The workshop includes intentionally introduced bugs and performance issues that you'll debug and fix using Kotzilla's real-time monitoring capabilities and the Koin IntelliJ Plugin's static analysis features.

You can find the original [readme](https://github.com/android/nowinandroid/blob/main/README.md) file.

# About

This workshop showcases three key technologies working together:

- **[Koin Framework](https://insert-koin.io/)**: The pragmatic and lightweight dependency injection framework for Kotlin
- **[Koin IntelliJ Plugin](https://plugins.jetbrains.com/plugin/10671-koin)**: Static analysis tools that help detect DI configuration issues directly in your IDE during development and integrate with the Kotzilla Platform
- **[Kotzilla Platform](https://kotzilla.io/)**: AI Performance Monitoring Platform for Koin. Catch crashes and performance issues in your apps, and fix them with contextual prompts for any coding assistant

# Setup and Sign-Up

To fully make the project work:

1. [Sign up](https://console.kotzilla.io/signup) for a free account on the Kotzilla platform.
2. [Register your application](https://console.kotzilla.io/onboarding) with the following information:
   - Application Name: `Now in Android`
   - Application package: `com.google.samples.apps.nowinandroid.demo.debug`
3. In the next step of the onboarding, simply download the kotzilla.json file and skip the remaining steps, as the Koin and Kotzilla libraries are already included in this project.
4. Put your `kotzilla.json` file inside the `app` folder  

<img width="250" height="216" alt="image" src="https://github.com/user-attachments/assets/ebc57a6a-63bb-40ce-9931-f126d4ad3bdd" />

## Launch Your App

Now start your app from Android Studio! 🎉 Connect on the [Kotzilla console](https://console.kotzilla.io/) to check the first session running.

<img width="670" height="400" alt="image" src="https://github.com/user-attachments/assets/19b0b771-b45a-4928-996d-1a51fea72121" />


# Workshop

In this application, we have introduced intentional issues and crashes. Your goal is to fix the following issues using the Kotzilla Platform and the Koin IntelliJ Plugin.

The platform will collect your app data and analyze it to show you **critical issues**. The Koin plugin is helping you work with your **Koin configuration**, and can display detected issues in your code.

> ⚠️ The workshop includes an intentionally introduced crash on the  `Interests` tab. The 1st step will let you fix this.


## 1. Fix App Crash in `Interests` Tab

### Description

By clicking on the `Interests` tab, you will cause the app to crash. Your goal is to identify and fix this crash using the Kotzilla platform.

<img width="250" height="550" alt="image" src="https://github.com/user-attachments/assets/c1c3a666-0e60-4afd-a552-c5d48fbd8eeb" />

### TODO

- [ ] Provoke app crash by clicking on `Interests` tab.
- [ ] Look at the [Kotzilla console](https://console.kotzilla.io/) to find the `Crash` Issues linked to the `InterestsViewModel` class. This will show you the error stacktrace.
- [ ] Fix `InterestsViewModel` class.


## 2. Fix Main Thread Blocking & ANR in `MainActivity`

### Description

We aim to fix the detected Main Thread Blocking issue in the `MainActivityViewModel` class. 

**What is a "Main Thread Issue"**: A component resolution is running on the main thread for more than 100 ms. ANRs (Application Not Responding) occur when the main thread is blocked for too long, making the app unresponsive and causing it to freeze. Common causes include heavy computations or synchronous operations running on the main thread.

**Impact**: Main thread blockages severely **degrade the user experience**, slowing down the responsiveness of your app, which can lead to negative reviews, higher uninstall rates, and reduced app store rankings.

### TODO

- [ ] Look at the [Kotzilla console](https://console.kotzilla.io/) to find the **Main Thread Issue** in `MainActivityViewModel`.
- [ ] Open issue details screen (by clicking on the issue or directly in a session) to investigate `MainActivityViewModel`.
- [ ] Follow analysis to check how to fix `MainActivityViewModel` or Prompt for AI fix.
- [ ] Fix the `MainActivityViewModel` class.

<img width="600" height="300" alt="image" src="https://github.com/user-attachments/assets/759fa82a-ae8a-4951-9428-d859e1518c7a" />


## 3. Fix Heavy Background Thread Usage with `SyncWorker`

### Description

We aim to fix the detected Background Thread Blocking issue in the `SyncWorker` class. 

**What is a "Background Thread Issue"**: Background performance issues arise when background tasks consume too many resources or take too long to execute, impacting app responsiveness and overall performance.

**Impact**: Inefficient background processing can drain device resources, slow down the app, and lead to a poor user experience.

### TODO

- [ ] Look at the [Kotzilla console](https://console.kotzilla.io/) to find the **Background Thread Issue** in `androidx.work.ListenableWorker`.
- [ ] Open issue details screen (by clicking on the issue or directly in a session) to investigate `androidx.work.ListenableWorker`.
- [ ] Follow analysis to check how to fix `SyncWorker` class or Prompt for AI fix.
- [ ] Fix the `SyncWorker` class.

## 4. Fix Slow App Startup

### Description

We aim to fix the detected Slow startup issue in the `NiaApplication` class. 

**What is a "Slow App Startup Issue"**: Startup performance issues occur when the app takes too long to initialize, delaying the appearance of the first usable screen. This issue often arises from heavy operations or blocking tasks running on the main thread during startup.

**Impact**
- **User frustration**: Slow startup times can frustrate users, making them more likely to abandon the app.
- **App retention**: A smoother and faster startup enhances user experience, encouraging users to continue engaging with the app.
- **Business impact**: An app that starts quickly is more likely to have higher retention rates and lower abandonment rates.

### TODO

- [ ] Look at the [Kotzilla console](https://console.kotzilla.io/) to find the **Slow App Startup Issue**.
- [ ] Open issue details screen (by clicking on the issue or directly in a session).
- [ ] We advise investigating the `NiaApplication` class, and use the `trace` function.
- [ ] Fix the `NiaApplication` class.

Below, an example of manual tracing with the `trace` function:

<img width="400" height="400" alt="image" src="https://github.com/user-attachments/assets/61022e17-0566-4e0c-882b-7f2e9ed4ffcc" />


## 5. Architecture Stability - Single vs Factory

### Description

**What is a "DI Misconfiguration"**: We configured Koin using `factory` in data layers, in `dataKoinModule`, `daosModule`, and `flavoredNetworkModule`, to demonstrate that some components need to be kept in memory to avoid recreating them. This can impact memory and CPU usage when the Koin DI container recreates instances unnecessarily.

**Impact**: Using `factory` instead of `single` for data layer components causes unnecessary object creation, leading to increased memory consumption and CPU overhead. This affects app performance and resource efficiency.

### TODO

- [ ] Look at the [Kotzilla console](https://console.kotzilla.io/) to find the latest application session.
- [ ] Look at the memory graph and compare `creating` and `in memory` instances.
- [ ] Fix `dataKoinModule`, `daosModule`, and `flavoredNetworkModule` modules with `single` and `singleOf` declarations instead of `factory`.
- [ ] Compare the new result of memory allocation and time resolution between the two configurations.

<img width="550" height="550" alt="image" src="https://github.com/user-attachments/assets/bba0744b-d805-4f9b-a32f-46ecfb8f5a26" />


# License

**Now in Android** is distributed under the terms of the Apache License (Version 2.0). See the
[license](LICENSE) for more information.
