package org.example.pharmacy_web.service.model;

import org.example.pharmacy_web.service.value.Price;

public class DrugModel {
    private Long id;
    private String code;
    private String name;
    private String dose;
    private String form;
    private String manufacturer;
    private Integer availableUnits;
    private Price price;

    public DrugModel(Long id, String code, String name, String dose, String form, String manufacturer, Integer availableUnits, Price price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dose = dose;
        this.form = form;
        this.manufacturer = manufacturer;
        this.availableUnits = availableUnits;
        this.price = price;
    }

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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}