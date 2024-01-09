/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String s) {
        // Replace the following statement with your code
        String answer=new String();
        for(int i=0;i<s.length();i++)
        {

            if((s.charAt(i)<(char)65) || (s.charAt(i)>(char)90)) //uppercase characters are between 65 and 90
            {
                answer+=s.charAt(i);
            }
            else
            {
                if(((char)65<=s.charAt(i)) && ((char)90>=s.charAt(i)))
                {
                    answer+=(char)(s.charAt(i)+32);
                }
            }

        }
        return answer;
    }
}
