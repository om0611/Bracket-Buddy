For each Principle of Universal Design, write 2-3 sentences — or point form notes — explaining which features of your program adhere to that principle. If you do not have any such features, you can either:

(a) Describe features that you could implement in the future that would adhere to the principle or

(b) Explain why the principle does not apply to a program like yours.

ANSWER:
1. Equitable Use:
 - Our program could be extended to include language support for non-English speakers. This is a logical spot for extension, as our UI pulls its display string information from a strings.xml file, therefore the 
   strings in the file could be translated, allowing for equitable language support.
2. Flexibility in Use:
 - Our program UI creates many buttons for features, facilitating the user’s accuracy with use, regardless of their handedness.
 - Additionally, our application automatically switches between a light and dark mode UI, depending on the user’s selected mode in their Android settings, demonstrating flexibility in the user experience.
3. Simple and Intuitive Use:
 - Our app contains intuitive and simple interfaces, with prompting for each of its features either through text boxes or Android notifications.
 - The app also displays Android notifications indicating when mutations are successfully updated on Start.gg, which prevents the user from needing to check the website whenever they make a mutation request on 
   the app.
 - Specifically, the reporting set menu was designed for simple and intuitive use, as it automatically updates the valid set score and game information in the menu every time the user reports a game. Specifically,
   games are added or removed from the menu depending on whether the set is complete, and what a valid set would be according to the settings of the tournament.
4. Perceptible Information:
 - Our UI is created with constraints between each of the fields in the fragments, which allows for visible and perceptible information on devices with different screen sizes, and prevents test overlap.
 - Additionally, due to the simple nature of the Views, the relevant user information is clearly displayed without background clutter or font accessibility issues.
5. Tolerance for Error:
 - In our menus relevant to mutating information to Start.gg, the app checks whether or not the inputted information, such as reported game information for reporting sets, is valid, and will not run the mutation 
   if the input is invalid. Instead, the user is prompted to fix the input, avoiding error in mutation requests sent to Start.gg.
 - One important additional feature that our app could implement is the ability to reset sets. Currently in our app, once a set is reported or called to Start.gg, its result is final. However, Start.gg’s reset
   set mutation request can be customized to reset a certain set’s state to unstarted status, and this could be an additional feature for future implementation to account for accidental mis-reports.
6. Low Physical Effort:
 - Due to the application being on mobile Android software, the extent of the physical effort an user has to put in is moving their fingers to click buttons. Therefore, the accessibility decisions of our app do 
   not significantly influence this principle for universal design.
7. Size and Space for Approach and Use:
 - Similarly, our application operates on mobile devices meaning that accessibility decisions within the app don’t influence the amount of size and space of the mobile device itself.
 - However, making this application as a mobile app allows for portability and ease of use in organizing and reporting tournaments, which is often currently done by carrying around laptops through the tournament 
   venues.

Write a paragraph (3-6 sentences) about who you would market your program towards, if you were to sell or license your program to customers. This could be a specific category of users, such as "students", or more vague, such as "people who like games". Try to give a bit more detail along with the category.


ANSWER:
	Our program would be marketed towards people who organize online or in-person tournaments, particularly tournaments relating to competitive video games such as Super Smash Bros or Street Fighter. This is because Start.gg is an established standard for running video game tournaments on a variety of scales. Start.gg is used both in weekly tournaments ran by UofT’s Smash Club, and worldwide EVO tournaments with thousands of entrants. While it has heavy video game functionality, Start.gg can also be used to run miscellaneous brackets not specific to video games as well. The consensus among TOs is that the Start.gg website is notoriously difficult to work with on mobile devices, due to issues with responsiveness and clunky UI. Our app is useful for these tournament organizers as it provides a convenient and mobile option for interacting with any of their admin tournaments as they are ongoing, with a cleaner UI and without the severe responsiveness issues that come with mobile Start.gg.


Write a paragraph about whether or not your program is less likely to be used by certain demographics. Your discussion here should be informed by the content of our embedded ethics modules this term.

ANSWER:
	Our program is less likely to be used by Apple users, as its front end is currently only developed for Android devices. However, the Apple users are unlikely to suffer from tangible harm from a lack of app access, as they likely only represent a subset of tournament organizers for any given tournament. Therefore, it is likely that at least one tournament organizer among a team would have an Android device, meaning that all tournament organizers for this tournament would indirectly benefit from the use of the app, as their tournament can now be run more smoothly than before. Additionally, our program would be less likely used by non-English speakers, which are restricted from the benefits of our app due to its English UI. However, with all of our View Fragments displaying strings from an individual strings.xml file that stores output strings, the program is open for extension to other languages by translating the strings in this xml file, opening up the possibility of plugin integration towards accessibility for other languages.
