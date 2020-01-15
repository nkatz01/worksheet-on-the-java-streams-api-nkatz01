import java.lang.*; 
import java.util.*; 
import java.util.stream.*;

 
public class Dish {
  private final String name;
  private final boolean vegetarian;
  private final int calories;
  private final Type type;

  public Dish(String name, boolean vegetarian, int calories, Type type) {
    this.name = name;
    this.vegetarian = vegetarian;
    this.calories = calories;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public int getCalories() {
    return calories;
  }

  public Type getType() {
    return type;
  }

  public enum Type {MEAT, FISH, OTHER}

  @Override
  public String toString() {
    return name;
  }
  
  public static final List<Dish> menu =
          Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                  new Dish("beef", false, 700, Dish.Type.MEAT),
                  new Dish("chicken", false, 400, Dish.Type.MEAT),
                  new Dish("french fries", true, 530, Dish.Type.OTHER),
                  new Dish("rice", true, 350, Dish.Type.OTHER),
                  new Dish("season fruit", true, 120, Dish.Type.OTHER),
                  new Dish("pizza", true, 550, Dish.Type.OTHER),
                  new Dish("prawns", false, 400, Dish.Type.FISH),
                  new Dish("salmon", false, 450, Dish.Type.FISH));

				  public static void main(String[] args){
//1
	List<Dish> firstTwoDishes = IntStream.range(0, menu.size()).filter(i -> i == 0 || i == 1).mapToObj(i -> menu.get(i)).collect(Collectors.toList());
	 System.out.println(firstTwoDishes);
//2	
	 int noOfDishes = menu.stream().map(x -> 1).reduce(0, (x, y) -> x + y);			
	 System.out.println(noOfDishes);
//3
	Integer[] intArray = {1,7,3,4,8,2};
	Stream<Integer> IntStream = Arrays.stream(intArray);
	List<Integer>  listSquares = IntStream.map(x -> x * x).collect(Collectors.toList());
	 System.out.println(listSquares);
//4
	List<Integer> listA = Arrays.asList(1,2,3);
	List<Integer> listB = Arrays.asList(3,4);
	List<String> CP = new ArrayList<>();
	listA.forEach(a -> listB.forEach(b -> CP.add("(" + a +"," + b+")")));//https://stackoverflow.com/questions/32131987/how-can-i-make-cartesian-product-with-java-8-streams 
	 System.out.println(CP);
//5 	
	List<String> CondCP = new ArrayList<>();
	listA.forEach(a -> listB.forEach(b -> {if ((a+b)%3==0) CondCP.add("(" + a +"," + b+")");}));//https://stackoverflow.com/questions/32131987/how-can-i-make-cartesian-product-with-java-8-streams 
	 System.out.println(CondCP);
//6 & 7
	List<String> words = Arrays.asList("Hana", "man", "mona", "mike", "Barcelona", "bona", "strike","Hare", "ware", "frown", "vanac","Harrico", "warico", "we", "wo", "wac","q");
	 words.stream().forEach(s -> System.out.printf("  %s%n", s));
	 words.stream().forEach(s -> System.out.printf("%s%n", s));
	
	 
//8
	words.stream().map( s -> s + "!").forEach(s -> System.out.printf(" %s",s));
	System.out.println();
	words.stream().map(s -> s.replace("i", "eye")).forEach(s -> System.out.printf(" %s",s));
	System.out.println();
 	words.stream().map(String::toUpperCase).forEach(s -> System.out.printf(" %s",s));
//9
	System.out.println();
	words.stream().filter(s -> s.length() < 4).forEach(s -> System.out.printf(" %s",s));
	System.out.println();
	words.stream().filter(s -> s.contains("b")).forEach(s -> System.out.printf(" %s",s));
	System.out.println();
	words.stream().filter(s -> (s.length() % 2) == 0).forEach(s -> System.out.printf(" %s",s));
//10
	System.out.println();
	Optional<String> firstRes = words.stream().filter(s -> s.contains("e")).map(String::toUpperCase).filter(s -> s.length() < 4).findFirst();
	firstRes.ifPresent(System.out::println);
//10.2
 	System.out.println(words.stream().filter(s -> s.contains("q")).map(String::toUpperCase).filter(s -> s.length() < 4).findFirst().isPresent() ? words.stream().filter(s -> s.contains("q")).map(String::toUpperCase).filter(s -> s.length() < 4).findFirst().get() : "not found");
 	
	 
//11
	List<String> peekIntoLazyStream = words.stream().peek(e-> System.out.println("Original Element: " + e)).filter(s -> s.contains("a") && s.length() <= 4 ).peek(e -> System.out.println("Filtered As: " + e)).map(String::toUpperCase).peek(e -> System.out.println("mapped uppercases: " + e)).collect(Collectors.toList());
	 System.out.println(peekIntoLazyStream);
	 
//12
	System.out.println(orderedNumberList(50,5,15));
//13
	System.out.println(randomNumberList(5));
   
//14
	List<Integer> lst = Arrays.asList(1,2,3,4,5,6,7,8,9,10);  
	Integer sum = lst.stream().reduce(0,(s, i) -> s+i);
	 System.out.println(sum);

	sum = lst.stream().reduce(0, Integer::sum);
   System.out.println(sum);

   sum = lst.stream().mapToInt(Integer::intValue).sum();
   System.out.println(sum);
   
//15  
	sum = lst.parallelStream().mapToInt(Integer::intValue).sum();
   System.out.println(sum);   
   
//16
List<Double> dblList = Arrays.asList(0.01,789.5,1.23,3.21,-6.54,-4.56,1.93,7.57,3.33,8.71);   
	Double dblProds = dblList.stream().reduce(1.0,(s, i) -> s*i);;
   System.out.println(dblProds);
   
    dblProds = dblList.parallelStream().reduce(1.0,(s, i) -> s*i);
   System.out.println(dblProds);
   
    dblProds = dblList.parallelStream().reduce(1.0,(s, i) -> s*i);
   System.out.println(dblProds);
   
}
public static List<Integer> orderedNumberList(int from, int step, int limit) {//https://farenda.com/java/java-8-range-of-numbers/
    return IntStream.iterate(from, i -> i+step).limit(limit/step).boxed().collect(Collectors.toList());
}
public static List<Double>  randomNumberList(int limit) {//https://farenda.com/java/java-8-range-of-numbers/
 List<Double>  streamOfDbls = DoubleStream.generate(() -> { return (double)(Math.random() * 10000); }).limit(limit).boxed().collect(Collectors.toList());
return streamOfDbls;
}


				  
}