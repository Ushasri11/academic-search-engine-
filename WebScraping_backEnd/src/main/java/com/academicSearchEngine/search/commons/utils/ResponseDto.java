package com.academicSearchEngine.search.commons.utils;

import java.util.List;


public class ResponseDto {

 
  private String entityId;

  private List<String> errorMessage;

  private int rowNumber;

  public String getEntityId() {
    return entityId;
  }

  public void setEntityId(String entityId) {
    this.entityId = entityId;
  }

  public List<String> getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(List<String> errorMessage) {
    this.errorMessage = errorMessage;
  }

  public int getRowNumber() {
    return rowNumber;
  }

  public void setRowNumber(int rowNumber) {
    this.rowNumber = rowNumber;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "ResponseDto [entityId=" + entityId + ", errorMessage=" + errorMessage + ", rowNumber=" + rowNumber + "]";
  }

}
