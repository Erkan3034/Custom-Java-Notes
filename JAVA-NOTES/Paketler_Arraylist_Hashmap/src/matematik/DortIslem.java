package matematik;

public class DortIslem {
	private int _sayı1;
	private int _sayı2;

	public DortIslem(int sayı1, int sayı2) {
		_sayı1 = sayı1;
		_sayı2 = sayı2;
	}

	public  int toplama() {
		return _sayı1 + _sayı2;
		
	}
	
	public int cıkarma() {
		return _sayı1 - _sayı2;
	}
	
	public int bölme() {
		return _sayı1 / _sayı2;
	}

	public int carpma() {
		return _sayı1 * _sayı2;
	}


}
