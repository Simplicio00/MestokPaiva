
package mestok1.Database.Entidade;

public class Estoque {
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    private String Nome;
    private String DataCadastro;
    private float ValorContabil;    
    //public boolean EstoqueAtivo;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(String DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public float getValorContabil() {
        return ValorContabil;
    }

    public void setValorContabil(float ValorContabil) {
        this.ValorContabil = ValorContabil;
    }
    
}
