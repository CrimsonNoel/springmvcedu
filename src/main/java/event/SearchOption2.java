package event;

import java.util.Collection;
import java.util.Date;

public class SearchOption2 {
	
	private Collection<EventType> types;
	private boolean allType;
	private Date from;
	private Date to;
	public Collection<EventType> getTypes() {
		return types;
	}
	public void setTypes(Collection<EventType> types) {
		this.types = types;
	}
	public boolean isAllType() {
		return allType;
	}
	public void setAllType(boolean allType) {
		this.allType = allType;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	@Override
	public String toString() {
		return "SearchOption2 [types=" + types + ", allType=" + allType + ", from=" + from + ", to=" + to + "]";
	}
	
	
	
	

}
