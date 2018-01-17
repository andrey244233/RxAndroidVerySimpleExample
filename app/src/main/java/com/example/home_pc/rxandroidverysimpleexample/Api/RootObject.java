package com.example.home_pc.rxandroidverysimpleexample.Api;


import android.renderscript.Sampler;

public class RootObject {
    private Sampler.Value[] value;

    private String type;

    public Sampler.Value[] getValue ()
    {
        return value;
    }

    public void setValue (Sampler.Value[] value)
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
