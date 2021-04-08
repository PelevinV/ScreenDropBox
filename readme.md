# ScreenDropBox
Allows you to take a *screenshot* and automatically send to the specified [DropBox](https://www.dropbox.com/)

## How to start.
1. Create an app in a [DropBox Developer](https://www.dropbox.com/developers/).
    1. *Type of access - "App folder".*
    2. *Permission type - "files.content.write".*
2. Generate access **token**.    
```
String ACCESS_TOKEN = "---YourToken---";
```