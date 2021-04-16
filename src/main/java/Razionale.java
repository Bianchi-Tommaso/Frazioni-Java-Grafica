

public class Razionale 
{
    //variabili 
    private int N;
    private int D;
    
    //costruttori
    public Razionale()
    {
        N = 0;
        D = 1;
    }
    
    public Razionale(int N)
    {
        this.N = N;
        D = 1;
    }
    
    public Razionale(int N, int D)throws ArithmeticException
    {
        if(D == 0)
        {
            throw new ArithmeticException("Impossibile Dividere Per Zero");
        }
        this.N = N;
        this.D = D;
    }
    
    public int getD()
    {
        return D;
    }
    
    public int getN()
    {
        return N;
    }
    
    public void setf(int N, int D)
    {
        if(D == 0)
        {
            throw new ArithmeticException("Impossibile Dividere Per 0");
        }
        this.N = N;
        this.D = D;
    }
    
    public void riduci()
    {
         MCD frazione = new MCD();
       int divisore = frazione.mcd(N,D);
       int nuovo_N = N / divisore;
       int nuovo_D = D/ divisore;
       N = nuovo_N;
       D = nuovo_D;    
    }
    
    public Razionale somma(Razionale x)
    {
         MCM frazione = new MCM();
         int multiplo = frazione.mcm(D, x.getD());
         int nuovo_N = multiplo / D * N + multiplo / x.getD() * x.getN();
         int nuovo_D = multiplo;
         Razionale riss = new Razionale(nuovo_N, nuovo_D);
         riss.riduci();
         return riss;
    }
    
    public Razionale sottrazione(Razionale x)
    {
         MCM frazione = new MCM();
         int multiplo = frazione.mcm(D, x.getD());
         int nuovo_N = multiplo / D * N - multiplo / x.getD() * x.getN();
         int nuovo_D = multiplo;
         Razionale rissot = new Razionale(nuovo_N, nuovo_D);
         rissot.riduci();
         return rissot;
    }
    
     public Razionale prodotto(Razionale x)
    {
         int nuovo_N = N * x.getN();
         int nuovo_D = D * x.getD();
         Razionale rispro = new Razionale(nuovo_N, nuovo_D);
         rispro.riduci();
         return rispro;
    }
     
        public Razionale quoziente(Razionale x)
    {
         int nuovo_N = N * x.getD();
         int nuovo_D = D * x.getN();
         Razionale risquo = new Razionale(nuovo_N, nuovo_D);
         risquo.riduci();
         return risquo;
    }
        
          public Razionale reciproco()
    {
         int nuovo_N = D;
         int nuovo_D = N;
         Razionale risrec = new Razionale(nuovo_N, nuovo_D);
         return risrec;
    }
          
          public boolean isZero()
          {
              boolean t = false;
              if(N == 0)
              {
                  t = true;
              }
              return t;
          }
          
         public boolean isPositive()
          {
              boolean t = false;
              if(N > 0 )
              {
                  t = true;
              }
              return t;
          }
         
         public int confronto(Razionale x)
         {
             int i = 0;
             
             if(N == x.getN() && D == x.getD())
             {  
                 i = 0;
             }
             else if(D < x.getD())
             {
                 i = -1;
             }
             else 
             {
                 i = 1;
             }
            
            return i;
         }
         
         public String toString()
         {
             String s = N + "/" + D;
             
             return s;
         }
}
