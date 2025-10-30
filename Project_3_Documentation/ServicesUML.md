# Services UML

## Services

<br>

### USERSERVICE

---

```

```

---

```
+ createUser(user : User) : Boolean
+ updateUser(user : User) : Boolean
+ deleteUser(userId : Integer) : Boolean
+ getUserById(userId : Integer) : User
+ getUsersByRole(role : UserRole) : List<User>
+ authenticateDevice(deviceId : Integer) : User
+ authorizeAction(userId : Integer, action : String) : Boolean
```

---

<br>

### EVENTSERVICE

---

```

```

---

```
+ createEvent(event : Event) : Boolean
+ updateEvent(event : Event) : Boolean
+ deleteEvent(eventId : Integer) : Boolean
+ getEventDetails(eventId : Integer) : Event
+ updateEventStatus(eventId : Integer, status : EventStatus) : Boolean
+ getEventsByOrganizer(organizerId : Integer) : List<Event>
+ getRegisteredEventsByUserId(userId : Integer) : List<Event>
+ getSelectedEventsByUserId(userId : Integer) : List<Event>
+ getCancelledEventsByUserId(userId : Integer) : List<Event>
+ getEventsByUserId(userId : Integer) : List<Event>
```

---

<br>

### LOTTERYSERVICE

---

```

```

---

```
+ drawLottery(eventId : Integer) : LotteryResult
+ handleDeclinedInvitations(eventId : Integer) : Boolean
+ replaceEntrants(eventId : Integer, replacementCount : Integer) : List<Integer>
+ logLotteryResults(result : LotteryResult) : Boolean
+ notifyEntrants(result : LotteryResult) : Boolean
```

---

<br>

### NOTIFICATIONSERVICE

---

```

```

---

```
+ sendNotification(notification : Notification) : Boolean
+ sendLotteryResult(eventId : Integer, entrantIds : List<Integer>) : Boolean
+ sendEventUpdate(eventId : Integer, message : String) : Boolean
+ logNotification(notification : Notification) : Boolean
+ manageUserPreferences(userId : Integer, hasNotificationOn : Boolean) : Boolean
```

---

<br>

### POSTERSERVICE

---

```

```

---

```
+ uploadPoster(poster : Poster) : Integer
+ updatePoster(poster : Poster) : Boolean
+ deletePoster(posterId : Integer) : Boolean
+ getPoster(posterId : Integer) : Poster
+ moderatePoster(posterId : Integer, approved : Boolean) : Boolean
```

---

<br>

### QRCODESERVICE

---

```

```

---

```
+ generateQRCode(eventId : Integer) : QRCode
+ scanQRCode(codeData : String) : QRCode
+ validateQRCode(codeId : Integer) : Boolean
+ getEventFromQRCode(codeId : Integer) : Event
```

---

<br>

### SCANQRCODESERVICE

---

```

```

---

```
+ scanAndValidate(qrData : String) : Boolean
+ retrieveEventInfo(qrData : String) : Event
```

---

<br>

### REGISTRATIONSERVICE

---

```

```

---

```
+ registerEntrant(eventId : Integer, userId : Integer) : Boolean
+ cancelRegistration(eventId : Integer, userId : Integer) : Boolean
+ updateRegistrationStatus(eventId : Integer, userId : Integer, status : EventRegistrationStatus) : Boolean
+ notifyLotteryServiceOnOpenSlot(eventId : Integer) : Boolean
+ trackNonResponders(eventId : Integer) : List<Integer>
```

---

<br>

### FIREBASESERVICE

---

```

```

---

```
+ storeUserData(user : User) : Boolean
+ storeEventData(event : Event) : Boolean
+ storeWaitingListData(eventId : Integer, waitingList : List<Integer>) : Boolean
+ syncRealTimeUpdates() : Boolean
```

---

<br>

### LOGINSERVICE

---

```
- currentLoggedInUser : User
```

---

```
+ login(email : String, password : String) : Boolean
+ loginWithDevice(deviceId : Integer) : Boolean
+ logout() : Boolean
+ getCurrentUser() : User
+ isAuthenticated() : Boolean
+ refreshSession() : Boolean
```

---
