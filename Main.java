//comments are how I tested the algorithm.

class Main
{

  public static void main (String[]args)
  {
    Salesman[]man;

    man = new Salesman[7];

    man[0] = new Salesman ("James", 5);
    man[1] = new Salesman ("Martin", 1);
    man[2] = new Salesman ("Arthur", 6);
    man[3] = new Salesman ("Chad", 14);
    man[4] = new Salesman ("Charlie", 3);
    man[5] = new Salesman ("Bob", 8);
    man[6] = new Salesman ("Darwin", 11);

    int max = man[0].sales;
    int guy = 8;
    int maxGuy = -1;
    for (int g = 0; g < 5; g++)
      {
	max = 0;
	guy = -1;
	maxGuy = -1;
	//System.out.println("Old Maxguy " + maxGuy);
	for (int i = 0; i < man.length; i++)
	  {
	    //System.out.println (guy);
	    if (man[i].sales > max)
	      {
		if (maxGuy != i)
		  {
		    max = man[i].sales;
		    guy = i;
		    //System.out.println (guy);
		  }
	      }
	  }
	maxGuy = guy;
	//System.out.println("Maxguy " + maxGuy);
	man[maxGuy].displayTop5 ();
	man[maxGuy] = new Salesman (man[maxGuy].name, 0);
      }

  }

}

class Salesman
{

  String name;

  int sales;

    Salesman (String name, int sales)
  {
    this.name = name;
    this.sales = sales;
  }

  public void displayTop5 ()
  {
    System.out.println (name + " had " + sales + " total sales ");
    System.out.println ();
  }

}
