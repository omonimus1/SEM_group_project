package com.napier.sem;

import java.sql.Statement;
import java.util.ArrayList;

public class Country {
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private float SurfaceArea;
    private int IndepYea;
    private int Population;
    private float LifeExpectancy;
    private float GNP;
    private float GNPOld;
    private String LocalName;
    private String GovernmentForm;
    private String HeadOfState;
    private int Capital ;
    private String Code2;

    public String getCode()
    {
        return Code;
    }
    public void setCode(String new_code)
    {
        this.Code=new_code;
    }

    public String getContinent()
    {
        return Continent;
    }
    public void setContinent(String new_con)
    {
        this.Continent=new_con;
    }

    public int getPopulation()
    {
        return Population;
    }
    public void setPopulation(int new_pop)
    {
        this.Population=new_pop;
    }

    public String getName()
    {
        return Name;
    }
    public void setName(String new_name)
    {
        this.Name=new_name;
    }

}
