package interpreter;

abstract class Value {}

class IntValue extends Value {
	int value;

	IntValue(int value) {
		this.value = value;
	}
}

class StringValue extends Value {
	String value;

	StringValue(String value) {
		this.value = value;
	}
}

class BooleanValue extends Value {
	boolean value;

	BooleanValue(boolean value) {
		this.value = value;
	}
}

public class Interpreter {
	Value evaluate(Value value1, char operator, Value value2) {
		return switch (operator) {
		case '+' -> {
			yield switch (value1) {
			case IntValue i -> new IntValue(i.value + ((IntValue) value2).value); 
			case StringValue s -> new StringValue(s.value + ((StringValue) value2).value);
			default -> throw new RuntimeException("Invalid operation");
            };}
		case '-' -> {
			yield switch (value1) {
			case BooleanValue b -> new BooleanValue(b.value && ((BooleanValue) value2).value);
			case IntValue i -> new IntValue(i.value - ((IntValue) value2).value);
			default -> throw new RuntimeException("Invalid operation");
            };}
       default -> throw new RuntimeException("Invalid operator");
			}
		}

}
