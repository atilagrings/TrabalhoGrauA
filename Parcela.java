/** Átila Grings e Leonardo Marques  Trabalho GA Lab1 Turma 53 2016/2 */

public class Parcela{
    private Cliente cliente;
    private Data dtVencimento;
    private double vlrOriginal;
    private double vlrFinal;
    private char situacao;
    
    public Parcela(Cliente cliente, Data data, double vlr){
        this.dtVencimento = data;
        this.cliente = cliente;
        dtVencimento = data;
        vlrOriginal = vlr;
        situacao = 'N';
    }
    
    public boolean registraAtraso(){
        Data d = new Data();
        if (situacao == 'N' && dtVencimento.diasDeOutraData(d)>0) {
            situacao = 'A';
            return true;
        }
       return false;
    }
    
    public double pagaParcela(Data data){
        int diaPgto = dtVencimento.diasDeOutraData(data);
        if (diaPgto <= 0) {
            situacao = 'Q';
            vlrFinal = vlrOriginal;
            return vlrFinal;
        }
                else if (diaPgto > 0 && diaPgto <=5) {
                    situacao = 'Q';
                    vlrFinal = vlrOriginal*1.01;
                    return vlrFinal;
                }
                else if (diaPgto >5 && diaPgto <=15){
                    situacao = 'Q';
                    vlrFinal = vlrOriginal*1.015;
                    return vlrFinal;
                }
                else {
                    situacao = 'Q';
                    vlrFinal = vlrOriginal*1.025;
                    return vlrFinal;
        }
    }
    
    public String traduzSituacao(){
        if (situacao == 'N') 
            return "Parcela não venceu ainda" ;
        else if (situacao =='A'){
            return "Parcela vencida" ;}
        else
            return "Parcela quitada"; 
    }
   
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public void setVlrOriginal(double vlr){
        vlrOriginal = vlr;
    }
        
    public void setVlrFinal(double vlr){
        vlrFinal = vlr;
    }
        
    public double getVlrOriginal(){
        return vlrOriginal;
    }
        
    public double getVlrFinal(){
        return vlrFinal;
    }
    
    public Data getData(){
        return dtVencimento;
    }

    public void exibeDados(int nParcela){
        System.out.println("n° Parcela Cliente\tVencimento\tValor\tSituação");
        System.out.println("\t"+nParcela+"   "+cliente.getNome()+"\t"+dtVencimento.obtemDataPadrao()+"\t"+vlrOriginal+"\t"+traduzSituacao());
    }
}

