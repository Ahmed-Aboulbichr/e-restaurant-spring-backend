package com.example.restaurantmanagement.web;

import com.example.restaurantmanagement.entities.Categorie;
import com.example.restaurantmanagement.entities.Table;
import com.example.restaurantmanagement.exceptions.CategorieNotFoundException;
import com.example.restaurantmanagement.exceptions.TableNotFoundException;
import com.example.restaurantmanagement.services.TableService;
import com.example.restaurantmanagement.services.TableServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TableRestApi {

    private TableService tableService;

    @GetMapping("/tables")
    public ResponseEntity<List<Table>> tables(){
        return ResponseEntity.ok(tableService.getTables());
    }

    @PostMapping("/tables")
    public ResponseEntity<Table> createTable(@Valid @RequestBody Table table){
        return ResponseEntity.ok(tableService.createTable(table));
    }

    @PutMapping("/tables/{id}")
    public ResponseEntity<Table> updateTable(@PathVariable Long id, @RequestBody Table table) throws TableNotFoundException {
        return new ResponseEntity<>(tableService.updateTable(id, table), HttpStatus.OK);
    }

    @DeleteMapping("/tables/{id}")
    public ResponseEntity<HttpStatus> deleteCategorie(@PathVariable Long id) throws TableNotFoundException {
        tableService.deleteTable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
