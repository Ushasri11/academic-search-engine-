package com.academicSearchEngine.search.mysql.pojo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import org.springframework.data.annotation.CreatedDate;

import com.academicSearchEngine.search.commons.utils.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class AbstractDomain.
 */
@MappedSuperclass
@JsonIgnoreProperties(value = {"createdOn"}, allowGetters = true, allowSetters = false)
public abstract class AbstractCreatedOn implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -3213961670407371349L;

  /** The created on. */
  @Column(name = "CreatedOn", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP",
      updatable = false)
  @CreatedDate
  @JsonFormat(shape = Shape.STRING, pattern = Constant.DATE_PATTEREN)
  private Date createdOn;

  /**
   * Pre persist.
   */
  @PrePersist
  public void prePersist() {
    Date now = new Date(Calendar.getInstance().getTimeInMillis());
    createdOn = now;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  @Override
  public String toString() {
    return "AbstractCreatedOn [createdOn=" + createdOn + "]";
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
    result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
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
    AbstractCreatedOn other = (AbstractCreatedOn) obj;
    if (createdOn == null) {
      if (other.createdOn != null)
        return false;
    } else if (!createdOn.equals(other.createdOn)) {
      return false;
    }
    return true;
  }

  /**
   * Copy entity from.
   *
   * @param source the source
   */
  public void copyEntityFrom(AbstractCreatedOn source) {
    this.createdOn = source.createdOn;
  }

}
