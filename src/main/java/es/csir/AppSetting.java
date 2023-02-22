package es.csir;

import java.util.HashMap;
import java.util.Map;

public class AppSetting 
{
    Map<String, String> mapOptions;
    boolean isValid;

    String inputFilePath;
    String outputFilePath;
    String type;

    public AppSetting()
    {
        this.mapOptions = new HashMap<>();
    }

    public void setValid(boolean b)
    {
        this.isValid = b;
    }

    public void put(String opt, String value)
    {
        this.mapOptions.put(opt, value);
    }

    public String get(String opt)
    {
        return this.mapOptions.get(opt);
    }
    
    public String getType()
    {
        return mapOptions.get("-t");
    }
    
}
