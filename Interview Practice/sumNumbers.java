//Finds all the numbers within a string and returns their sum
public int sumNumbers(String str) {
      char[] strArr = str.toCharArray();
      int sum = 0; 
      for (int i=0;i<strArr.length;i++){
        if (Character.isDigit(strArr[i])){
          int j=i; //Temp i value, used to find a full number
          String fullNumber ="";
          //Iterates through to ensure all digits are accounted for
          while(j<strArr.length && Character.isDigit(strArr[j])){
             fullNumber +=strArr[j];
             j++;
          }
          i=j; //Skips past number that was already accounted for
          sum += Integer.parseInt(fullNumber);
        }
      }
      return sum;
    }

 public static void main(String []args){
        System.out.println(sumNumbers("1tj11tj"));
        System.out.println(sumNumbers("1tesj"));
        System.out.println(sumNumbers("1te@%%$*@%^*#@%^321&^(*^@&*32"));
        System.out.println(sumNumbers("1"));
        System.out.println(sumNumbers(""));
     }
