package member;

public class OrderInfo {
	private Long id;
	private int totalPrice;
	private String memberId;
	
	
	
	public OrderInfo(Long id, int totalPrice, String memberId) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.memberId = memberId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	
}
