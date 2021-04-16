


public class MCM 
{
    
    int a,b,mult_a,mult_b;
    
    public MCM()
    {
    }
    
   public int mcm(int a, int b){
    mult_a = a;
    mult_b = b;
    while (mult_a != mult_b) { // continua finchè non trova due multipli uguali
    while (mult_a < mult_b)  mult_a += a; // genera i multipli di a finchè non superano quelli di b
    while (mult_b < mult_a)  mult_b += b; // genera i multipli di b finchè non superano quelli di a
    }
    return mult_a;
    }
    }
