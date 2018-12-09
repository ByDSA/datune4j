package diatonic;

import java.util.Arrays;

public class CustomScale implements Scale {
	private int[] value;
	
	public CustomScale(int... i) {
		value = i;
	}
	
	public int get(int n) {
		return value[trim( n )];
	}
	
	@Override
	public int[] val() {
		return Arrays.copyOf(
			value, value.length
		);
	}
	
	public boolean equals(Object m) {
		if ( m instanceof Scale )
			return Arrays.equals(
				value, ( (Scale) m ).val()
			);
		else if ( m instanceof int[] )
			return Arrays.equals(
				value, (int[]) m
			);
		else
			return false;
	}

	@Override
	public int length() {
		return value.length;
	}
}
