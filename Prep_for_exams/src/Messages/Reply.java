package Messages;

import java.util.List;

public class Reply extends Message {

	final Message parent;

	Reply(String Author, Message parent) {
		super(Author);
		this.parent = parent;
		parent.replies.add(this);
	}
	
	public Message getParent() {
		return this.parent;
	}
	
	@Override
	public void delete() {
		super.delete();
		parent.replies.remove(this);
	}
	
	@Override
	public boolean Isomorphic(Message other) {
		return super.Isomorphic(other) && other instanceof Reply && parent.Isomorphic(((Reply)other).parent);
	}

}
