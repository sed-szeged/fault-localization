package hu.szte.inf.sed.fl.coverage.data;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Granularity {

	BINARY(1, "binary"), COUNT(2, "count"), CHAIN(4, "chain");

	private final int id;
	private final String text;

	public static Granularity fromId(final int id) {
		switch (id) {
			case 1:
				return BINARY;
			case 2:
				return COUNT;
			case 4:
				return CHAIN;
			default:
				throw new IllegalArgumentException(String.format("Invalid granularity value '%d'", id));
		}
	}

	public static Granularity fromText(final String text) {
		switch (text) {
			case "binary":
				return BINARY;
			case "count":
				return COUNT;
			case "chain":
				return CHAIN;
			default:
				throw new IllegalArgumentException(String.format("Invalid granularity value '%s'", text));
		}
	}

}
