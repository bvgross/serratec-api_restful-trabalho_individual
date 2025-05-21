package org.serratec.api.trabalho.trabalhoIndividual.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.serratec.api.trabalho.trabalhoIndividual.exception.EnumValidationException;

public enum Estado {
    AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO;

    @JsonCreator
    public static Estado verificar(Object valor) throws EnumValidationException {
        if (valor instanceof String) {
            for (Estado e: values()) {
                if (valor.equals(e.name())) {
                    return e;
                }
            }
            throw new EnumValidationException("Sigla de estado (UF) inválida. Digite uma sigla correta.");
        }
        throw new EnumValidationException("Dado informado no campo \"estado\" deve ser uma sigla (string) de duas letras.");
    }
}
