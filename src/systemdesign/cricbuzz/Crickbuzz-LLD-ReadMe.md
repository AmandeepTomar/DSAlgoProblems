# CrickBuzz LLD 

## Flow 
TeamA and Teamb 

## Objects 
1. Match 
   2. Innings
      3. Overs 
         4. Ball
2. Team 
   1. Player
2. Scorecard



## LLD

```java

import java.util.Queue;

class Match {
   Team teamA;
   Team teamB;
   Date datePfMatch;
   String vanue;
   Innings[] innings;
   MatchType matchType;
   String tossWinner;


   void startMatch() {

   }
}

class Team {
   String teamName;
   int teamId;
   Queue<Player> playing11;
   List<Player> onBench;
   PlayerBattingController playerBattingController;
   PlayerBowlingController playerBowlingController;

}

class Player {
   Person person;
   PlayerType playerType;
   BattingScoreCard battingScoreCard;
   BowlingScoreCard bowlingScoreCard;
}

class Person {
   int id;
   String name;
   String DOB;
   int age;
   Address address;
}


enum PlayerType {
   BOWLER, BATTER, WICKET_KEEPER, ALLROUNDER, CAPTAIN
}

class battingScorecard {
   int id;
   int totalRun;
   int totalBowlPlayed;
   int total4s;
   int total6s;
   double strikeRate;

}

class bowlingScorecard {
   int id;
   int totalOversDelivered;
   int totalMaidenOvers;
   int runsGiven;
   int wicketsTaken;
   int noBalls;
   int wideWallCount;
   float ecoRate;

}


class PlayerBattingController {

   // how many get to play 
   // Player is on strike 
   // who is going to come next and all managing. 
   // maintain a certain Queue , who yet to come , so we pick from the queue. 

   Queue<Player> playersNextToPlay;
   Player playerOnStrike;
   Player playerOnNonStriker;

   void setBatterList(){

   }

   void chooseTheNextNatter(){

   }
}

class PlayerBowlingController {

   // how many get to play 
   // Player is on strike 
   // who is going to come next and all managing. 
   // maintain a certain Queue , who yet to come , so we pick from the queue. 

   Deque<Player> playersNextToPlay; // queue has three bower , P1 and chosen as next bowler.
   Map<Player, count> bowlerVsOverCount;
   Player currentBowler;
   
   void setBowlersList(){
       
   }
   
   void chooseTheNextBowler(){
       
   }
}

interface MatchType {
   int noOfOvers();

   int maximumOverPerBowler();
}

class OneDay implements MatchType {
   @Override
   public int noOfOvers() {
      return 50;
   }

   @Override
   public int maximumOverPerBowler() {
      return 10;
   }
}

class T20Day implements MatchType {
   @Override
   public int noOfOvers() {
      return 20;
   }

   @Override
   public int maximumOverPerBowler() {
      return 4;
   }
}

class Innings {
   Team battingTeam;
   Team bowlingTeam;
   List<Overs> listOfOvers;


   void startInning() {

   }
}


class Over {
   int overNo;
   List<Ball> ballList;


   void startOver() {

   }
}

class Ball {
   int bollNo;
   BallType ballType;
   RunType runType;
   Player playedBy;
   Player bowledBy;
   List<ScoreUpdaterObserver> scoreUpdaterObserverList;


   public Ball(int ballNumber) {
      this.ballNumber = ballNumber;
      scoreUpdaterObserverList.add(new BowlingScoreUpdater());
      scoreUpdaterObserverList.add(new BattingScoreUpdater());
   }


   void startBowlDelivery() {
       notifyUpdaters(ball);
   }


   private void notifyUpdaters(Ball ball){

      for(ScoreUpdaterObserver observer : scoreUpdaterObserverList) {
         observer.update(ballDetails);
      }
   }

}

enum BallType {
   NORMAL, NOBALL, WIDEBALL
}

enum RunType {
   ONE, TWO, THREE, FOUR, SIX
}

interface ScoreUpdaterObserver {
   void update(Ball ball);
}

class BattingScorecardUpdater implements ScoreUpdaterObserver {
   @Override
   public void update(Ball ball) {
      
   }
}

class BowlingScorecardUpdater implements ScoreUpdaterObserver {
   @Override
   public void update(Ball ball) {

   }
}



```