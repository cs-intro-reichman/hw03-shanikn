/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        // Replace the following statement with your code
        String answer=new String();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==(char)32)//32 is space
            {
                answer+=s.charAt(i);
            }
            else
            {
                if(answer.indexOf(s.charAt(i))==-1)
                {
                    answer+=s.charAt(i);
                }
            }
        }
        
        return answer;
    }
}
