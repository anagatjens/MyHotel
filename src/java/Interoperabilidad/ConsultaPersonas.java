/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interoperabilidad;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;


/**
 *
 * @author Ana Gatjens Campos
 */
public class ConsultaPersonas {
    public String obtenerNombreAPI(String cedula){
        String _nombreCompleto;
        try{
            //get ya que se realiza desde la URL
            String _urlAPI = "https://apis.gometa.org/cedulas/"+cedula;
            URL _url = new URL(_urlAPI);
            HttpURLConnection conn = (HttpURLConnection) _url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            //respuesta correcta, codigo 200
            
            int _responseCode = conn.getResponseCode();
            if(_responseCode!=200){
                throw new RuntimeException("Ocurrio un error en la consulta del API" + _responseCode);
            }else{
                //leer el objeto
                StringBuilder _infoString = new StringBuilder();
                Scanner _data = new Scanner(_url.openStream());
                
                while(_data.hasNext()){
                    _infoString.append(_data.nextLine());
                }
                _data.close();
                
                JSONObject _jsonObjt = new JSONObject(_infoString.toString());
                
                _nombreCompleto = _jsonObjt.getString("nombre");
                if(_nombreCompleto.length()<2){
                   _nombreCompleto = "No se encontraron datos"; 
                }
                return _nombreCompleto;
            }
        }catch(Exception e){
            _nombreCompleto = "No se encontraron datos";
            System.out.println(e.toString());        
        }
        return _nombreCompleto;
    }
    
}
