public int sumNumbers(String str) {
  char[] strArr = str.toCharArray();
      int total = 0;
      for (int i=0;i<strArr.length;i++){
        if (Character.isDigit(strArr[i])){
          int tempValue = 0;
          int j=i;
          String fullNumber ="";
          while(j<strArr.length && Character.isDigit(strArr[j])){
             fullNumber +=strArr[j];
             j++;
          }
          i=j;
          total += Integer.parseInt(fullNumber);
        }
      }
      return total;
    }

 public static void main(String []args){
        System.out.println(sumNumbers("1tj11tj"));
        System.out.println(sumNumbers("1tesj"));
        System.out.println(sumNumbers("1te@%%$*@%^*#@%^321&^(*^@&*32"));
        System.out.println(sumNumbers("1"));
        System.out.println(sumNumbers(""));
     }
