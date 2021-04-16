


public class MCD 
{
    
    public int a;
    public int b;
    
    public int mcd(int a, int b)
    {  
        if (a == b)
            return a;
        else
   if (a > b)
       return mcd(a - b, b);
   else 
       return mcd(b, a);
    }
}
