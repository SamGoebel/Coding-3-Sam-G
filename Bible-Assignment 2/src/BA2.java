import java.math.BigInteger;

public class BA2 {
    public static void main(String[] args) {
        BigInteger totalPopulation = new BigInteger("7800000000"); // Total population
        BigInteger initialDisciples = new BigInteger("13"); // Initial number of disciples
        int newDisciplesPerCouple = 1; // Number of new disciples per couple
        int trainingAge = 18; // Age when disciples can start training
        int newDiscipleAge = 21; // Age when male disciples can start training new disciples
        int newDiscipleFrequency = 3; // New disciple training frequency

        BigInteger disciples = initialDisciples; // Initialize with the initial disciples
        int years = 0; // Initialize years

        while (disciples.compareTo(BigInteger.ZERO) > 0) {
            BigInteger couples = disciples.divide(BigInteger.valueOf(2)); // Number of couples formed by disciples

            // Calculate new disciples
            BigInteger newDisciples = BigInteger.ZERO;

            for (int i = 0; i < couples.intValue(); i++) {
                if (i * 2 + trainingAge <= years) {
                    newDisciples = newDisciples.add(BigInteger.valueOf(newDisciplesPerCouple));
                }
            }

            disciples = disciples.add(newDisciples); // Total number of disciples after training

            // Add new disciples trained by male disciples
            if (years >= newDiscipleAge && years % newDiscipleFrequency == 0) {
                BigInteger maleDisciples = disciples.divide(BigInteger.valueOf(2)); //creates a big int with a value of two so that dividing can be done 
                newDisciples = maleDisciples;
                disciples = disciples.add(newDisciples);
            }

            years++; // Increment years by 1

            // Check if disciples have converted the entire population
            if (disciples.compareTo(totalPopulation) >= 0) {
                System.out.println("It would take " + years + " years for " + initialDisciples + " disciples to convert " + totalPopulation + " people into disciples of Jesus.");
                break; //ends the program so it doesn't keep going. 
            }

            // Check if there is a couple of disciples, a man and a woman, who are 30 years old
            if (years >= 30) {
                BigInteger maleDisciples = disciples.divide(BigInteger.valueOf(2));
                BigInteger femaleDisciples = disciples.divide(BigInteger.valueOf(2));

                if (maleDisciples.compareTo(BigInteger.ZERO) > 0 && femaleDisciples.compareTo(BigInteger.ZERO) > 0) {
                    // A couple of disciples, a man and a woman, who are 30 years old, have a child
                    disciples = disciples.add(BigInteger.ONE);
                }
            }

            // Remove disciples when they reach the age of 72
            if (years % 72 == 0) {
                BigInteger elderlyDisciples = disciples.divide(BigInteger.valueOf(2));
                disciples = disciples.subtract(elderlyDisciples);
            }
        }
    }
}