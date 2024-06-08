package Messages;

import java.util.List;

public abstract class Message {
	
	final String author;
	
	List<Message> replies;
	
	boolean isDeleted;
	
	public String getAuthor() {
		return this.author;
	}
	
	public List<Message> getReplies() {
		return List.copyOf(replies);		
	}
	
	public boolean isDeleted() { return isDeleted; }
	
	Message(String Author){
		if (Author == null) {
			throw new IllegalArgumentException("The Author cannot be null!");
		}
		this.author = Author;
	}
	
	public void delete() {
		isDeleted = true;
	}
	
	public boolean Isomorphic(Message other) {
		return this.equals(other) && isDeleted == other.isDeleted;
	}

}
