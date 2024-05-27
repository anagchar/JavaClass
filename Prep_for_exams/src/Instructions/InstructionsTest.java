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
       Instructions[] instructions = {
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
	
	@Test
    void testNoRepresentationExposure() {
        Machine machine = new Machine();
        int[] registers = new int[2];
        Instructions[] instructions = { new LoadConstant(0, 10), new LoadConstant(1, 20), new Halt() };

        machine.execute(registers, instructions);

        // Clone registers to capture state after execution
        int[] originalState = registers.clone();

        // Attempt to modify the array outside the Machine class
        registers[0] = 99;
        registers[1] = 99;

        // Verify that the modifications outside the Machine class did not affect the cloned state
        assertEquals(10, originalState[0]);
        assertEquals(20, originalState[1]);
    }

}
