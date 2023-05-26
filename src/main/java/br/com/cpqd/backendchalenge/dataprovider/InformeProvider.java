package br.com.cpqd.backendchalenge.dataprovider;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cpqd.backendchalenge.InformeBoundary;
import br.com.cpqd.backendchalenge.core.domain.InformeDiario;

public class InformeProvider implements InformeBoundary {

    private static final int HEADER_LINE = 1;

    @Override
    public List<InformeDiario> getAll() {

        try {

            final Path path = Paths.get("src/main/resources/informes", "informe_diario.csv");
            Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

            try (BufferedReader dataset = new BufferedReader(reader)) {
                return dataset
                        .lines()
                        .skip(HEADER_LINE)
                        .map(InformeDiario::new)
                        .collect(Collectors.toList());
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException("Arquivo não encontrado");
        }
    }

	
	
	
    
    
}
