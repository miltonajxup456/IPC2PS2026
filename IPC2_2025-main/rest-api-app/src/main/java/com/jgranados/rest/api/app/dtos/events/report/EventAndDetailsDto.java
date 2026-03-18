/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.rest.api.app.dtos.events.report;

import java.util.List;

/**
 *
 * @author jose
 */
public class EventAndDetailsDto {
    private String code;
    private String name;
    private Double price;
    private List<EventDetailDto> details;

    public EventAndDetailsDto(String code, String name, Double price, List<EventDetailDto> details) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.details = details;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<EventDetailDto> getDetails() {
        return details;
    }

    public void setDetails(List<EventDetailDto> details) {
        this.details = details;
    }
    
    
}
