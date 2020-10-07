/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.util;
import com.google.gson.Gson;
/**
 *
 * @author dario
 */
public class ConvertToJsonUtil {
     static Gson gson;
     static{
       gson  = new Gson();
     }

    public static String converterObjeto(Object ob){
        String jsonString = gson.toJson(ob);
        return jsonString;
    }
    
}
