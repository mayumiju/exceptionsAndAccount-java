package model.exceptions;

public class WithdrawLimit extends Exception{
	private static final long serialVersionUID = 1L;

	public WithdrawLimit(String msg) {
		super(msg);
	}
}
