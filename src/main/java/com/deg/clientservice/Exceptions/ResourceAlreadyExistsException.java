/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deg.clientservice.Exceptions;

/**
 *
 * @author USUARIO
 */
public class ResourceAlreadyExistsException extends Exception{
    
    public ResourceAlreadyExistsException(String msg){
      super(msg);
    }
}
