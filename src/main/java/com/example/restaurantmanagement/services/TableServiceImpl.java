package com.example.restaurantmanagement.services;

import com.example.restaurantmanagement.entities.Table;
import com.example.restaurantmanagement.exceptions.TableNotFoundException;
import com.example.restaurantmanagement.repositories.TableRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TableServiceImpl implements TableService{

    private TableRepository tableRepository;

    @Override
    public Table createTable(Table table) {
        return tableRepository.save(table);
    }

    @Override
    public List<Table> getTables() {
        return tableRepository.findAll();
    }

    @Override
    public Table updateTable(Long id,Table table)throws TableNotFoundException {
        return tableRepository.findById(id).map(table1 -> {
            table1.setName(table.getName());
            table1.setReserved(table.isReserved());
            return tableRepository.save(table1);
        }).orElseThrow( () -> new TableNotFoundException("Table not Found"));
    }

    @Override
    public void deleteTable(Long id) throws TableNotFoundException {
        Table table= tableRepository.findById(id).orElse(null);
        if(table == null) {
            throw new TableNotFoundException("Table not found");
        }else{
            tableRepository.delete(table);
        }
    }
}
