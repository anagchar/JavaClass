package interpreter_oop;

interface Value {}

interface AddableValue extends Value {
	abstract Value add(Value other);
}

interface AndableValue extends Value {
	abstract Value and(Value other);
}

class IntValue implements AddableValue, AndableValue {
	int value;

	IntValue(int value) {
		this.value = value;
	}
	@Override
	public Value add(Value other) {
       return new IntValue(this.value + ((IntValue) other).value);
    }
	@Override
	public Value and(Value other) {
		return new IntValue(this.value & ((IntValue) other).value);
	}
}

class StringValue implements AddableValue {
	String value;

	StringValue(String value) {
		this.value = value;
	}
	@Override
	public Value add(Value other) {
		return new StringValue(this.value + ((StringValue) other).value);
	}
}

class FloatValue implements AddableValue {
	float value;

	FloatValue(float value) {
		this.value = value;
	}

	@Override
	public Value add(Value other) {
		return new FloatValue(this.value + ((FloatValue) other).value);
	}
}

class BooleanValue implements AndableValue {
	boolean value;

	BooleanValue(boolean value) {
		this.value = value;
	}
	
	@Override
	public Value and(Value other) {
		return new BooleanValue(this.value && ((BooleanValue) other).value);
	}
}

public class Interpreter {
	
	Value evaluate(Value value1, char operator, Value value2) {
		return switch (operator) {
		case '+' -> {
			yield ((AddableValue)value1).add(value2);
        }
        case '&' -> {
        	yield ((AndableValue)value1).and(value2);
        }
        default -> throw new RuntimeException("Bad operator");
        };
           
}
}
