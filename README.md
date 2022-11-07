# Songr SpringBoot app

Start this application with `./gradlew bootRun`. The app exposes the following routes on `http://localhost:8080`:

- `/`: This is the splash page for welcoming users
- `/hello`: This greets a generic user
- `/capitalize/{insertWordsHere}`: Replace the brackets and the contained words with a string of your choice to see those words capitalized and echoed back. Beware of URL encoding, though!
- `/albums`: Shows a list of hardcoded albums

