## 4.1. A. Views (Boundary/UI Layer)

Views represent the visible user interfaces. They are responsible for displaying data and capturing user input. 

- **LoginView:** Want to show a log-in screen to show the fields for user to enter their credentials.  
- **SignupView:** Want to show a Signup screen to show the fields for user to enter their valid credentials (name, email, password) for the first time, also requires user to enter other optional information like phone number.  
- **NavbarView:** Shows the options (Browse Events, Create Events, Manage Events, Scan QR code, Notifications, Profile, Log out) in Nav bar as soon as user sign in into the app. Has Controller of its own.  
- **EventListView:** Displays all events and filtering options. Also lets entrants accept or decline invitations with an accept and decline button shown against each event in the list.  
- **EventDetailsView:** Shows event info; allows joining/leaving the waiting list. QR code Redirect available. Also has Registration period info. Includes the “View poster” button.  
- **RegisterEventsView:** Shows the events we have joined. Displays waitinglist/Selected/Confirmed.  
- **QRScanView:** Scans event QR codes to open details.  
- **QRGenerateView:** Generates a QR code automatically when an event is created.  
- **UserNotificationView:** Shows all the notifications sent to the User.  
- **ProfileView:** Displays user info and Device ID, gives option to edit user profile info (Name, Email, Phone). A pop-up button that says “change password,” has three fields (old password, new password, confirm password) along with cancel and save buttons. Includes a notification toggle.  
- **CreateEventView:** Requires Event Information (Name, Description, etc.), has an upload poster button, toggle for requiring Geo-location from Users.  
- **ManageEventListView:** Organizer’s event management dashboard. Shows users map, toggle for requiring Geo-location from Users, lets you change the required distance for the Geo location, draw lottery settings, user list (Confirmed, Selected, Cancelled, Waiting), also has the “notify all” button and “export as CSV” button.  
- **EditEventListView:** Organizer’s event management dashboard. Shows total events, active events, and has a list of all the events that can be managed, where each event has a “manage event” button too.  
- **EventEditView:** Totals counts on waitlist, selected list, confirm list, declined list. Shows the option to edit event details (name, description, price), has the “update the poster” button, and “share the QR code” button.  
- **DisplayPosterView:** Shows the poster and has a button with downloading the poster functionality.  
- **WaitingListView:** Displays live waiting list data.  
- **MapView:** Displays entrant geolocation clusters.  
- **AdminManageEventsView:** Lists all events by all users. Lets the admin delete the events and also offers filtering for the list of events.  
- **AdminManageProfileView:** Shows the list of users with “view profile” button for each user and also a delete button for each user profile listed.  
- **AdminProfileView:** This View is for inspecting a user’s details and taking domain actions on the account (same as user profile, except password).  
- **AdminImageListView:** Lists images for all the events. Admin has the option to filter and/or search for images based on event uploader and event date. Shows two options for details and images, where “details” lets filter details, and “images” shows images (these two options will be completely synced).  
- **AdminManageImages:** Lets admin delete or download an image.  
- **NotificationLogView:** Admin audit view for all sent notifications.  

