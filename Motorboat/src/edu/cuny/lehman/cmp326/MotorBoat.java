package edu.cuny.lehman.cmp326;
public class MotorBoat 
{
	private double capacity;
	private double fuelLeft;
	private double topSpeed;
	private double currentSpeed;
	private double howEfficient;
	private double distanceTotal;
	/**
	* Pre/Postcondition: Default constructor.
	*/ 
	public MotorBoat()
	{
	}
	/**
	* Pre/Postcondition: Constructor that initializes fuelCapacity, fuelInTank, maxSpeed, efficiency, and distanceTraveled. 
	*/
	public MotorBoat(double fuelCapacity, double fuelInTank, double maxSpeed, double efficiency, double distanceTraveled)
	{
		capacity = fuelCapacity;
		fuelLeft = fuelInTank;
		topSpeed = maxSpeed;
		howEfficient = efficiency;
		distanceTotal = distanceTraveled;
	}
	/**
	* Pre/Postcondition: Constructor that initializes fuelCapacity, maxSpeed, and efficiency.
	*/
	public MotorBoat(double fuelCapacity, double maxSpeed, double efficiency)
	{
		capacity = fuelCapacity;
		topSpeed = maxSpeed;
		howEfficient = efficiency;
	}
	/**
	* Precondition: Change the current speed of the boat.
	* Postcondition: Sets currentSpeed to either topSpeed, zero, or actual speed depending on what you enter.  
	*/
	public void setCurrentSpeed(double speed)
	{
		if (speed < 0.0)
		{
			currentSpeed = 0.0;
		}
		else if (speed > topSpeed)
		{
			currentSpeed = topSpeed;
		}
		else
		{
			currentSpeed = speed;
		}
	}
	/**
	* Precondition: Operate the boat for an amount of time at the current speed.
	* Postcondition: Uses currentSpeed with a time to update fuel and distance.  
	*/
	public void driveBoat(double time)
	{
		if(time > 0.0 )
		{
            double t ,fuelUsage = howEfficient * currentSpeed * currentSpeed * time;
            if(fuelUsage > fuelLeft)
            {
                t = time * (fuelLeft/fuelUsage);
                fuelLeft = 0.0;
            }
            else
            {
                fuelLeft -= fuelUsage;
                t = time;
            }
           distanceTotal += currentSpeed * time; //CANNOT  GET THIS TO RUN BUT time IS SUPPOSE TO BE t. 
		}
	}
	/**
	* Precondition: Refuel the boat with some amount of fuel.
	* Postcondition: Returns 0 if all fuel fit if not then returns number that did not fit.
	*/
	public double refuelBoat(double fuel)
	{
		double overFuel = (fuel + fuelLeft) - capacity;
		if(fuel > 0.0)
		{
            if (fuel + fuelLeft > capacity)
            { 
                fuelLeft = capacity;
            }
            else
            {
                 fuelLeft += fuel;
            }
		}
		return (overFuel > 0  ? overFuel: 0); // neat little trick i learned ^_^
	}
	/**
	* Pre/Postcondition: Get the amount of fuel currently in the tank. 
	*/
	public double getFuel()
	{
		return fuelLeft;
	}
	/**
	* Pre/Postcondition: Get the distance traveled so far.
	*/
	public double getDistanceTraveled()
	{
		return distanceTotal;
	}
	/**
	* Precondition:Compute and return the maximum distance some boat can travel. 
	* Postcondition: Returns -1 if below 0 or above motorboat top speed.
	*/
	public double findMaximumRange(MotorBoat boat, double speed)
	{
		if ( speed > boat.topSpeed || speed < 0) 
		{
			return -1;
		}
		else
		{
			return (speed  * (capacity/ boat.howEfficient));
		}
	}
	/**
	* Precondition: Compare two MotorBoats for equality.
	* Postcondition: Returns true or false based on two motorboats created.
	*/
	public boolean equals(MotorBoat boat1, MotorBoat boat2)
	{
		return (boat1.topSpeed == boat2.topSpeed && boat1.capacity == boat2.capacity && boat1.capacity == boat2.capacity && boat1.howEfficient == boat2.howEfficient);
	}
	/**
	* Pre/Postcondition: Returns a string.
	*/
	public String toString()
	{
		return "\tMotorBoat\nFuel capacity:  " + capacity +" gallons\n" + 
				"Maximum speed:  " + topSpeed + " knots\n" +
				"Efficiency:     " + howEfficient + " gallons/hour\n" +
				"Distance: 	" + distanceTotal + " knots\n" +
				"Current fuel:   " + fuelLeft + " gallons\n" +
				"Current speed:	" + currentSpeed + " knots";
	}
}

