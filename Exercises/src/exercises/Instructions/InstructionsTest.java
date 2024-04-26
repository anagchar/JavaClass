package exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

sealed abstract class Instruction permits LoadConstant, Decrement, Multiply, JumpIfZero, Jump, Halt{
}

final class LoadConstant extends Instruction {
	int r, c;

	LoadConstant(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

final class Decrement extends Instruction{
	int r;

	Decrement(int r) {
		this.r = r;
	}
}

final class Multiply extends Instruction{
	int r1, r2;

	Multiply(int r1, int r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
}

final class JumpIfZero extends Instruction{
	int r, a;

	JumpIfZero(int r, int a) {
		this.r = r;
		this.a = a;
	}
}

final class Jump extends Instruction{
	int a;

	Jump(int a) {
		this.a = a;
	}
}

final class Halt extends Instruction{
}

class Machine {
	void execute(int[] registers, Instruction[] instructions) {
		int pc = 0;
		while (0 <= pc) {
			Instruction i = instructions[pc];
			if (i instanceof LoadConstant lc) { // alternative is to use type cast but this is the newer way
				registers[lc.r] = lc.c;
				pc++;
				} else if (i instanceof Decrement d) {
					registers[d.r]--;
                    pc++;
                } else if (i instanceof Multiply m) {
                    registers[m.r1] *= registers[m.r2];
                    pc++;
				} else if (i instanceof JumpIfZero j) {
					if (registers[j.r] == 0) {
						pc = j.a;
					} else {
						pc++;
					}
				} else if (i instanceof Jump j) {
					pc = j.a;
				} else if (i instanceof Halt h) {
					pc = -1;
			}
		}
	}
}

class InstructionsTest {

	@Test
	void test() {
		assertEquals(8, power(2, 3));
		assertEquals(9, power(3,2));
	}
	
	int power(int x, int y) {
       Instruction[] instructions = {
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
