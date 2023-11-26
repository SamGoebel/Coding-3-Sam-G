import java.math.BigInteger;

public class BA3 {
	public static void DiscipleAlgo(BigInteger disciples, BigInteger humans, BigInteger followers) //loop for first question 
	{
		for(int years = 0; years != -1; years += 3 ) //loop goes on forever until the disciples are >= 7.7 billion
		{
			followers = disciples.add(followers); 
			
			if(followers.compareTo(humans) >= 0)
			
			{
				System.out.println("It took " + years + " years to get " + humans + " disciples of Christ.");
				break;
			}
		}
	
	}
	
	
	public static void main(String[] args) 
	{
		BigInteger disciples = new BigInteger("13"); 
		//BigInteger trained = new BigInteger ("2"); 
		BigInteger humans = new BigInteger("7700000000"); 
		BigInteger followers = new BigInteger("0");
		
		DiscipleAlgo(disciples, humans, followers);
	
		}

}
