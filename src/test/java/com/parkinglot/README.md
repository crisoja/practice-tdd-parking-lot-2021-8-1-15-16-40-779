README.md

# story 1
[x] Case1  
Given a parking lot, and a car  
When park the car  
Then return a parking ticket. 

[x] Case 2
Given a parking lot with a parked car and a parking ticket
When fetch the car
Then return the parked car

[x] Case 3
Given a parking lot with two parked cars and two parkingtickets
When fetch the car twice
Then return the right car.

[x] Case 4
Given a parking lot, and wrong parking ticket
When fetch the car
Then return nothing

[x] Case 5
Given a wrong parking ticket
When fetch the car
Then return nothing

[x] Case 6
Given a parking lot, without any position, and a car
When park the car
Then return nothing

# story 2

[x] Case 1
Given a parking lot, and a wrong ticket
when fetch the car
Then return error message "Unrecognized parking ticket"

[x] Case 2
Given a parking lot, and a used ticket
when fetch the car
Then error message "Unrecognized parking ticket"

[x] Case 3
Given a full parking lot, and a car
When park the car
Then return error message "No available position"

# story 3
[x] Case1  
Given a parking lot, and a car  
When parking boy park the car  
Then return a parking ticket.

[x] Case 2
Given a parking lot with a parked car and a parking ticket
When parking boy fetch the car
Then return the parked car

[x] Case 3
Given a parking lot with two parked cars and two parking ticket
When parking boy fetch the car twice
Then return the right car.

[x] Case 4
Given a parking lot, and a wrong ticket
when parking boy fetch the car
Then return error message "Unrecognized parking ticket"

[x] Case 5
Given a parking lot, and a used ticket
when parking boy fetch the car
Then error message "Unrecognized parking ticket"

[x] Case 6
Given a full parking lot, and a car
When parking boy park the car
Then return error message "No available position"
