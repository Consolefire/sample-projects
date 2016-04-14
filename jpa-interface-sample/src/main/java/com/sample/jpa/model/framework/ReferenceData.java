package com.sample.jpa.model.framework;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by sabuj.das on 04/02/16.
 */
@Getter
@Setter
@NoArgsConstructor
public class ReferenceData<K extends Serializable, T> {

  /**
   * This defines from which source the data to be provided
   */
  private ReferenceSourceType referenceSourceType;

  /**
   * The key of the reference data
   */
  private K referenceKey;

  /**
   * The type of the reference data in the referred source
   */
  private T referenceType;

  public ReferenceData(ReferenceSourceType referenceSourceType, K referenceKey, T referenceType) {
    this.referenceSourceType = referenceSourceType;
    this.referenceKey = referenceKey;
    this.referenceType = referenceType;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((referenceKey == null) ? 0 : referenceKey.hashCode());
    result = prime * result + ((referenceSourceType == null) ? 0 : referenceSourceType.hashCode());
    result = prime * result + ((referenceType == null) ? 0 : referenceType.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof ReferenceData)) {
      return false;
    }
    ReferenceData other = (ReferenceData) obj;
    if (referenceKey == null) {
      if (other.referenceKey != null) {
        return false;
      }
    } else if (!referenceKey.equals(other.referenceKey)) {
      return false;
    }
    if (referenceSourceType != other.referenceSourceType) {
      return false;
    }
    if (referenceType == null) {
      if (other.referenceType != null) {
        return false;
      }
    } else if (!referenceType.equals(other.referenceType)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ReferenceData [");
    if (referenceSourceType != null)
      builder.append("referenceSourceType=").append(referenceSourceType).append(", ");
    if (referenceKey != null)
      builder.append("referenceKey=").append(referenceKey).append(", ");
    if (referenceType != null)
      builder.append("referenceType=").append(referenceType);
    builder.append("]");
    return builder.toString();
  }



}
