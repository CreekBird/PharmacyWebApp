package org.example.pharmacy_web.controller.dto;
// DTO class for Drug entity
public class DrugDto {

    private Long id;
    private String name;
    private double price;
    private int availableUnits;
    private String code;
    private String dose;
    private String form;
    private String manufacturer;

    public DrugDto(Long id, String name, double price, int availableUnits, String code, String dose, String form, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availableUnits = availableUnits;
        this.code = code;
        this.dose = dose;
        this.form = form;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
