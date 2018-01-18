package com.example.home_pc.rxandroidverysimpleexample.Api;




public class RootObject {
    private Value[] value;

    private String type;

    public Value[] getValue ()
    {
        return value;
    }

    public void setValue (Value[] value)
    {
        this.value = value;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [value = "+value+", type = "+type+"]";
    }
}
