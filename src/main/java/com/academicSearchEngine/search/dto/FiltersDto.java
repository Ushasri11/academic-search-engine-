package com.academicSearchEngine.search.dto;

import java.io.Serializable;
import java.util.Date;

import com.academicSearchEngine.search.commons.utils.Constant;
import com.academicSearchEngine.search.mysql.enums.FilterKeys;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * The Class FiltersDto.
 */
public class FiltersDto implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -3323456459925167876L;

  /** The key. */
  private FilterKeys key;

  /** The value. */
  private String value;
  
//  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Boolean lessEqualDate;

  /** The date value. */
  @JsonFormat(shape = Shape.STRING, pattern = Constant.REQUEST_DATE_PATTEREN)
  private Date dateValue;

  @JsonFormat(shape = Shape.STRING,
      pattern = Constant.REQUEST_DATE_PATTEREN + " " + Constant.REQUEST_TIME_PATTEREN)
  private Date dateTimeValue;

  public FiltersDto() {
    super();
  }

  public FiltersDto(FilterKeys key, String value) {
    super();
    this.key = key;
    this.value = value;
  }

  public FiltersDto(FilterKeys key, String value, Date dateValue) {
    super();
    this.key = key;
    this.value = value;
    this.dateValue = dateValue;
  }

  public FilterKeys getKey() {
    return key;
  }

  public void setKey(FilterKeys key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Date getDateValue() {
    return dateValue;
  }

  public void setDateValue(Date dateValue) {
    this.dateValue = dateValue;
  }

  public Date getDateTimeValue() {
    return dateTimeValue;
  }

  public void setDateTimeValue(Date dateTimeValue) {
    this.dateTimeValue = dateTimeValue;
  }
  
  public Boolean getLessEqualDate() {
	return lessEqualDate;
}

public void setLessEqualDate(Boolean lessEqualDate) {
	this.lessEqualDate = lessEqualDate;
}

@Override
  public String toString() {
    return "FiltersDto [key=" + key + ", value=" + value + ", dateValue=" + dateValue
        + ", dateTimeValue=" + dateTimeValue + "]";
  }

}
