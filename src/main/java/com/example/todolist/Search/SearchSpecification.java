package com.example.todolist.Search;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class SearchSpecification<T> implements Specification<T>{
    private SearchCriteria criteria;

    public SearchSpecification(final SearchCriteria searchCriteria) {
        super();
        this.criteria = searchCriteria;
    }
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if(SearchOperationType.NULL.equals(criteria.getOperation())){
            return root.get(criteria.getDataField()).isNull();
        }

        return null;
    }
}
