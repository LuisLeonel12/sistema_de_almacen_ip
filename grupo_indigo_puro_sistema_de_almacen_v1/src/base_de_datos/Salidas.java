package base_de_datos;

public class Salidas {

	//variables globales solo para la clase debido a que son de clase privada
		private int Id;
	    private String Codigo_Rollo;
	    private String Nombre_Tela;
	    private String Proveedor;
	    private String Peso;
	    private String Caracteristicas;
	    private String Fecha_Salida;
	    private String Hora_de_Salida;
	    
	    //constructor vacio
	    public Salidas() {
	    	
	    }
	    
	    
	    //contructor con la clase inicializada
	    public Salidas(int Id ,String Codigo_Rollo, String Nombre_Tela, String Proveedor, String Peso, String Caracteristicas, String Fecha_Salida, String Hora_Salida) {
	    	this.Id= Id;
	    	this.Codigo_Rollo= Codigo_Rollo;
	    	this.Nombre_Tela = Nombre_Tela;
	    	this.Proveedor = Proveedor;
	    	this.Peso = Peso;
	    	this.Caracteristicas = Caracteristicas;
	    	this.Fecha_Salida = Fecha_Salida;
	    	this.Hora_de_Salida = Hora_Salida;
	    }


	    
	    
		public String getCodigo_Rollo() {
			return Codigo_Rollo;
		}


		public void setCodigo_Rollo(String codigo_Rollo) {
			this.Codigo_Rollo = codigo_Rollo;
		}


		public String getNombre_Tela() {
			return Nombre_Tela;
		}


		public void setNombre_Tela(String nombre_Tela) {
			this.Nombre_Tela = nombre_Tela;
		}


		public int getId() {
			return Id;
		}


		public void setId(int id) {
			this.Id = id;
		}


		public String getCodigo_Tela() {
			return Codigo_Rollo;
		}


		public void setCodigo_Tela(String codigo_Tela) {
			this.Codigo_Rollo = codigo_Tela;
		}


		public String getProveedor() {
			return Proveedor;
		}


		public void setProveedor(String proveedor) {
			this.Proveedor = proveedor;
		}


		public String getPeso() {
			return Peso;
		}


		public void setPeso(String peso) {
			this.Peso = peso;
		}


		public String getCaracteristicas() {
			return Caracteristicas;
		}


		public void setCaracteristicas(String caracteristicas) {
			this.Caracteristicas = caracteristicas;
		}


		public String getFecha_Entrada() {
			return Fecha_Salida;
		}


		public void setFecha_Entrada(String fecha_Entrada) {
			this.Fecha_Salida = fecha_Entrada;
		}


		public String getHora_de_Entrada() {
			return Hora_de_Salida;
		}


		public void setHora_de_Entrada(String hora_de_Entrada) {
			this.Hora_de_Salida = hora_de_Entrada;
		}
	
}
