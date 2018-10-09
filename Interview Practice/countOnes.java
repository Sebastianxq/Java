 public int count(String s)
    {
    //Essentially temp and current values, holds the current KOTH and then potential next highest number
    int currMax = 0;
    int curr = 0;
    
    //Iterates through string and determines length of consecutive 1s
    for (int i=0; i<s.length(); i++){
        if (s.charAt(i) == '1'){
            curr = 1;
            for (int j=i+1; j<s.length(); j++){
                if (s.charAt(j) == '1'){
                    curr++;
                }
                if (s.charAt(j) == '0'){
                    break;
                }
            }
            //If the last iteration of 1s is greater than the previous then swap
            if (curr>currMax)
              currMax = curr;
        }
    }
    return currMax;
 }
