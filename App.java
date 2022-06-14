import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
	public static void main(String[] args) {

		String arquivoCSV = "pesquisa.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";

		Linguagens[] linguagens = new Linguagens[47];

		try {
			br = new BufferedReader(new FileReader(arquivoCSV));
			for (int i = 0; (linha = br.readLine()) != null; i++) {

				String[] colunas = linha.split(csvDivisor);

				linguagens[i] = new Linguagens();

				linguagens[i].setLinguagem(colunas[0]);
				linguagens[i].setBackend(colunas[1]);
				linguagens[i].setFrontend(colunas[2]);

				//                System.out.println(linguagens[i].toString());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("REGRA 1: LINGUAGEM JAVA, SPRINGBOOT NO BACKEND E REACT NO FRONTEND: ");
		System.out.print("Suporte: ");
		System.out.printf("%.2f\n", suporteRegra1(linguagens));
		System.out.print("Confiança: ");
		System.out.printf("%.2f\n", confiancaRegra1(linguagens));

		System.out.println("");

		System.out.println("REGRA 2: LINGUAGEM JAVA, SPRINGBOOT NO BACKEND E ANGULAR NO FRONTEND:");
		System.out.print("Suporte: ");
		System.out.printf("%.2f\n", suporteRegra2(linguagens));
		System.out.print("Confiança: ");
		System.out.printf("%.2f\n", confiancaRegra2(linguagens));

		System.out.println("");

		System.out.println("REGRA 3: LINGUAGEM JAVASCRIPT, EXPRESS JS NO BACKEND E REACT NO FRONTEND:");
		System.out.print("Suporte: ");
		System.out.printf("%.2f\n", suporteRegra3(linguagens));
		System.out.print("Confiança: ");
		System.out.printf("%.2f\n", confiancaRegra3(linguagens));

		System.out.println("");

		System.out.println("REGRA 4: LINGUAGEM JAVASCRIPT, EXPRESS JS NO BACKEND E ANGULAR NO FRONTEND:");
		System.out.print("Suporte: ");
		System.out.printf("%.2f\n", suporteRegra4(linguagens));
		System.out.print("Confiança: ");
		System.out.printf("%.2f\n", confiancaRegra4(linguagens));

		System.out.println("");

		System.out.println("REGRA 5: LINGUAGEM PYTHON, DJANGO NO BACKEND E REACT NO FRONTEND:");
		System.out.print("Suporte: ");
		System.out.printf("%.2f\n", suporteRegra5(linguagens));
		System.out.print("Confiança: ");
		System.out.printf("%.2f\n", confiancaRegra5(linguagens));
		
		System.out.println("");

		System.out.println("REGRA 6: LINGUAGEM PYTHON, DJANGO NO BACKEND E ANGULAR NO FRONTEND:");
		System.out.print("Suporte: ");
		System.out.printf("%.2f\n", suporteRegra6(linguagens));
		System.out.print("Confiança: ");
		System.out.printf("%.2f\n", confiancaRegra6(linguagens));
	}

	//LINGUAGEM JAVA, SPRINGBOOT NO BACKEND E REACT NO FRONTEND 
	//suporte
	public static double suporteRegra1(Linguagens[] linguagens) {

		int frequencia = 0;

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("JAVA") && linguagens[i].getBackend().equals("SPRINGBOOT") && linguagens[i].getFrontend().equals("REACT")) {
				frequencia += 1;
			}
		}

		return frequencia / (double) linguagens.length;
	}

	//confiança
	public static double confiancaRegra1(Linguagens[] linguagens) {

		int frequencia1 = 0;
		int frequencia2 = 0;

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("JAVA") && linguagens[i].getBackend().equals("SPRINGBOOT") && linguagens[i].getFrontend().equals("REACT")) {
				frequencia1 += 1;
			}
		}

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("JAVA") && linguagens[i].getBackend().equals("SPRINGBOOT")) {
				frequencia2 += 1;
			}
		}
		return (double) frequencia1 / (double) frequencia2;
	}

	//LINGUAGEM JAVA, SPRINGBOOT NO BACKEND E ANGULAR NO FRONTEND 
	//suporte
	public static double suporteRegra2(Linguagens[] linguagens) {

		int frequencia = 0;

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("JAVA") && linguagens[i].getBackend().equals("SPRINGBOOT") && linguagens[i].getFrontend().equals("ANGULAR")) {
				frequencia += 1;
			}
		}

		return frequencia / (double) linguagens.length;
	}

	//confiança
	public static double confiancaRegra2(Linguagens[] linguagens) {

		int frequencia1 = 0;
		int frequencia2 = 0;

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("JAVA") && linguagens[i].getBackend().equals("SPRINGBOOT") && linguagens[i].getFrontend().equals("ANGULAR")) {
				frequencia1 += 1;
			}
		}

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("JAVA") && linguagens[i].getBackend().equals("SPRINGBOOT")) {
				frequencia2 += 1;
			}
		}
		return (double) frequencia1 / (double) frequencia2;
	}

	//LINGUAGEM JAVASCRIPT, EXPRESS JS NO BACKEND E REACT NO FRONTEND 
	//suporte
	public static double suporteRegra3(Linguagens[] linguagens) {

		int frequencia = 0;

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("JAVASCRIPT") && linguagens[i].getBackend().equals("EXPRESS JS") && linguagens[i].getFrontend().equals("REACT")) {
				frequencia += 1;
			}
		}

		return frequencia / (double) linguagens.length;
	}

	//confiança
	public static double confiancaRegra3(Linguagens[] linguagens) {

		int frequencia1 = 0;
		int frequencia2 = 0;

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("JAVASCRIPT") && linguagens[i].getBackend().equals("EXPRESS JS") && linguagens[i].getFrontend().equals("REACT")) {
				frequencia1 += 1;
			}
		}

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("JAVASCRIPT") && linguagens[i].getBackend().equals("EXPRESS JS")) {
				frequencia2 += 1;
			}
		}
		return (double) frequencia1 / (double) frequencia2;
	}

	//LINGUAGEM JAVASCRIPT, EXPRESS JS NO BACKEND E ANGULAR NO FRONTEND 
	//suporte
	public static double suporteRegra4(Linguagens[] linguagens) {

		int frequencia = 0;

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("JAVASCRIPT") && linguagens[i].getBackend().equals("EXPRESS JS") && linguagens[i].getFrontend().equals("ANGULAR")) {
				frequencia += 1;
			}
		}

		return frequencia / (double) linguagens.length;
	}

	//confiança
	public static double confiancaRegra4(Linguagens[] linguagens) {

		int frequencia1 = 0;
		int frequencia2 = 0;

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("JAVASCRIPT") && linguagens[i].getBackend().equals("EXPRESS JS") && linguagens[i].getFrontend().equals("ANGULAR")) {
				frequencia1 += 1;
			}
		}

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("JAVASCRIPT") && linguagens[i].getBackend().equals("EXPRESS JS")) {
				frequencia2 += 1;
			}
		}
		return (double) frequencia1 / (double) frequencia2;
	}

	//LINGUAGEM PYTHON, DJANGO NO BACKEND E REACT NO FRONTEND 
	//suporte
	public static double suporteRegra5(Linguagens[] linguagens) {

		int frequencia = 0;

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("PYTHON") && linguagens[i].getBackend().equals("DJANGO") && linguagens[i].getFrontend().equals("REACT")) {
				frequencia += 1;
			}
		}

		return frequencia / (double) linguagens.length;
	}

	//confiança
	public static double confiancaRegra5(Linguagens[] linguagens) {

		int frequencia1 = 0;
		int frequencia2 = 0;

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("PYTHON") && linguagens[i].getBackend().equals("DJANGO") && linguagens[i].getFrontend().equals("REACT")) {
				frequencia1 += 1;
			}
		}

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("PYTHON") && linguagens[i].getBackend().equals("DJANGO")) {
				frequencia2 += 1;
			}
		}
		return (double) frequencia1 / (double) frequencia2;
	}
	
	//LINGUAGEM PYTHON, DJANGO NO BACKEND E ANGULAR NO FRONTEND 
	//suporte
	public static double suporteRegra6(Linguagens[] linguagens) {

		int frequencia = 0;

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("PYTHON") && linguagens[i].getBackend().equals("DJANGO") && linguagens[i].getFrontend().equals("ANGULAR")) {
				frequencia += 1;
			}
		}

		return frequencia / (double) linguagens.length;
	}

	//confiança
	public static double confiancaRegra6(Linguagens[] linguagens) {

		int frequencia1 = 0;
		int frequencia2 = 0;

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("PYTHON") && linguagens[i].getBackend().equals("DJANGO") && linguagens[i].getFrontend().equals("ANGULAR")) {
				frequencia1 += 1;
			}
		}

		for (int i = 0; i < linguagens.length; i++) {
			if (linguagens[i].getLinguagem().equals("PYTHON") && linguagens[i].getBackend().equals("DJANGO")) {
				frequencia2 += 1;
			}
		}
		return (double) frequencia1 / (double) frequencia2;
	}
}
