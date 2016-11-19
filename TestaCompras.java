/** Átila Grings e Leonardo Marques  Trabalho GA Lab1 Turma 53 2016/2 */

public class TestaCompras{
    public static void main(String[] args){
        Data hoje = new Data();
        Data nasc = new Data(24,11,1985);
        
        Cliente cliente1 = new Cliente("Carlos",nasc);
        
        System.out.println("\f");
        
        //COMPRA 1
        Data dtcompra = new Data(hoje.getDia(),cliente1.getDataNascimento().getMes(),hoje.getAno());
        Compra compra1 = new Compra(cliente1, 
                                    dtcompra,100.00);
                                    compra1.exibeDados();
                        
        //Compra2
        Compra  compra2 = new Compra(cliente1,200.00,15,10,hoje.getAno());
                compra2.exibeDados();
                
        //Compra3
        Compra  compra3 = new Compra(cliente1,300.00,10,12,hoje.getAno());
                compra3.exibeDados();   
                
        //Compra4
        Compra  compra4 = new Compra(cliente1,150.00,1,12,hoje.getAno());
                compra4.exibeDados();        
        
       //Compra5
        Compra  compra5 = new Compra(cliente1,600.00,5,12,hoje.getAno());
                compra5.exibeDados();         
        
    }
}