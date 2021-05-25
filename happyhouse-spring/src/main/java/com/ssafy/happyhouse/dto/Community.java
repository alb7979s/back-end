package com.ssafy.happyhouse.dto;

public class Community extends Board{
	private int like;

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}
	
	public String toString() {
		return super.toString("CommunityDto", Integer.toString(like));
	}
}
