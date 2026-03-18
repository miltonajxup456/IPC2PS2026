/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  jose
 * Created: Sep 2, 2025
 */

create schema eventsdb;
use eventsdb;
create table evento (
    codigo varchar(50) primary key,
    nombre varchar(250) not null,
    tipo ENUM('CONGRESO', 'CHARLA', 'TALLER', 'DEBATE') not null,
    limite int not null
);