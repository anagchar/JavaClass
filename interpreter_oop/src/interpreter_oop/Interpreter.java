package interpreter_oop;

import java.lang.*;

abstract class Value {}

abstract class AddableValue extends Value {
	abstract Value add(Value other);
}

class IntValue extends AddableValue {
	int value;

	IntValue(int value) {
		this.value = value;
	}
	@Override
	Value add(Value other) {
       return new IntValue(this.value + ((IntValue) other).value);
    }
}

class StringValue extends AddableValue {
	String value;

	StringValue(String value) {
		this.value = value;
	}
	@Override
	Value add(Value other) {
		return new StringValue(this.value + ((StringValue) other).value);
	}
}

class FloatValue extends AddableValue {
	float value;

	FloatValue(float value) {
		this.value = value;
	}

	@Override
	Value add(Value other) {
		return new FloatValue(this.value + ((FloatValue) other).value);
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
			yield ((AddableValue)value1).add(value2);
        }
        case '&' -> {
        	yield switch (value1) {
            case BooleanValue b -> new BooleanValue(b.value && ((BooleanValue) value2).value);
            case IntValue i -> new BooleanValue(i.value != 0 && ((IntValue) value2).value != 0);
            default -> throw new RuntimeException("Bad values");
            };
        }
        default -> throw new RuntimeException("Bad operator");
        };
           
}
}
