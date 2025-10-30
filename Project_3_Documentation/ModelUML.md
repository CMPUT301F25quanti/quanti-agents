# Models UML

<br>

### UserRole `<ENUM>`

---

```
ENTRANT
ADMIN
```

---

```

```

---

<br>

### EventRegistrationStatus `<ENUM>`

---

```
WAITLIST
CANCELLED
CONFIRMED
SELECTED
```

---

```

```

---

<br>

### EventStatus `<ENUM>`

---

```
OPEN
CLOSED
FULL
CANCELLED
```

---

```

```

---

<br>

### NotificationType `<ENUM>`

---

```
GOOD
WARNING
REMINDER
BAD
```

---

```

```

---

<br>

### USER

---

```
- id : Integer
- name : String
- email : String
- phone : Long
- role (ENTRANT, ADMIN) : UserRole
- createdOn : DateTime
- registrationHistory : RegistrationHistory
- hasNotificationOn : Boolean
```

---

```
+ getUserId() : String
+ setUserId(id : Integer) : Void
+ getUserName() : String
+ setUserName(name : String) : Void
+ getUserEmail() : String
+ setUserEmail(email : String) : Void
+ getUserPassword() : String
+ setUserPassowrd(password : String) : Void
+ getUserRole() : UserRole
+ setUserRole(role : UserRole) : Void
+ getUserCreatedOn() : DateTime
+ setUserCreatedOn(createdOn : DateTime) : Void
+ getUserHasNotificationOn() : Boolean
+ setUserHasNotificationOn(hasNotificationOn : Boolean) : Void
+ getUserRegistrationHistory() : RegistrationHistory
+ setUserRegistrationHistory(registrationHistory : RegistrationHistory) : Void
```

---

<br>

### RegistrationHistory

---

```
- eventId : Integer
- userId : Integer
- eventRegStatus : EventRegistrationStatus
- registeredAt : DateTime
```

---

```
+ getEventId() : Integer
+ getUserId() : Integer
+ getEventRegistrationStatus() : EventRegistrationStatus
+ setUserId(userId : Integer ) : Void
+ setEventId(eventId : Integer ) : Void
+ setEventRegistrationStatus(eventRegStatus : EventRegistrationStatus ) : Void
+ getRegisteredAt() : DateTime
+ setRegisteredAt(registeredAt : DateTime) : Void
```

---

<br>

### EVENT

---

```
- id : Integer
- name : String
- description : String
- eventStartTime : DateTime
- eventEndTime : DateTime
- registrationStartTime : DateTime
- registrationEndTime : DateTime
- location : String
- cost : Double
- status : EventStatus
- posterId : Integer
- qrCodeId : Integer
- organizerId : Integer
- waitingListLimit : Integer
- eventCapacity : Integer
- isGeoLocationOn : Boolean
- waitingList : List<Integer>
- selectedList : List<Integer>
- confirmedList : List<Integer>
- cancelledList : List<Integer>
- isFirstLotteryDone : Boolean
```

---

```
+ getEventId() : Integer
+ setEventId(id : Integer) : Void
+ getEventName() : String
+ setEventName(name : String) : Void
+ getEventDescription() : String
+ setEventDescription(description : String) : Void
+ getEventStartTime() : DateTime
+ setEventStartTime(startTime : DateTime) : Void
+ getEventEndTime() : DateTime
+ setEventEndTime(endTime : DateTime) : Void
+ getRegistrationStartTime() : DateTime
+ setRegistrationStartTime(registrationStartTime : DateTime) : Void
+ getRegistrationEndTime() : DateTime
+ setRegistrationEndTime(registrationEndTime : DateTime) : Void
+ getEventLocation() : String
+ setEventLocation(location : String) : Void
+ getEventCost() : Double
+ setEventCost(cost : Double) : Void
+ getEventStatus() : EventStatus
+ setEventStatus(status : EventStatus) : Void
+ getPosterId() : Integer
+ setPosterId(posterId : Integer) : Void
+ getQrCodeId() : Integer
+ setQrCodeId(qrCodeId : Integer) : Void
+ getOrganizerId() : Integer
+ setOrganizerId(organizerId : Integer) : Void
+ getWaitingListLimit() : Integer
+ setWaitingListLimit(waitingListLimit : Integer) : Void
+ getEventCapacity() : Integer
+ setEventCapacity(eventCapacity : Integer) : Void
+ getIsGeoLocationOn() : Boolean
+ setIsGeoLocationOn(isGeoLocationOn : Boolean) : Void
+ getWaitingList() : List<Integer>
+ setWaitingList(waitingList : List<Integer>) : Void
+ getSelectedList() : List<Integer>
+ setSelectedList(selectedList : List<Integer>) : Void
+ getConfirmedList() : List<Integer>
+ setConfirmedList(confirmedList : List<Integer>) : Void
+ getCancelledList() : List<Integer>
+ setCancelledList(cancelledList : List<Integer>) : Void
+ getIsFirstLotteryDone() : Boolean
+ setIsFirstLotteryDone(isFirstLotteryDone : Boolean) : Void
```

