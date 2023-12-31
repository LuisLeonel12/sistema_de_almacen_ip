package base_de_datos;

public class Inventario {

		//variables globales solo para la clase debido a que son de clase privada
		private int Id;
	    private String Codigo_Rollo;
	    private String Nombre_Tela;
	    private String Proveedor;
	    private String Peso_Total;
	    private Double Metros;
	    private Double Metros_Totales;
	    private String Estilo;
	    private String Ancho;
	    private String Caracteristicas;
	    private String Ubicacion;
	    private String Fecha_Entrada;
	    private String Hora_de_Entrada;

	    //constructor vacio
	    public Inventario() {

	    }


	    //contructor con la clase inicializada
	    public Inventario(int Id ,String Codigo_Rollo, String Nombre_Tela, String Proveedor, String Peso_Total,Double Metros,Double Metros_Totales,String Estilo,String Ancho ,String Caracteristicas,String Ubicacion, String Fecha_Entrada, String Hora_Entrada) {
	    	this.Id= Id;
	    	this.Codigo_Rollo= Codigo_Rollo;
	    	this.Nombre_Tela = Nombre_Tela;
	    	this.Proveedor = Proveedor;
	    	this.Metros = Metros;
	    	this.Metros_Totales = Metros_Totales;
	    	this.Estilo = Estilo;
	    	this.Ancho = Ancho;
	    	this.Caracteristicas = Caracteristicas;
	    	this.Ubicacion = Ubicacion;
	    	this.Fecha_Entrada = Fecha_Entrada;
	    	this.Hora_de_Entrada = Hora_Entrada;
	    }


		public String getUbicacion() {
			return Ubicacion;
		}


		public void setUbicacion(String ubicacion) {
			Ubicacion = ubicacion;
		}


		public Double getMetros_Totales() {
			return Metros_Totales;
		}


		public void setMetros_Totales(Double metros_Totales) {
			Metros_Totales = metros_Totales;
		}


		public String getPeso_Total() {
			return Peso_Total;
		}


		public void setPeso_Total(String peso_Total) {
			Peso_Total = peso_Total;
		}


		public String getCodigo_Rollo() {
			return Codigo_Rollo;
		}

		public Double getMetros() {
			return Metros;
		}


		public void setMetros(Double metros) {
			this.Metros = metros;
		}


		public String getEstilo() {
			return Estilo;
		}


		public void setEstilo(String estilo) {
			this.Estilo = estilo;
		}


		public String getAncho() {
			return Ancho;
		}


		public void setAncho(String ancho) {
			this.Ancho = ancho;
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



		public String getPeso_total() {
			return Peso_Total;
		}


		public void setPeso_total(String peso_total) {
			Peso_Total = peso_total;
		}


		public String getCaracteristicas() {
			return Caracteristicas;
		}


		public void setCaracteristicas(String caracteristicas) {
			this.Caracteristicas = caracteristicas;
		}


		public String getFecha_Entrada() {
			return Fecha_Entrada;
		}


		public void setFecha_Entrada(String fecha_Entrada) {
			this.Fecha_Entrada = fecha_Entrada;
		}


		public String getHora_de_Entrada() {
			return Hora_de_Entrada;
		}


		public void setHora_de_Entrada(String hora_de_Entrada) {
			this.Hora_de_Entrada = hora_de_Entrada;
		}

}
