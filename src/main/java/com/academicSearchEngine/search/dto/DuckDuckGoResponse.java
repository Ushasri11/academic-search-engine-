package com.academicSearchEngine.search.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DuckDuckGoResponse {
	
	@JsonProperty("Abstract")
	private String Abstract;
	
	@JsonProperty("AbstractSource")
	private String AbstractSource;
	
	@JsonProperty("AbstractText")
	private String AbstractText;
	
	private String AbstractURL;
	
	private String Answer;
	
	private String AnswerType;
	
	private String Definition;
	
	private String DefinitionSurce;
	
	private String DefinitionURL;
	
	private String Entity;
	
	private String Heading;
	
	private String Image;
	
	private Integer ImageHeight;
	
	private Integer ImageIsLogo;
	
	private Integer ImageWidth;
	
	private String Infobox;
	
	private String Redirect;
	
	private String Type;
	
	@JsonProperty("RelatedTopics")
	private List<DuckDuckGoRelatedTopic> RelatedTopics;

	public String getAbstract() {
		return Abstract;
	}

	public void setAbstract(String abstract1) {
		Abstract = abstract1;
	}

	public String getAbstractSource() {
		return AbstractSource;
	}

	public void setAbstractSource(String abstractSource) {
		AbstractSource = abstractSource;
	}

	public String getAbstractText() {
		return AbstractText;
	}

	public void setAbstractText(String abstractText) {
		AbstractText = abstractText;
	}

	public String getAbstractURL() {
		return AbstractURL;
	}

	public void setAbstractURL(String abstractURL) {
		AbstractURL = abstractURL;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public String getAnswerType() {
		return AnswerType;
	}

	public void setAnswerType(String answerType) {
		AnswerType = answerType;
	}

	public String getDefinition() {
		return Definition;
	}

	public void setDefinition(String definition) {
		Definition = definition;
	}

	public String getDefinitionSurce() {
		return DefinitionSurce;
	}

	public void setDefinitionSurce(String definitionSurce) {
		DefinitionSurce = definitionSurce;
	}

	public String getDefinitionURL() {
		return DefinitionURL;
	}

	public void setDefinitionURL(String definitionURL) {
		DefinitionURL = definitionURL;
	}

	public String getEntity() {
		return Entity;
	}

	public void setEntity(String entity) {
		Entity = entity;
	}

	public String getHeading() {
		return Heading;
	}

	public void setHeading(String heading) {
		Heading = heading;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public Integer getImageHeight() {
		return ImageHeight;
	}

	public void setImageHeight(Integer imageHeight) {
		ImageHeight = imageHeight;
	}

	public Integer getImageIsLogo() {
		return ImageIsLogo;
	}

	public void setImageIsLogo(Integer imageIsLogo) {
		ImageIsLogo = imageIsLogo;
	}

	public Integer getImageWidth() {
		return ImageWidth;
	}

	public void setImageWidth(Integer imageWidth) {
		ImageWidth = imageWidth;
	}

	public String getInfobox() {
		return Infobox;
	}

	public void setInfobox(String infobox) {
		Infobox = infobox;
	}

	public String getRedirect() {
		return Redirect;
	}

	public void setRedirect(String redirect) {
		Redirect = redirect;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public List<DuckDuckGoRelatedTopic> getRelatedTopics() {
		return RelatedTopics;
	}

	public void setRelatedTopics(List<DuckDuckGoRelatedTopic> relatedTopics) {
		RelatedTopics = relatedTopics;
	} 
	
	
	
}
