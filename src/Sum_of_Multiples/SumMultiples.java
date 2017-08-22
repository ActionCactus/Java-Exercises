package Sum_of_Multiples;

import java.util.Arrays;

/**
 * Extremely simple cli program that takes any number of inputs and adds the sum of all
 * of their multiples under 1000.
 *
 * It's been awhile since I've done any java so I figured I'd play around with something
 * simple.
 */
public class SumMultiples
{
    public static void main(String[] args)
    {
        SumMultiples obj = new SumMultiples();
        int[] inputs = obj.getSanitizedInput(args);
        Arrays.sort(inputs); // Not really necessary

        int sum = 0;

        for(int x = inputs[0]; x < 1000; x++){
            for(int i = 0; i < inputs.length; i++) {
                if ((x % inputs[i]) != 0) {
                    continue;
                }

                sum += x;
                break;
            }
        }

        obj.printExitString(sum, args);
    }

    private int[] getSanitizedInput(String[] args)
    {
        if(args.length == 0){
            System.out.print("No arguments passed; exiting!");
            System.exit(0);
        }

        int[] ints = new int[args.length];

        for(int i = 0; i < args.length; i++){
            /**
             * This is a bummer.
             *
             * I don't know how taxing exceptions are in Java, but my experience tells
             * me that there should be a more efficient and legible way of doing this
             * with the default libraries.
             */
            try{
                ints[i] = Integer.parseInt(args[i]);
            }catch(NumberFormatException e){
                System.out.print("All passed parameters must be integers; \""
                        + args[i] + "\" is an invalid type!");
                System.exit(0);
            }
        }

        return ints;
    }

    private void printExitString(int sum, String[] inputs)
    {
        String inputSegment = "";

        for(int i = 0; i < inputs.length; i++){
            if(i != 0 && inputs.length != 2){
                inputSegment += ", ";
            }

            if(i == (inputs.length - 1)){
                inputSegment += "and ";
            }

            inputSegment += inputs[i];
        }

        System.out.println("The sum of all multiples of " + inputSegment + " is " + sum);
    }
}
