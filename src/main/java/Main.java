import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("test", null), new Person("test2", 30));
		final Person oldestPerson = people.stream().max(Comparator.comparingInt(person -> person.age != null ? person.age : 0)).get();
		System.out.println("The oldest person is " + oldestPerson);
	}
	
	static class Person {
		private final String name;
		private final Integer age;

		public Person(String name, Integer age) {
			this.name = name;
			this.age = age;
		}
		
		public String toString() {
			return String.format("Person(name=%s, age=%d)", this.name, this.age);
		}
	}
}


