package es.csir.util;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;

import es.csir.metric.DevCategoryCSIR;
import es.csir.metric.DevMet;

public class WriteJSON 
{
    public static void writeDevMet(JsonWriter writer, DevMet devMet)
    {
        Gson gs = new Gson();
        gs.toJson(devMet, DevMet.class, writer);
    }

    public static void writeDevCategoryCSIR(JsonWriter writer, DevCategoryCSIR devCategoryCSIR)
    {
        Gson gs = new Gson();
        gs.toJson(devCategoryCSIR, DevCategoryCSIR.class, writer);
    }

    public static void writeDevMet(JsonWriter writer, List<DevMet> listDevMet) throws IOException
    {
        for ( DevMet devMet : listDevMet) 
        {
            writeDevMet(writer, devMet);
        }
    }
    
    public static void writeDevCategoryCSIR(JsonWriter writer, List<DevCategoryCSIR> listDevMet) throws IOException
    {
        for ( DevCategoryCSIR devCategoryCSIR : listDevMet) 
        {
            writeDevCategoryCSIR(writer, devCategoryCSIR);
        }
    }    

    public static void writeDevMet(String writeFilePath, List<DevMet> listDevMet) throws IOException
    {
        Gson gs = new Gson();
        JsonWriter writer = new JsonWriter(new FileWriter(writeFilePath));
        Type type = new TypeToken<List<DevMet>>(){}.getType();
        gs.toJson(listDevMet, type, writer);
        writer.close();
    }

    public static void writeDevCategoryCSIR(String writeFilePath, List<DevCategoryCSIR> listDevCategoryCSIR) throws IOException
    {
        Gson gs = new Gson();
        JsonWriter writer = new JsonWriter(new FileWriter(writeFilePath));
        Type type = new TypeToken<List<DevCategoryCSIR>>(){}.getType();
        gs.toJson(listDevCategoryCSIR, type, writer);
        writer.close();
    }
        
}
