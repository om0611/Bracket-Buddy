# Bracket Buddy

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Authors](#authors)
- [Installation](#installation)
- [Usage](#usage)
- [Feedback](#feedback)
- [Contributing](#contributing)
- [License](#license)

## Overview
Bracket Buddy is an Android application designed to help tournament organizers manage and run their tournaments locally 
through their mobile device. It interacts with the start.gg API for fetching and modifying the user's start.gg data. 
Bracket Buddy provides a user-friendly alternative to the "notoriously poor" start.gg website functionality on mobile 
devices. With Bracket Buddy, tournament organizers can save time and reduce frustration, making it an invaluable tool for 
managing tournaments on the go. 

## Features
- **Log in**: The tournament organizer (TO) can log into their start.gg account through our app.
- **Access tournaments and events**: The TO can access their current and upcoming tournaments and events.
- **Access and modify bracket matches**: The TO can see the bracket matches for a given event, declare the result 
of the match, and upload the changes to start.gg. 
- **Modify seeding**: The TO can modify the seeding for a bracket and upload the changes to start.gg. 
- **Call sets**: The TO can assign players to specific setups or stations.
- **Ensure controller compatibility**: The TO can keep track of players with limiting controllers while calling sets 
to ensure that players can only be called to setups where their controllers are compatible.
- **Track payments**: The TO can keep track of which attendees have paid, in order to calculate total revenue of the 
tournament and collect payment from unpaid entrants.
- **Generate Event Description**: The TO can generate a description for an event, which can be used for advertising 
the event.

## Authors
- [Sahil Basra](https://github.com/SahilBas2005)
- [Alexander Leonardos](https://github.com/AlexLeonardos)
- [Esther Siu](https://github.com/essi-304)
- [Om Patel](https://github.com/ompatech)
- [Om Patel](https://github.com/om0611)

## Installation
There are two methods to install this program.

Installing the APK (Recommended):
1. Create a Start.gg account
   Go to the Start.gg dashboard at [Start.gg](https://www.start.gg/). Press the login button on the bottom left and
   then click "Create a new account". Then set your username and password
2. Enable installation of unknown apps
Go to Settings > Apps > Special app access > Install unknown apps. You can also enable Unknown sources in Settings > Security. 
3. Download the APK file
Download the BracketBuddy.apk file on this github repository.
You can download the APK file to your computer and then transfer it to your Android device in the download folder.
You can also download APK files from the github on mobile using software like APK pure. 
4. Open the APK file
Open the APK file using the app you granted permission to install it from. You can also use your Android device's file manager
to locate the APK file. 
5. Install the app
Confirm the installation and tap Done when it's complete.
6. Log in on the app
   Once you open the app, you will be prompted to login to Start.gg. Log in using the information you created in step 1.
   Now, the app should redirect you to the select tournament menu where you can see any tournaments that you manage.

Common Issues:
The app does not appear in my app drawer on my phone - Make sure the apk is placed in the download folder and that your
permissions are configured as shown in step 2.

The tournament selection page is empty - If you don't have any tournaments created on the Start.gg website, then nothing
should appear here. To progress past this menu create a tournament on Start.gg. If you need help doing this, there is
a tutorial at [here](https://help.start.gg/en/articles/1465683-creating-a-tournament).

Log in page shows a connection error - This occurs if the phone has limited or inconsistent access to the internet.
Try reconecting your Wi-fi and rerunning the app.

Installing from IntelliJ (Not Recommended):
1. Create a Start.gg account
   Go to the Start.gg dashboard at [Start.gg](https://www.start.gg/). Press the login button on the bottom left and
   then click "Create a new account". Then set your username and password
2. Get a Start.gg API key
   Visit the Start.gg developer portal and get a key as shown [here](https://developer.start.gg/docs/authentication/#:~:text=In%20order%20to%20access%20start,AND%20fill%20out%20this%20form.).
3. Generate a CoHere API key
   Sign up for a CoHere key on the cohere website as shown [here](https://www.nightfall.ai/ai-security-101/cohere-api-key#:~:text=conversational%20AI%20applications.-,To%20get%20a%20Cohere%20API%20key%2C%20developers%20need%20to%20sign,before%20deploying%20them%20to%20production.).
4. Download the main branch from GitHub and open it in IntelliJ or Android Studio
   Note: If you are using IntelliJ make sure you have the Android plugin installed
5. Download the following gradle libraries:
   org.nanohttpd:nanohttpd, Version 2.3.1
   com.squareup.okhttp3:okhttp, Version 4.12.0
6. Create a local.properties file in the root folder
   Add the following to the bottom of the local.properties file:
  token= PUT YOUR START GG TOKEN HERE
  client_id= PUT YOUR START GG CLIENT ID HERE
  client_secret= PUT YOUR START GG CLIENT SECRET TOKEN HERE
  cohere= "PUT YOUR COHERE TOKEN HERE
7. Build the project using Gradle
   Make sure you add a valid Android device to the wireless debugging as shown here [here](https://www.geeksforgeeks.org/guide-to-install-and-setup-intellij-idea-for-android-app-development/).
7. Install the app
The app should appear in your app drawer once the gradle build is complete.
8. Log in on the app
   Once you open the app, you will be prompted to login to Start.gg. Log in using the information you created in step 1.
   Now, the app should redirect you to the select tournament menu where you can see any tournaments that you manage.

Common Issues:
The app crashes on start up with an API permission error on LogCat - Make sure the local.properties folder is created
and populated exactly as shown in step 6.

Gradle build failed on IntelliJ or Android Studio - Redownload the files from the GitHub and ensure that the project
files are configured properly.

Gradle build is successful but no app is generated - After running the Gradle build once, switch to the Android app
configuration which should already be generated by Gradle. Running this configuration should build the app.

The tournament selection page is empty - If you don't have any tournaments created on the Start.gg website, then nothing
should appear here. To progress past this menu create a tournament on Start.gg. If you need help doing this, there is
a tutorial at [here](https://help.start.gg/en/articles/1465683-creating-a-tournament).

Log in page shows a connection error - This occurs if the phone has limited or inconsistent access to the internet.
Try reconecting your Wi-fi and rerunning the app.

If you have further issues please submit them in the Feedback Google Form shown below.   

## Usage
On app startup, the user will be prompted with a login button where they can login to their start.gg account. Once they have done this, they should navigate back to BracketBuddy.

Once they log in, the user should select their desired tournament and event. Once they do, they will be prompted with 5 menus in a navigation bar at the bottom of the screen. Within each of these menus are options related to its specific functionality, images of each menu are recorded [here](https://drive.google.com/drive/folders/1ykSAsVVC5Af_IVYZX9h985wE7KAtisu3?usp=sharing). 
## Feedback
Bracket Buddy is open to feedback through this [google form](https://forms.gle/7vZLDufXwvgFXi8L8)!
When submitting feedback, be sure to:
- Include an email or other contact so that we can reach back to you for further information.
- Be clear about potential bugs and their fixes if applicable.
- Consider user interactions and how the application could be improved.

After submitting feedback, you can expect a follow-up from us shortly.


## Contributing
Unfortunately, BracketBuddy is currently closed for public contributions. If this changes, we will add information on this readme file about how to reach out and get your contributions documented. Non-contributor
pull requests on this repository will be ignored.

## License
This program is closed for open source editing and is using the MIT license.
Check out the MIT license [here](LICENSE).
