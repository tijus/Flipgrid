# Flipgrid

Some design decisions:
1. The app has a single activity multiple fragment design
2. It follows the Model View Presenter architecture
3. For design the app uses MaterialUI library
4. It uses AppCompat / AndroidX Fragment and Activity
3. The app has all the features stated in the design sheet i.e.
  a. The first screen is profile creation page where the user can enter values to the edit text
  b. The email and password input field are required field.
  c. The data collected at this page is passed to the next page through bundles.
  d. The next page shows the profile summary. Also, it can route the user to the web page mentioned in the Profile details screen
  e. The app follows most of the design and coding related practices.
5. The important functionality unit tested

Opportunity areas:
1. The next step will be to convert the architecture into more robust form like MVVM. This will solve a lot of memory leaks and orientation / resurrection related bugs
2. We can have some kind of caching to save the registered details of the user so that if they can continue signing up directly. The app may also have an ability to reset the cache.
3. Dagger injection can be used to make the implementation more optimal.
4. UI testing can be implemented using espresso

Please follow this PR - https://github.com/tijus/Flipgrid/pull/1 to see the full code online
