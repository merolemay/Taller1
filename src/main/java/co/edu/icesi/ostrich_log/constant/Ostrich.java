package co.edu.icesi.ostrich_log.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Ostrich {

	WEIGHT(100, 180),
    AGE(0, 60),
    HEIGHT(1.90f, 2.30f);

    private final float min, max;
}
