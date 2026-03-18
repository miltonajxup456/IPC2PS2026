/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.backend.eventos;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jose
 */
public class Evento {
    private String codigo;
    private String nombre;
    private TipoEventoEnum tipo;
    private int limite;

    public Evento(String codigo, String nombre, TipoEventoEnum tipo, int limite) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.limite = limite;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public TipoEventoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEventoEnum tipo) {
        this.tipo = tipo;
    }
    
    public boolean esValido() {
        return StringUtils.isNotBlank(codigo)
                && StringUtils.isNotBlank(nombre)
                && tipo != null
                && limite > 0;
    }
    
}
