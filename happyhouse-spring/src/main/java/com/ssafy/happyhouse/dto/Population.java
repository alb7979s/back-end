package com.ssafy.happyhouse.dto;

public class Population {
	private String gugun;
	private String dong;
	private String family; //세대수
	private String population; //인구수
	private String korean; 
	private String foreigner;
	private double family_population;
	private String over65;
	
	private double percentage_k;
	private double percentage_f;

	
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getKorean() {
		return korean;
	}
	public void setKorean(String korean) {
		this.korean = korean;
	}
	public String getForeigner() {
		return foreigner;
	}
	public void setForeigner(String foreigner) {
		this.foreigner = foreigner;
	}
	public double getFamily_population() {
		return family_population;
	}
	public void setFamily_population(double family_population) {
		this.family_population = family_population;
	}
	public String getOver65() {
		return over65;
	}
	public void setOver65(String over65) {
		this.over65 = over65;
	}
	
	
	
	public double getPercentage_k() {
		return percentage_k;
	}
	public void setPercentage_k(double percentage_k) {
		this.percentage_k = percentage_k;
	}
	public double getPercentage_f() {
		return percentage_f;
	}
	public void setPercentage_f(double percentage_f) {
		this.percentage_f = percentage_f;
	}
	@Override
	public String toString() {
		return "Population [gugun=" + gugun + ", dong=" + dong + ", family=" + family + ", population=" + population
				+ ", korean=" + korean + ", foreigner=" + foreigner + ", family_population=" + family_population
				+ ", over65=" + over65 + ", percentage_k=" + percentage_k + ", percentage_f=" + percentage_f + "]";
	}


	
	
}
