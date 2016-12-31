package edu.cuny.lehman.cmp326;

public class MotorBoatDemo 
{

	public static void main(String[] args)
	{
		MotorBoat Speedster = new MotorBoat ( 50,100,5);
		
		MotorBoat myBoat = new MotorBoat(50,100,1);

		System.out.println(Speedster);
		
		Speedster.setCurrentSpeed(50);
		
		System.out.println(Speedster);
		
		Speedster.driveBoat(2.0);
		
		System.out.println(Speedster);
		
		System.out.println(Speedster.refuelBoat(30));
		
		System.out.println(Speedster);
		
		System.out.println(Speedster.getFuel());
		
		System.out.println(Speedster.getDistanceTraveled());
		
		System.out.println(Speedster.findMaximumRange(Speedster, 50));
		
		System.out.println(Speedster.equals(Speedster, myBoat));
		
		System.out.println(Speedster.toString());
	}

}
