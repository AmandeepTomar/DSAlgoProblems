## Stream app , chat app design

- Problem
    - chat application simple like two friends chat
        - Last seen , user pic , name , message , time , read or not read.
- What we required
    - Overview UI/UX
    - entity, data model
    - Api
    - Storage
    - Architecture
    - Deep drive

- Entity
    - Friend
        - name , avatarUrl , id
    - FriendStatue
        - friendId , status (offline, online) , gameName , lastSeenTimeStamp
- API
    - getFriendsList :List<Friend> , we can add the timestamp in get request so the server send the updated status
    - Now we need to update the FriendStatus in each 5 second so need to check what are the way to get it.
        - Most simplest is pooling -> we need to sends a lot of request so huge load on server so it is not good
          usecase.
        - sockets -> this one is the best solution, cause now server get to know when app is open or not. As the app
          open we open the socket and send the friend status object.
        - push notification -> We need to send the push notification , is not a good solutions , because we do not =know
          app is open or not.
- Storage 
  - We do not need to store the friend status 
  - We need to save the list of Friends
    - Preference 
    - Sqlite 
    - RoomData  -> use Room 
    - Serialize and deSerialize
- Architecture Diagram 
  -  Android   <--->  BackEnd , MVVM
