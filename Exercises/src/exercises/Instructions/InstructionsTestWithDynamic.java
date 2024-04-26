package exercises.Instructions;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

sealed abstract class Instruction permits LoadConstant, Decrement, Multiply, JumpIfZero, Jump, Halt{
	abstract void execute(int[] registers, Machine machine); 
}

final class LoadConstant extends Instruction {
	int r, c;
	
	LoadConstant(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	@Override
	void execute(int[] registers, Machine machine) {
		registers[r] = c;
		machine.pc++;
	}
}

final class Decrement extends Instruction {
    int r;

    Decrement(int r) {
        this.r = r;
    }

    @Override
    void execute(int[] registers, Machine machine) {
        registers[r]--;
        machine.pc++;
    }
}

final class Multiply extends Instruction {
	int r1, r2;
	
	Multiply(int r1, int r2){
		this.r1 = r1;
		this.r2 = r2;
	}
	
	@Override
	void execute(int[] registers, Machine machine) {
		registers[r1] *= registers[r2];
		machine.pc++;
	}
}

final class JumpIfZero extends Instruction {
	int r, a;
	
	JumpIfZero(int r, int a){
		this.r = r;
		this.a = a;
	}
	
	@Override
	void execute(int[] registers, Machine machine) {
		if (registers[r] == 0) {
			machine.pc = a;
		} else {
			machine.pc++;
		}
	}
}

final class Jump extends Instruction {
	int a;
	
	Jump(int a){
		this.a = a;
	}
	
	@Override
	void execute(int[] registers, Machine machine) {
		machine.pc = a;
	}
}

final class Halt extends Instruction {
	@Override
	void execute(int[] registers, Machine machine) {
		machine.pc = -1;
	}
}

class Machine {
	int pc;
	int[] registers;
	
	void execute(int[] registers, Instruction[] instruction) {
		this.registers = registers.clone();
		this.pc = 0;
		while(0 <= this.pc) {
			instruction[pc].execute(this.registers, this);
		}
	}
}


class InstructionsTestWithDynamic {
	
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
       Machine machine = new Machine();
       machine.execute(registers, instructions);
//     System.out.println("Final PC: " + machine.pc);
//       System.out.println("Final Registers: " + Arrays.toString(machine.registers));
       return machine.registers[2];
    }

}
