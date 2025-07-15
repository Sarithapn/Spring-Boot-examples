import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


class leetcode {
	 public static void main(String[] args)
     {
		 leetcode s = new leetcode();
     	Scanner sc = new Scanner (System.in);
     	//System.out.println("enter string");
     	//String str = sc.next();
     	//System.out.println(s.longestPalindrome(str));
//     	System.out.println("enter int");
//     	int i = sc.nextInt();
//     	System.out.println(isPalindrome(i));
     	
//     	String[] arr = {"flow","flower","float","fly"};
//     	System.out.println("approach 1 "+longestCommonPrefix(arr));
//     	System.out.println("approach 2 "+longestCommonPrefix2(arr));

         String string = "({{[]}}()";
         System.out.println("isvalidstring   "+isValid(string));


     	
     }

    public static boolean isValid(String s) {
         boolean result  = true;
        List<Character> openingBraces = Arrays.asList('(','{','[');
        List<Character> closingBraces = Arrays.asList(')','}',']');
        char[] arr = new char[s.length()];
        int top = -1;

        for(char c :s.toCharArray())
        {
          if(openingBraces.contains(c))
          {
              top++;
              arr[top] = c;
          }
          else {

              if((c == ')' &&  arr[top] != '(') ||
                      (c == '}' &&  arr[top] != '{') ||
                      (c == ']' &&  arr[top] != '[')
              )              {
                  return false;
              }
              top--;

          }
        }

        if(top !=-1)
            result = false;

         return result;
    }
	 
	   public static String longestCommonPrefix(String[] strs) {

           //find min length string
           String minString = strs[0] ;
           int minlength = strs[0].length();

           for(int i =1; i<strs.length ;i++)
           {
               if(minlength > strs[i].length())
               {
                  minString = strs[i];
                  minlength = strs[i].length(); 
               }
           }
           System.out.println("minString :: "+minString);
          String prefix = "";
          boolean isCommon = true;
          //check for common prefix based on min length string
          for(int j=minlength-1;j>=0;j--)
          {       
           for(int k=0;k<strs.length;k++)
           {
        	   isCommon = true;
        	   String nextprefix = minString.substring(0,j+1);
        	   String sCompare = strs[k].substring(0,j+1);
               if(!minString.substring(0,j+1).equalsIgnoreCase(strs[k].substring(0,j+1)))
               {
               	isCommon = false;
               	break;
               }
           }
           if(isCommon)
           	{
        	   prefix = minString.substring(0,j+1);
           	return prefix;
           	}
          }
          return prefix;
      }
	   
	   static String longestCommonPrefix2(String[] arr){
		      
	        // Sort the array of strings
	        Arrays.sort(arr);

	        // Get the first and last strings after sorting
	        String first = arr[0];
	        String last = arr[arr.length - 1];
	        int minLength = Math.min(first.length(), 
	                                 	last.length());
	        
	        // Find the common prefix between the first 
	      	// and last strings
	      	int i = 0;
	        while (i < minLength && 
	               first.charAt(i) == last.charAt(i)) {
	            i++;
	        }

	        // Return the common prefix
	        return first.substring(0, i);
	    }
    public String longestPalindrome(String s) {
       List l = new ArrayList();
        for(int i =0;i<s.length(); i++)
        {
            //find palidroms for character position
        	l.addAll(findPalindromes(s.substring(i)));
        	
        }
      System.out.println(l);
      Optional<String> maxString = l.stream().max(Comparator.comparing(String::length));
        return maxString.get();
    }
        private List findPalindromes(String s)
        {
             int n = s.length();
             List<String> pl = new ArrayList();
            for(int j=n;j>0;j--)
            {
            	String s1 = s.substring(0, j);
                String rs =new StringBuilder(s1).reverse().toString();
                
                if(s1.equalsIgnoreCase(rs) && s1.length()!=1 )
                {
                	pl.add(s1.toString());
                }
            }
            //System.out.println(pl);
            return pl;
        }
        
    
            public static boolean isPalindrome(int x) {
            	boolean res = false;
            	int temp = x;
            	int rev =0;
            	while(temp>0)
            	{
            		rev = rev*10+(temp%10);
            		temp = temp/10;
            	}
            	System.out.println(rev);
            	if(rev == x)
            		res = true;
            	return res;
                 }
            
            
         
        
       
    }
   