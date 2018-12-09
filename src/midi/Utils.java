package midi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import diatonic.ChromaticFunction;

public class Utils {
	public static String array2Str(int[] array) {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < array.length; i++ ) {
			if ( i > 0 )
				sb.append( "-" );
			sb.append( array[i] );
		}

		return sb.toString();
	}

	public static byte[] dec2bytes(int n) {
		ArrayList<Byte> array = new ArrayList<Byte>();

		while ( n > 0 ) {
			byte b = (byte) ( n & 0xff );
			array.add( 0, b );
			n >>= 8;
		}

		byte[] bytes = new byte[array.size()];
		for ( int i = 0; i < array.size(); i++ ) {
			bytes[i] = array.get( i ).byteValue();
		}

		return bytes;
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

	public static class ArrayWrap<T> {
		T[] data;

		public ArrayWrap(T... d) {
			data = d;
		}

		public T get(int n) {
			return data[n];
		}

		@Override
		public boolean equals(Object o) {
			if ( o instanceof ArrayWrap ) {
				ArrayWrap a = (ArrayWrap) o;
				return Arrays.equals( data, a.data );
			} else
				return false;
		}

		@Override
		public int hashCode() {
			return Arrays.hashCode( data );
		}

		public String toString() {
			return Arrays.toString( data );
		}
	}

	public static class ArrayWrapInteger extends ArrayWrap<Integer> {
		public ArrayWrapInteger(Integer... d) {
			data = d;
		}

		@Override
		public boolean equals(Object o) {
			if ( o instanceof ArrayWrap ) {
				ArrayWrap a = (ArrayWrap) o;
				return Arrays.equals( data, a.data );
			} else if ( o instanceof Integer[] ) {
				Integer[] a = (Integer[]) o;
				return Arrays.equals( data, a );
			} else
				return false;
		}

		@Override
		public int hashCode() {
			return Arrays.hashCode( data );
		}
	}
}
