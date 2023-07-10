package com.academicSearchEngine.search.mysql.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;


public class QuerySearchCriteria<T> implements Specification<T> {

	 private static final long serialVersionUID = -7918496306157839185L;

	 private SearchCriteria criteria;

	 public QuerySearchCriteria(SearchCriteria searchCriteria) {
	this.criteria = searchCriteria;
	}

  @Override
  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

    switch (criteria.getOperation()) {
      case EQUALITY:
        return builder.equal(root.get(criteria.getKey()), criteria.getValue());
      case NEGATION:
        return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
      case GREATER_THAN_EQUALS:
        return builder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()),
            criteria.getValue().toString());
      case DATE_GREATER_THAN_EQUALS:
        return builder.greaterThanOrEqualTo(root.<Date>get(criteria.getKey()),
            (Date) criteria.getValue());
      case JOIN_MULTI_DATE_GREATER_THAN:
        Path<Date> datepath = root.get(criteria.getKey());
        if (!CollectionUtils.isEmpty(criteria.getMultiJoinKeys())) {
          for (String key : criteria.getMultiJoinKeys()) {
            datepath = datepath.get(key);
          }
        }
        return builder.greaterThanOrEqualTo(datepath, criteria.getDateOption());
      case JOIN_MULTI_DATE_LESS_THAN:
        Path<Date> datepathless = root.get(criteria.getKey());
        if (!CollectionUtils.isEmpty(criteria.getMultiJoinKeys())) {
          for (String key : criteria.getMultiJoinKeys()) {
            datepathless = datepathless.get(key);
          }
        }
       
        return builder.lessThanOrEqualTo(datepathless, criteria.getDateOption());
      case GREATER_THAN:
        return builder.greaterThan(root.<String>get(criteria.getKey()),
            criteria.getValue().toString());
      case LESS_THAN_EQUAL:
        return builder.lessThanOrEqualTo(root.<String>get(criteria.getKey()),
            criteria.getValue().toString());
      case DATE_LESS_THAN_EQUAL:
        return builder.lessThanOrEqualTo(root.<Date>get(criteria.getKey()),
            (Date) criteria.getValue());
      case LESS_THAN:
        return builder.lessThan(root.<String>get(criteria.getKey()),
            criteria.getValue().toString());
      case LIKE:
        return builder.like(root.<String>get(criteria.getKey()), criteria.getValue().toString());
      case STARTS_WITH:
        return builder.like(root.<String>get(criteria.getKey()), criteria.getValue() + "%");
      case ENDS_WITH:
        return builder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue());
      case CONTAINS:
        return builder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
      case NOT_NULL:
        return builder.isNotNull(root.<String>get(criteria.getKey()));
      case EQUALS_NULL:
    	  return builder.isNull(root.<String>get(criteria.getKey()));
  
  
      case LONGIN:
        String[] values = String.valueOf(criteria.getValue()).split(",");
       
        List<Long> searchValues = new ArrayList<>();
        for (String val : values)
          searchValues.add(Long.valueOf(val));
       
        return builder.in(root.get(criteria.getKey())).value(searchValues);
        
      case BIGINTEGERIN:
          String[] bigIntvalues = String.valueOf(criteria.getValue()).split(",");
         
          List<BigInteger> bigIntsearchValues = new ArrayList<>();
          for (String val : bigIntvalues)
        	  bigIntsearchValues.add(BigInteger.valueOf(Long.valueOf(val)));
        
          return builder.in(root.get(criteria.getKey())).value(bigIntsearchValues);
          
      case STARTS_ENDS_WITH_STRINGIN:
    	  String[] strValues = String.valueOf(criteria.getValue()).split(",");
    	  
    	  List<String> strsearchValues = Arrays.asList(strValues);
    	 
    	  List<Predicate> predicates = new ArrayList<>();
    	  Predicate predicate = null;
    	  Predicate predicate2 = null;
    	  for(String val2 : strsearchValues)
    	  {
    	  predicates.add(builder.like(root.<String>get(criteria.getKey()), "%" + val2 + "%"));
    	  }
    	  return builder.or(predicates.toArray(new Predicate[0]));   
         
          
      case INTEGERIN:
        String[] intValues = String.valueOf(criteria.getValue()).split(",");
       
        List<Integer> intSearchValues = new ArrayList<>();
        for (String val : intValues)
          intSearchValues.add(Integer.valueOf(val));
       
        return builder.in(root.get(criteria.getKey())).value(intSearchValues);
      case STRINGIN:
        return builder.in(root.get(criteria.getKey()))
            .value(Arrays.asList(String.valueOf(criteria.getValue()).split(",")));
      case STRING_NOT_IN :
          return builder.not(root.get(criteria.getKey()).in(Arrays.asList(String.valueOf(criteria.getValue()).split(","))));
      case JOIN_MULTI_STRING_LIST:
        Path<String> path = root.get(criteria.getKey());
        if (!CollectionUtils.isEmpty(criteria.getMultiJoinKeys())) {
          for (String key : criteria.getMultiJoinKeys()) {
            path = path.get(key);
          }
        }
        return builder.like(path, criteria.getValue().toString() + "%");
    
      case JOIN_MULTI_INTEGER_LIST:
      case JOIN_MULTI_STRING:
        path = root.get(criteria.getKey());
        if (!CollectionUtils.isEmpty(criteria.getMultiJoinKeys())) {
          for (String key : criteria.getMultiJoinKeys()) {
            path = path.get(key);
          }
        }
        return builder.equal(path, criteria.getValue());
    
        //edited for phoneNo
      case Starts_With_Long:
    	  String[] longValues = String.valueOf(criteria.getValue()).split(",");
          
          List<Long> searchValues1 = new ArrayList<>();
          for (String val : longValues)
            searchValues1.add(Long.valueOf(val));
          
          return builder.like(root.get(criteria.getKey()).as(String.class) , criteria.getValue() + "%");
          
      case LONG_CONTAINS:
    	  String[] longValuesContain = String.valueOf(criteria.getValue()).split(",");
          
          List<Long> searchLongValues = new ArrayList<>();
          for (String val : longValuesContain)
        	  searchLongValues.add(Long.valueOf(val));
          
          return builder.like(root.<String>get(criteria.getKey()).as(String.class), "%" + criteria.getValue() + "%");        
    
        //edited
      case JOIN_MULTI_STRING_STARTS_WITH:
    	  path = root.get(criteria.getKey());
    	  if (!CollectionUtils.isEmpty(criteria.getMultiJoinKeys())) {
    	  for (String key : criteria.getMultiJoinKeys()) {
    	  path = path.get(key);
    	  }
    	  }
    	  return builder.like(path, criteria.getValue() + "%");
      
      case JOIN_MULTI_INTEGER_LIST_IN:
      case JOIN_MULTI_STRING_IN:
        Path<Object> pathObj = root.get(criteria.getKey());
        if (!CollectionUtils.isEmpty(criteria.getMultiJoinKeys())) {
          for (String key : criteria.getMultiJoinKeys()) {
            pathObj = pathObj.get(key);
          }
        }
        return builder.in(pathObj).value(criteria.getValue());
      case JOIN_MULTI_INTEGER_LIST_NOT_EQ:
        pathObj = root.get(criteria.getKey());
        if (!CollectionUtils.isEmpty(criteria.getMultiJoinKeys())) {
          for (String key : criteria.getMultiJoinKeys()) {
            pathObj = pathObj.get(key);
          }
        }
        return builder.notEqual(pathObj, criteria.getValue());
      case JOIN_MULTI_NOT_INTEGER_LIST:
        path = root.get(criteria.getKey());
        if (!CollectionUtils.isEmpty(criteria.getMultiJoinKeys())) {
          for (String key : criteria.getMultiJoinKeys()) {
            path = path.get(key);
          }
        }
        return builder.notEqual(path, criteria.getValue());
      default:
        return null;
    }
  }
}
