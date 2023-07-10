package com.academicSearchEngine.search.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DuckDuckGoSaveDto {
	
	@JsonProperty("FirstURL")
	private String FirstURL;
	
	@JsonProperty("Text")
	private String Text;

	public String getFirstURL() {
		return FirstURL;
	}

	public void setFirstURL(String firstURL) {
		FirstURL = firstURL;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}
	
	

}
