package _01_member.model;

import java.util.List;

public class MessageReturn {
	int result;
	List<InnerMsg> msgs;
	
	
	public MessageReturn() {
	}


	public MessageReturn(int result, List<InnerMsg> msgs) {
		this.result = result;
		this.msgs = msgs;
	}
	
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public List<InnerMsg> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<InnerMsg> msgs) {
		this.msgs = msgs;
	}
	
	
	
}
