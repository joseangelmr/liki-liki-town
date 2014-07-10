package ISIS.Code.Matriz;

/**
 * 
 * @author ISIS
 */

public class CargarObjetos {

	public static Vivienda petrocasa, rancho, majunche, palafito, cabana; // Edificaciones
	public static Vivienda ambulatorio, aseo, companiaElectrica, escuela,
			aguaDeMerida; // Servicios Publicos
	public static Vivienda camellon, granzon, concreto; // Vias
	private Vivienda carpinteria, cafetin, fruteria, mercalito,
			almuerzoPopular;// Industrias
	private Vivienda consejoComunal, comedorPopular;// EdificiosComunitarios

	public CargarObjetos() {
		iniciarComponentes();
	}

	public static void iniciarComponentes() {
		System.out.println("entra a iniciar comp");
		// Edificaciones
		petrocasa = new Vivienda("petrocasa");
		petrocasa.setImagen(ImageCache.getInstance().getImage(
				"src/ISIS/Code/Matriz/petrocasa.png"));
		rancho = new Vivienda("rancho");
		rancho.setImagen(ImageCache.getInstance().getImage(
				"src/ISIS/Code/Matriz/rancho.png"));
		majunche = new Vivienda("majunche");
		majunche.setImagen(ImageCache.getInstance().getImage(
				"src/ISIS/Code/Matriz/majunche.png"));
		palafito = new Vivienda("palafito");
		palafito.setImagen(ImageCache.getInstance().getImage(
				"src/ISIS/Code/Matriz/palafito.png"));
		cabana = new Vivienda("cabana");
		cabana.setImagen(ImageCache.getInstance().getImage(
				"src/ISIS/Code/Matriz/cabana.png"));

		// Servicios Publicos
		// ambulatorio = new Vivienda("ambulatorio");
		// ambulatorio.setImagen(ImageCache.getInstance().getImage(
		// "src/ISIS/Code/Matriz/ambulatorio.png"));
		// aseo = new Vivienda("aseo");
		// aseo.setImagen(ImageCache.getInstance().getImage(
		// "src/ISIS/Code/Matriz/aseo.png"));
		// companiaElectrica = new Vivienda("companiaElectrica");
		// companiaElectrica.setImagen(ImageCache.getInstance().getImage(
		// "src/ISIS/Code/Matriz/companiaElectrica.png"));
		// escuela = new Vivienda("escuela");
		// escuela.setImagen(ImageCache.getInstance().getImage(
		// "src/ISIS/Code/Matriz/escuela.png"));
		// aguaDeMerida = new Vivienda("aguaDeMerida");
		// aguaDeMerida.setImagen(ImageCache.getInstance().getImage(
		// "src/ISIS/Code/Matriz/aguaDeMerida.png"));

		// Vias
		camellon = new Vivienda("camellon");
		camellon.setImagen(ImageCache.getInstance().getImage(
				"src/ISIS/Code/Matriz/camellon.png"));
		granzon = new Vivienda("granzon");
		granzon.setImagen(ImageCache.getInstance().getImage(
				"src/ISIS/Code/Matriz/granzon.png"));

		// granzon.setImagen(ImageCache.getInstance().getImage("src/ISIS/Code/Matriz/granzon1.png"));

		concreto = new Vivienda("concreto");
		concreto.setImagen(ImageCache.getInstance().getImage(
				"src/ISIS/Code/Matriz/concreto.png"));

		// Industrias
		// carpinteria = new Vivienda("carpinteria");
		// carpinteria.setImagen(ImageCache.getInstance().getImage(
		// "src/ISIS/Code/Matriz/carpinteria.png"));
		// cafetin = new Vivienda("cafetin");
		// cafetin.setImagen(ImageCache.getInstance().getImage(
		// "src/ISIS/Code/Matriz/cafetin.png"));
		// fruteria = new Vivienda("fruteria");
		// fruteria.setImagen(ImageCache.getInstance().getImage(
		// "src/ISIS/Code/Matriz/fruteria.png"));
		// mercalito = new Vivienda("mercalito");
		// mercalito.setImagen(ImageCache.getInstance().getImage(
		// "src/ISIS/Code/Matriz/mercalito.png"));
		// almuerzoPopular = new Vivienda("mercalito");
		// almuerzoPopular.setImagen(ImageCache.getInstance().getImage(
		// "src/ISIS/Code/Matriz/almuerzoPopular.png"));

		// EdificiosComunitarios
		// consejoComunal = new Vivienda("consejoComunal");
		// consejoComunal.setImagen(ImageCache.getInstance().getImage(
		// "src/ISIS/Code/Matriz/consejoComunal.png"));
		// comedorPopular = new Vivienda("comedorPopular");
		// comedorPopular.setImagen(ImageCache.getInstance().getImage(
		// "src/ISIS/Code/Matriz/comedorPopular.png"));

	}
}
