# Views UML

## Views

### LOGINVIEW
---
**Methods**
+ onLoginClick() : Boolean
+ onForgotPasswordClick() : Void <br>
**Description**
Displays a login screen for user credential input (email, password).
Allows users to submit and authenticate via LoginService.
---

### SIGNUPVIEW
---
**Methods**
+ onSignupSubmit() : Boolean
+ onCancelSignup() : Void <br>
**Description**
Displays a sign-up form for new users to enter name, email, password, and optional phone number.
Validates inputs before account creation using UserService.
---

### NAVBARVIEW
---
**Methods**
+ onBrowseEventsClick() : Void
+ onCreateEventClick() : Void
+ onManageEventsClick() : Void
+ onScanQRCodeClick() : Void
+ onNotificationsClick() : Void
+ onProfileClick() : Void
+ onLogoutClick() : Void <br>
**Description**
Visible after login.
Displays navigation options: Browse Events, Create Events, Manage Events, Scan QR Code, Notifications, Profile, and Log Out.
Has its own controller for managing navigation state.
---

### EVENTLISTVIEW
---
**Methods**
+ onFilterEvents() : Void
+ onAcceptInvitation() : Void
+ onDeclineInvitation() : Void
+ onViewEventDetails() : Void <br>
**Description**
Displays all available events with filtering options.
Shows Accept/Decline buttons for event invitations.
Fetches event data using EventService.
---

### EVENTDETAILSVIEW
---
**Methods**
+ onJoinWaitingList() : Void
+ onLeaveWaitingList() : Void
+ onViewPosterClick() : Void
+ onShareQRCodeClick() : Void <br>
**Description**
Displays detailed event information.
Allows joining/leaving the waiting list.
Shows registration period and “View Poster” button.
Supports QR code redirection.
---

### REGISTEREVENTSVIEW
---
**Methods**
+ onViewWaitingEvents() : Void
+ onViewSelectedEvents() : Void
+ onViewConfirmedEvents() : Void <br>
**Description**
Displays events the user has joined, categorized by Waiting, Selected, and Confirmed.
Syncs data from RegistrationService.
---

### QRSCANVIEW
---
**Methods**
+ onScanQRCode() : Void
+ onOpenEventDetails() : Void <br>
**Description**
Enables users to scan event QR codes using their device camera.
Redirects to EventDetailsView upon successful scan via ScanQRCodeService.
---

### QRGENERATEVIEW
---
**Methods**
+ onGenerateQRCode() : Void
+ onShareGeneratedQRCode() : Void <br>
**Description**
Automatically generates a QR code when an event is created.
Used by organizers to share event links via QRCodeService.
---

### USERNOTIFICATIONVIEW
---
**Methods**
+ onViewNotifications() : Void
+ onMarkAsRead() : Void
+ onDeleteNotification() : Void <br>
**Description**
Displays all notifications received by the user.
Supports filtering and marking notifications as read.
Integrates with NotificationService.
---

### PROFILEVIEW
---
**Methods**
+ onEditProfileClick() : Void
+ onSaveProfileChanges() : Void
+ onChangePasswordClick() : Void
+ onToggleNotificationPreference() : Void <br>
**Description**
Displays user profile information including Device ID.
Allows editing of Name, Email, and Phone number.
Provides a “Change Password” popup with old, new, and confirm fields.
Includes a notification preference toggle.
Uses UserService for updates.
---

### CREATEEVENTVIEW
---
**Methods**
+ onSubmitEvent() : Boolean
+ onUploadPosterClick() : Void
+ onToggleGeoLocation() : Void <br>
**Description**
Organizer view for creating new events.
Includes fields for Event Name, Description, Time, Cost, and toggles for Geo-location requirement.
Has “Upload Poster” button.
Uses EventService and PosterService.
---

### MANAGEEVENTLISTVIEW
---
**Methods**
+ onViewUserMap() : Void
+ onToggleGeoRequirement() : Void
+ onChangeGeoDistance() : Void
+ onDrawLotteryClick() : Void
+ onNotifyAllClick() : Void
+ onExportCSVClick() : Void <br>
**Description**
Organizer dashboard to manage events.
Displays map of users, geo-location toggles, lottery settings, user lists (Confirmed, Selected, Cancelled, Waiting),
and buttons for “Notify All” and “Export as CSV.”
Connects with EventService and NotificationService.
---

### EDITEVENTLISTVIEW
---
**Methods**
+ onViewActiveEvents() : Void
+ onManageEventClick() : Void <br>
**Description**
Organizer dashboard for viewing all events.
Shows total and active events.
Each event has a “Manage Event” button leading to EventEditView.
Uses EventService.
---

### EVENTEDITVIEW
---
**Methods**
+ onEditEventDetails() : Void
+ onUpdatePosterClick() : Void
+ onShareQRCodeClick() : Void <br>
**Description**
Displays total counts (Waitlist, Selected, Confirmed, Declined).
Allows editing of Event details (Name, Description, Price).
Includes “Update Poster” and “Share QR Code” buttons.
Uses EventService and PosterService.
---

### DISPLAYPOSTERVIEW
---
**Methods**
+ onDownloadPosterClick() : Void <br>
**Description**
Displays event posters in full view.
Includes a button to download the poster.
Connects to PosterService.
---

### WAITINGLISTVIEW
---
**Methods**
+ onRefreshWaitingList() : Void <br>
**Description**
Displays a live waiting list of entrants for an event.
Updates dynamically with real-time changes from EventService.
---

### MAPVIEW
---
**Methods**
+ onZoomIn() : Void
+ onZoomOut() : Void
+ onSelectMarker() : Void <br>
**Description**
Displays entrant geo-location clusters on a map.
Allows zooming and interaction for organizers.
Uses EventService and Geolocation data.
---

### ADMINMANAGEEVENTSVIEW
---
**Methods**
+ onFilterEvents() : Void
+ onDeleteEventClick() : Void <br>
**Description**
Admin interface for listing all events across users.
Provides filtering options and the ability to delete events.
Uses EventService.
---

### ADMINMANAGEPROFILEVIEW
---
**Methods**
+ onViewProfileClick() : Void
+ onDeleteProfileClick() : Void <br>
**Description**
Displays list of all user profiles.
Each profile row includes “View Profile” and “Delete” buttons.
Connects to UserService.
---

### ADMINPROFILEVIEW
---
**Methods**
+ onDeactivateUserClick() : Void
+ onSaveAdminChanges() : Void <br>
**Description**
Displays detailed information of a user’s profile for admin inspection.
Allows admin to modify or deactivate accounts.
Same layout as ProfileView, without password management.
Uses UserService.
---

### ADMINIMAGELISTVIEW
---
**Methods**
+ onFilterImages() : Void
+ onViewImageDetails() : Void <br>
**Description**
Displays all uploaded event images.
Allows filtering/searching by event uploader and date.
Includes “Details” and “Images” tabs that stay synchronized.
Uses PosterService.
---

### ADMINMANAGEIMAGES
---
**Methods**
+ onDeleteImageClick() : Void
+ onDownloadImageClick() : Void <br>
**Description**
Allows admin to delete or download an event image.
Works directly with PosterService for moderation.
---

### NOTIFICATIONLOGVIEW
---
**Methods**
+ onViewLogs() : Void
+ onFilterLogs() : Void <br>
**Description**
Admin audit view for tracking notifications sent by organizers.
Displays sender, recipient, timestamp, and message summary.
Integrates with NotificationService.
--- 

