public class Carro {
    private  int posicao;

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public  void andar (int km){
        this.posicao += km;
    }
}
