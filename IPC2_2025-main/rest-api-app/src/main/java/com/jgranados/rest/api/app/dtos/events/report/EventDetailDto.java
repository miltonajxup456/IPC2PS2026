/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.rest.api.app.dtos.events.report;

import java.time.LocalDate;

/**
 *
 * @author jose
 */
public class EventDetailDto {
    private String nameDetail;
    private LocalDate dateDetail;
    private Integer limitDetail;

    public EventDetailDto(String nameDetail, LocalDate dateDetail, Integer limitDetail) {
        this.nameDetail = nameDetail;
        this.dateDetail = dateDetail;
        this.limitDetail = limitDetail;
    }

    public String getNameDetail() {
        return nameDetail;
    }

    public void setNameDetail(String nameDetail) {
        this.nameDetail = nameDetail;
    }

    public LocalDate getDateDetail() {
        return dateDetail;
    }

    public void setDateDetail(LocalDate dateDetail) {
        this.dateDetail = dateDetail;
    }

    public Integer getLimitDetail() {
        return limitDetail;
    }

    public void setLimitDetail(Integer limitDetail) {
        this.limitDetail = limitDetail;
    }
    
    
}
