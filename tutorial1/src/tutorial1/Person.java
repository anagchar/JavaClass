package tutorial1;

public class Person {
	int age;
	Person nextOldestSibling;
	
	//Constructor to initialize the age and the nextOldestSibling
	public Person(int age) {
		this.age = age;
		this.nextOldestSibling = null;
	}
	
	int countYoungerSiblings() {
		int count = 0;
		Person currentSibling = nextOldestSibling;
		while (currentSibling != null) {
			count++;
			currentSibling = currentSibling.nextOldestSibling;
		}
		return count;
	}
	
	int countYoungerSiblingRecur() {
		if (nextOldestSibling == null) {
			return 0;
		}
		else {
			return 1 + nextOldestSibling.countYoungerSiblingRecur();
		}
	}
	
	int countAdults() {
	    int count = 0;
	    Person currentSibling = this;
	    while (currentSibling != null) {
	        if (age >= 18) {
	            count++;
	        }
	        currentSibling = currentSibling.nextOldestSibling;
	    }
	    return count;
	}

	
	int countAdultsRecur() {
	    if (age >= 18) {
	        if (nextOldestSibling == null) {
	            return 1;
	        } else {
	            return 1 + nextOldestSibling.countAdultsRecur();
	        }
	    } else {
	        if (nextOldestSibling == null) {
	            return 0;
	        } else {
	            return nextOldestSibling.countAdultsRecur();
	        }
	    }
	}
	
	void increment(Person person) {
		person.age += 1;
		Person next = person.nextOldestSibling;
		while(next != null){
			next.age += 1;
			next = next.nextOldestSibling;
		}
	}


	Person increments(Person person){
			if (person.nextOldestSibling == null){
				person.age++;
				return person.nextOldestSibling; 
		}
			person.age++;
			return increments(person.nextOldestSibling);
		}
	
	Person updates(Person p){
		if (p.nextOldestSibling == null){
			Person newSib = new Person();
			newSib.age = 0;
			p.nextOldestSibling = newSib;
			return p;
	}
		return updates(p.nextOldestSibling);
	}
	
	Person updatesRecur(Person p){
		Person next = p.nextOldestSibling;
		while(next != null){
			if (next.nextOldestSibling == null){
				Person newSib = new Person();
				newSib.age = 0;
				next.nextOldestSibling = newSib;
				return p; 
		}
			next = next.nextOldestSibling;
		}
		}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person(20);
		Person person2  = new Person(22);
		Person person3 = new Person(19);
		
		person1.nextOldestSibling = person3;
		person2.nextOldestSibling = person1;
		person3.nextOldestSibling = null;
		
		int countperson1 = person1.countYoungerSiblingRecur();
		int countperson3 = person3.countYoungerSiblingRecur();
		int countAdults1 = person1.countAdults();
		int countAdults2 = person2.countAdultsRecur();
		System.out.println("The count for person1 is: " + countperson1 + " and they are "+ countAdults1 + " and the count for person3 is: " + countperson3);
	}

}
