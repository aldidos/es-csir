package es.csir;

import java.util.regex.Pattern;

public class CommandArgs 
{
    String[] args;   
    final String optPtnReg = "^-[iot]";
    Pattern ptn;
    
    public CommandArgs(String[] args)
    {
        this.args = args;
        this.ptn = Pattern.compile(optPtnReg);
    }

    public String getArgs(int i)
    {
        if( i >= args.length ) return null;
        return args[i];
    }

    public boolean isOption(String s)
    {
        return ptn.matcher(s).matches();
    }
}
