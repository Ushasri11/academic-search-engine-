package com.academicSearchEngine.search.mysql.utils;

/**
 * The Enum SearchOperation.
 */
public enum SearchOperation {

  /** The equality. */
  EQUALITY,
  /** The negation. */
  NEGATION,
  /** The greater than. */
  GREATER_THAN,
  /** The less than. */
  LESS_THAN,
  /** The greater than or equals. */
  GREATER_THAN_EQUALS,
  DATE_GREATER_THAN_EQUALS,
  /** The less than or equals. */
  LESS_THAN_EQUAL,
  DATE_LESS_THAN_EQUAL,
  /** The like. */
  LIKE,
  /** The starts with. */
  STARTS_WITH,
  /** The ends with. */
  ENDS_WITH,
  /** The contains. */
  CONTAINS,
  /** The longin. */
  LONGIN,
  SHORTIN,
  /** The stringin. */
  STRINGIN,
  /** The integerin. */
  INTEGERIN,
  /** The not null. */
  NOT_NULL,
  JOIN_MULTI_INTEGER_LIST,
  JOIN_MULTI_NOT_INTEGER_LIST,
  JOIN_MULTI_STRING_LIST,
  JOIN_MULTI_STRING,
  JOIN_MULTI_INTEGER_LIST_IN,
  JOIN_MULTI_INTEGER_LIST_NOT_EQ,
  JOIN_MULTI_STRING_IN,
  JOIN_MULTI_STRING_NOT_IN,
  JOIN_MULTI_DATE_GREATER_THAN,
  JOIN_MULTI_DATE_LESS_THAN,
  STRING_NOT_IN,
  EQUALS_NULL,
  
  JOIN_MULTI_STRING_STARTS_WITH, 
  Starts_With_Long, BIGINTEGERIN, STARTS_ENDS_WITH_STRINGIN, LONG_CONTAINS;
	
}

