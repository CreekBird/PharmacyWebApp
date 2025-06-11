package org.example.pharmacy_web.controller.dto;

import jakarta.validation.constraints.Size;


public class CreateDrugRequestDto {
    private Long id;

    private String code;

    private String name;

    @Size(min = 0, message = "Dose cannot be negative")
    private String dose;

    private String form;

    private String manufacturer;
    @Size(min = 0, message = "Available units cannot be negative")
    private int availableUnits;
    @Size(min = 0, message = "Price cannot be negative")
    private double price;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(Integer availableUnits) {
        this.availableUnits = availableUnits;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



}
