public class Linguagens {
    private String linguagem;
    private String backend;
    private String frontend; 
    
    public Linguagens() {
    }

    public Linguagens(String linguagem, String backend, String frontend) {
        this.linguagem = linguagem;
        this.backend = backend;
        this.frontend = frontend;
    }

    public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	public String getBackend() {
		return backend;
	}

	public void setBackend(String backend) {
		this.backend = backend;
	}

	public String getFrontend() {
		return frontend;
	}

	public void setFrontend(String frontend) {
		this.frontend = frontend;
	}

	@Override
    public String toString() {
        return "Linguagens [linguagem=" + linguagem + ", backend=" + backend + ", frontend=" + frontend + "]";
    }
}
