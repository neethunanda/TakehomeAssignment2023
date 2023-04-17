package com.assignment.assignment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


	
	
	@Entity
	@Table(name = "csv_data")
	public class CsvData {
		
		@Id
		private String code;
		private String source;
		private String codeListCode;
		private String displayValue;
		private String longDescription;
		private String fromDate;
		private String toDate;
		private String sortingPriority;
		
		public CsvData() {
			// Empty constructor needed by JPA
		}
		
		public CsvData(String code, String source, String codeListCode, String displayValue,
				String longDescription, String fromDate, String toDate, String sortingPriority) {
			this.code = code;
			this.source = source;
			this.codeListCode = codeListCode;
			this.displayValue = displayValue;
			this.longDescription = longDescription;
			this.fromDate = fromDate;
			this.toDate = toDate;
			this.sortingPriority = sortingPriority;
		}
		
		// Getters and setters for all variables
		
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getCodeListCode() {
			return codeListCode;
		}

		public void setCodeListCode(String codeListCode) {
			this.codeListCode = codeListCode;
		}

		public String getDisplayValue() {
			return displayValue;
		}

		public void setDisplayValue(String displayValue) {
			this.displayValue = displayValue;
		}

		public String getLongDescription() {
			return longDescription;
		}

		public void setLongDescription(String longDescription) {
			this.longDescription = longDescription;
		}

		public String getFromDate() {
			return fromDate;
		}

		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;
		}

		public String getToDate() {
			return toDate;
		}

		public void setToDate(String toDate) {
			this.toDate = toDate;
		}

		public String getSortingPriority() {
			return sortingPriority;
		}

		public void setSortingPriority(String sortingPriority) {
			this.sortingPriority = sortingPriority;
		}
		
		@Override
		public String toString() {
			return "CsvData [code=" + code + ", source=" + source + ", codeListCode=" + codeListCode
					+ ", displayValue=" + displayValue + ", longDescription=" + longDescription + ", fromDate=" + fromDate
					+ ", toDate=" + toDate + ", sortingPriority=" + sortingPriority + "]";
		}
	}





