/** Átila Grings e Leonardo Marques  Trabalho GA Lab1 Turma 53 2016/2 */

public class Cliente{
    private String nome;
    private Data dtNascimento;
    private double vlrPenultimaCompra;
    private double vlrUltimaCompra;
    private double saldoDevedor;
    
    public Cliente (String nome, Data dtNasc){
        this.nome = nome;
        dtNascimento = dtNasc;
    }
    
    public void fazCompra(double vlrCompra){
        vlrPenultimaCompra = vlrUltimaCompra;
        vlrUltimaCompra = vlrCompra;
        saldoDevedor += vlrCompra;
    }
    
    public void fazCompra(double vlrCompra, int nParcelas){
        fazCompra(vlrCompra);
    }
    
    public void pagar1Parcela(double vlrParcela){
        saldoDevedor -=vlrParcela;
    }
    
    public void exibeDados(){
        System.out.println("\f------------------------------------------------------------------------------------");
        System.out.println("Cliente\tData Nasc.\tSaldo devedor\tVlrUltimacompra\tVlrPenultimaCompra");
        System.out.println(nome+"\t"+dtNascimento.obtemDataPadrao()+"\t"+saldoDevedor+"\t\t"+vlrUltimaCompra+"\t\t"+vlrPenultimaCompra);
        System.out.println("------------------------------------------------------------------------------------");
    }
    
    public void setUltimaCompra(double vlrCompra){
        vlrUltimaCompra = vlrCompra;
    }
    
    public void setPenultimaCompra(double vlrCompra){
        vlrPenultimaCompra = vlrCompra;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSaldoDevedor(Double saldo){
        this.saldoDevedor = saldo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public double getVlrUltimaCompra(){
        return vlrUltimaCompra;
    }
        
    public double getVlrPenultimaCompra(){
        return vlrPenultimaCompra;
    }
        
    public double getSaldoDevedor(){
        return saldoDevedor;
    }
    
    public Data getDataNascimento(){
        return dtNascimento;
    }
        
}