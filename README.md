# mobile-engineering-code-test-android [![Build Status](https://app.bitrise.io/app/c6d58412d8d29b79/status.svg?token=ZQctxSUbgD27p5qqSamkRA&branch=master)](https://app.bitrise.io/app/c6d58412d8d29b79)

Code test for Mobile Engineering

## Technical Requirements and Tips

- Jetpack Compose
  - Views
    - CurrencyPairItem
    - CurrencyPairSectionHeader
    - MainTabBar
    - MarketInfoHeader
    - MarketsScreen
    - Navigation
- Repositories
  - AccountInfoRepository
  - CurrencyPairRepository
- Entity
  - AccountInfoModel
  - CurrencyPairModel
- Router
  - AccountInfoRouter
  - CurrencyPairRouter
- Protocol
  - AccountInfoView
  - CurrencyPairView

## Bonus

- Contract Design 
- MVVM [reference](https://developer.android.com/jetpack/guide)
  - ViewModel
    - ViewModelOutputs
    - ViewModelInputs
      ...

- Programmatic UI/Layout is preferred over XML layout
- TDD, Unit tests for business logic module get higher scores
- UI tests with Espresso get higher scores
- Snapshot test get higher score

# Sample UI

<img src="screen1.png" width="200"/>
<img src="screen2.png" width="200"/>

## Developer Notes

- [ ] Setup Bitrise for pull request status checking
- [ ] Create Base components for Jetpack Compose
- [ ] Create Jetpack Compose modules
  - [ ] `CurrencyPair`
  - [ ] `AccountInfo`
- [ ] Setup Room (model persistence)
- [ ] Setup Retrofit
- [ ] Create `MarketsScreen` with view model
  - [ ] Integration with Jetpack Compose and view model
- [ ] Create UI components
  - [ ] List item
  - [ ] Market info header
  - [ ] Tab layout
- [ ] UI + MVVM integration
- [ ] Skeleton view animation before data is loaded
- [ ] Unit tests

## Recommended Environment

Before running, developing, and building the app, make sure your device's environment is suitable. We recommend the following specifications:

- **macOS version >= 10.14**
- **Android Studio Arctic Fox (2020.3.1) or newer**
- **Kotlin version >= 1.5.0**

## Build Steps

1. fork this repository using `$ git clone git@bitbucket.org:fishkingsin/mobile-engineering-code-test.git`
2. create android project 
3. push commit to your own forked repo

## Architecture

This project is divided into two main sections: business logic and screen logic.

1. For the business logic part, it is built using Clean Architecture with Coroutines and Flow.

   - Suggested reading:
     1. https://developer.android.com/topic/architecture
     2. https://developer.android.com/kotlin/flow

2. For the screen logic part, I used Jetpack Compose combined with MVVM architecture pattern.
   - Suggested reading:
     1. https://developer.android.com/jetpack/compose
     2. https://developer.android.com/jetpack/guide
