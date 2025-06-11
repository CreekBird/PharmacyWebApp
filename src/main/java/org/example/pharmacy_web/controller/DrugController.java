package org.example.pharmacy_web.controller;
import org.example.pharmacy_web.controller.dto.DrugResponseDto;
import org.example.pharmacy_web.infrastructure.entity.Drug;
import org.example.pharmacy_web.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drugs")
public class DrugController {
    private final DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping
    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    @GetMapping("/{id}")
    public DrugResponseDto getOne(@PathVariable Long id) {
        Drug drug = drugService.getOne(id);
        return new DrugResponseDto(drug.getId(), drug.getName(), drug.getPrice(), drug.getAvailableUnits(), drug.getCode(), drug.getDose(), drug.getForm(), drug.getManufacturer());
    }
    @PostMapping
    public DrugResponseDto create(@Validated @RequestBody Drug drug) {
        var drugs = new Drug();
        drugs.setCode(drug.getCode());
        drugs.setName(drug.getName());
        drugs.setDose(drug.getDose());
        drugs.setForm(drug.getForm());
        drugs.setManufacturer(drug.getManufacturer());
        drugs.setAvailableUnits(drug.getAvailableUnits());
        drugs.setPrice(drug.getPrice());

        var createdDrug = drugService.create(drug);
        return createdDrug;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        drugService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
