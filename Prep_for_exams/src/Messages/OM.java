package Messages;

import java.util.List;

public class OM extends Message {
	
	OM(String Author) {
		super(Author);
	}

	@Override
	public void delete() {
		super.delete();		
	}
	
	@Override
	public boolean Isomorphic(Message other) {
		return super.Isomorphic(other) && other instanceof OM;
	}
}
