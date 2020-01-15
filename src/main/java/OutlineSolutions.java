import java.lang.*; 
import java.io.*; 
import java.util.*; 
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class OutlineSolutions<T> {
  public static void main(String... args) { // varargs alternative to String[]
String[] stringArray = {"Rosh Hashanah", "Yom Kipur", "Succot", "Chanukah", "Purim", "Easter", "Shavout", "Epiphany"};
  
  
//1.1 	length (i.e., shortest to longest)

   //Arrays.sort(stringArray,  (Comparator.comparing(s -> s.length())));  

//1.2 	reverse length (i.e., longest to shortest)
	/* Arrays.sort(stringArray, (String s1, String s2) -> {
      int c = s2.length() - s1.length();
      if (c == 0)
        c = s2.compareToIgnoreCase(s1);
      return c;
    }); */
	
	
	//1.3  first char		
	//Arrays.sort(stringArray, (String s1, String s2) -> s1.compareTo(s2));
	
	
//1.4 
	/* Arrays.sort(stringArray, (String s1, String s2) -> {
	String searchLetter = "e";
	Pattern pattern = Pattern.compile(searchLetter, Pattern.CASE_INSENSITIVE);
	Matcher matcher1 = pattern.matcher(s1);
	Matcher matcher2 = pattern.matcher(s2);
	
	if ( matcher1.find() && !matcher2.find() )
		return -1;
	else if (!matcher1.find() &&  matcher2.find())
		return 	1;	
	else 
	   return 0;
	});  */
	
	
//2 	(*uncomment class StringUtils)
	// Arrays.sort(stringArray, (String s1, String s2) ->  StringUtils.eChecker(s1, s2));
	
//prints out sorted array for all prolems so far (that is, for one problem at a time).	
	//System.out.println(Arrays.asList(stringArray));

/*	
//3		(*method betterString inside StringUtils and interface TwoStringPredicate are associated with this solution)
	String test1 = "nuchem";
	String test2 = "menachem";
	System.out.println(StringUtils.betterString(test1, test2, (s1,  s2) -> s1.length() > s2.length()));
	System.out.println(StringUtils.betterString(test1, test2, (s1, s2) -> true));
	System.out.println(StringUtils.betterString(test1, test2, (s1, s2) -> s1.contains("a") && !s1.contains("a")));

//4

	System.out.println(StringUtils.betterEntry(test1, test2,  (  s1,   s2) -> s1.length() > s2.length()));
	 System.out.println(StringUtils.betterEntry(test1, test2, (s1, s2) -> true));
	  System.out.println(StringUtils.betterEntry(test1, test2, (s1, s2) -> s1.contains("a") && !s1.contains("a")));
	  Integer testA = 1;
	  Integer testB = 2;
 	  System.out.println(StringUtils.betterEntry(testA, testB, (s1, s2) -> s1 > s1 ));
 
  
//5
	List<String> words =  new ArrayList<String>(Arrays.asList("Hana", "man", "mona", "mike", "Barcelona", "bona", "strike"));
	List<String> shortWords =	StringUtils.allMatches(words, s -> s.length() <=4); 
	List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
	List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2) == 0);

	System.out.println( Arrays.toString(shortWords.toArray()));
	System.out.println( Arrays.toString(wordsWithB.toArray()));
	System.out.println( Arrays.toString(evenLengthWords.toArray()));
	// shortWords.forEach((l) -> System.out.println(l) );
*/
//6	
		List<String> words1 =  new ArrayList<String>(Arrays.asList("Hana", "man", "mona", "mike", "Barcelona", "bona", "strike"));
	List<String> shortWords1 =	StringUtils.genAllMatches(words1, s -> s.length() <=4); 
	System.out.println( Arrays.toString(shortWords1.toArray()));
	
 	List<Integer> numbers =  new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
	List<Integer> largerThanFour =	StringUtils.genAllMatches(numbers, v -> v.compareTo(4) >0); 
	List<Integer> evenNumbers =	StringUtils.genAllMatches(numbers, v -> (v % 2) == 0); 
	List<Integer> randomCond =	StringUtils.genAllMatches(numbers, v -> ((v * v)/2) > numbers.size()); 
	System.out.println( Arrays.toString(largerThanFour.toArray()));
	System.out.println( Arrays.toString(evenNumbers.toArray()));
	System.out.println( Arrays.toString(randomCond.toArray()));
//7 use java's filter(Predicate) and Streams
	shortWords1 =	StringUtils.FilterUseOnGenPredicate(words1, s -> s.length() <=4); 
	System.out.println(shortWords1);
	largerThanFour =	StringUtils.FilterUseOnGenPredicate(numbers, v -> v.compareTo(4) >0); 
	System.out.println(largerThanFour);
/*
	//7
	List<String> words2 =  new ArrayList<String>(Arrays.asList("Hana", "man", "mona", "mike", "Barcelona", "bona", "strike"));
	List<String> excitingWords = StringUtils.transformedList(words2, s -> s + "!");
	List<String> eyeWords = StringUtils.transformedList(words2, s -> s.replace("i", "eye"));
	List<String> upperCaseWords = StringUtils.transformedList(words2, String::toUpperCase);
	System.out.println( Arrays.toString(excitingWords.toArray()));
	System.out.println( Arrays.toString(eyeWords.toArray()));
	System.out.println( Arrays.toString(upperCaseWords.toArray()));//asList
 
//8

  	List<Integer> numbers1 =  new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
	List<Integer> numbersSquared =	StringUtils.genTransformedList(numbers1, v -> (v * v)); 
	System.out.println(numbersSquared);
	List<String> words3 =  new ArrayList<String>(Arrays.asList("Hana", "man", "mona", "mike", "Barcelona", "bona", "strike"));
	List<String> excitingWords1 = StringUtils.genTransformedList(words3, s -> s + "!");
	System.out.println(excitingWords1);
*/ 
  }
  
    static class StringUtils{
		
			static List<String> transformedList(List<String> ls, Function<String,String> fn ){
			List<String> processedList = ls.stream().map(x -> fn.apply(x)).collect(Collectors.toList());
				return processedList;
			}

			static <T> List<T> genTransformedList(List<T> ls, Function<T,T> fn ){
			List<T> processedList = ls.stream().map(x -> fn.apply(x)).collect(Collectors.toList());
				return processedList;
			}
			
			static <T> List<T> FilterUseOnGenPredicate(List<T> ls, Predicate<T> pred){
			List<T> filteredVals = ls.stream().filter(v-> pred.test(v)).collect(Collectors.toList());

				return filteredVals;	 
			} 
				
			static <T> List<T> genAllMatches(List<T> ls, GenPredicate<T> pred){
			List<T> filteredVals = new ArrayList<T>();
			ls.forEach((v) -> {
			if (pred.returnTifPasses(v)) 
				filteredVals.add(v);
			});
				return filteredVals;	 
			} 
		
			static List<String> allMatches(List<String> ls, myPredicate<String> pred){
			List<String> filteredWords = new ArrayList<String>();
			ls.forEach((s) -> {
				if (pred.returnTifPasses(s)) 
					filteredWords.add(s);
				});
					return filteredWords;	 
				} 
		  
			static int  eChecker(String s1, String s2){
			{

			String searchLetter = "e";
			Pattern pattern = Pattern.compile(searchLetter, Pattern.CASE_INSENSITIVE);
			Matcher matcher1 = pattern.matcher(s1);
			Matcher matcher2 = pattern.matcher(s2);

			if ( matcher1.find() && !matcher2.find() )
			return -1;
			else if (!matcher1.find() &&  matcher2.find())
			return 	1;	
			else  

			return 0;
		}
		} 
		
		 static String betterString(String s1, String s2, TwoStringPredicate boolLambda){
		  
		  if (boolLambda.returnTifBetter(s1, s2)) 
			return s1;  
		  else 
			 return s2;
		}
		
		static   <T> T betterEntry(  T s1,  T s2, TwoElementPredicate<T> boolLambda){
	  
   if (boolLambda.returnTifBetter(s1, s2))
	   return s1;
   else
	   return s2;
 	  
  }
		
	} 
	
	interface TwoStringPredicate{
		boolean returnTifBetter(String s1, String s2);
	}


	public  interface TwoElementPredicate<T>{
		boolean returnTifBetter(T s1, T s2);
	}

	interface myPredicate<String>{
		boolean returnTifPasses(String s);
	}
  
   interface  GenPredicate<T>{
	  boolean returnTifPasses(T v);
	}
  
  
}



