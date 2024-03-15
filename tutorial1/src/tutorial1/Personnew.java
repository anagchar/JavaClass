package tutorial1;

class Personnew { 
	int age; 
	static Personnew nextOldestSibling;
	
	// Constructor to initialize the age and siblings list
    public Personnew(int age) {
        this.age = age;
        Personnew.nextOldestSibling = null;
    }
	
	static int countYoungerSiblings(Personnew person) { 
		int count = 0; 
		Personnew currentSibling = nextOldestSibling; 
		while (currentSibling != null) { 
			count++; 
			currentSibling = Personnew.nextOldestSibling; 
			} 
			return count; 
		} 
	public static void main(String[] args) {
        Personnew person1 = new Personnew(25);
        Personnew person2 = new Personnew(30);
        Personnew person3 = new Personnew(20);

        // Set nextOldestSibling relationships
        person1.nextOldestSibling = person3;
        person2.nextOldestSibling = person1;
        person3.nextOldestSibling = null;

        System.out.println(countYoungerSiblings(person1)); // Output: 0
    }
}
