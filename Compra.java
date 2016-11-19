/** Átila Grings e Leonardo Marques  Trabalho GA Lab1 Turma 53 2016/2 */

public class Compra{
    private int modalidade;
    private Cliente cliente;
    private Data data;
    private double valor;
    private double valorFinal;
    private Parcela p1;
    private Parcela p2;
    private Parcela p3;
    
    public Compra(Cliente nome, Data dt, double valor){
        cliente = nome;
        data = dt;
        this.valor = valor;
        escolheModalidade();
    }
   
    public Compra(Cliente nome, double valor, int dia, int mes, int ano){
        cliente = nome;
        this.valor = valor;
        Data d = new Data(dia,mes,ano);
        data = d;
        escolheModalidade();
    }
    
    public void escolheModalidade(){
        Teclado t = new Teclado();
        int mod = t.leInt("\n\nIndique a modalidade da compra:\n\t1 - a vista\n\t2 - parcelada com entrada\n\t3 - parcelada sem entrada");
        if (mod ==2) modalidade =2;
        else if (mod==3) modalidade =3;
        else modalidade =1;
    }
    
    private boolean ultimasCrescente(double valorUltimaCompra){
        if (cliente.getVlrPenultimaCompra()<cliente.getVlrUltimaCompra() && cliente.getVlrUltimaCompra()<valorUltimaCompra) return true;
        return false;
    }       
    
    public String finalizaCompra(){
        Data hoje = new Data();
        valorFinal=valor;       
        if (modalidade ==2){
            valorFinal=valor*0.965;
            p1= new Parcela(cliente, calculaVencimentoParcela(data),valorFinal/3);
            p2= new Parcela (cliente, calculaVencimentoParcela(p1.getData()), valorFinal/3);
            cliente.setPenultimaCompra(cliente.getVlrUltimaCompra());// Atualiza a penultima compra = Ultima compra
            cliente.setUltimaCompra(valorFinal);// Ultima compra = Valor final (após os descontos) 
            return "Compra com entrada +2 parcelas, ganhou desconto de 3,5%";
        }
        
        if(modalidade ==3){
            p1= new Parcela(cliente, calculaVencimentoParcela(data),valorFinal/3);
            p2= new Parcela(cliente, calculaVencimentoParcela(p1.getData()),valorFinal/3);
            p3= new Parcela(cliente, calculaVencimentoParcela(p2.getData()),valorFinal/3);
            cliente.setPenultimaCompra(cliente.getVlrUltimaCompra());// Atualiza a penultima compra = Ultima compra
            cliente.setUltimaCompra(valorFinal);// Ultima compra = Valor final (após os descontos)  
            return "Compra em 3 parcelas, não ganhou desconto";
        }
        
        // SE A MODALIDADE NÃO FOR 2 NEM 3 SÓ PODE SER 1, SEGUE ABAIXO:
        if (data.getMes()==cliente.getDataNascimento().getMes()) {
            valorFinal = valor*0.8;
            cliente.setPenultimaCompra(cliente.getVlrUltimaCompra());// Atualiza a penultima compra = Ultima compra
            cliente.setUltimaCompra(valorFinal);// Ultima compra = Valor final (após os descontos)                
            return "Compra a vista, ganhou 20% de desconto, pois cliente nasceu em "+cliente.getDataNascimento().obtemDataPadrao();
        }
            
        if (ultimasCrescente(valorFinal)){ 
            valorFinal = valor*0.92;
            cliente.setPenultimaCompra(cliente.getVlrUltimaCompra());// Atualiza a penultima compra = Ultima compra
            cliente.setUltimaCompra(valorFinal);// Ultima compra = Valor final (após os descontos) 
            return "Compra a vista, ganhou 8% de desconto";
        }
            valorFinal = valor*0.95;
            cliente.setPenultimaCompra(cliente.getVlrUltimaCompra());// Atualiza a penultima compra = Ultima compra
            cliente.setUltimaCompra(valorFinal);// Ultima compra = Valor final (após os descontos) 
            return "Compra a vista, ganhou 5% de desconto";
        } 
        
    public Data calculaVencimentoParcela(Data data){
        int ano = data.getAno();
        int mes = data.getMes();
        if (data.getMes()==12) {
            ano = data.getAno()+1;
            mes = 0;
        }
        Data d = new Data(28,mes+1,ano);
        return d;
    }
        
    public void exibeDados(){
        String modalidadeCompra = finalizaCompra();
        System.out.println("\nModalidade\tCliente\tDtCompra\tValorOriginal\tValorFinal");
        System.out.println("  "+modalidade+"\t\t"+cliente.getNome()+"\t"+data.obtemDataPadrao()+"\t"+valor+"\t\t"+valorFinal+"\n\n\t"+modalidadeCompra);
        
        if (modalidade ==2) {
            System.out.println("\nEntrada de: "+valorFinal/3);
            System.out.println("Primeira parcela: "+p1.getData().obtemDataPadrao()+"\tValor: "+p1.getVlrOriginal());
            System.out.println("Segunda parcela: "+p2.getData().obtemDataPadrao()+"\tValor: "+p2.getVlrOriginal());
        }
        if (modalidade ==3) {
            System.out.println("\nPrimeira parcela: "+p1.getData().obtemDataPadrao()+"\tValor: "+p1.getVlrOriginal());
            System.out.println("Segunda parcela: "+p2.getData().obtemDataPadrao()+"\tValor: "+p2.getVlrOriginal());
            System.out.println("Terceira parcela: "+p3.getData().obtemDataPadrao()+"\tValor: "+p3.getVlrOriginal());
        }
    }
    
    }

    

    
    
    
    
    

