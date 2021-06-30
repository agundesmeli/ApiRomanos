package br.com.meli.apiromanos;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiRomanosController {

    @RequestMapping("/romanos/{numero}")
    public String endPoint1(@PathVariable Integer numero) {
        return converteRomano(numero);
    }

    private String converteRomano(Integer n) {
        int[] vaNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] vaRom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String num = "";
        int numero = n;

        if (numero == 0) {
            return "Não existe o 0 em romanos";
        }
        int i = 0;
        while (numero > 0) {
            if (numero >= vaNum[i]) {
                num = num + vaRom[i];
                numero -= vaNum[i];
            } else {
                i++;
            }
        }
        return num;
    }
}
