import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    /*1.Write a program to find all of the longest word in a given dictionary.*/
        ArrayList<String> list=new ArrayList<String>();

        list.add("cat");
        list.add("dog");
        list.add("red");
        list.add("is");
        list.add("am");
        int longLength=list.get(0).length();  // 3

        for (String str : list) {
            int length=str.length();
            if (length > longLength)
            {
                longLength=length;
            }
        }
        for(String item : list)
        {
            if(item.length()==longLength){
                System.out.println(item);
            }
        }

        /*2-Write a program that displays the number of occurrences of an element in the array*/
        int [] numbers={1,1,1,3,3,5};
        ArrayList<Integer> counts = new ArrayList<>();
        ArrayList<Integer> numbers2 = new ArrayList<>();
        for(int x=0;x<numbers.length;x++){
            if(numbers2.size() < 1){
                numbers2.add(numbers[x]);
                counts.add( 1);
            }else{

                boolean found=false;
                for(int y = 0; y< numbers2.size();y++){
                    if(numbers[x]==numbers2.get(y)){
                        if(counts.size() > y){
                            int value = counts.get(y);
                            counts.set(y , ++value);
                        }else{
                            counts.add(1);

                        }

                        found=true;
                        break;
                    }
                }
                if(!found){
                    numbers2.add(numbers[x]);
                    counts.add(1);
                }
            }

        }
        for(int x=0;x<numbers2.size();x++){
            if(counts.size() > x){
                System.out.println(numbers2.get(x) + " occures " + counts.get(x));
            }else{

                System.out.println(numbers2.get(x) + " occures  1");
            }

        }
        System.out.println("=====================");
      /*3-Write a program to find the k largest elements in a given array. Elements in the array can be in any order.*/
         int[] largest={1,4,17,7,25,3,100};
         int[] sortedArray=new int[largest.length];
         int max = largest[0];
         int index=0;
         for(int j=0;j<largest.length;j++){
             for(int i=0;i<largest.length;i++){
                 if(largest[i]>max){
                     max=largest[i];
                    index = i;
                 }
             }
             largest[index]= 0;
             sortedArray[j]=max;
             max = 0;
         }

         if (sortedArray.length > 3) {
             System.out.print(sortedArray[0] + "\t");
             System.out.print(sortedArray[1] + "\t");
             System.out.print(sortedArray[2] + "\t");
         }
        System.out.println("========================");
         /*4- Create a method to reverse an array of integers. Implement the method without creating a new aray*/
         int[] arr ={5,4,3,2,1};
       int[] result = reverse(arr);
       for (int i : result) {
           System.out.print(i + "\t");
       }
/*5. Write a menu driven Java program with following option:*/

        boolean isRun = true;
        System.out.println();
        int  arrayCount=0;
        int[]   array =new int[arrayCount];
        while(isRun){
            System.out.println("1- Accept elements of an array ");
            System.out.println("2-display elements of an array ");
            System.out.println("3-search the elements");
            System.out.println("4-sort the array");
            System.out.println("5-to stop");
            System.out.println("chose from 1 to 5: ");
            int choice=input.nextInt();



            switch(choice){
                case 1:
                    System.out.println("enter array length:");
                    arrayCount=input.nextInt();
                    array =new int[arrayCount];
                    System.out.println("enter array elements:");
                    for(int i=0;i<arrayCount;i++){
                        array[i]=input.nextInt();
                    }
                    System.out.println("elements entered");
                    break;
                case 2:
                    if(arrayCount!=0){
                        for(int i=0;i<arrayCount;i++){
                            System.out.print(array[i] + "\t");
                            System.out.println();
                        }
                    }else {
                        System.out.println("no elements in array:");
                    }
                    break;
                case 3:
                    System.out.println("enter element to search:");
                    int search=input.nextInt();
                    boolean found=false;
                    for(int i : array){
                        if(search==i){
                            System.out.println("element found");
                            found=true;
                        }
                    }
                    if(!found){
                        System.out.println("element not found");
                    }
                    break;
                case 4:
                    int[] mySortedArray=new int[array.length];
                    int myMax = array[0];
                    int x=0;
                    for(int j=0;j<array.length;j++){
                        for(int i=0;i<array.length;i++){
                            if(array[i] > myMax){
                                myMax=array[i];
                                x = i;
                            }
                        }
                        array[x]= 0;
                        mySortedArray[j]=myMax;
                        myMax = 0;
                    }
                    int[] mySortedArray2=new int[array.length];
                    for(int i=0;i<array.length;i++){
                        mySortedArray2[i]=mySortedArray[mySortedArray.length-1-i];
                    }
                    for(int k : mySortedArray2){
                        System.out.print(k + "\t");
                    }
                    break;
                case 5:
                    isRun = false;
                    break;

            }
        }

       /*6. Create a method that generates a random number within a given range. Allow the user to
specify the range and call the method to display random numbers.
Hint: use Random class*/
        System.out.println("enter the minimum value of the range");
        int min=input.nextInt();
        System.out.println("enter the maximum value of the range");
        int maxi = input.nextInt();
        System.out.println("enter the number of random numbers");
        int rnadomNumbers = input.nextInt();
        int[] randomArr = generateNumbers(min,maxi,rnadomNumbers);
        System.out.println("random numbers:");
        for(int i=0;i<randomArr.length;i++){
            System.out.print(randomArr[i] + "\t");
        }

    }
    public static int[] reverse(int[] array){
        for(int i=0;i<array.length/2;i++){
            int temp=array[i];
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=temp;
        }
        return array;
    }

    public static int[] generateNumbers(int min , int max , int n){
        int[] numbers=new int[n];

        for(int i=0;i<n;i++){
            while(true){
                double myNumber =  Math.random() * 10;
                int number = (int) myNumber;
                if(number>min && number<max){
                    numbers[i]=number;
                    break;
                }
            }

        }
        return numbers;
    }
}