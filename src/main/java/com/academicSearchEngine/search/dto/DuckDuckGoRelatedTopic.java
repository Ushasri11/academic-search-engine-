package com.academicSearchEngine.search.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DuckDuckGoRelatedTopic {

	@JsonProperty("FirstURL")
	private String FirstURL;

	@JsonProperty("Result")
	private String Result;

	@JsonProperty("Icon")
	private DuckDuckGoIcon Icon;

	@JsonProperty("Text")
	private String Text;

	@JsonProperty("Name")
	private String Name;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFirstURL() {
		return FirstURL;
	}

	public void setFirstURL(String firstURL) {
		FirstURL = firstURL;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public DuckDuckGoIcon getIcon() {
		return Icon;
	}

	public void setIcon(DuckDuckGoIcon icon) {
		Icon = icon;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}
	
	

}
