package es.danisales.datune.midi;

public class Utils {
	private Utils() {
	}

	public static byte[] deltaByte(int n) {
		if ( n <= 127 )
			return new byte[] {
					(byte) n
			};
		else {
			// Contar bits del deltaByte
			int i = n;
			int bits = 0;
			while ( i != 0 ) {
				if ( ( bits + 1 ) % 7 == 0 )
					bits++;

				i >>>= 1;
				bits++;
			}
			int bytes = (int) Math.ceil( bits / 8.0 );

			// Formar cadena de bytes con bits 7 corregidos
			byte[] ret = new byte[bytes];
			for ( int j = bytes - 1; j >= 0; j-- ) {
				ret[j] = (byte) ( n & 0x7F );

				if ( j != bytes - 1 )
					ret[j] |= 0x80;

				n >>>= 7;
			}

			return ret;

		}
	}
}
