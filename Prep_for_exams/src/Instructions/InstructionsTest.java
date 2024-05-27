package Instructions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InstructionsTest {

	@Test
	void test() {
		assertEquals(8, power(2, 3));
		assertEquals(9, power(3,2));
	}
	
	int power(int x, int y) {
       InstructionsWithDynamicBinding[] instructions = {
        		new LoadConstant(2, 1),
        		new JumpIfZero(1, 5),
        		new Decrement(1),
        		new Multiply(2, 0),
        		new Jump(1),
        		new Halt()
        		
        };
       int[] registers = {x, y, 0};
       new Machine().execute(registers, instructions);
       return registers[2];
    }

}
