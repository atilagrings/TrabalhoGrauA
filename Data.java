import java.util.GregorianCalendar;

public class Data
{
   private int dia;
   private int mes;
   private int ano;
   
   /** Construtor sem parametros inicializa a data de hoje*/
   public Data(){
       GregorianCalendar c = new GregorianCalendar();
       dia = c.get(GregorianCalendar.DAY_OF_MONTH);//DAY_OT_MONTH � um campo final static int
       mes = c.get(GregorianCalendar.MONTH)+1;//MONTH � campo final static int que corresponde ao m�s do ano - come�a em 0
       ano = c.get(GregorianCalendar.YEAR);
   }
   
   public Data(int d, int m, int a)
   {   dia = d;  mes = m;  ano = a;  }

   public String obtemDataPadrao()
   {   return dia + "/" + mes + "/" + ano;   }

   public String obtemDataPadraoComZeros(){
       if (dia >= 10 && mes >= 10)
          return obtemDataPadrao();
       else{
           String d = String.valueOf(dia);
           if (dia < 10)
              d = "0" + dia;
           String m = String.valueOf(mes);
           if (mes < 10)
              m = "0" + mes;
           return d + "/" + m + "/" + ano;
           }
   }              

   public int obtemDataInvertida()
   {   return ano * 10000 + mes * 100 + dia;   }

   public void setDia(int d){dia = d;}   
   public void setMes(int m){mes = m;}   
   public void setAno(int a){ano = a;}

   public int getDia(){return dia;}
   public int getMes(){return mes;}
   public int getAno(){return ano;}
   
   public void leData()
   {   Teclado t = new Teclado();
       int data = t.leInt();
       ano = data / 10000;
       mes = (data - ano * 10000) / 100;
       dia = data - ano * 10000 - mes * 100;
   }
   
   /* indica se um ano e bissexto ou nao */
   public boolean eBissexto(int ano){
       if (ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0))
          return true;
       else
          return false;
   }
   
   /* informa quantos dias tem um mes */
   public int diasDoMes(int mes, int ano){
       if (mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes ==12)
          return 31;
       else if (mes == 2)
       {
           if (eBissexto(ano))
               return 29;
           else
               return 28;
       }
       else
          return 30;
   }
    
   /* Calcula quantidade de dias entre duas datas */
   public int diasDeOutraData(Data outra)
   {
       Data max, min;
       if (this.obtemDataInvertida() > outra.obtemDataInvertida()){
           max = this; min = outra;
       }
       else{
           max = outra; min = this;
       }
       int dias = 0;
       if (max.ano == min.ano)//mesmo ano
          if (max.mes == min.mes)//mesmo mes
             if (max.dia == min.dia)//mesmo dia
                 dias = 0;
             else
                 dias = max.dia - min.dia;//mesmo mes, dias dif
           //mesmo ano, meses diferentes
           else {
               dias = diasDoMes(min.mes, min.ano) - min.dia;
               for (int i = min.mes+1; i<max.mes; i++)
                   dias += diasDoMes(i, min.ano);
               dias += max.dia;
            }
        //Anos diferentes
        else{ 
             //soma dias dos anos entre os anos extremos
             for (int i=min.ano + 1; i<max.ano; i++)
                if (eBissexto(i))
                   dias += 366;
                else
                   dias += 365;
             //conta dias do ano inicial - da data ate fim do ano
             dias += diasDoMes(min.mes, min.ano) - min.dia;
             for (int i = min.mes+1; i<=12; i++)
                   dias += diasDoMes(i, min.ano);
             //conta dias do ano final - de 1/1 ate a data
             for (int i = 1; i < max.mes; i++)
                 dias += diasDoMes(i, max.ano);
             dias += max.dia;
            }
        return dias;
    }
    
    
   }
   
  
       
  

