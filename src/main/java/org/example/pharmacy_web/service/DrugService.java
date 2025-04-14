package org.example.pharmacy_web.service;


import org.example.pharmacy_web.controller.dto.DrugDto;
import org.example.pharmacy_web.infrastructure.entity.Drug;
import org.example.pharmacy_web.infrastructure.repo.DrugRepository;
import org.example.pharmacy_web.service.model.DrugModel;
import org.example.pharmacy_web.service.value.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DrugService {
    private final DrugRepository drugRepository;
    @Autowired
    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }
    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }
    public Drug getOne(Long id) {
        return drugRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Drug not found"));
    }
    public DrugDto create(Drug drug){
        var price = Price.create((drug.getPrice()));
        var drugModel = new DrugModel(
                drug.getId(),
                drug.getCode(),
                drug.getName(),
                drug.getDose(),
                drug.getForm(),
                drug.getManufacturer(),
                drug.getAvailableUnits(),
                price
        );
        var drugs = new Drug();
        drugs.setName(drugModel.getName());
        drugs.setPrice(drugModel.getPrice().getValue());

        var savedDrug = drugRepository.save(drugs);
        return new DrugDto(
                savedDrug.getId(),
                savedDrug.getName(),
                savedDrug.getPrice(),
                savedDrug.getAvailableUnits(),
                savedDrug.getCode(),
                savedDrug.getDose(),
                savedDrug.getForm(),
                savedDrug.getManufacturer()
        );

    }
    public void delete(long id) {
        if(!drugRepository.existsById(id)){
            throw new RuntimeException();
        }
        drugRepository.deleteById(id);
    }

}
