## CICD

## CI -> Continuous Integration

## CD -> Continuous Delivery

## Develop -> TEST -> Deploy

### WorkFlow

- It has works flow that is
- Event
- Job
- Runners -> environment
- Steps
- Actions ->

## SetUp github Action

- Create a github repository, push the code on repository
- Create work flow create directory `.github/workflows` , in root level
- Crete a new file `AndroidBuild.yml` in side .github/worksflows folder and we will write each job and command in thin
  .yml file.
- We can create the same using github actions tab also.
- Now edit the file here 
```kotlin
name:AndroidBuild // workflow Name 
on:  // events 
    pull_request : 
        branches: [master]
    push:
        branches: [master]

jobs: // define multiple jobs 
    build:
        runs-on: ubantu-latest
        steps:
            // available plugin on github market 
            1. checkout 
            2. setUpJDK
       name: buid with gradlw support 
       run - ./gradlew  build 
      
      upload build artifact   
                
        


```

- push that file on repository 