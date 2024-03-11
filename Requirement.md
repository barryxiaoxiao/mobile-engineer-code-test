# Android Mobile Engineer – Technical Test

## Task Description:

You are tasked with developing a Currency Exchange App that replicates the market watchlist screen as shown in the design specifications provided. The app should fetch currency pairings data from a reliable API source and display dynamic elements such as sell/buy prices, % change, equity, balance, and other relevant information.

## Obtaining the Data:

You have two options for obtaining currency data:
- Utilize a publicly accessible API such as Free Forex API.
- Alternatively, sign up to a brokerage offering API access, like Oanda.

## Specific Requirements:

- Implement the app using Kotlin.
- Utilize MVVM architecture combined with Clean Architecture principles.
- Ensure the app is available in both landscape and portrait modes.
- The number of forex pairs displayed should be determined dynamically based on the API response.
- Simulate sell/buy prices by adding/removing 1-10 pips randomly from the mid-price received from the API.
- Currency prices should be regularly updated.
- Calculate the % change from the first price received upon launching the app and reflect it in the UI.
- Assume the account base currency is in USD:
  - Simulate going long $10,000 USD worth units on each forex pairing at the first price received.
  - Calculate Equity dynamically based on the current value of total assets.
  - Calculate Balance as $10,000 USD * Number of forex pairings available.
- The Margin / Used values on the panel can be hardcoded or simply shown as placeholders.
- Include Unit Tests where appropriate.

## Judging Criteria:

We will evaluate your submission based on the following criteria:
- Adherence to the design specifications.
- Code quality, including architectural knowledge, error handling, and threading.
- Usage of modern Android development practices, such as Kotlin, MVVM, Clean Architecture, and functional programming.
- Documentation and tests provided.
- Demonstrated understanding and implementation of asynchronous operations and data handling.
- UI/UX considerations for a smooth user experience.

## Design Specifications:

![Screen 1](Screen1.png) ![Screen 2](Screen2.png)

## Tips:

- Please refer to the README.md in the repository for additional instructions.
- Ensure your submission closely matches the design specifications.
- Provide comprehensive documentation and tests to showcase your skills.

We look forward to reviewing your submission.
