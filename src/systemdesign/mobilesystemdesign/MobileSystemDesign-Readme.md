## System Design

1. Observation and navigation
    1. Talk about the
        1. .How many user going to use it at a time
        2. Does offline mode supported
        3. Data base
        4. Api
        5. caching
        6. Architecture
        7. Also talk about the priority
    2. Now deep drive into problems
    3. Just talk about the mobile problem first
        4. Battery usages.
        5. Reduce the unused resources.
    4. Common Design pattern
    5. UI Architecture
        1. Screen extremely big data (Recycler View)
    6. Backend
        1. Rest Api
        2. Web Socket
        3. Server sent events
        4. Pooling
        5. GrpC -> live streaming
        6. GraphQl -> chat and live update , user can modify the response and get the single value no extra values.
        5. Push notification.
    7. Data Storage
        1. Room data base
        2. Preference
        3. DataStore -> asynchronous , reactive observability , backward compatibility , type safety , and coroutine
           support.
        3. local cache
    8. App Specification
        1. Responsive UI
    9. User experience
        1. Pull to refresh.
2. Working solution
3. technical communication
4. Technical excellence

# System Design For Instagram.

We are going to design the vertica list of feeds with endless scroll and pull to refresh.

1. Vertical scroll view with pull to refresh.
   Features

- News Feed of posts
- Post
    - Photos , album , author caption and like count
    - like a post
    - fast infinite scroll
    - offline mode
    - 10000 posts
      Plan
      - Data Model
      - Api Integration
      - Storage
      - Architecture
      - UI Layer
      - Discussion
      - Data Model

```kotlin
        data class Post(
        val postId: Long,
        val type: Int, // (Photo, Album , Video)
        val author: String,
        val likeCount: Long,
        val caption: String,
        val location: String,
        val photoUrl: String
)

class User {
    var userName: String
    var userId: Long
    var userAvatarImage: String
}

class Like {
    var likeId: Long
    var postId: Long
    var successFullySynced: Boolean
}
```

API

- Rest Api
- Retrofit
- Peggination
    - offset based -> Array
        - next page and all
        - limit and offset
        - pageNo
        - this approach is not works well when server state changes , or we will get duplicates and all.
    - cursor based ->LinkedList
        - last object identifier
        - select some kind of object identifier , like id , timestamp for object.
    - @Get Api/user/{post_id}/{limit=20}/{pageNo}
    - @post post_like(post_id,isUpdated:Bool)

Storage

- preference
- Room
- DataStore
  Images cache
    - Glide 
    - Coil compose

