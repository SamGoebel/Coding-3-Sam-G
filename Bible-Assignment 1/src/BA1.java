import java.math.*;

public class BA1 
{

	public static void DiscipleAlgo(BigInteger disciples, BigInteger trained, BigInteger humans) //loop for first question 
	{
		for(int years = 0; years != -1; years += 3 ) //loop goes on forever until the disciples are >= 7.7 billion
		{
			disciples = disciples.multiply(trained);
			
			if(disciples.compareTo(humans) >= 0)
			
			{
				System.out.println("It took " + years + " years to get " + humans + " disciples of Christ.");
				break;
			}
		}
	
	}
	
	public static void DiscipleAlgo2(BigInteger disciples, BigInteger totalYears, BigInteger humans) //loop for second question
	{
		BigInteger trained = new BigInteger ("0");
		BigInteger loopNumber = new BigInteger ("2");
		
		for(int trainedPeople = 2; trainedPeople != -1; trainedPeople++) //loop goes on forever until the disciples are >= 7.7 billion in 50 years
		{
			disciples = BigInteger.valueOf(13);
			disciples = disciples.multiply(trained);
			disciples = disciples.multiply(totalYears);
			
			trained = trained.add(loopNumber);
			
			if(disciples.compareTo(humans) >= 0)
			
			{
				System.out.println(trained + " disciples per year are needed to convert everyone to Christ in " + totalYears + " years.");
				break;
			}
			//else
				//System.out.println("nope");
		}
	
	}
	
	
	
	public static void main(String[] args) 
	{
		BigInteger disciples = new BigInteger("13"); 
		BigInteger trained = new BigInteger ("2"); 
		BigInteger humans = new BigInteger("7700000000"); 
		BigInteger totalYears = new BigInteger("50");
		
		DiscipleAlgo(disciples, trained, humans);
	
		DiscipleAlgo2(disciples, totalYears, humans);
	
	}

}


