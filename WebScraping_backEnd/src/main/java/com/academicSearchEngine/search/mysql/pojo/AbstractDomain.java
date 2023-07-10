package com.academicSearchEngine.search.mysql.pojo;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import org.springframework.data.annotation.LastModifiedDate;

import com.academicSearchEngine.search.commons.utils.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class AbstractDomain.
 */
@MappedSuperclass
@JsonIgnoreProperties(value = {"createdOn", "updatedOn"}, allowGetters = true, allowSetters = false)
public abstract class AbstractDomain extends AbstractCreatedOn {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -3213961670407371349L;

  /** The updated on. */
  @Column(name = "UpdatedOn",
      columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
  @LastModifiedDate
  @JsonFormat(shape = Shape.STRING, pattern = Constant.DATE_PATTEREN)
  private Date updatedOn;

  /**
   * Pre update.
   */
  @PreUpdate
  public void preUpdate() {
    updatedOn = new Date(Calendar.getInstance().getTimeInMillis());
  }

  public Date getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(Date updatedOn) {
    this.updatedOn = updatedOn;
  }

  @Override
  public String toString() {
    return "AbstractDomain [createdOn=" + getCreatedOn() + ", updatedOn=" + updatedOn + "]";
  }

  /**
   * Hash code.
   *
   * @return the int
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getCreatedOn() == null) ? 0 : getCreatedOn().hashCode());
    result = prime * result + ((updatedOn == null) ? 0 : updatedOn.hashCode());
    return result;
  }

  /**
   * Equals.
   *
   * @param obj the obj
   * @return true, if successful
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AbstractDomain other = (AbstractDomain) obj;
    if (getCreatedOn() == null) {
      if (other.getCreatedOn() != null)
        return false;
    } else if (!getCreatedOn().equals(other.getCreatedOn())) {
      return false;
    }
    if (updatedOn == null) {
      if (other.updatedOn != null)
        return false;
    } else if (!updatedOn.equals(other.updatedOn)) {
      return false;
    }
    return true;
  }

  /**
   * Copy entity from.
   *
   * @param source the source
   */
  public void copyEntityFrom(AbstractDomain source) {
    setCreatedOn(source.getCreatedOn());
    this.updatedOn = source.updatedOn;
  }

}
