import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 10
//Purpose of program: Teach myself how to use Stacks to compute postfix expressions
//Date last modified:11/22/15

public class Evaluator {

	public static void main(String[] args) throws FileNotFoundException {
		GenericStack myStack = new GenericStack();
		//createArray();
		computeStack(myStack);
		//createStack();
		System.out.println("The computed value is " + myStack.peek());
	}


	public static void computeStack(GenericStack myStack) throws FileNotFoundException{ 
		char[] charArray = createArray();
		//OH MAN I GIVE UP
		int temp, tempInt, tempInt2, addedInt;
		for (int i = 0; i< charArray.length;i++){

			tempInt = 0;
			tempInt2 = 0;
			addedInt = 0;

			if (Character.isDigit(charArray[i])){
				System.out.println(charArray[i] + " is a number");
				temp = Character.getNumericValue(charArray[i]);
				myStack.push(temp);
			}
			else if(charArray[i] == '+'){

				System.out.println(charArray[i] + " is a plus sign");

				if (myStack.peek() != null){

					System.out.println("The peek for tempInt in the adding reads "+ myStack.peek());
					tempInt = (int) myStack.peek();
					System.out.println("The tempInt 1 is "+ tempInt);
					myStack.pop();

					if (myStack.peek() != null){

						System.out.println("The peek for tempInt2 in the adding reads "+ myStack.peek());
						tempInt2 = (int) myStack.peek();
						myStack.pop();
						System.out.println("The tempInt 2 is " + tempInt2);
						addedInt = (tempInt+tempInt2);
						System.out.println("The value of the addedInt is " + addedInt);
						myStack.push(addedInt);
					}

					else{
						System.out.println("oops, something went wrong (tempInt2");
					}
				}

				else{
					System.out.println("OppsSomething went wrong (first if check)");
				}
			}
			else if(charArray[i] == '*'){

				System.out.println(charArray[i] + " is a multiply sign");
				if (myStack.peek() != null){

					System.out.println("The peek for tempInt in the multiply reads " + myStack.peek());
					tempInt = (int) myStack.peek();
					System.out.println("The tempInt 1 is "+ tempInt);
					myStack.pop();
					if (myStack.peek() != null){

						System.out.println("The peek for tempInt2 in the multiply reads " + myStack.peek());
						tempInt2 = (int) myStack.peek();
						myStack.pop();
						System.out.println("The tempInt 2 is " + tempInt2);
						addedInt = (tempInt*tempInt2);
						System.out.println("The value of the addedInt is " + addedInt);
						myStack.push(addedInt);
					}

					else{
						System.out.println("oops, something went wrong (tempInt2)");
					}
				}

				else{
					System.out.println("Oops Something went wrong (first if check)");
				}
			}

			else if (charArray[i] == '-'){
				System.out.println(charArray[i] + " is a minus sign");

				if (myStack.peek() != null){

					System.out.println("The peek for tempInt in the adding reads "+ myStack.peek());
					tempInt = (int) myStack.peek();
					System.out.println("The tempInt 1 is "+ tempInt);
					myStack.pop();

					if (myStack.peek() != null){

						System.out.println("The peek for tempInt2 in the adding reads "+ myStack.peek());
						tempInt2 = (int) myStack.peek();
						myStack.pop();
						System.out.println("The tempInt 2 is " + tempInt2);
						addedInt = (tempInt+tempInt2);
						System.out.println("The value of the addedInt is " + addedInt);
						myStack.push(addedInt);
					}

					else{
						System.out.println("oops, something went wrong (tempInt2");
					}
				}

				else{
					System.out.println("OppsSomething went wrong (first if check)");
				}

			}

			else if (charArray[i] == '/'){
				System.out.println(charArray[i] + " is a divide sign");

				if (myStack.peek() != null){

					System.out.println("The peek for tempInt in the adding reads "+ myStack.peek());
					tempInt = (int) myStack.peek();
					System.out.println("The tempInt 1 is "+ tempInt);
					myStack.pop();

					if (myStack.peek() != null){

						System.out.println("The peek for tempInt2 in the adding reads "+ myStack.peek());
						tempInt2 = (int) myStack.peek();
						myStack.pop();
						System.out.println("The tempInt 2 is " + tempInt2);
						addedInt = (tempInt+tempInt2);
						System.out.println("The value of the addedInt is " + addedInt);
						myStack.push(addedInt);
					}
					else{
						System.out.println("oops, something went wrong (tempInt2");
					}
				}
				else{
					System.out.println("OppsSomething went wrong (first if check)");
				}
			}
		}
	}

	public static char[] createArray() throws FileNotFoundException{
		Scanner fileScnr;

		fileScnr = new Scanner(new File("C:\\Users\\squin_000\\Desktop\\input.txt"));

		//This is a thing that works
		String temp = fileScnr.nextLine();
		System.out.println(temp);
		temp = temp.replaceAll(" ", "");
		System.out.println(temp);

		//i hope i still know how to do this
		//yeeeaaahhhhh
		char[] charArray = temp.toCharArray();
		fileScnr.close();
		return charArray;

	}
}
