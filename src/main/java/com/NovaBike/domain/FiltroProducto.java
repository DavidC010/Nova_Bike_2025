/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.NovaBike.domain;


import java.math.BigDecimal;
import lombok.Data;

@Data
public class FiltroProducto {
    private BigDecimal min;
    private BigDecimal max;
    private String nombre; 
}
