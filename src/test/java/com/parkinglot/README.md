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

# story 4

[x] Case 1
Given a standard parking boy who manage two parking lots, both with available position, and a car
When standard parking boy park the car
Then the car will be parked to the first parking lot

[x] Case 2
Given a standard parking boy, who manage two parking lots, first is full and second with available position, and a car
When standard parking boy park the car
THen the car will be parked to the second parking lot

[x] Case 3
Given a standard parking boy who manage two parking lots bot with a parked car and two parking ticket
When standard parking boy fetch the car twice
Then return the right car with each ticket

[x] Case 4
Given a standard parking boy, who manage two parking lots, and an unrecognized ticket,
When standard parking boy fetch the car,
Then return nothing with error message "Unrecognized parking ticket"

[x] Case 5
Given a standard parking boy, who manage two parking lots and a used ticket,
When standard parking boy fetch the car
then return nothing with error message "Unrecognized parking ticket"

[x] Case 6
Given a standard parking boy who manage two parking lots, bot without any position and a car
When standard parking boy park the car
Then return nothing with error message "No available position"

# story 5

[x] Case 1
Given a smart parking boy who manage two parking lots, both with available position, and a car
When smart parking boy park the car
Then the car will be parked to the first parking lot

[x] Case 2
Given a smart parking boy, who manage two parking lots, first parking lot has less position than second parking lot, and a car
When smart parking boy park the car
Then the car will be parked to the second parking lot

[x] Case 3
Given a smart parking boy, who manage two parking lots, second parking lot has less position than first parking lot, and a car
When smart parking boy park the car
Then the car will be parked to the first parking lot

[x] Case 4
Given a smart parking boy who manage two parking lots bot with a parked car and two parking ticket
When smart parking boy fetch the car twice
Then return the right car with each ticket

[x] Case 5
Given a smart parking boy, who manage two parking lots, and an unrecognized ticket,
When standard parking boy fetch the car,
Then return nothing with error message "Unrecognized parking ticket"

[x] Case 6
Given a smart parking boy, who manage two parking lots and a used ticket,
When smart parking boy fetch the car
then return nothing with error message "Unrecognized parking ticket"

[x] Case 7
Given a smart parking boy who manage two parking lots, bot without any position and a car
When smart parking boy park the car
Then return nothing with error message "No available position"


# story 6

[x] Case 1
Given a super smart parking boy who manage two parking lots, both with available position, and a car
When super smart parking boy park the car
Then the car will be parked to the first parking lot

[x] Case 2
Given a super smart parking boy, who manage two parking lots, first parking lot has larger available position rate than second parking lot, and a car
When super smart parking boy park the car
Then the car will be parked to the second parking lot


[] Case 3
Given a smart parking boy, who manage two parking lots, second parking lot has arger available position rate than first parking lot, and a car
When smart parking boy park the car
Then the car will be parked to the first parking lot


[] Case 4
Given a super smart parking boy, who manage two parking lots, and an unrecognized ticket,
When standard parking boy fetch the car,
Then return nothing with error message "Unrecognized parking ticket"

[] Case 5
Given a super smart parking boy, who manage two parking lots and a used ticket,
When super smart parking boy fetch the car
then return nothing with error message "Unrecognized parking ticket"

[] Case 6
Given a super smart parking boy who manage two parking lots, bot without any position and a car
When super smart parking boy park the car
Then return nothing with error message "No available position"

