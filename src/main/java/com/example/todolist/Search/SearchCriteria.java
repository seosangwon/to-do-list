package com.example.todolist.Search;

import lombok.Getter;

import java.util.List;

@Getter
public class SearchCriteria {
    public SearchCriteria(String dataField, SearchOperationType operation, List<Object> values, boolean isOrOperation) {
        this.dataField = dataField;
        this.operation = operation;
        this.values = values;
        this.isOrOperation = isOrOperation;
    }
    private String dataField;
    private SearchOperationType operation;
    private List<Object> values;
    private boolean isOrOperation;
}
