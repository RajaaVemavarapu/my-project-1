package com.medicalstore.dto;

public class StockDto {
   
	  public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		

		public double getPurchasePrice() {
			return purchasePrice;
		}

		public void setPurchasePrice(double purchasePrice) {
			this.purchasePrice = purchasePrice;
		}

		public String getPurchaseDate() {
			return purchaseDate;
		}

		public void setPurchaseDate(String purchaseDate) {
			this.purchaseDate = purchaseDate;
		}

		public int getReorderLevel() {
			return reorderLevel;
		}

		public void setReorderLevel(int reorderLevel) {
			this.reorderLevel = reorderLevel;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		private Long id;

	  


	    private double purchasePrice;

	    private String purchaseDate;

	   
	    private int reorderLevel;

	    private String location;
}