---

<br>

### LOTTERYRESULT

---

```
- eventId : Integer
- entrantIds : List<Integers>
- timestamp : DateTime
```

---

```
+ getEventId() : Integer
+ setEventId(eventId : Integer) : Void
+ getEntrantIds() : List<Integer>
+ setEntrantIds(entrantIds : List<Integer>) : Void
+ getTimestamp() : DateTime
+ setTimestamp(timestamp : DateTime) : Void
```

---

<br>

### NOTIFICATION

---

```
- id : Integer
- type : NotificationType
- content : String
- recipientId : Integer
- senderId : Integer
- affiliatedEventId : Integer
- timestamp : DateTime
- hasRead : Boolean
```

---

```
+ getNotificationId() : Integer
+ setNotificationId(id : Integer) : Void
+ getNotificationType() : NotificationType
+ setNotificationType(type : NotificationType) : Void
+ getNotificationContent() : String
+ setNotificationContent(content : String) : Void
+ getRecipientId() : Integer
+ setRecipientId(recipientId : Integer) : Void
+ getSenderId() : Integer
+ setSenderId(senderId : Integer) : Void
+ getAffiliatedEventId() : Integer
+ setAffiliatedEventId(affiliatedEventId : Integer) : Void
+ getTimestamp() : DateTime
+ setTimestamp(timestamp : DateTime) : Void
+ getHasRead() : Boolean
+ setHasRead(hasRead : Boolean) : Void
```

---

<br>

### POSTER

---

```

- id : Integer
- imageUrl : String
- file : File
- eventId : Integer
- uploadedBy : Integer
```

---

```
+ getPosterId() : Integer
+ setPosterId(id : Integer) : Void
+ getPosterImageUrl() : String
+ setPosterImageUrl(imageUrl : String) : Void
+ getPosterFile() : File
+ setPosterFile(file : File) : Void
+ getEventId() : Integer
+ setEventId(eventId : Integer) : Void
+ getUploadedBy() : Integer
+ setUploadedBy(uploadedBy : Integer) : Void

```

---

<br>

### QRCODE

---

```

- id : Integer
- codeData : String or BLOB
- eventId : Integer
```

---

```
+ getQrCodeId() : Integer
+ setQrCodeId(id : Integer) : Void
+ getCodeData() : String
+ setCodeData(codeData : String) : Void
+ getEventId() : Integer
+ setEventId(eventId : Integer) : Void
```

---

<br>

### GEOLOCATION

---

```
- latitude : Double
- longitude : Double
- timestamp : Double
- userId : Integer
- eventid : Integer
```

---

```
+ getLatitude() : Double
+ setLatitude(latitude : Double) : Void
+ getLongitude() : Double
+ setLongitude(longitude : Double) : Void
+ getTimestamp() : Double
+ setTimestamp(timestamp : Double) : Void
+ getUserId() : Integer
+ setUserId(userId : Integer) : Void
+ getEventId() : Integer
+ setEventId(eventId : Integer) : Void
```

---

<br>

### DEVICEIDENTIFIER

---

```
- deviceId : Integer
- userId : Integer
```

---

```
+ getDeviceId() : Integer
+ setDeviceId(deviceId : Integer) : Void
+ getUserId() : Integer
+ setUserId(userId : Integer) : Void
```

---
