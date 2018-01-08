# System Tests
GitLab URL: https://gitlab.cs.cf.ac.uk/c1673218/Y2_Behaviour_11

GitLab SSH: git@gitlab.cs.cf.ac.uk:c1673218/Y2_Behaviour_11.git

Master branch is where the full working version lies.

Before starting the application, in the directory go to the SQL folder and run the 
behaviourdb.sql script.

## Test 1
GO TO: http://localhost:8080/patient/1/index
### Expected Output:
Under Dashboard:
- Coming up: 2
- Average Score: 2
- Completion Rate: 83%
- Favourites: 3
- Completed: 5
- Positive Activities: 1
- Negative Activities: 1
- Deleted: 2

Graphs (Hover over points to see values)
Your Last Three Activities:
- Visiting David:
 Before = 6
 After = 2
 - Cinema:
 Before = 6
 After = 1
 - Mowing the Lawn
 Before = 1
 After = 5
 
 Overall Activities By Day:
 Friday = 1
 Monday = 1
 Thursday = 5
 Tuesday = 1
 
 WHAT YOU GENERALLY FEEL BEFORE AND AFTER ACTIVITIES:
 Before = 4
 After = 2
 
 Mood Change:
 Running = 0
 Visiting David = -4
 Mowing the Lawn = 4
 Go to Park = 5
 Cinema = -5
 
 ## TEST 2 
 GO TO: http://localhost:8080/patient/activities/1
 ### Expected Output:
 Under Upcoming Tab:
 Walking
 Painting
 
 Under Favourites tab:
 Walking 
 Painting 
 Visiting David
 
 Under History Tab:
 Running	
 Visiting David	
 Mowing the Lawn	
 Go to the Park
 
 
 ## Test 3
 GO TO: http://localhost:8080/patient/2/index
 ### Expected Output:
 Under Dashboard:
 - Coming up: 2 
 - Average Score: 2
 - Completion Rate: 60%
 - Favourites: 3
 - Completed: 3
 - Positive Activities: 1
 - Negative Activities: 1
 - Deleted: 0
 
 Graphs (Hover over points to see values)
 Your Last Three Activities:
 - Go to Gym:
  Before = 3
  After = 5
  - Visit Theresa:
  Before = 4
  After = 4
  - Go to Cinema
  Before = 1
  After = 6
  
  Overall Activities By Day:
  Friday = 1
  Monday = 1
  Thursday = 2
  Tuesday = 1
  
  WHAT YOU GENERALLY FEEL BEFORE AND AFTER ACTIVITIES:
  Before = 3
  After = 3
  
  Mood Change:
  Go to Gym = 1
  Visit Theresa = 0
  Go to Cinema = 5
  
  
  ## TEST 4 
  GO TO: http://localhost:8080/patient/activities/2
  ### Expected Output:
  Under Upcoming Tab:
  Go cycling to Maidenhead
  Planting
  
  Under Favourites tab:
  Go to the Gym 
  Go to the cinema
  Go cycling to Maidenhead
  
  Under History Tab:
  Go to the Gym
  Visit Theresa	
  Mowing the Lawn	
  Go to the cinema
