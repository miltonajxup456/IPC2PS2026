/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.rest.api.app.models.events;

import java.time.LocalDate;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jose
 */
public class Event {
    private String code;
    private String name;
    private EventTypeEnum eventType;
    private Integer limit;
    private LocalDate startDate;
    private Double price;

    public Event(String code, String name, EventTypeEnum eventType, Integer limit, LocalDate startDate, Double price) {
        this.code = code;
        this.name = name;
        this.eventType = eventType;
        this.limit = limit;
        this.startDate = startDate;
        this.price = price;
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

    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    
    
    public boolean isValid() {
        return StringUtils.isNotBlank(code)
                && StringUtils.isNotBlank(name)
                && eventType != null
                && limit > 0
                && startDate != null
                && price > 0;
    }
}
