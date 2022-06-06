package com.example.restaurantmanagement.services;

import com.example.restaurantmanagement.entities.Table;
import com.example.restaurantmanagement.exceptions.TableNotFoundException;

import java.util.List;

public interface TableService {

    Table createTable(Table table);

    List<Table> getTables();

    Table updateTable(Long id,Table table) throws TableNotFoundException;

    void deleteTable(Long id) throws TableNotFoundException;


}
